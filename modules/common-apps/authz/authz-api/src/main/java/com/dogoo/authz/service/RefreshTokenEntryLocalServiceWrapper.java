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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RefreshTokenEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RefreshTokenEntryLocalService
 * @generated
 */
public class RefreshTokenEntryLocalServiceWrapper
	implements RefreshTokenEntryLocalService,
			   ServiceWrapper<RefreshTokenEntryLocalService> {

	public RefreshTokenEntryLocalServiceWrapper(
		RefreshTokenEntryLocalService refreshTokenEntryLocalService) {

		_refreshTokenEntryLocalService = refreshTokenEntryLocalService;
	}

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
	@Override
	public com.dogoo.authz.model.RefreshTokenEntry addRefreshTokenEntry(
		com.dogoo.authz.model.RefreshTokenEntry refreshTokenEntry) {

		return _refreshTokenEntryLocalService.addRefreshTokenEntry(
			refreshTokenEntry);
	}

	@Override
	public com.dogoo.authz.model.RefreshTokenEntry addRefreshTokenEntry(
		String userName, String token, java.util.Date expiryDate) {

		return _refreshTokenEntryLocalService.addRefreshTokenEntry(
			userName, token, expiryDate);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _refreshTokenEntryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new refresh token entry with the primary key. Does not add the refresh token entry to the database.
	 *
	 * @param refreshTokenId the primary key for the new refresh token entry
	 * @return the new refresh token entry
	 */
	@Override
	public com.dogoo.authz.model.RefreshTokenEntry createRefreshTokenEntry(
		long refreshTokenId) {

		return _refreshTokenEntryLocalService.createRefreshTokenEntry(
			refreshTokenId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _refreshTokenEntryLocalService.deletePersistedModel(
			persistedModel);
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
	@Override
	public com.dogoo.authz.model.RefreshTokenEntry deleteRefreshTokenEntry(
			long refreshTokenId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _refreshTokenEntryLocalService.deleteRefreshTokenEntry(
			refreshTokenId);
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
	@Override
	public com.dogoo.authz.model.RefreshTokenEntry deleteRefreshTokenEntry(
		com.dogoo.authz.model.RefreshTokenEntry refreshTokenEntry) {

		return _refreshTokenEntryLocalService.deleteRefreshTokenEntry(
			refreshTokenEntry);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _refreshTokenEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _refreshTokenEntryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _refreshTokenEntryLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _refreshTokenEntryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _refreshTokenEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _refreshTokenEntryLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _refreshTokenEntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _refreshTokenEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.dogoo.authz.model.RefreshTokenEntry fetchByToken(String token) {
		return _refreshTokenEntryLocalService.fetchByToken(token);
	}

	@Override
	public com.dogoo.authz.model.RefreshTokenEntry fetchRefreshTokenEntry(
		long refreshTokenId) {

		return _refreshTokenEntryLocalService.fetchRefreshTokenEntry(
			refreshTokenId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _refreshTokenEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _refreshTokenEntryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _refreshTokenEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _refreshTokenEntryLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.dogoo.authz.model.RefreshTokenEntry>
		getRefreshTokenEntries(int start, int end) {

		return _refreshTokenEntryLocalService.getRefreshTokenEntries(
			start, end);
	}

	/**
	 * Returns the number of refresh token entries.
	 *
	 * @return the number of refresh token entries
	 */
	@Override
	public int getRefreshTokenEntriesCount() {
		return _refreshTokenEntryLocalService.getRefreshTokenEntriesCount();
	}

	/**
	 * Returns the refresh token entry with the primary key.
	 *
	 * @param refreshTokenId the primary key of the refresh token entry
	 * @return the refresh token entry
	 * @throws PortalException if a refresh token entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.authz.model.RefreshTokenEntry getRefreshTokenEntry(
			long refreshTokenId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _refreshTokenEntryLocalService.getRefreshTokenEntry(
			refreshTokenId);
	}

	@Override
	public boolean isContains(String userName) {
		return _refreshTokenEntryLocalService.isContains(userName);
	}

	@Override
	public void removeByUserName(String userName) {
		_refreshTokenEntryLocalService.removeByUserName(userName);
	}

	@Override
	public com.dogoo.authz.model.RefreshTokenEntry updateRefreshToken(
		String token, java.util.Date expiryDate) {

		return _refreshTokenEntryLocalService.updateRefreshToken(
			token, expiryDate);
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
	@Override
	public com.dogoo.authz.model.RefreshTokenEntry updateRefreshTokenEntry(
		com.dogoo.authz.model.RefreshTokenEntry refreshTokenEntry) {

		return _refreshTokenEntryLocalService.updateRefreshTokenEntry(
			refreshTokenEntry);
	}

	@Override
	public RefreshTokenEntryLocalService getWrappedService() {
		return _refreshTokenEntryLocalService;
	}

	@Override
	public void setWrappedService(
		RefreshTokenEntryLocalService refreshTokenEntryLocalService) {

		_refreshTokenEntryLocalService = refreshTokenEntryLocalService;
	}

	private RefreshTokenEntryLocalService _refreshTokenEntryLocalService;

}