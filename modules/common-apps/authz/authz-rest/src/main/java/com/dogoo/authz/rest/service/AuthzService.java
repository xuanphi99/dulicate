package com.dogoo.authz.rest.service;

import com.dogoo.authz.constant.AuthzKeys;
import com.dogoo.authz.model.RefreshTokenEntry;
import com.dogoo.authz.rest.jwt.JwtUtils;
import com.dogoo.authz.rest.model.Token;
import com.dogoo.authz.rest.util.Helper;
import com.dogoo.authz.service.RefreshTokenEntryLocalServiceUtil;
import com.dogoo.exception.api.TokenRefreshException;
import com.dogoo.exception.api.UnAuthenticationException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.Authenticator;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;


@Component(immediate = true, service = AuthzService.class)
public class AuthzService {

    private Properties AUTHZ_PROPERTIES =
            new Helper().loadResourceBundled("/configuration/authz.properties");

    public Token getToken(long companyId, String userName, String passWord) throws PortalException, UnAuthenticationException {

        Token token;

        int authResult = UserLocalServiceUtil.authenticateByScreenName(
                companyId, userName, passWord, null, null, null);


        if (authResult == Authenticator.SUCCESS) {
            User user = UserLocalServiceUtil.getUserByScreenName(companyId, userName);

            token = Token.of(
                    jwtUtils.getJWToken(companyId, userName, AuthzKeys.TOKEN_SUBJECT),
                    AuthzKeys.TOKEN_TYPE,
                    getRefreshTokenEntry(userName).getToken());

        } else {
            throw new UnAuthenticationException("DOG-1000", "An error occurred while trying login to DoGoo");
        }

        return token;
    }

    public Token refreshToken(long companyId, String refreshToken) throws TokenRefreshException {
        Date now = new Date();

        RefreshTokenEntry refreshTokenEntry =
                RefreshTokenEntryLocalServiceUtil.fetchByToken(refreshToken);

        if (refreshTokenEntry.getExpiryDate().compareTo(now) < 0) {
            throw new TokenRefreshException("DOG-1403", "Refresh token was expired. Please make a new Sign-in request");
        }

        Date expirationDate =
                getExpirationDate(
                        GetterUtil.getInteger(AUTHZ_PROPERTIES.getProperty(AuthzKeys.EXPIRATION_REFRESH_TIME)));

        RefreshTokenEntryLocalServiceUtil.updateRefreshToken(refreshToken, expirationDate);

        return Token.of(
                jwtUtils.getJWToken(companyId, refreshTokenEntry.getUserName(), AuthzKeys.TOKEN_SUBJECT),
                AuthzKeys.TOKEN_TYPE,
                refreshTokenEntry.getToken());
    }

    public RefreshTokenEntry getRefreshTokenEntry(String userName) {

        RefreshTokenEntryLocalServiceUtil.removeByUserName(userName);

        Date expirationDate =
                getExpirationDate(
                        GetterUtil.getInteger(AUTHZ_PROPERTIES.getProperty(AuthzKeys.EXPIRATION_REFRESH_TIME)));

        return RefreshTokenEntryLocalServiceUtil.addRefreshTokenEntry(userName,
                PortalUUIDUtil.generate(), expirationDate);
    }

    public Company getCompanyContext(HttpServletRequest httpServletRequest) throws PortalException{
        return _portal.getCompany(httpServletRequest);
    }

    private Date getExpirationDate(int expirationTimeMs) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MILLISECOND, expirationTimeMs);

        return c.getTime();
    }

    @Reference
    private Portal _portal;

    @Reference
    private JwtUtils jwtUtils;
}
