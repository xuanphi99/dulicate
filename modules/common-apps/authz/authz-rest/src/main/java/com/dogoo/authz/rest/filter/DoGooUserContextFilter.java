package com.dogoo.authz.rest.filter;

import com.dogoo.authz.constant.AuthzKeys;
import com.dogoo.authz.rest.jwt.JwtUtils;
import com.dogoo.exception.api.BadRequestException;
import com.dogoo.exception.api.ErrorMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component(
        immediate = true,
        property = {
                "servlet-context-name=",
                "servlet-filter-name=DoGoo User Context Filter",
                "url-pattern=/o/dogoo/*"
        },
        service = Filter.class
)
public class DoGooUserContextFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        String userContext = httpRequest.getHeader(AuthzKeys.USER_CONTEXT);

        if (userContext == null || userContext.isEmpty()) {
            buildErrorResponse(response,
                    "DOG-1401",
                    "Header " + AuthzKeys.USER_CONTEXT + " is required.",
                    "You need implement login flow. Detail in DoGoo Handbook for Dev");
            return;
        }

        boolean tokenValid = jwtUtils.validateJwtToken(userContext);

        if (tokenValid) {
            chain.doFilter(request, response);

        } else {
            buildErrorResponse(response,
                    "DOG-1402",
                    "Header " + AuthzKeys.USER_CONTEXT + " token is expired",
                    "You need implement login flow. Detail in DoGoo Handbook for Dev");
        }

    }

    private void buildErrorResponse(ServletResponse response, String code, String message, String devMessage)
            throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        BadRequestException badRequestException =
                new BadRequestException(HttpServletResponse.SC_BAD_REQUEST, code, message, devMessage);

        ErrorMessage object = new ErrorMessage(badRequestException);

        HttpServletResponse httpResp = (HttpServletResponse) response;
        httpResp.reset();
        httpResp.setHeader("Content-Type","application/json;charset=UTF-8");
        httpResp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        String json =  mapper.writeValueAsString(object);
        response.getWriter().write(json);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //default
    }

    @Override
    public void destroy() {
        //default
    }

    @Reference
    private JwtUtils jwtUtils;
}
