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

package com.dogoo.poc.pet.service;

import com.dogoo.poc.pet.model.PetEntry;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for PetEntry. This utility wraps
 * <code>com.dogoo.poc.pet.service.impl.PetEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PetEntryLocalService
 * @generated
 */
public class PetEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.dogoo.poc.pet.service.impl.PetEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static PetEntry addPet(
		String name, String tag, long scopeOrgId, long creatorId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().addPet(
			name, tag, scopeOrgId, creatorId, serviceContext);
	}

	/**
	 * Adds the pet entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petEntry the pet entry
	 * @return the pet entry that was added
	 */
	public static PetEntry addPetEntry(PetEntry petEntry) {
		return getService().addPetEntry(petEntry);
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
	 * Creates a new pet entry with the primary key. Does not add the pet entry to the database.
	 *
	 * @param petId the primary key for the new pet entry
	 * @return the new pet entry
	 */
	public static PetEntry createPetEntry(long petId) {
		return getService().createPetEntry(petId);
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
	 * Deletes the pet entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petId the primary key of the pet entry
	 * @return the pet entry that was removed
	 * @throws PortalException if a pet entry with the primary key could not be found
	 */
	public static PetEntry deletePetEntry(long petId) throws PortalException {
		return getService().deletePetEntry(petId);
	}

	/**
	 * Deletes the pet entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petEntry the pet entry
	 * @return the pet entry that was removed
	 */
	public static PetEntry deletePetEntry(PetEntry petEntry) {
		return getService().deletePetEntry(petEntry);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.poc.pet.model.impl.PetEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.poc.pet.model.impl.PetEntryModelImpl</code>.
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

	public static PetEntry fetchPetEntry(long petId) {
		return getService().fetchPetEntry(petId);
	}

	/**
	 * Returns the pet entry matching the UUID and group.
	 *
	 * @param uuid the pet entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	public static PetEntry fetchPetEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchPetEntryByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
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
	 * Returns a range of all the pet entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dogoo.poc.pet.model.impl.PetEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @return the range of pet entries
	 */
	public static List<PetEntry> getPetEntries(int start, int end) {
		return getService().getPetEntries(start, end);
	}

	/**
	 * Returns all the pet entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the pet entries
	 * @param companyId the primary key of the company
	 * @return the matching pet entries, or an empty list if no matches were found
	 */
	public static List<PetEntry> getPetEntriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getPetEntriesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of pet entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the pet entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of pet entries
	 * @param end the upper bound of the range of pet entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching pet entries, or an empty list if no matches were found
	 */
	public static List<PetEntry> getPetEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PetEntry> orderByComparator) {

		return getService().getPetEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of pet entries.
	 *
	 * @return the number of pet entries
	 */
	public static int getPetEntriesCount() {
		return getService().getPetEntriesCount();
	}

	/**
	 * Returns the pet entry with the primary key.
	 *
	 * @param petId the primary key of the pet entry
	 * @return the pet entry
	 * @throws PortalException if a pet entry with the primary key could not be found
	 */
	public static PetEntry getPetEntry(long petId) throws PortalException {
		return getService().getPetEntry(petId);
	}

	/**
	 * Returns the pet entry matching the UUID and group.
	 *
	 * @param uuid the pet entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching pet entry
	 * @throws PortalException if a matching pet entry could not be found
	 */
	public static PetEntry getPetEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getPetEntryByUuidAndGroupId(uuid, groupId);
	}

	public static PetEntry patchPet(
			long petId, String name, String tag, String status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().patchPet(petId, name, tag, status, serviceContext);
	}

	public static PetEntry updatePet(
			long petId, String name, String tag, String status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updatePet(petId, name, tag, status, serviceContext);
	}

	/**
	 * Updates the pet entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petEntry the pet entry
	 * @return the pet entry that was updated
	 */
	public static PetEntry updatePetEntry(PetEntry petEntry) {
		return getService().updatePetEntry(petEntry);
	}

	public static PetEntryLocalService getService() {
		return _service;
	}

	private static volatile PetEntryLocalService _service;

}