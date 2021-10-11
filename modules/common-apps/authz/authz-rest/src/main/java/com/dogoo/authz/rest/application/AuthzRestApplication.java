package com.dogoo.authz.rest.application;

import com.dogoo.authz.rest.model.RefreshToken;
import com.dogoo.authz.rest.model.SignIn;
import com.dogoo.authz.rest.model.Token;
import com.dogoo.authz.rest.service.AuthzService;
import com.dogoo.authz.rest.validator.AuthzValidator;
import com.dogoo.exception.api.BadRequestException;
import com.dogoo.exception.api.BadRequestExceptionMapper;
import com.dogoo.exception.api.NotFoundException;
import com.dogoo.exception.api.NotFoundExceptionMapper;
import com.dogoo.exception.api.TokenRefreshException;
import com.dogoo.exception.api.TokenRefreshExceptionMapper;
import com.dogoo.exception.api.UnAuthenticationException;
import com.dogoo.exception.api.UnAuthenticationExceptionMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.liferay.oauth2.provider.scope.RequiresScope;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author khoavu
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/authz-rest",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Authz.Rest"
		},
	service = Application.class
)
public class AuthzRestApplication extends Application {

	@Override
	public Set<Object> getSingletons() {

		Set<Object> singletons = new HashSet<Object>();

		singletons.add(new JacksonJsonProvider());

		singletons.add(this);

		return singletons;
	}

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		/* Classes to wrap any exception into a JSON response */
		classes.add(UnAuthenticationExceptionMapper.class);
		classes.add(BadRequestExceptionMapper.class);
		classes.add(TokenRefreshExceptionMapper.class);
		classes.add(NotFoundExceptionMapper.class);
		/* add additional JAX-RS classes here */
		return classes;
	}

	@GET
	@Produces("text/plain")
	@RequiresScope("DOGOO_APP_R")
	public String working(SignIn signIn) {
		return "It works!";
	}

	@POST
	@Path("/signin")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@RequiresScope("DOGOO_APP_R")
	public Response signin(SignIn signIn, @Context HttpServletRequest httpServletRequest)
			throws PortalException, UnAuthenticationException, BadRequestException {

		authzValidator.validateForSignIn(signIn);

		Company company = authzService.getCompanyContext(httpServletRequest);

		Token token = authzService.getToken(company.getCompanyId(), signIn.getUsername(), signIn.getPassword());

		return Response.status(HttpURLConnection.HTTP_OK).entity(token).build();
	}

	@POST
	@Path("/refreshtoken")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response refreshToken(RefreshToken refreshToken, @Context HttpServletRequest httpServletRequest)
			throws PortalException, TokenRefreshException, BadRequestException, NotFoundException {

		authzValidator.validateForRefreshToken(refreshToken);

		Company company = authzService.getCompanyContext(httpServletRequest);

		Token token = authzService.refreshToken(company.getCompanyId(), refreshToken.getToken());

		return Response.status(HttpURLConnection.HTTP_OK).entity(token).build();
	}


	@POST
	@Path("/refreshtoken2")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response refreshToken2(@Context HttpServletRequest httpServletRequest)
			throws PortalException, TokenRefreshException, BadRequestException, NotFoundException {

		SignIn token = new SignIn();
		token.setPassword("pass");
		token.setUsername("dsads");

		return Response.status(HttpURLConnection.HTTP_OK).entity(token).build();
	}


	@Reference
	private AuthzService authzService;

	@Reference
	private AuthzValidator authzValidator;

}