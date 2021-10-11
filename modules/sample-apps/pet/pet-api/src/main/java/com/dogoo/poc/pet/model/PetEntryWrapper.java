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

package com.dogoo.poc.pet.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PetEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PetEntry
 * @generated
 */
public class PetEntryWrapper
	extends BaseModelWrapper<PetEntry>
	implements ModelWrapper<PetEntry>, PetEntry {

	public PetEntryWrapper(PetEntry petEntry) {
		super(petEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("petId", getPetId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("creatorId", getCreatorId());
		attributes.put("scopeOrgId", getScopeOrgId());
		attributes.put("name", getName());
		attributes.put("tag", getTag());
		attributes.put("status", getStatus());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long petId = (Long)attributes.get("petId");

		if (petId != null) {
			setPetId(petId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long creatorId = (Long)attributes.get("creatorId");

		if (creatorId != null) {
			setCreatorId(creatorId);
		}

		Long scopeOrgId = (Long)attributes.get("scopeOrgId");

		if (scopeOrgId != null) {
			setScopeOrgId(scopeOrgId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String tag = (String)attributes.get("tag");

		if (tag != null) {
			setTag(tag);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	/**
	 * Returns the company ID of this pet entry.
	 *
	 * @return the company ID of this pet entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this pet entry.
	 *
	 * @return the create date of this pet entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the creator ID of this pet entry.
	 *
	 * @return the creator ID of this pet entry
	 */
	@Override
	public long getCreatorId() {
		return model.getCreatorId();
	}

	/**
	 * Returns the group ID of this pet entry.
	 *
	 * @return the group ID of this pet entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this pet entry.
	 *
	 * @return the modified date of this pet entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this pet entry.
	 *
	 * @return the name of this pet entry
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the pet ID of this pet entry.
	 *
	 * @return the pet ID of this pet entry
	 */
	@Override
	public long getPetId() {
		return model.getPetId();
	}

	/**
	 * Returns the primary key of this pet entry.
	 *
	 * @return the primary key of this pet entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the scope org ID of this pet entry.
	 *
	 * @return the scope org ID of this pet entry
	 */
	@Override
	public long getScopeOrgId() {
		return model.getScopeOrgId();
	}

	/**
	 * Returns the status of this pet entry.
	 *
	 * @return the status of this pet entry
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status date of this pet entry.
	 *
	 * @return the status date of this pet entry
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the tag of this pet entry.
	 *
	 * @return the tag of this pet entry
	 */
	@Override
	public String getTag() {
		return model.getTag();
	}

	/**
	 * Returns the user ID of this pet entry.
	 *
	 * @return the user ID of this pet entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this pet entry.
	 *
	 * @return the user name of this pet entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this pet entry.
	 *
	 * @return the user uuid of this pet entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this pet entry.
	 *
	 * @return the uuid of this pet entry
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this pet entry.
	 *
	 * @param companyId the company ID of this pet entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this pet entry.
	 *
	 * @param createDate the create date of this pet entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the creator ID of this pet entry.
	 *
	 * @param creatorId the creator ID of this pet entry
	 */
	@Override
	public void setCreatorId(long creatorId) {
		model.setCreatorId(creatorId);
	}

	/**
	 * Sets the group ID of this pet entry.
	 *
	 * @param groupId the group ID of this pet entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this pet entry.
	 *
	 * @param modifiedDate the modified date of this pet entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this pet entry.
	 *
	 * @param name the name of this pet entry
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the pet ID of this pet entry.
	 *
	 * @param petId the pet ID of this pet entry
	 */
	@Override
	public void setPetId(long petId) {
		model.setPetId(petId);
	}

	/**
	 * Sets the primary key of this pet entry.
	 *
	 * @param primaryKey the primary key of this pet entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the scope org ID of this pet entry.
	 *
	 * @param scopeOrgId the scope org ID of this pet entry
	 */
	@Override
	public void setScopeOrgId(long scopeOrgId) {
		model.setScopeOrgId(scopeOrgId);
	}

	/**
	 * Sets the status of this pet entry.
	 *
	 * @param status the status of this pet entry
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status date of this pet entry.
	 *
	 * @param statusDate the status date of this pet entry
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the tag of this pet entry.
	 *
	 * @param tag the tag of this pet entry
	 */
	@Override
	public void setTag(String tag) {
		model.setTag(tag);
	}

	/**
	 * Sets the user ID of this pet entry.
	 *
	 * @param userId the user ID of this pet entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this pet entry.
	 *
	 * @param userName the user name of this pet entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this pet entry.
	 *
	 * @param userUuid the user uuid of this pet entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this pet entry.
	 *
	 * @param uuid the uuid of this pet entry
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected PetEntryWrapper wrap(PetEntry petEntry) {
		return new PetEntryWrapper(petEntry);
	}

}