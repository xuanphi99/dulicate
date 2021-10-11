package com.dogoo.poc.pet.rest.internal.graphql.mutation.v1_0;

import com.dogoo.poc.pet.rest.dto.v1_0.Pet;
import com.dogoo.poc.pet.rest.resource.v1_0.PetResource;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author khoavu
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setPetResourceComponentServiceObjects(
		ComponentServiceObjects<PetResource>
			petResourceComponentServiceObjects) {

		_petResourceComponentServiceObjects =
			petResourceComponentServiceObjects;
	}

	@GraphQLField(description = "Create a pet")
	public Pet createPet(@GraphQLName("pet") Pet pet) throws Exception {
		return _applyComponentServiceObjects(
			_petResourceComponentServiceObjects, this::_populateResourceContext,
			petResource -> petResource.postPet(pet));
	}

	@GraphQLField
	public Response createPetBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_petResourceComponentServiceObjects, this::_populateResourceContext,
			petResource -> petResource.postPetBatch(callbackURL, object));
	}

	@GraphQLField(description = "Delete a pet")
	public boolean deletePet(@GraphQLName("petId") Long petId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_petResourceComponentServiceObjects, this::_populateResourceContext,
			petResource -> petResource.deletePet(petId));

		return true;
	}

	@GraphQLField
	public Response deletePetBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_petResourceComponentServiceObjects, this::_populateResourceContext,
			petResource -> petResource.deletePetBatch(callbackURL, object));
	}

	@GraphQLField(
		description = "Updates the pet with information sent in the request body. Only the provided fields are updated."
	)
	public Pet pathPet(
			@GraphQLName("petId") Long petId, @GraphQLName("pet") Pet pet)
		throws Exception {

		return _applyComponentServiceObjects(
			_petResourceComponentServiceObjects, this::_populateResourceContext,
			petResource -> petResource.pathPet(petId, pet));
	}

	@GraphQLField(
		description = "Replaces the pet with information sent in the request body. Any missing fields are deleted unless they are required."
	)
	public Pet updatePet(
			@GraphQLName("petId") Long petId, @GraphQLName("pet") Pet pet)
		throws Exception {

		return _applyComponentServiceObjects(
			_petResourceComponentServiceObjects, this::_populateResourceContext,
			petResource -> petResource.putPet(petId, pet));
	}

	@GraphQLField
	public Response updatePetBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_petResourceComponentServiceObjects, this::_populateResourceContext,
			petResource -> petResource.putPetBatch(callbackURL, object));
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(PetResource petResource)
		throws Exception {

		petResource.setContextAcceptLanguage(_acceptLanguage);
		petResource.setContextCompany(_company);
		petResource.setContextHttpServletRequest(_httpServletRequest);
		petResource.setContextHttpServletResponse(_httpServletResponse);
		petResource.setContextUriInfo(_uriInfo);
		petResource.setContextUser(_user);
		petResource.setGroupLocalService(_groupLocalService);
		petResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<PetResource>
		_petResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}