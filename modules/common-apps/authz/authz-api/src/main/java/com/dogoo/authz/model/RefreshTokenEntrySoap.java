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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class RefreshTokenEntrySoap implements Serializable {

	public static RefreshTokenEntrySoap toSoapModel(RefreshTokenEntry model) {
		RefreshTokenEntrySoap soapModel = new RefreshTokenEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setRefreshTokenId(model.getRefreshTokenId());
		soapModel.setUserName(model.getUserName());
		soapModel.setToken(model.getToken());
		soapModel.setExpiryDate(model.getExpiryDate());
		soapModel.setIssuedDate(model.getIssuedDate());
		soapModel.setRefreshedDate(model.getRefreshedDate());

		return soapModel;
	}

	public static RefreshTokenEntrySoap[] toSoapModels(
		RefreshTokenEntry[] models) {

		RefreshTokenEntrySoap[] soapModels =
			new RefreshTokenEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RefreshTokenEntrySoap[][] toSoapModels(
		RefreshTokenEntry[][] models) {

		RefreshTokenEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new RefreshTokenEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new RefreshTokenEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RefreshTokenEntrySoap[] toSoapModels(
		List<RefreshTokenEntry> models) {

		List<RefreshTokenEntrySoap> soapModels =
			new ArrayList<RefreshTokenEntrySoap>(models.size());

		for (RefreshTokenEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RefreshTokenEntrySoap[soapModels.size()]);
	}

	public RefreshTokenEntrySoap() {
	}

	public long getPrimaryKey() {
		return _refreshTokenId;
	}

	public void setPrimaryKey(long pk) {
		setRefreshTokenId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getRefreshTokenId() {
		return _refreshTokenId;
	}

	public void setRefreshTokenId(long refreshTokenId) {
		_refreshTokenId = refreshTokenId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public String getToken() {
		return _token;
	}

	public void setToken(String token) {
		_token = token;
	}

	public Date getExpiryDate() {
		return _expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		_expiryDate = expiryDate;
	}

	public Date getIssuedDate() {
		return _issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		_issuedDate = issuedDate;
	}

	public Date getRefreshedDate() {
		return _refreshedDate;
	}

	public void setRefreshedDate(Date refreshedDate) {
		_refreshedDate = refreshedDate;
	}

	private String _uuid;
	private long _refreshTokenId;
	private String _userName;
	private String _token;
	private Date _expiryDate;
	private Date _issuedDate;
	private Date _refreshedDate;

}