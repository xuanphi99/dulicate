/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.dogoo.poc.pet.service.impl;

import com.dogoo.poc.pet.constant.PetEntryConstant;
import com.dogoo.poc.pet.model.PetEntry;
import com.dogoo.poc.pet.service.base.PetEntryLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import org.osgi.service.component.annotations.Component;

import java.util.Date;

/**
 * The implementation of the pet entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.dogoo.poc.pet.service.PetEntryLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PetEntryLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.dogoo.poc.pet.model.PetEntry",
	service = AopService.class
)
public class PetEntryLocalServiceImpl extends PetEntryLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.dogoo.poc.pet.service.PetEntryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.dogoo.poc.pet.service.PetEntryLocalServiceUtil</code>.
	 */
	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public PetEntry addPet(String name, String tag,
						   long scopeOrgId, long creatorId, ServiceContext serviceContext) {

		PetEntry pet = createPetEntry(counterLocalService.increment(PetEntry.class.getName()));

		Date current = new Date();

		updateModifierAudit(pet, current, serviceContext);

		pet.setGroupId(serviceContext.getScopeGroupId());
		pet.setCompanyId(serviceContext.getCompanyId());
		pet.setCreateDate(serviceContext.getCreateDate(current));
		pet.setModifiedDate(serviceContext.getModifiedDate(current));

		pet.setScopeOrgId(scopeOrgId);
		pet.setCreatorId(creatorId);

		pet.setName(name);
		pet.setTag(tag);
		pet.setStatus(PetEntryConstant.PENDING.name());
		pet.setStatusDate(current);

		return addPetEntry(pet);
	}

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public PetEntry updatePet(long petId, String name, String tag, String status,
							  ServiceContext serviceContext) throws PortalException {

		PetEntry pet = getPetEntry(petId);

		Date current = new Date();
		String currentStatus = pet.getStatus();

		updateModifierAudit(pet, current, serviceContext);

		pet.setName(name);
		pet.setTag(tag);

		if (status != null && !status.contentEquals(currentStatus)) {
			pet.setStatus(status);
			pet.setStatusDate(current);
		}

		return updatePetEntry(pet);
	}

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public PetEntry patchPet(long petId, String name, String tag, String status,
							 ServiceContext serviceContext) throws PortalException {

		PetEntry pet = getPetEntry(petId);

		Date current = new Date();
		String currentStatus = pet.getStatus();

		boolean changed = false;

		if (name != null) {
			pet.setName(name);
			changed = true;
		}

		if (tag != null) {
			pet.setTag(tag);
			changed = true;
		}

		if (!status.isEmpty() && !status.contentEquals(currentStatus)) {
			pet.setStatus(status);
			pet.setStatusDate(current);
			changed = true;
		}

		if (changed) {
			updateModifierAudit(pet, current, serviceContext);
		}

		return updatePetEntry(pet);
	}

	private void updateModifierAudit(PetEntry pet, Date current, ServiceContext serviceContext) {
		User user = userLocalService.fetchUser(serviceContext.getUserId());

		if (user != null) {
			pet.setUserName(user.getFullName());
			pet.setUserUuid(user.getUserUuid());
		}

		pet.setModifiedDate(serviceContext.getModifiedDate(current));
		pet.setUserId(serviceContext.getUserId());

	}

}