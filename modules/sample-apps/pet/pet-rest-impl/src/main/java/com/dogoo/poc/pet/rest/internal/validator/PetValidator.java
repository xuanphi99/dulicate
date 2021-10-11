package com.dogoo.poc.pet.rest.internal.validator;

import com.dogoo.poc.pet.model.PetEntry;
import com.dogoo.poc.pet.rest.dto.v1_0.Pet;
import com.dogoo.poc.pet.service.PetEntryLocalService;
import com.liferay.portal.vulcan.pagination.Pagination;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;

@Component(immediate = true, service = com.dogoo.poc.pet.rest.internal.validator.PetValidator.class)
public class PetValidator {
    private static final  String PET_NOT_FOUND = "Not found Pet";
    private static final String NAME_REQUEST = "Pet name is requested";
    private static final String TAG_REQUEST = "Pet tag is requested";
    private static final String FIELDS_FOR_PATCH_REQUEST = "Fields for patch is requested";
    private static final String PAGE_SIZE_MAX = "page-size-is-greater-than-x";


    public void validatorForSearch(Pagination pagination) {
        if (pagination.getPageSize() > 250) {
            throw new BadRequestException(String.format(PAGE_SIZE_MAX, 250));
        }
    }

    public void validatorForAddPet(Pet pet) {
        checkRequiredField(pet.getName(), NAME_REQUEST);
        checkRequiredField(pet.getTag(), TAG_REQUEST);
    }

    public void validatorForUpdatePet(long petId, Pet pet) {
        validatorPetIsExists(petId);

        checkRequiredField(pet.getName(), NAME_REQUEST);
        checkRequiredField(pet.getTag(), TAG_REQUEST);
        checkRequiredField(pet.getStatus().name(), TAG_REQUEST);
    }

    public void validatorForPatchPet(long petId, Pet pet) {

        validatorPetIsExists(petId);

        if (pet.getName() != null && !pet.getName().trim().isEmpty()) {
            return;
        }

        if (pet.getTag() != null && !pet.getTag().trim().isEmpty()) {
            return;
        }

        throw new BadRequestException(FIELDS_FOR_PATCH_REQUEST);
    }

    public void validatorPetIsExists(long petId) {
        PetEntry petEntry = petEntryLocalService.fetchPetEntry(petId);

        if (petEntry != null) {
            return;
        }

        throw new NotFoundException(PET_NOT_FOUND);
    }

    private void checkRequiredField(String value, String errorMsg) {
        if (null == value || value.trim().isEmpty()) {
            throw new BadRequestException(errorMsg);
        }
    }

    @Reference
    private PetEntryLocalService petEntryLocalService;
}
