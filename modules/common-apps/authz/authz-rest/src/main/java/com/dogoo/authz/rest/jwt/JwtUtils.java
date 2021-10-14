package com.dogoo.authz.rest.jwt;

import com.dogoo.authz.constant.AuthzKeys;
import com.dogoo.authz.constant.ClaimsKeys;
import com.dogoo.authz.rest.util.Helper;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Calendar;
import java.util.Properties;

@Component(immediate = true, service = JwtUtils.class)
public class JwtUtils {

    private Properties AUTHZ_PROPERTIES =
            new Helper().loadResourceBundled("/configuration/authz.properties");

    public String getJWToken(long companyId, String userName, String subject) {

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        String token = null;

        byte[] apiKeySecretBytes =
                DatatypeConverter.parseBase64Binary(AUTHZ_PROPERTIES.getProperty(AuthzKeys.TOKEN_KEY));

        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        int expiration =  GetterUtil.getInteger(AUTHZ_PROPERTIES.getProperty(AuthzKeys.EXPIRATION_TIME));

        Calendar c = Calendar.getInstance();
        c.add(Calendar.MILLISECOND, expiration);
        Claims claims = Jwts.claims().setSubject(subject);

        claimsUtils.buildClaims(companyId, userName, claims);

        token  = Jwts.builder()
                .setClaims(claims)
                .setExpiration(c.getTime())
                .signWith(signingKey,signatureAlgorithm)
                .compact();

        return token;
    }

    public String[] decodeJWToken(String token) {
        String[] tokenData = null;

        if(Validator.isNotNull(token) && !token.equals("undefined")) {
            Claims claims =
                    Jwts.parserBuilder()
                    .setSigningKey(
                            DatatypeConverter
                                    .parseBase64Binary(AUTHZ_PROPERTIES.getProperty(AuthzKeys.TOKEN_KEY))).build()
                    .parseClaimsJws(token).getBody();

            tokenData = new String[5];

            tokenData[4] = String.valueOf(claims.get(ClaimsKeys.USER_ROLES));
            tokenData[3] = String.valueOf(claims.get(ClaimsKeys.USER_ID));
            tokenData[2] = String.valueOf(claims.get(ClaimsKeys.USER_SCR_NAME));
            tokenData[1] = String.valueOf(claims.get(ClaimsKeys.USER_FULL_NAME));
            tokenData[0] = String.valueOf(claims.get(ClaimsKeys.USER_EMAIL));
        }

        return tokenData;
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(
                    DatatypeConverter.parseBase64Binary(AUTHZ_PROPERTIES.getProperty(AuthzKeys.TOKEN_KEY)))
                    .build().parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException e) {
            _log.error("Invalid JWT token: " + e.getMessage());
        } catch (ExpiredJwtException e) {
            _log.error("JWT token is expired: " + e.getMessage());
        } catch (UnsupportedJwtException e) {
            _log.error("JWT token is unsupported: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            _log.error("JWT claims string is empty: "  + e.getMessage());
        } catch (SignatureException e) {
            _log.error("JWT signature does not match locally computed signature: "  + e.getMessage());
        }

        return false;
    }

    @Reference
    private ClaimsUtils claimsUtils;

    private static final Log _log = LogFactoryUtil.getLog(JwtUtils.class);

}
