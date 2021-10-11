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

package com.dogoo.authz.service.persistence;

import com.dogoo.authz.model.RefreshTokenEntry;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the refresh token entry service. This utility wraps <code>com.dogoo.authz.service.persistence.impl.RefreshTokenEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RefreshTokenEntryPersistence
 * @generated
 */
public class RefreshTokenEntryUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(RefreshTokenEntry refreshTokenEntry) {
		getPersistence().clearCache(refreshTokenEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, RefreshTokenEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RefreshTokenEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RefreshTokenEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RefreshTokenEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RefreshTokenEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RefreshTokenEntry update(
		RefreshTokenEntry refreshTokenEntry) {

		return getPersistence().update(refreshTokenEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RefreshTokenEntry update(
		RefreshTokenEntry refreshTokenEntry, ServiceContext serviceContext) {

		return getPersistence().update(refreshTokenEntry, serviceContext);
	}

	/**
	 * Returns all the refresh token entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching refresh token entries
	 */
	public static List<RefreshTokenEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the refresh token entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RefreshTokenEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of refresh token entries
	 * @param end the upper bound of the range of refresh token entries (not inclusive)
	 * @return the range of matching refresh token entries
	 */
	public static List<RefreshTokenEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the refresh token entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RefreshTokenEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of refresh token entries
	 * @param end the upper bound of the range of refresh token entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching refresh token entries
	 */
	public static List<RefreshTokenEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RefreshTokenEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the refresh token entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RefreshTokenEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of refresh token entries
	 * @param end the upper bound of the range of refresh token entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching refresh token entries
	 */
	public static List<RefreshTokenEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RefreshTokenEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first refresh token entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching refresh token entry
	 * @throws NoSuchRefreshTokenEntryException if a matching refresh token entry could not be found
	 */
	public static RefreshTokenEntry findByUuid_First(
			String uuid, OrderByComparator<RefreshTokenEntry> orderByComparator)
		throws com.dogoo.authz.exception.NoSuchRefreshTokenEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first refresh token entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching refresh token entry, or <code>null</code> if a matching refresh token entry could not be found
	 */
	public static RefreshTokenEntry fetchByUuid_First(
		String uuid, OrderByComparator<RefreshTokenEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last refresh token entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching refresh token entry
	 * @throws NoSuchRefreshTokenEntryException if a matching refresh token entry could not be found
	 */
	public static RefreshTokenEntry findByUuid_Last(
			String uuid, OrderByComparator<RefreshTokenEntry> orderByComparator)
		throws com.dogoo.authz.exception.NoSuchRefreshTokenEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last refresh token entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching refresh token entry, or <code>null</code> if a matching refresh token entry could not be found
	 */
	public static RefreshTokenEntry fetchByUuid_Last(
		String uuid, OrderByComparator<RefreshTokenEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the refresh token entries before and after the current refresh token entry in the ordered set where uuid = &#63;.
	 *
	 * @param refreshTokenId the primary key of the current refresh token entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next refresh token entry
	 * @throws NoSuchRefreshTokenEntryException if a refresh token entry with the primary key could not be found
	 */
	public static RefreshTokenEntry[] findByUuid_PrevAndNext(
			long refreshTokenId, String uuid,
			OrderByComparator<RefreshTokenEntry> orderByComparator)
		throws com.dogoo.authz.exception.NoSuchRefreshTokenEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			refreshTokenId, uuid, orderByComparator);
	}

	/**
	 * Removes all the refresh token entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of refresh token entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching refresh token entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the refresh token entry where token = &#63; or throws a <code>NoSuchRefreshTokenEntryException</code> if it could not be found.
	 *
	 * @param token the token
	 * @return the matching refresh token entry
	 * @throws NoSuchRefreshTokenEntryException if a matching refresh token entry could not be found
	 */
	public static RefreshTokenEntry findByT_K(String token)
		throws com.dogoo.authz.exception.NoSuchRefreshTokenEntryException {

		return getPersistence().findByT_K(token);
	}

	/**
	 * Returns the refresh token entry where token = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param token the token
	 * @return the matching refresh token entry, or <code>null</code> if a matching refresh token entry could not be found
	 */
	public static RefreshTokenEntry fetchByT_K(String token) {
		return getPersistence().fetchByT_K(token);
	}

	/**
	 * Returns the refresh token entry where token = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param token the token
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching refresh token entry, or <code>null</code> if a matching refresh token entry could not be found
	 */
	public static RefreshTokenEntry fetchByT_K(
		String token, boolean useFinderCache) {

		return getPersistence().fetchByT_K(token, useFinderCache);
	}

	/**
	 * Removes the refresh token entry where token = &#63; from the database.
	 *
	 * @param token the token
	 * @return the refresh token entry that was removed
	 */
	public static RefreshTokenEntry removeByT_K(String token)
		throws com.dogoo.authz.exception.NoSuchRefreshTokenEntryException {

		return getPersistence().removeByT_K(token);
	}

	/**
	 * Returns the number of refresh token entries where token = &#63;.
	 *
	 * @param token the token
	 * @return the number of matching refresh token entries
	 */
	public static int countByT_K(String token) {
		return getPersistence().countByT_K(token);
	}

	/**
	 * Returns the refresh token entry where userName = &#63; or throws a <code>NoSuchRefreshTokenEntryException</code> if it could not be found.
	 *
	 * @param userName the user name
	 * @return the matching refresh token entry
	 * @throws NoSuchRefreshTokenEntryException if a matching refresh token entry could not be found
	 */
	public static RefreshTokenEntry findByU_N(String userName)
		throws com.dogoo.authz.exception.NoSuchRefreshTokenEntryException {

		return getPersistence().findByU_N(userName);
	}

	/**
	 * Returns the refresh token entry where userName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userName the user name
	 * @return the matching refresh token entry, or <code>null</code> if a matching refresh token entry could not be found
	 */
	public static RefreshTokenEntry fetchByU_N(String userName) {
		return getPersistence().fetchByU_N(userName);
	}

	/**
	 * Returns the refresh token entry where userName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userName the user name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching refresh token entry, or <code>null</code> if a matching refresh token entry could not be found
	 */
	public static RefreshTokenEntry fetchByU_N(
		String userName, boolean useFinderCache) {

		return getPersistence().fetchByU_N(userName, useFinderCache);
	}

	/**
	 * Removes the refresh token entry where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 * @return the refresh token entry that was removed
	 */
	public static RefreshTokenEntry removeByU_N(String userName)
		throws com.dogoo.authz.exception.NoSuchRefreshTokenEntryException {

		return getPersistence().removeByU_N(userName);
	}

	/**
	 * Returns the number of refresh token entries where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching refresh token entries
	 */
	public static int countByU_N(String userName) {
		return getPersistence().countByU_N(userName);
	}

	/**
	 * Caches the refresh token entry in the entity cache if it is enabled.
	 *
	 * @param refreshTokenEntry the refresh token entry
	 */
	public static void cacheResult(RefreshTokenEntry refreshTokenEntry) {
		getPersistence().cacheResult(refreshTokenEntry);
	}

	/**
	 * Caches the refresh token entries in the entity cache if it is enabled.
	 *
	 * @param refreshTokenEntries the refresh token entries
	 */
	public static void cacheResult(
		List<RefreshTokenEntry> refreshTokenEntries) {

		getPersistence().cacheResult(refreshTokenEntries);
	}

	/**
	 * Creates a new refresh token entry with the primary key. Does not add the refresh token entry to the database.
	 *
	 * @param refreshTokenId the primary key for the new refresh token entry
	 * @return the new refresh token entry
	 */
	public static RefreshTokenEntry create(long refreshTokenId) {
		return getPersistence().create(refreshTokenId);
	}

	/**
	 * Removes the refresh token entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param refreshTokenId the primary key of the refresh token entry
	 * @return the refresh token entry that was removed
	 * @throws NoSuchRefreshTokenEntryException if a refresh token entry with the primary key could not be found
	 */
	public static RefreshTokenEntry remove(long refreshTokenId)
		throws com.dogoo.authz.exception.NoSuchRefreshTokenEntryException {

		return getPersistence().remove(refreshTokenId);
	}

	public static RefreshTokenEntry updateImpl(
		RefreshTokenEntry refreshTokenEntry) {

		return getPersistence().updateImpl(refreshTokenEntry);
	}

	/**
	 * Returns the refresh token entry with the primary key or throws a <code>NoSuchRefreshTokenEntryException</code> if it could not be found.
	 *
	 * @param refreshTokenId the primary key of the refresh token entry
	 * @return the refresh token entry
	 * @throws NoSuchRefreshTokenEntryException if a refresh token entry with the primary key could not be found
	 */
	public static RefreshTokenEntry findByPrimaryKey(long refreshTokenId)
		throws com.dogoo.authz.exception.NoSuchRefreshTokenEntryException {

		return getPersistence().findByPrimaryKey(refreshTokenId);
	}

	/**
	 * Returns the refresh token entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param refreshTokenId the primary key of the refresh token entry
	 * @return the refresh token entry, or <code>null</code> if a refresh token entry with the primary key could not be found
	 */
	public static RefreshTokenEntry fetchByPrimaryKey(long refreshTokenId) {
		return getPersistence().fetchByPrimaryKey(refreshTokenId);
	}

	/**
	 * Returns all the refresh token entries.
	 *
	 * @return the refresh token entries
	 */
	public static List<RefreshTokenEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the refresh token entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RefreshTokenEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of refresh token entries
	 * @param end the upper bound of the range of refresh token entries (not inclusive)
	 * @return the range of refresh token entries
	 */
	public static List<RefreshTokenEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the refresh token entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RefreshTokenEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of refresh token entries
	 * @param end the upper bound of the range of refresh token entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of refresh token entries
	 */
	public static List<RefreshTokenEntry> findAll(
		int start, int end,
		OrderByComparator<RefreshTokenEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the refresh token entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RefreshTokenEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of refresh token entries
	 * @param end the upper bound of the range of refresh token entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of refresh token entries
	 */
	public static List<RefreshTokenEntry> findAll(
		int start, int end,
		OrderByComparator<RefreshTokenEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the refresh token entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of refresh token entries.
	 *
	 * @return the number of refresh token entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RefreshTokenEntryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RefreshTokenEntryPersistence, RefreshTokenEntryPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			RefreshTokenEntryPersistence.class);

		ServiceTracker
			<RefreshTokenEntryPersistence, RefreshTokenEntryPersistence>
				serviceTracker =
					new ServiceTracker
						<RefreshTokenEntryPersistence,
						 RefreshTokenEntryPersistence>(
							 bundle.getBundleContext(),
							 RefreshTokenEntryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}