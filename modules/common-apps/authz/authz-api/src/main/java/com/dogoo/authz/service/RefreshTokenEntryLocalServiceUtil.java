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

package com.dogoo.authz.service;

import com.dogoo.authz.model.RefreshTokenEntry;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for RefreshTokenEntry. This utility wraps
 * <code>com.dogoo.authz.service.impl.RefreshTokenEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see RefreshTokenEntryLocalService
 * @generated
 */
public class RefreshTokenEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.dogoo.authz.service.impl.RefreshTokenEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the refresh token entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RefreshTokenEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param refreshTokenEntry the refresh token entry
	 * @return the refresh token entry that was added
	 */
	public static RefreshTokenEntry addRefreshTokenEntry(
		RefreshTokenEntry refreshTokenEntry) {

		return getService().addRefreshTokenEntry(refreshTokenEntry);
	}

	public static RefreshTokenEntry addRefreshTokenEntry(
		String userName, String token, java.util.Date expiryDate) {

		return getService().addRefreshTokenEntry(userName, token, expiryDate);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new refresh token entry with the primary key. Does not add the refresh token entry to the database.
	 *
	 * @param refreshTokenId the primary key for the new refresh token entry
	 * @return the new refresh token entry
	 */
	public static RefreshTokenEntry createRefreshTokenEntry(
		long refreshTokenId) {

		return getService().createRefreshTokenEntry(refreshTokenId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the refresh token entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RefreshTokenEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param refreshTokenId the primary key of the refresh token entry
	 * @return the refresh token entry that was removed
	 * @throws PortalException if a refresh token entry with the primary key could not be found
	 */
	public static RefreshTokenEntry deleteRefreshTokenEntry(long refreshTokenId)
		throws PortalException {

		return getService().deleteRefreshTokenEntry(refreshTokenId);
	}

	/**
	 * Deletes the refresh token entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RefreshTokenEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param refreshTokenEntry the refresh token entry
	 * @return the refresh token entry that was removed
	 */
	public static RefreshTokenEntry deleteRefreshTokenEntry(
		RefreshTokenEntry refreshTokenEntry) {

		return getService().deleteRefreshTokenEntry(refreshTokenEntry);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.authz.model.impl.RefreshTokenEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.authz.model.impl.RefreshTokenEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static RefreshTokenEntry fetchByToken(String token) {
		return getService().fetchByToken(token);
	}

	public static RefreshTokenEntry fetchRefreshTokenEntry(
		long refreshTokenId) {

		return getService().fetchRefreshTokenEntry(refreshTokenId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns a range of all the refresh token entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.authz.model.impl.RefreshTokenEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of refresh token entries
	 * @param end the upper bound of the range of refresh token entries (not inclusive)
	 * @return the range of refresh token entries
	 */
	public static List<RefreshTokenEntry> getRefreshTokenEntries(
		int start, int end) {

		return getService().getRefreshTokenEntries(start, end);
	}

	/**
	 * Returns the number of refresh token entries.
	 *
	 * @return the number of refresh token entries
	 */
	public static int getRefreshTokenEntriesCount() {
		return getService().getRefreshTokenEntriesCount();
	}

	/**
	 * Returns the refresh token entry with the primary key.
	 *
	 * @param refreshTokenId the primary key of the refresh token entry
	 * @return the refresh token entry
	 * @throws PortalException if a refresh token entry with the primary key could not be found
	 */
	public static RefreshTokenEntry getRefreshTokenEntry(long refreshTokenId)
		throws PortalException {

		return getService().getRefreshTokenEntry(refreshTokenId);
	}

	public static boolean isContains(String userName) {
		return getService().isContains(userName);
	}

	public static void removeByUserName(String userName) {
		getService().removeByUserName(userName);
	}

	public static RefreshTokenEntry updateRefreshToken(
		String token, java.util.Date expiryDate) {

		return getService().updateRefreshToken(token, expiryDate);
	}

	/**
	 * Updates the refresh token entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RefreshTokenEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param refreshTokenEntry the refresh token entry
	 * @return the refresh token entry that was updated
	 */
	public static RefreshTokenEntry updateRefreshTokenEntry(
		RefreshTokenEntry refreshTokenEntry) {

		return getService().updateRefreshTokenEntry(refreshTokenEntry);
	}

	public static RefreshTokenEntryLocalService getService() {
		return _service;
	}

	private static volatile RefreshTokenEntryLocalService _service;

}