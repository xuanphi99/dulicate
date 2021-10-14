package com.dogoo.poc.pet.rest.internal.service;

import com.dogoo.common.user.api.UserContextTokenDecoder;
import com.dogoo.poc.pet.model.PetEntry;
import com.dogoo.poc.pet.rest.dto.v1_0.Pet;
import com.dogoo.poc.pet.rest.internal.mapper.PetMapper;
import com.dogoo.poc.pet.service.PetEntryLocalService;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.SearchUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Collections;

@Component(immediate = true, service = com.dogoo.poc.pet.rest.internal.service.PetService.class)
public class PetService {
    public Page<Pet> getPetsPage(String search, Filter filter,
                                 Pagination pagination, Sort[] sorts,
                                 String token, ServiceContext serviceContext) throws Exception {

        return SearchUtil.search(
                Collections.emptyMap(),
                booleanQuery -> {
                    // does nothing, we just need the UnsafeConsumer<BooleanQuery, Exception> method
                },
                filter, PetEntry.class, search, pagination,
                queryConfig -> queryConfig.setSelectedFieldNames(
                        Field.ENTRY_CLASS_PK),
                searchContext -> searchContext.setCompanyId(
                        serviceContext.getCompanyId()),
                sorts,
                document -> petMapper.mapFromPetEntryToPet(
                        petEntryLocalService.getPetEntry(
                                GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK))), token));
    }

    public Pet postPet(Pet pet, String token, ServiceContext serviceContext) throws Exception {
        PetEntry petEntity = petEntryLocalService.addPet(pet.getName(),
                pet.getTag(), tokenDecoder.getOrgIds(token), tokenDecoder.getUserId(token), serviceContext);

        return petMapper.mapFromPetEntryToPet(petEntity, token);
    }

    public void deletePet(Long petId) throws Exception {
        petEntryLocalService.deletePetEntry(petId);
    }

    public Pet getPet(Long petId, String token) throws Exception {
        PetEntry petEntity = petEntryLocalService.getPetEntry(petId);

        return petMapper.mapFromPetEntryToPet(petEntity, token);
    }

    public Pet pathPet(Long petId, Pet pet, String token, ServiceContext serviceContext) throws Exception {

        PetEntry petEntity = petEntryLocalService.
                patchPet(petId, pet.getName(), pet.getTag(), GetterUtil.getString(pet.getStatus()), serviceContext);

        return petMapper.mapFromPetEntryToPet(petEntity, token);
    }

    public Pet putPet(Long petId, Pet pet, String token, ServiceContext serviceContext) throws Exception {
        PetEntry petEntity = petEntryLocalService.
                updatePet(petId, pet.getName(), pet.getTag(), pet.getStatus().name(), serviceContext);

        return petMapper.mapFromPetEntryToPet(petEntity, token);
    }

    @Reference
    private PetMapper petMapper;

    @Reference
    private PetEntryLocalService petEntryLocalService;

    @Reference
    private UserContextTokenDecoder tokenDecoder;

}
