package com.dogoo.pet.rest.internal.test.validator;

import com.dogoo.pet.rest.internal.test.mockdata.PetMockDataUtil;
import com.dogoo.poc.pet.model.PetEntry;
import com.dogoo.poc.pet.rest.dto.v1_0.Pet;
import com.dogoo.poc.pet.rest.internal.validator.PetValidator;
import com.dogoo.poc.pet.service.PetEntryLocalService;
import com.liferay.portal.vulcan.pagination.Pagination;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PetValidatorTest {
    private static final Long PET_ID = 1l;


    @InjectMocks
    private PetValidator validator;

    @Mock
    private PetEntryLocalService petLocalService;

    @Mock
    private PetEntry petEntry;

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Before
    public void setup() {
        when(petLocalService.fetchPetEntry(anyLong())).thenReturn(petEntry);
    }

    @Test
    public void ensureValidatorForSearchPet() {
        Pagination pagination =  Pagination.of(1, 10);

        validator.validatorForSearch(pagination);
    }

    @Test
    public void ensureValidatorForSearchPetExceptionWhenPageSizeLager250() {
        expected.expect(RuntimeException.class);

        Pagination pagination =  Pagination.of(1, 251);

        validator.validatorForSearch(pagination);
    }

    @Test
    public void ensureValidatorForAddPet() {
        Pet pet = PetMockDataUtil.buildPet("Anna", "f1");

        validator.validatorForAddPet(pet);
    }

    @Test
    public void ensureValidatorForUpdatePet() {
        Pet pet = PetMockDataUtil.buildPet("Anna", "f1", Pet.Status.APPROVED);

        validator.validatorForUpdatePet(PET_ID, pet);
    }

    @Test
    public void ensureValidatorForAddPetExceptionWhenMissingRequestField() {
        expected.expect(RuntimeException.class);

        Pet pet = PetMockDataUtil.buildPet("", "f1");

        validator.validatorForAddPet(pet);
    }

    @Test
    public void ensureValidatorForPatchPet() {
        Pet pet = PetMockDataUtil.buildPet("Anna", "f1", Pet.Status.APPROVED);

        validator.validatorForPatchPet(PET_ID, pet);
    }

    @Test
    public void ensureValidatorForPatchPetOnlyOneFieldPatch() {
        Pet pet = PetMockDataUtil.buildPet("", "f1", Pet.Status.APPROVED);

        validator.validatorForPatchPet(PET_ID, pet);
    }

    @Test
    public void ensureValidatorForPatchPetExceptionWhenNotHaveAnyFieldBody() {
        expected.expect(RuntimeException.class);

        Pet pet = PetMockDataUtil.buildPet("", "", null);

        validator.validatorForPatchPet(PET_ID, pet);
    }

    @Test
    public void ensureValidatorPetIsExists() {

        validator.validatorPetIsExists(PET_ID);
    }

    @Test
    public void ensureValidatorPetIsExistsThrowExceptionIfPetIdDoesNotExist() {
        expected.expect(RuntimeException.class);

        when(petLocalService.fetchPetEntry(anyLong())).thenReturn(null);

        validator.validatorPetIsExists(PET_ID);
    }

}
