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

import com.dogoo.authz.exception.NoSuchRefreshTokenEntryException;
import com.dogoo.authz.model.RefreshTokenEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the refresh token entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RefreshTokenEntryUtil
 * @generated
 */
@ProviderType
public interface RefreshTokenEntryPersistence
	extends BasePersistence<RefreshTokenEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RefreshTokenEntryUtil} to access the refresh token entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the refresh token entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching refresh token entries
	 */
	public java.util.List<RefreshTokenEntry> findByUuid(String uuid);

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
	public java.util.List<RefreshTokenEntry> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<RefreshTokenEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RefreshTokenEntry>
			orderByComparator);

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
	public java.util.List<RefreshTokenEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RefreshTokenEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first refresh token entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching refresh token entry
	 * @throws NoSuchRefreshTokenEntryException if a matching refresh token entry could not be found
	 */
	public RefreshTokenEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<RefreshTokenEntry>
				orderByComparator)
		throws NoSuchRefreshTokenEntryException;

	/**
	 * Returns the first refresh token entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching refresh token entry, or <code>null</code> if a matching refresh token entry could not be found
	 */
	public RefreshTokenEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RefreshTokenEntry>
			orderByComparator);

	/**
	 * Returns the last refresh token entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching refresh token entry
	 * @throws NoSuchRefreshTokenEntryException if a matching refresh token entry could not be found
	 */
	public RefreshTokenEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<RefreshTokenEntry>
				orderByComparator)
		throws NoSuchRefreshTokenEntryException;

	/**
	 * Returns the last refresh token entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching refresh token entry, or <code>null</code> if a matching refresh token entry could not be found
	 */
	public RefreshTokenEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RefreshTokenEntry>
			orderByComparator);

	/**
	 * Returns the refresh token entries before and after the current refresh token entry in the ordered set where uuid = &#63;.
	 *
	 * @param refreshTokenId the primary key of the current refresh token entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next refresh token entry
	 * @throws NoSuchRefreshTokenEntryException if a refresh token entry with the primary key could not be found
	 */
	public RefreshTokenEntry[] findByUuid_PrevAndNext(
			long refreshTokenId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<RefreshTokenEntry>
				orderByComparator)
		throws NoSuchRefreshTokenEntryException;

	/**
	 * Removes all the refresh token entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of refresh token entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching refresh token entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the refresh token entry where token = &#63; or throws a <code>NoSuchRefreshTokenEntryException</code> if it could not be found.
	 *
	 * @param token the token
	 * @return the matching refresh token entry
	 * @throws NoSuchRefreshTokenEntryException if a matching refresh token entry could not be found
	 */
	public RefreshTokenEntry findByT_K(String token)
		throws NoSuchRefreshTokenEntryException;

	/**
	 * Returns the refresh token entry where token = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param token the token
	 * @return the matching refresh token entry, or <code>null</code> if a matching refresh token entry could not be found
	 */
	public RefreshTokenEntry fetchByT_K(String token);

	/**
	 * Returns the refresh token entry where token = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param token the token
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching refresh token entry, or <code>null</code> if a matching refresh token entry could not be found
	 */
	public RefreshTokenEntry fetchByT_K(String token, boolean useFinderCache);

	/**
	 * Removes the refresh token entry where token = &#63; from the database.
	 *
	 * @param token the token
	 * @return the refresh token entry that was removed
	 */
	public RefreshTokenEntry removeByT_K(String token)
		throws NoSuchRefreshTokenEntryException;

	/**
	 * Returns the number of refresh token entries where token = &#63;.
	 *
	 * @param token the token
	 * @return the number of matching refresh token entries
	 */
	public int countByT_K(String token);

	/**
	 * Returns the refresh token entry where userName = &#63; or throws a <code>NoSuchRefreshTokenEntryException</code> if it could not be found.
	 *
	 * @param userName the user name
	 * @return the matching refresh token entry
	 * @throws NoSuchRefreshTokenEntryException if a matching refresh token entry could not be found
	 */
	public RefreshTokenEntry findByU_N(String userName)
		throws NoSuchRefreshTokenEntryException;

	/**
	 * Returns the refresh token entry where userName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userName the user name
	 * @return the matching refresh token entry, or <code>null</code> if a matching refresh token entry could not be found
	 */
	public RefreshTokenEntry fetchByU_N(String userName);

	/**
	 * Returns the refresh token entry where userName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userName the user name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching refresh token entry, or <code>null</code> if a matching refresh token entry could not be found
	 */
	public RefreshTokenEntry fetchByU_N(
		String userName, boolean useFinderCache);

	/**
	 * Removes the refresh token entry where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 * @return the refresh token entry that was removed
	 */
	public RefreshTokenEntry removeByU_N(String userName)
		throws NoSuchRefreshTokenEntryException;

	/**
	 * Returns the number of refresh token entries where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching refresh token entries
	 */
	public int countByU_N(String userName);

	/**
	 * Caches the refresh token entry in the entity cache if it is enabled.
	 *
	 * @param refreshTokenEntry the refresh token entry
	 */
	public void cacheResult(RefreshTokenEntry refreshTokenEntry);

	/**
	 * Caches the refresh token entries in the entity cache if it is enabled.
	 *
	 * @param refreshTokenEntries the refresh token entries
	 */
	public void cacheResult(
		java.util.List<RefreshTokenEntry> refreshTokenEntries);

	/**
	 * Creates a new refresh token entry with the primary key. Does not add the refresh token entry to the database.
	 *
	 * @param refreshTokenId the primary key for the new refresh token entry
	 * @return the new refresh token entry
	 */
	public RefreshTokenEntry create(long refreshTokenId);

	/**
	 * Removes the refresh token entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param refreshTokenId the primary key of the refresh token entry
	 * @return the refresh token entry that was removed
	 * @throws NoSuchRefreshTokenEntryException if a refresh token entry with the primary key could not be found
	 */
	public RefreshTokenEntry remove(long refreshTokenId)
		throws NoSuchRefreshTokenEntryException;

	public RefreshTokenEntry updateImpl(RefreshTokenEntry refreshTokenEntry);

	/**
	 * Returns the refresh token entry with the primary key or throws a <code>NoSuchRefreshTokenEntryException</code> if it could not be found.
	 *
	 * @param refreshTokenId the primary key of the refresh token entry
	 * @return the refresh token entry
	 * @throws NoSuchRefreshTokenEntryException if a refresh token entry with the primary key could not be found
	 */
	public RefreshTokenEntry findByPrimaryKey(long refreshTokenId)
		throws NoSuchRefreshTokenEntryException;

	/**
	 * Returns the refresh token entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param refreshTokenId the primary key of the refresh token entry
	 * @return the refresh token entry, or <code>null</code> if a refresh token entry with the primary key could not be found
	 */
	public RefreshTokenEntry fetchByPrimaryKey(long refreshTokenId);

	/**
	 * Returns all the refresh token entries.
	 *
	 * @return the refresh token entries
	 */
	public java.util.List<RefreshTokenEntry> findAll();

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
	public java.util.List<RefreshTokenEntry> findAll(int start, int end);

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
	public java.util.List<RefreshTokenEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RefreshTokenEntry>
			orderByComparator);

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
	public java.util.List<RefreshTokenEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RefreshTokenEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the refresh token entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of refresh token entries.
	 *
	 * @return the number of refresh token entries
	 */
	public int countAll();

}