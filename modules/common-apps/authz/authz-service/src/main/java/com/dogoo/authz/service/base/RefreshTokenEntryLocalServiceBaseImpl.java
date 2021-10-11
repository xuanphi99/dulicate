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

package com.dogoo.authz.service.base;

import com.dogoo.authz.model.RefreshTokenEntry;
import com.dogoo.authz.service.RefreshTokenEntryLocalService;
import com.dogoo.authz.service.RefreshTokenEntryLocalServiceUtil;
import com.dogoo.authz.service.persistence.RefreshTokenEntryPersistence;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the refresh token entry local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.dogoo.authz.service.impl.RefreshTokenEntryLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.dogoo.authz.service.impl.RefreshTokenEntryLocalServiceImpl
 * @generated
 */
public abstract class RefreshTokenEntryLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService,
			   RefreshTokenEntryLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>RefreshTokenEntryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>RefreshTokenEntryLocalServiceUtil</code>.
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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public RefreshTokenEntry addRefreshTokenEntry(
		RefreshTokenEntry refreshTokenEntry) {

		refreshTokenEntry.setNew(true);

		return refreshTokenEntryPersistence.update(refreshTokenEntry);
	}

	/**
	 * Creates a new refresh token entry with the primary key. Does not add the refresh token entry to the database.
	 *
	 * @param refreshTokenId the primary key for the new refresh token entry
	 * @return the new refresh token entry
	 */
	@Override
	@Transactional(enabled = false)
	public RefreshTokenEntry createRefreshTokenEntry(long refreshTokenId) {
		return refreshTokenEntryPersistence.create(refreshTokenId);
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
	@Indexable(type = IndexableType.DELETE)
	@Override
	public RefreshTokenEntry deleteRefreshTokenEntry(long refreshTokenId)
		throws PortalException {

		return refreshTokenEntryPersistence.remove(refreshTokenId);
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
	@Indexable(type = IndexableType.DELETE)
	@Override
	public RefreshTokenEntry deleteRefreshTokenEntry(
		RefreshTokenEntry refreshTokenEntry) {

		return refreshTokenEntryPersistence.remove(refreshTokenEntry);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return refreshTokenEntryPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			RefreshTokenEntry.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return refreshTokenEntryPersistence.findWithDynamicQuery(dynamicQuery);
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return refreshTokenEntryPersistence.findWithDynamicQuery(
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return refreshTokenEntryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return refreshTokenEntryPersistence.countWithDynamicQuery(dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return refreshTokenEntryPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public RefreshTokenEntry fetchRefreshTokenEntry(long refreshTokenId) {
		return refreshTokenEntryPersistence.fetchByPrimaryKey(refreshTokenId);
	}

	/**
	 * Returns the refresh token entry with the primary key.
	 *
	 * @param refreshTokenId the primary key of the refresh token entry
	 * @return the refresh token entry
	 * @throws PortalException if a refresh token entry with the primary key could not be found
	 */
	@Override
	public RefreshTokenEntry getRefreshTokenEntry(long refreshTokenId)
		throws PortalException {

		return refreshTokenEntryPersistence.findByPrimaryKey(refreshTokenId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			refreshTokenEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(RefreshTokenEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("refreshTokenId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			refreshTokenEntryLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(RefreshTokenEntry.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"refreshTokenId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			refreshTokenEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(RefreshTokenEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("refreshTokenId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return refreshTokenEntryPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return refreshTokenEntryLocalService.deleteRefreshTokenEntry(
			(RefreshTokenEntry)persistedModel);
	}

	@Override
	public BasePersistence<RefreshTokenEntry> getBasePersistence() {
		return refreshTokenEntryPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return refreshTokenEntryPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<RefreshTokenEntry> getRefreshTokenEntries(int start, int end) {
		return refreshTokenEntryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of refresh token entries.
	 *
	 * @return the number of refresh token entries
	 */
	@Override
	public int getRefreshTokenEntriesCount() {
		return refreshTokenEntryPersistence.countAll();
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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public RefreshTokenEntry updateRefreshTokenEntry(
		RefreshTokenEntry refreshTokenEntry) {

		return refreshTokenEntryPersistence.update(refreshTokenEntry);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			RefreshTokenEntryLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		refreshTokenEntryLocalService = (RefreshTokenEntryLocalService)aopProxy;

		_setLocalServiceUtilService(refreshTokenEntryLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return RefreshTokenEntryLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return RefreshTokenEntry.class;
	}

	protected String getModelClassName() {
		return RefreshTokenEntry.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				refreshTokenEntryPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		RefreshTokenEntryLocalService refreshTokenEntryLocalService) {

		try {
			Field field =
				RefreshTokenEntryLocalServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, refreshTokenEntryLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	protected RefreshTokenEntryLocalService refreshTokenEntryLocalService;

	@Reference
	protected RefreshTokenEntryPersistence refreshTokenEntryPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}