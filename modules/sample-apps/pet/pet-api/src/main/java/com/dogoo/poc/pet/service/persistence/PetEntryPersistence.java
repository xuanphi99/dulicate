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

package com.dogoo.poc.pet.service.persistence;

import com.dogoo.poc.pet.exception.NoSuchPetEntryException;
import com.dogoo.poc.pet.model.PetEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the pet entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PetEntryUtil
 * @generated
 */
@ProviderType
public interface PetEntryPersistence extends BasePersistence<PetEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PetEntryUtil} to access the pet entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the pet entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching pet entries
	 */
	public java.util.List<PetEntry> findByUuid(String uuid);

	/**
	 * Returns a range of all the pet entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @return the range of matching pet entries
	 */
	public java.util.List<PetEntry> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the pet entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pet entries
	 */
	public java.util.List<PetEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the pet entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pet entries
	 */
	public java.util.List<PetEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pet entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	public PetEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
				orderByComparator)
		throws NoSuchPetEntryException;

	/**
	 * Returns the first pet entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public PetEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator);

	/**
	 * Returns the last pet entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	public PetEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
				orderByComparator)
		throws NoSuchPetEntryException;

	/**
	 * Returns the last pet entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public PetEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator);

	/**
	 * Returns the pet entries before and after the current pet entry in the ordered set where uuid = &#63;.
	 *
	 * @param petId the primary key of the current pet entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet entry
	 * @throws NoSuchPetEntryException if a pet entry with the primary key could not be found
	 */
	public PetEntry[] findByUuid_PrevAndNext(
			long petId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
				orderByComparator)
		throws NoSuchPetEntryException;

	/**
	 * Removes all the pet entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of pet entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching pet entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the pet entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPetEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	public PetEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchPetEntryException;

	/**
	 * Returns the pet entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public PetEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the pet entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public PetEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the pet entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the pet entry that was removed
	 */
	public PetEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchPetEntryException;

	/**
	 * Returns the number of pet entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching pet entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the pet entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching pet entries
	 */
	public java.util.List<PetEntry> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the pet entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @return the range of matching pet entries
	 */
	public java.util.List<PetEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the pet entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pet entries
	 */
	public java.util.List<PetEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the pet entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pet entries
	 */
	public java.util.List<PetEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pet entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	public PetEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
				orderByComparator)
		throws NoSuchPetEntryException;

	/**
	 * Returns the first pet entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public PetEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator);

	/**
	 * Returns the last pet entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	public PetEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
				orderByComparator)
		throws NoSuchPetEntryException;

	/**
	 * Returns the last pet entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public PetEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator);

	/**
	 * Returns the pet entries before and after the current pet entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param petId the primary key of the current pet entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet entry
	 * @throws NoSuchPetEntryException if a pet entry with the primary key could not be found
	 */
	public PetEntry[] findByUuid_C_PrevAndNext(
			long petId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
				orderByComparator)
		throws NoSuchPetEntryException;

	/**
	 * Removes all the pet entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of pet entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching pet entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the pet entries where tag = &#63;.
	 *
	 * @param tag the tag
	 * @return the matching pet entries
	 */
	public java.util.List<PetEntry> findByT_S(String tag);

	/**
	 * Returns a range of all the pet entries where tag = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tag the tag
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @return the range of matching pet entries
	 */
	public java.util.List<PetEntry> findByT_S(String tag, int start, int end);

	/**
	 * Returns an ordered range of all the pet entries where tag = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tag the tag
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pet entries
	 */
	public java.util.List<PetEntry> findByT_S(
		String tag, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the pet entries where tag = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param tag the tag
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pet entries
	 */
	public java.util.List<PetEntry> findByT_S(
		String tag, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pet entry in the ordered set where tag = &#63;.
	 *
	 * @param tag the tag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	public PetEntry findByT_S_First(
			String tag,
			com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
				orderByComparator)
		throws NoSuchPetEntryException;

	/**
	 * Returns the first pet entry in the ordered set where tag = &#63;.
	 *
	 * @param tag the tag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public PetEntry fetchByT_S_First(
		String tag,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator);

	/**
	 * Returns the last pet entry in the ordered set where tag = &#63;.
	 *
	 * @param tag the tag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry
	 * @throws NoSuchPetEntryException if a matching pet entry could not be found
	 */
	public PetEntry findByT_S_Last(
			String tag,
			com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
				orderByComparator)
		throws NoSuchPetEntryException;

	/**
	 * Returns the last pet entry in the ordered set where tag = &#63;.
	 *
	 * @param tag the tag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public PetEntry fetchByT_S_Last(
		String tag,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator);

	/**
	 * Returns the pet entries before and after the current pet entry in the ordered set where tag = &#63;.
	 *
	 * @param petId the primary key of the current pet entry
	 * @param tag the tag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pet entry
	 * @throws NoSuchPetEntryException if a pet entry with the primary key could not be found
	 */
	public PetEntry[] findByT_S_PrevAndNext(
			long petId, String tag,
			com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
				orderByComparator)
		throws NoSuchPetEntryException;

	/**
	 * Removes all the pet entries where tag = &#63; from the database.
	 *
	 * @param tag the tag
	 */
	public void removeByT_S(String tag);

	/**
	 * Returns the number of pet entries where tag = &#63;.
	 *
	 * @param tag the tag
	 * @return the number of matching pet entries
	 */
	public int countByT_S(String tag);

	/**
	 * Caches the pet entry in the entity cache if it is enabled.
	 *
	 * @param petEntry the pet entry
	 */
	public void cacheResult(PetEntry petEntry);

	/**
	 * Caches the pet entries in the entity cache if it is enabled.
	 *
	 * @param petEntries the pet entries
	 */
	public void cacheResult(java.util.List<PetEntry> petEntries);

	/**
	 * Creates a new pet entry with the primary key. Does not add the pet entry to the database.
	 *
	 * @param petId the primary key for the new pet entry
	 * @return the new pet entry
	 */
	public PetEntry create(long petId);

	/**
	 * Removes the pet entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param petId the primary key of the pet entry
	 * @return the pet entry that was removed
	 * @throws NoSuchPetEntryException if a pet entry with the primary key could not be found
	 */
	public PetEntry remove(long petId) throws NoSuchPetEntryException;

	public PetEntry updateImpl(PetEntry petEntry);

	/**
	 * Returns the pet entry with the primary key or throws a <code>NoSuchPetEntryException</code> if it could not be found.
	 *
	 * @param petId the primary key of the pet entry
	 * @return the pet entry
	 * @throws NoSuchPetEntryException if a pet entry with the primary key could not be found
	 */
	public PetEntry findByPrimaryKey(long petId) throws NoSuchPetEntryException;

	/**
	 * Returns the pet entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param petId the primary key of the pet entry
	 * @return the pet entry, or <code>null</code> if a pet entry with the primary key could not be found
	 */
	public PetEntry fetchByPrimaryKey(long petId);

	/**
	 * Returns all the pet entries.
	 *
	 * @return the pet entries
	 */
	public java.util.List<PetEntry> findAll();

	/**
	 * Returns a range of all the pet entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @return the range of pet entries
	 */
	public java.util.List<PetEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the pet entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pet entries
	 */
	public java.util.List<PetEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the pet entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pet entries
	 */
	public java.util.List<PetEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PetEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the pet entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of pet entries.
	 *
	 * @return the number of pet entries
	 */
	public int countAll();

}