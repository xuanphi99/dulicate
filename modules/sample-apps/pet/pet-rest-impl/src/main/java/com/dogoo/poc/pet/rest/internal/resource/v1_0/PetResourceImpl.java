package com.dogoo.poc.pet.rest.internal.resource.v1_0;

import com.dogoo.common.constant.api.CommonConstant;
import com.dogoo.poc.pet.rest.dto.v1_0.Pet;
import com.dogoo.poc.pet.rest.internal.odata.v1_0.PetEntityIndexModel;
import com.dogoo.poc.pet.rest.internal.service.PetService;
import com.dogoo.poc.pet.rest.internal.validator.PetValidator;
import com.dogoo.poc.pet.rest.resource.v1_0.PetResource;

import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.validation.constraints.NotNull;
import javax.ws.rs.core.MultivaluedMap;

/**
 * @author khoavu
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/pet.properties",
	scope = ServiceScope.PROTOTYPE, service = PetResource.class
)
public class PetResourceImpl extends BasePetResourceImpl {
	private PetEntityIndexModel petEntityIndexModel = new PetEntityIndexModel();

	@Override
	public EntityModel getEntityModel(MultivaluedMap multivaluedMap) {
		return petEntityIndexModel;
	}

	@Override
	public Page<Pet> getPetsPage(String search, Filter filter,
								 Pagination pagination, Sort[] sorts) throws Exception {

		petValidator.validatorForSearch(pagination);

		return petService.getPetsPage(search, filter, pagination, sorts, getToken(), getServiceContext());
	}

	@Override
	public Pet postPet(Pet pet) throws Exception {

		petValidator.validatorForAddPet(pet);

		return petService.postPet(pet, getToken(), getServiceContext());
	}

	@Override
	public void deletePet(@NotNull Long petId) throws Exception {

		petValidator.validatorPetIsExists(petId);

		petService.deletePet(petId);
	}

	@Override
	public Pet getPet(@NotNull Long petId) throws Exception {
		petValidator.validatorPetIsExists(petId);

		return petService.getPet(petId, getToken());
	}

	@Override
	public Pet pathPet(@NotNull Long petId, Pet pet) throws Exception {
		petValidator.validatorForPatchPet(petId, pet);

		return petService.pathPet(petId, pet, getToken(), getServiceContext());
	}

	@Override
	public Pet putPet(@NotNull Long petId, Pet pet) throws Exception {
		petValidator.validatorForUpdatePet(petId, pet);

		return petService.putPet(petId, pet, getToken(), getServiceContext());
	}

	private String getToken() {
		return contextHttpServletRequest.getHeader(commonConstant.TOKEN_HEADER_KEY);
	}

	public ServiceContext getServiceContext() {
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setCompanyId(contextCompany.getCompanyId());
		serviceContext.setUserId(contextUser.getUserId());
		serviceContext.setScopeGroupId(contextUser.getGroupId());

		return serviceContext;
	}

	@Reference
	private CommonConstant commonConstant;

	@Reference
	private PetService petService;

	@Reference
	private PetValidator petValidator;

}