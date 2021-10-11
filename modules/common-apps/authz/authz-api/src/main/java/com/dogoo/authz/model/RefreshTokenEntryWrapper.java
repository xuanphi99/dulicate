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

package com.dogoo.authz.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link RefreshTokenEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RefreshTokenEntry
 * @generated
 */
public class RefreshTokenEntryWrapper
	extends BaseModelWrapper<RefreshTokenEntry>
	implements ModelWrapper<RefreshTokenEntry>, RefreshTokenEntry {

	public RefreshTokenEntryWrapper(RefreshTokenEntry refreshTokenEntry) {
		super(refreshTokenEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("refreshTokenId", getRefreshTokenId());
		attributes.put("userName", getUserName());
		attributes.put("token", getToken());
		attributes.put("expiryDate", getExpiryDate());
		attributes.put("issuedDate", getIssuedDate());
		attributes.put("refreshedDate", getRefreshedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long refreshTokenId = (Long)attributes.get("refreshTokenId");

		if (refreshTokenId != null) {
			setRefreshTokenId(refreshTokenId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		String token = (String)attributes.get("token");

		if (token != null) {
			setToken(token);
		}

		Date expiryDate = (Date)attributes.get("expiryDate");

		if (expiryDate != null) {
			setExpiryDate(expiryDate);
		}

		Date issuedDate = (Date)attributes.get("issuedDate");

		if (issuedDate != null) {
			setIssuedDate(issuedDate);
		}

		Date refreshedDate = (Date)attributes.get("refreshedDate");

		if (refreshedDate != null) {
			setRefreshedDate(refreshedDate);
		}
	}

	/**
	 * Returns the expiry date of this refresh token entry.
	 *
	 * @return the expiry date of this refresh token entry
	 */
	@Override
	public Date getExpiryDate() {
		return model.getExpiryDate();
	}

	/**
	 * Returns the issued date of this refresh token entry.
	 *
	 * @return the issued date of this refresh token entry
	 */
	@Override
	public Date getIssuedDate() {
		return model.getIssuedDate();
	}

	/**
	 * Returns the primary key of this refresh token entry.
	 *
	 * @return the primary key of this refresh token entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the refreshed date of this refresh token entry.
	 *
	 * @return the refreshed date of this refresh token entry
	 */
	@Override
	public Date getRefreshedDate() {
		return model.getRefreshedDate();
	}

	/**
	 * Returns the refresh token ID of this refresh token entry.
	 *
	 * @return the refresh token ID of this refresh token entry
	 */
	@Override
	public long getRefreshTokenId() {
		return model.getRefreshTokenId();
	}

	/**
	 * Returns the token of this refresh token entry.
	 *
	 * @return the token of this refresh token entry
	 */
	@Override
	public String getToken() {
		return model.getToken();
	}

	/**
	 * Returns the user name of this refresh token entry.
	 *
	 * @return the user name of this refresh token entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the uuid of this refresh token entry.
	 *
	 * @return the uuid of this refresh token entry
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
	 * Sets the expiry date of this refresh token entry.
	 *
	 * @param expiryDate the expiry date of this refresh token entry
	 */
	@Override
	public void setExpiryDate(Date expiryDate) {
		model.setExpiryDate(expiryDate);
	}

	/**
	 * Sets the issued date of this refresh token entry.
	 *
	 * @param issuedDate the issued date of this refresh token entry
	 */
	@Override
	public void setIssuedDate(Date issuedDate) {
		model.setIssuedDate(issuedDate);
	}

	/**
	 * Sets the primary key of this refresh token entry.
	 *
	 * @param primaryKey the primary key of this refresh token entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the refreshed date of this refresh token entry.
	 *
	 * @param refreshedDate the refreshed date of this refresh token entry
	 */
	@Override
	public void setRefreshedDate(Date refreshedDate) {
		model.setRefreshedDate(refreshedDate);
	}

	/**
	 * Sets the refresh token ID of this refresh token entry.
	 *
	 * @param refreshTokenId the refresh token ID of this refresh token entry
	 */
	@Override
	public void setRefreshTokenId(long refreshTokenId) {
		model.setRefreshTokenId(refreshTokenId);
	}

	/**
	 * Sets the token of this refresh token entry.
	 *
	 * @param token the token of this refresh token entry
	 */
	@Override
	public void setToken(String token) {
		model.setToken(token);
	}

	/**
	 * Sets the user name of this refresh token entry.
	 *
	 * @param userName the user name of this refresh token entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the uuid of this refresh token entry.
	 *
	 * @param uuid the uuid of this refresh token entry
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected RefreshTokenEntryWrapper wrap(
		RefreshTokenEntry refreshTokenEntry) {

		return new RefreshTokenEntryWrapper(refreshTokenEntry);
	}

}