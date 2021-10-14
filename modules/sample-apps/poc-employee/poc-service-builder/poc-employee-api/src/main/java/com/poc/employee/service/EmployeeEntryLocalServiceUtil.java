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

package com.poc.employee.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.poc.employee.model.EmployeeEntry;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for EmployeeEntry. This utility wraps
 * <code>com.poc.employee.service.impl.EmployeeEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeEntryLocalService
 * @generated
 */
public class EmployeeEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.poc.employee.service.impl.EmployeeEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static EmployeeEntry addEmployee(
		String name, java.util.Date birthDay, int gender, String address,
		boolean hasAccount,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().addEmployee(
			name, birthDay, gender, address, hasAccount, serviceContext);
	}

	/**
	 * Adds the employee entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeEntry the employee entry
	 * @return the employee entry that was added
	 */
	public static EmployeeEntry addEmployeeEntry(EmployeeEntry employeeEntry) {
		return getService().addEmployeeEntry(employeeEntry);
	}

	/**
	 * Creates a new employee entry with the primary key. Does not add the employee entry to the database.
	 *
	 * @param employeeId the primary key for the new employee entry
	 * @return the new employee entry
	 */
	public static EmployeeEntry createEmployeeEntry(long employeeId) {
		return getService().createEmployeeEntry(employeeId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static EmployeeEntry deleteEmployee(long employeeId)
		throws com.poc.employee.exception.NoSuchEmployeeEntryException {

		return getService().deleteEmployee(employeeId);
	}

	/**
	 * Deletes the employee entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeEntry the employee entry
	 * @return the employee entry that was removed
	 */
	public static EmployeeEntry deleteEmployeeEntry(
		EmployeeEntry employeeEntry) {

		return getService().deleteEmployeeEntry(employeeEntry);
	}

	/**
	 * Deletes the employee entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeId the primary key of the employee entry
	 * @return the employee entry that was removed
	 * @throws PortalException if a employee entry with the primary key could not be found
	 */
	public static EmployeeEntry deleteEmployeeEntry(long employeeId)
		throws PortalException {

		return getService().deleteEmployeeEntry(employeeId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.poc.employee.model.impl.EmployeeEntryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.poc.employee.model.impl.EmployeeEntryModelImpl</code>.
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

	public static EmployeeEntry fetchEmployeeEntry(long employeeId) {
		return getService().fetchEmployeeEntry(employeeId);
	}

	/**
	 * Returns the employee entry matching the UUID and group.
	 *
	 * @param uuid the employee entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee entry, or <code>null</code> if a matching employee entry could not be found
	 */
	public static EmployeeEntry fetchEmployeeEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchEmployeeEntryByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static EmployeeEntry getDetailEmployee(long employeeId)
		throws com.poc.employee.exception.NoSuchEmployeeEntryException {

		return getService().getDetailEmployee(employeeId);
	}

	/**
	 * Returns a range of all the employee entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.poc.employee.model.impl.EmployeeEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee entries
	 * @param end the upper bound of the range of employee entries (not inclusive)
	 * @return the range of employee entries
	 */
	public static List<EmployeeEntry> getEmployeeEntries(int start, int end) {
		return getService().getEmployeeEntries(start, end);
	}

	/**
	 * Returns all the employee entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee entries
	 * @param companyId the primary key of the company
	 * @return the matching employee entries, or an empty list if no matches were found
	 */
	public static List<EmployeeEntry> getEmployeeEntriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getEmployeeEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of employee entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the employee entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of employee entries
	 * @param end the upper bound of the range of employee entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching employee entries, or an empty list if no matches were found
	 */
	public static List<EmployeeEntry> getEmployeeEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmployeeEntry> orderByComparator) {

		return getService().getEmployeeEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of employee entries.
	 *
	 * @return the number of employee entries
	 */
	public static int getEmployeeEntriesCount() {
		return getService().getEmployeeEntriesCount();
	}

	/**
	 * Returns the employee entry with the primary key.
	 *
	 * @param employeeId the primary key of the employee entry
	 * @return the employee entry
	 * @throws PortalException if a employee entry with the primary key could not be found
	 */
	public static EmployeeEntry getEmployeeEntry(long employeeId)
		throws PortalException {

		return getService().getEmployeeEntry(employeeId);
	}

	/**
	 * Returns the employee entry matching the UUID and group.
	 *
	 * @param uuid the employee entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching employee entry
	 * @throws PortalException if a matching employee entry could not be found
	 */
	public static EmployeeEntry getEmployeeEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getEmployeeEntryByUuidAndGroupId(uuid, groupId);
	}

	public static List<EmployeeEntry> getEmployees(int start, int end) {
		return getService().getEmployees(start, end);
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

	public static EmployeeEntry patchEmployee(
			long employeeId, String name, java.util.Date birthDay, int gender,
			String address, boolean hasAccount,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().patchEmployee(
			employeeId, name, birthDay, gender, address, hasAccount,
			serviceContext);
	}

	public static EmployeeEntry updateEmployee(
			long employeeId, String name, java.util.Date birthDay, int gender,
			String address, boolean hasAccount,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateEmployee(
			employeeId, name, birthDay, gender, address, hasAccount,
			serviceContext);
	}

	/**
	 * Updates the employee entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeEntry the employee entry
	 * @return the employee entry that was updated
	 */
	public static EmployeeEntry updateEmployeeEntry(
		EmployeeEntry employeeEntry) {

		return getService().updateEmployeeEntry(employeeEntry);
	}

	public static EmployeeEntryLocalService getService() {
		return _service;
	}

	private static volatile EmployeeEntryLocalService _service;

}