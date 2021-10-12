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

package com.poc.employee.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.poc.employee.exception.NoSuchEmployeeEntryException;
import com.poc.employee.model.EmployeeEntry;
import com.poc.employee.service.base.EmployeeEntryLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import javax.ws.rs.PUT;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * The implementation of the employee entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.poc.employee.service.EmployeeEntryLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeEntryLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.poc.employee.model.EmployeeEntry",
	service = AopService.class
)
public class EmployeeEntryLocalServiceImpl
	extends EmployeeEntryLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.poc.employee.service.EmployeeEntryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.poc.employee.service.EmployeeEntryLocalServiceUtil</code>.
	 */

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public EmployeeEntry addEmployee(String name , Date birthDay , int gender, String address , boolean hasAccount,ServiceContext serviceContext) {
		EmployeeEntry employeeEntry = createEmployeeEntry(String.valueOf(counterLocalService.increment(EmployeeEntry.class.getName())));

		Date current = new Date();

		updateModifierAudit(employeeEntry,current,serviceContext);

		employeeEntry.setGroupId(serviceContext.getScopeGroupId());
		employeeEntry.setCompanyId(serviceContext.getCompanyId());
		employeeEntry.setCreateDate(serviceContext.getCreateDate(current));
		employeeEntry.setModifiedDate(serviceContext.getModifiedDate(current));


		employeeEntry.setName(name);
		employeeEntry.setBirthDay(birthDay);
		employeeEntry.setGender(gender);
		employeeEntry.setAddress(address);
		employeeEntry.setHasAccount(hasAccount);

		return addEmployeeEntry(employeeEntry);

	}



	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public EmployeeEntry updateEmployee(String  employeeId, String name , Date birthDay , int gender, String address , boolean hasAccount,ServiceContext serviceContext) throws PortalException {

		EmployeeEntry employeeEntry = getEmployeeEntry(employeeId);

		Date current = new Date();

		updateModifierAudit(employeeEntry,current,serviceContext);

		employeeEntry.setName(name);
		employeeEntry.setBirthDay(birthDay);
		employeeEntry.setGender(gender);
		employeeEntry.setAddress(address);
		employeeEntry.setHasAccount(hasAccount);

		return updateEmployeeEntry(employeeEntry);

	}



	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public EmployeeEntry patchEmployee(String  employeeId, String name , Date birthDay , int gender, String address , boolean hasAccount,ServiceContext serviceContext) throws PortalException {
		EmployeeEntry employeeEntry = getEmployeeEntry(employeeId);
		Date current = new Date();
		boolean changed = false;
		if (name !=null){
			employeeEntry.setName(name);
			changed = true;
		}
		if (birthDay !=null){
			employeeEntry.setBirthDay(birthDay);
			changed = true;
		}
		if (Objects.nonNull(gender)  ){
			employeeEntry.setGender(gender);
			changed = true;
		}
		if (address != null ){
			employeeEntry.setAddress(address);
			changed = true;
		}

		if (Objects.nonNull(hasAccount)){
			employeeEntry.setHasAccount(hasAccount);
			changed = true;
		}

		if (changed){
			updateModifierAudit(employeeEntry,current,serviceContext);
		}

		return updateEmployeeEntry(employeeEntry);


	}

	@Indexable(type = IndexableType.REINDEX)
	public EmployeeEntry deleteEmployee(String employeeId) throws NoSuchEmployeeEntryException {
		return employeeEntryPersistence.remove(employeeId);
	}

	@Indexable(type = IndexableType.REINDEX)
	public EmployeeEntry getDetailEmployee(String employeeId) throws NoSuchEmployeeEntryException {
		return employeeEntryPersistence.findByPrimaryKey(employeeId);
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
				new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
				employeeEntryLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(EmployeeEntry.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("employeeId");

		return indexableActionableDynamicQuery;
	}

	@Indexable(type = IndexableType.REINDEX)
	public List<EmployeeEntry> getStudents(int start, int end) {
		return employeeEntryPersistence.findAll(start, end);
	}

	private void updateModifierAudit(EmployeeEntry employee , Date current, ServiceContext serviceContext) {
		User user = userLocalService.fetchUser(serviceContext.getUserId());

		if (user != null) {
			employee.setUserName(user.getFullName());
			employee.setUserUuid(user.getUserUuid());
		}

		employee.setModifiedDate(serviceContext.getModifiedDate(current));
		employee.setUserId(serviceContext.getUserId());

	}


}