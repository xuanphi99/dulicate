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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PetEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PetEntryLocalService
 * @generated
 */
public class PetEntryLocalServiceWrapper
	implements PetEntryLocalService, ServiceWrapper<PetEntryLocalService> {

	public PetEntryLocalServiceWrapper(
		PetEntryLocalService petEntryLocalService) {

		_petEntryLocalService = petEntryLocalService;
	}

	@Override
	public com.dogoo.poc.pet.model.PetEntry addPet(
		String name, String tag, long scopeOrgId, long creatorId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _petEntryLocalService.addPet(
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
	@Override
	public com.dogoo.poc.pet.model.PetEntry addPetEntry(
		com.dogoo.poc.pet.model.PetEntry petEntry) {

		return _petEntryLocalService.addPetEntry(petEntry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new pet entry with the primary key. Does not add the pet entry to the database.
	 *
	 * @param petId the primary key for the new pet entry
	 * @return the new pet entry
	 */
	@Override
	public com.dogoo.poc.pet.model.PetEntry createPetEntry(long petId) {
		return _petEntryLocalService.createPetEntry(petId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petEntryLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public com.dogoo.poc.pet.model.PetEntry deletePetEntry(long petId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petEntryLocalService.deletePetEntry(petId);
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
	@Override
	public com.dogoo.poc.pet.model.PetEntry deletePetEntry(
		com.dogoo.poc.pet.model.PetEntry petEntry) {

		return _petEntryLocalService.deletePetEntry(petEntry);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _petEntryLocalService.dslQuery(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _petEntryLocalService.dynamicQuery();
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

		return _petEntryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _petEntryLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _petEntryLocalService.dynamicQuery(
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

		return _petEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _petEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.dogoo.poc.pet.model.PetEntry fetchPetEntry(long petId) {
		return _petEntryLocalService.fetchPetEntry(petId);
	}

	/**
	 * Returns the pet entry matching the UUID and group.
	 *
	 * @param uuid the pet entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching pet entry, or <code>null</code> if a matching pet entry could not be found
	 */
	@Override
	public com.dogoo.poc.pet.model.PetEntry fetchPetEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return _petEntryLocalService.fetchPetEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _petEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _petEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _petEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _petEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petEntryLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.dogoo.poc.pet.model.PetEntry> getPetEntries(
		int start, int end) {

		return _petEntryLocalService.getPetEntries(start, end);
	}

	/**
	 * Returns all the pet entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the pet entries
	 * @param companyId the primary key of the company
	 * @return the matching pet entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.dogoo.poc.pet.model.PetEntry>
		getPetEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _petEntryLocalService.getPetEntriesByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.dogoo.poc.pet.model.PetEntry>
		getPetEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.dogoo.poc.pet.model.PetEntry> orderByComparator) {

		return _petEntryLocalService.getPetEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of pet entries.
	 *
	 * @return the number of pet entries
	 */
	@Override
	public int getPetEntriesCount() {
		return _petEntryLocalService.getPetEntriesCount();
	}

	/**
	 * Returns the pet entry with the primary key.
	 *
	 * @param petId the primary key of the pet entry
	 * @return the pet entry
	 * @throws PortalException if a pet entry with the primary key could not be found
	 */
	@Override
	public com.dogoo.poc.pet.model.PetEntry getPetEntry(long petId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petEntryLocalService.getPetEntry(petId);
	}

	/**
	 * Returns the pet entry matching the UUID and group.
	 *
	 * @param uuid the pet entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching pet entry
	 * @throws PortalException if a matching pet entry could not be found
	 */
	@Override
	public com.dogoo.poc.pet.model.PetEntry getPetEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petEntryLocalService.getPetEntryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.dogoo.poc.pet.model.PetEntry patchPet(
			long petId, String name, String tag, String status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petEntryLocalService.patchPet(
			petId, name, tag, status, serviceContext);
	}

	@Override
	public com.dogoo.poc.pet.model.PetEntry updatePet(
			long petId, String name, String tag, String status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _petEntryLocalService.updatePet(
			petId, name, tag, status, serviceContext);
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
	@Override
	public com.dogoo.poc.pet.model.PetEntry updatePetEntry(
		com.dogoo.poc.pet.model.PetEntry petEntry) {

		return _petEntryLocalService.updatePetEntry(petEntry);
	}

	@Override
	public PetEntryLocalService getWrappedService() {
		return _petEntryLocalService;
	}

	@Override
	public void setWrappedService(PetEntryLocalService petEntryLocalService) {
		_petEntryLocalService = petEntryLocalService;
	}

	private PetEntryLocalService _petEntryLocalService;

}