package com.dogoo.poc.pet.rest.internal.mapper;

import com.dogoo.common.user.api.UserUtil;
import com.dogoo.common.user.model.CreatorModel;
import com.dogoo.poc.pet.model.PetEntry;
import com.dogoo.poc.pet.rest.dto.v1_0.Creator;
import com.dogoo.poc.pet.rest.dto.v1_0.Pet;
import com.liferay.portal.kernel.exception.PortalException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.text.SimpleDateFormat;

@Component(immediate = true, service = com.dogoo.poc.pet.rest.internal.mapper.PetMapper.class)
public class PetMapper {
    private static final String PATTERN = "MM-dd-yyyy HH:mm:ss.SSSZ";

    public Pet mapFromPetEntryToPet(PetEntry from, String token) throws PortalException {
        Pet to = new Pet();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PATTERN);

        to.setId(from.getPetId());
        to.setName(from.getName());
        to.setTag(from.getTag());
        to.setStatus(Pet.Status.valueOf(from.getStatus()));
        to.setStatusDate(simpleDateFormat.format(from.getStatusDate()));
        to.setCreator(mapCreatorModelToCreator(userUtil.getCreatorModel(token)));

        return to;
    }

    private Creator mapCreatorModelToCreator(CreatorModel from) {
        Creator to = new Creator();

        to.setScopeOrgIds(from.getScopeOrgIds());
        to.setRoles(from.getRoles());

        to.setAdditionalName(from.getAdditionalName());
        to.setFamilyName(from.getFamilyName());
        to.setGivenName(from.getGivenName());
        to.setId(from.getId());
        to.setName(from.getName());
        to.setImage(from.getImage());
        to.setProfileURL(from.getProfileURL());

        return to;
    }

    @Reference
    private UserUtil userUtil;
}
