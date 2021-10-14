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

package com.dogoo.authz.service.impl;

import com.dogoo.authz.model.RefreshTokenEntry;
import com.dogoo.authz.service.base.RefreshTokenEntryLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

import java.util.Date;

/**
 * The implementation of the refresh token entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.dogoo.authz.service.RefreshTokenEntryLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RefreshTokenEntryLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.dogoo.authz.model.RefreshTokenEntry",
	service = AopService.class
)
public class RefreshTokenEntryLocalServiceImpl
	extends RefreshTokenEntryLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.dogoo.authz.service.RefreshTokenEntryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.dogoo.authz.service.RefreshTokenEntryLocalServiceUtil</code>.
	 */

	public RefreshTokenEntry addRefreshTokenEntry(String userName, String token, Date expiryDate) {
		Date current = new Date();

		RefreshTokenEntry refreshTokenEntry =
				createRefreshTokenEntry(counterLocalService.increment(RefreshTokenEntry.class.getName()));

		refreshTokenEntry.setUserName(userName);
		refreshTokenEntry.setToken(token);
		refreshTokenEntry.setExpiryDate(expiryDate);
		refreshTokenEntry.setIssuedDate(current);
		refreshTokenEntry.setRefreshedDate(current);

		return updateRefreshTokenEntry(refreshTokenEntry);
	}

	public RefreshTokenEntry updateRefreshToken(String token, Date expiryDate) {
		Date current = new Date();

		RefreshTokenEntry refreshTokenEntry = refreshTokenEntryPersistence.fetchByT_K(token);

		refreshTokenEntry.setRefreshedDate(current);
		refreshTokenEntry.setExpiryDate(expiryDate);

		return updateRefreshTokenEntry(refreshTokenEntry);
	}

	public boolean isContains(String userName) {
		return refreshTokenEntryPersistence.fetchByU_N(userName) != null;
	}

	public void removeByUserName(String userName) {
		if (isContains(userName)) {
			deleteRefreshTokenEntry(refreshTokenEntryPersistence.fetchByU_N(userName));
		}
	}

	public RefreshTokenEntry fetchByToken(String token) {
		return refreshTokenEntryPersistence.fetchByT_K(token);
	}
}