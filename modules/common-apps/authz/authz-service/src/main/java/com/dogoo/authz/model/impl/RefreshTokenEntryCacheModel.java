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

package com.dogoo.authz.model.impl;

import com.dogoo.authz.model.RefreshTokenEntry;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RefreshTokenEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RefreshTokenEntryCacheModel
	implements CacheModel<RefreshTokenEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RefreshTokenEntryCacheModel)) {
			return false;
		}

		RefreshTokenEntryCacheModel refreshTokenEntryCacheModel =
			(RefreshTokenEntryCacheModel)object;

		if (refreshTokenId == refreshTokenEntryCacheModel.refreshTokenId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, refreshTokenId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", refreshTokenId=");
		sb.append(refreshTokenId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", token=");
		sb.append(token);
		sb.append(", expiryDate=");
		sb.append(expiryDate);
		sb.append(", issuedDate=");
		sb.append(issuedDate);
		sb.append(", refreshedDate=");
		sb.append(refreshedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RefreshTokenEntry toEntityModel() {
		RefreshTokenEntryImpl refreshTokenEntryImpl =
			new RefreshTokenEntryImpl();

		if (uuid == null) {
			refreshTokenEntryImpl.setUuid("");
		}
		else {
			refreshTokenEntryImpl.setUuid(uuid);
		}

		refreshTokenEntryImpl.setRefreshTokenId(refreshTokenId);

		if (userName == null) {
			refreshTokenEntryImpl.setUserName("");
		}
		else {
			refreshTokenEntryImpl.setUserName(userName);
		}

		if (token == null) {
			refreshTokenEntryImpl.setToken("");
		}
		else {
			refreshTokenEntryImpl.setToken(token);
		}

		if (expiryDate == Long.MIN_VALUE) {
			refreshTokenEntryImpl.setExpiryDate(null);
		}
		else {
			refreshTokenEntryImpl.setExpiryDate(new Date(expiryDate));
		}

		if (issuedDate == Long.MIN_VALUE) {
			refreshTokenEntryImpl.setIssuedDate(null);
		}
		else {
			refreshTokenEntryImpl.setIssuedDate(new Date(issuedDate));
		}

		if (refreshedDate == Long.MIN_VALUE) {
			refreshTokenEntryImpl.setRefreshedDate(null);
		}
		else {
			refreshTokenEntryImpl.setRefreshedDate(new Date(refreshedDate));
		}

		refreshTokenEntryImpl.resetOriginalValues();

		return refreshTokenEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		refreshTokenId = objectInput.readLong();
		userName = objectInput.readUTF();
		token = objectInput.readUTF();
		expiryDate = objectInput.readLong();
		issuedDate = objectInput.readLong();
		refreshedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(refreshTokenId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		if (token == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(token);
		}

		objectOutput.writeLong(expiryDate);
		objectOutput.writeLong(issuedDate);
		objectOutput.writeLong(refreshedDate);
	}

	public String uuid;
	public long refreshTokenId;
	public String userName;
	public String token;
	public long expiryDate;
	public long issuedDate;
	public long refreshedDate;

}