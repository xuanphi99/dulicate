package com.dogoo.exception.api;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class TokenRefreshExceptionMapper implements ExceptionMapper<TokenRefreshException> {

    @Override
    public Response toResponse(TokenRefreshException exception) {
        return Response.status(Response.Status.FORBIDDEN)
                .entity(new ErrorMessage(exception))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
