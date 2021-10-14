package com.dogoo.authz.constant;

public class AuthzKeys {
    public static final String TOKEN_TYPE = "Bearer";
    public static final String TOKEN_SUBJECT = "DG_CTX";
    public static final String TOKEN_KEY = "dogoo.jwt.secret.key";
    public static final String EXPIRATION_REFRESH_TIME = "dogoo.jwt.expiration.refresh.ms";
    public static final String EXPIRATION_TIME = "dogoo.jwt.expiration.ms";
    public static final String USER_CONTEXT = "dogoo-x-user-context-request";
}
