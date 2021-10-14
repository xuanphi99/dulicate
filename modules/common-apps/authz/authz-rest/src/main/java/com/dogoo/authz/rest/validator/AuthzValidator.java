package com.dogoo.authz.rest.validator;

import com.dogoo.authz.model.RefreshTokenEntry;
import com.dogoo.authz.rest.model.RefreshToken;
import com.dogoo.authz.rest.model.SignIn;
import com.dogoo.authz.service.RefreshTokenEntryLocalServiceUtil;
import com.dogoo.exception.api.BadRequestException;
import com.dogoo.exception.api.NotFoundException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = AuthzValidator.class)
public class AuthzValidator {
    public static final String USER_NAME_REQUIRED = "Username is required";
    public static final String PASSWORD_REQUIRED = "Password is required";
    public static final String TOKEN_REQUIRED = "Token is required";
    public static final String TOKEN_INVALID = "Token does not exist";

    public void validateForRefreshToken(RefreshToken refreshToken) throws BadRequestException, NotFoundException {
        checkRequiredField(refreshToken.getToken(), TOKEN_REQUIRED);

        RefreshTokenEntry refreshTokenEntry =
                RefreshTokenEntryLocalServiceUtil.fetchByToken(refreshToken.getToken());

        if (refreshTokenEntry != null) {
            return;
        }

        throw new NotFoundException("DG-1404", TOKEN_INVALID);
    }

    public void validateForSignIn(SignIn signIn) throws BadRequestException {
        checkRequiredField(signIn.getUsername(), USER_NAME_REQUIRED);
        checkRequiredField(signIn.getPassword(), PASSWORD_REQUIRED);
    }

    private void checkRequiredField(String value, String errorMsg) throws BadRequestException {
        if (null == value || value.trim().isEmpty()) {
            throw new BadRequestException("DOGOO-1400", errorMsg);
        }
    }
}
