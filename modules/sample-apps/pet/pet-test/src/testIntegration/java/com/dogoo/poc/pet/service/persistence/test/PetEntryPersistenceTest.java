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

package com.dogoo.poc.pet.service.persistence.test;

import com.dogoo.poc.pet.exception.NoSuchPetEntryException;
import com.dogoo.poc.pet.model.PetEntry;
import com.dogoo.poc.pet.service.PetEntryLocalServiceUtil;
import com.dogoo.poc.pet.service.persistence.PetEntryPersistence;
import com.dogoo.poc.pet.service.persistence.PetEntryUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class PetEntryPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.dogoo.poc.pet.service"));

	@Before
	public void setUp() {
		_persistence = PetEntryUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<PetEntry> iterator = _petEntries.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PetEntry petEntry = _persistence.create(pk);

		Assert.assertNotNull(petEntry);

		Assert.assertEquals(petEntry.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		PetEntry newPetEntry = addPetEntry();

		_persistence.remove(newPetEntry);

		PetEntry existingPetEntry = _persistence.fetchByPrimaryKey(
			newPetEntry.getPrimaryKey());

		Assert.assertNull(existingPetEntry);
	}


	@Test
	public void testUpdateNew() throws Exception {
		addPetEntry();
	}



	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PetEntry newPetEntry = _persistence.create(pk);

		newPetEntry.setUuid(RandomTestUtil.randomString());

		newPetEntry.setGroupId(RandomTestUtil.nextLong());

		newPetEntry.setCompanyId(RandomTestUtil.nextLong());

		newPetEntry.setUserId(RandomTestUtil.nextLong());

		newPetEntry.setUserName(RandomTestUtil.randomString());

		newPetEntry.setCreateDate(RandomTestUtil.nextDate());

		newPetEntry.setModifiedDate(RandomTestUtil.nextDate());

		newPetEntry.setCreatorId(RandomTestUtil.nextLong());

		newPetEntry.setScopeOrgId(RandomTestUtil.nextLong());

		newPetEntry.setName(RandomTestUtil.randomString());

		newPetEntry.setTag(RandomTestUtil.randomString());

		newPetEntry.setStatus(RandomTestUtil.randomString());

		newPetEntry.setStatusDate(RandomTestUtil.nextDate());

		_petEntries.add(_persistence.update(newPetEntry));

		PetEntry existingPetEntry = _persistence.findByPrimaryKey(
			newPetEntry.getPrimaryKey());

		Assert.assertEquals(existingPetEntry.getUuid(), newPetEntry.getUuid());
		Assert.assertEquals(
			existingPetEntry.getPetId(), newPetEntry.getPetId());
		Assert.assertEquals(
			existingPetEntry.getGroupId(), newPetEntry.getGroupId());
		Assert.assertEquals(
			existingPetEntry.getCompanyId(), newPetEntry.getCompanyId());
		Assert.assertEquals(
			existingPetEntry.getUserId(), newPetEntry.getUserId());
		Assert.assertEquals(
			existingPetEntry.getUserName(), newPetEntry.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingPetEntry.getCreateDate()),
			Time.getShortTimestamp(newPetEntry.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingPetEntry.getModifiedDate()),
			Time.getShortTimestamp(newPetEntry.getModifiedDate()));
		Assert.assertEquals(
			existingPetEntry.getCreatorId(), newPetEntry.getCreatorId());
		Assert.assertEquals(
			existingPetEntry.getScopeOrgId(), newPetEntry.getScopeOrgId());
		Assert.assertEquals(existingPetEntry.getName(), newPetEntry.getName());
		Assert.assertEquals(existingPetEntry.getTag(), newPetEntry.getTag());
		Assert.assertEquals(
			existingPetEntry.getStatus(), newPetEntry.getStatus());
		Assert.assertEquals(
			Time.getShortTimestamp(existingPetEntry.getStatusDate()),
			Time.getShortTimestamp(newPetEntry.getStatusDate()));
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G("", RandomTestUtil.nextLong());

		_persistence.countByUUID_G("null", 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C("", RandomTestUtil.nextLong());

		_persistence.countByUuid_C("null", 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByT_S() throws Exception {
		_persistence.countByT_S("");

		_persistence.countByT_S("null");

		_persistence.countByT_S((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		PetEntry newPetEntry = addPetEntry();

		PetEntry existingPetEntry = _persistence.findByPrimaryKey(
			newPetEntry.getPrimaryKey());

		Assert.assertEquals(existingPetEntry, newPetEntry);
	}

	@Test(expected = NoSuchPetEntryException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<PetEntry> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"DG_PetEntry", "uuid", true, "petId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "creatorId", true, "scopeOrgId", true,
			"name", true, "tag", true, "status", true, "statusDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		PetEntry newPetEntry = addPetEntry();

		PetEntry existingPetEntry = _persistence.fetchByPrimaryKey(
			newPetEntry.getPrimaryKey());

		Assert.assertEquals(existingPetEntry, newPetEntry);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PetEntry missingPetEntry = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingPetEntry);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		PetEntry newPetEntry1 = addPetEntry();
		PetEntry newPetEntry2 = addPetEntry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPetEntry1.getPrimaryKey());
		primaryKeys.add(newPetEntry2.getPrimaryKey());

		Map<Serializable, PetEntry> petEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, petEntries.size());
		Assert.assertEquals(
			newPetEntry1, petEntries.get(newPetEntry1.getPrimaryKey()));
		Assert.assertEquals(
			newPetEntry2, petEntries.get(newPetEntry2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, PetEntry> petEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(petEntries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		PetEntry newPetEntry = addPetEntry();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPetEntry.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, PetEntry> petEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, petEntries.size());
		Assert.assertEquals(
			newPetEntry, petEntries.get(newPetEntry.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, PetEntry> petEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(petEntries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		PetEntry newPetEntry = addPetEntry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPetEntry.getPrimaryKey());

		Map<Serializable, PetEntry> petEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, petEntries.size());
		Assert.assertEquals(
			newPetEntry, petEntries.get(newPetEntry.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			PetEntryLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<PetEntry>() {

				@Override
				public void performAction(PetEntry petEntry) {
					Assert.assertNotNull(petEntry);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		PetEntry newPetEntry = addPetEntry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PetEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("petId", newPetEntry.getPetId()));

		List<PetEntry> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		PetEntry existingPetEntry = result.get(0);

		Assert.assertEquals(existingPetEntry, newPetEntry);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PetEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("petId", RandomTestUtil.nextLong()));

		List<PetEntry> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		PetEntry newPetEntry = addPetEntry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PetEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("petId"));

		Object newPetId = newPetEntry.getPetId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("petId", new Object[] {newPetId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingPetId = result.get(0);

		Assert.assertEquals(existingPetId, newPetId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PetEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("petId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"petId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		PetEntry newPetEntry = addPetEntry();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newPetEntry.getPrimaryKey()));
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromDatabase()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(true);
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromSession()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(false);
	}

	private void _testResetOriginalValuesWithDynamicQuery(boolean clearSession)
		throws Exception {

		PetEntry newPetEntry = addPetEntry();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PetEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("petId", newPetEntry.getPetId()));

		List<PetEntry> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(PetEntry petEntry) {
		Assert.assertEquals(
			petEntry.getUuid(),
			ReflectionTestUtil.invoke(
				petEntry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(petEntry.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				petEntry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected PetEntry addPetEntry() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PetEntry petEntry = _persistence.create(pk);

		petEntry.setUuid(RandomTestUtil.randomString());

		petEntry.setGroupId(RandomTestUtil.nextLong());

		petEntry.setCompanyId(RandomTestUtil.nextLong());

		petEntry.setUserId(RandomTestUtil.nextLong());

		petEntry.setUserName(RandomTestUtil.randomString());

		petEntry.setCreateDate(RandomTestUtil.nextDate());

		petEntry.setModifiedDate(RandomTestUtil.nextDate());

		petEntry.setCreatorId(RandomTestUtil.nextLong());

		petEntry.setScopeOrgId(RandomTestUtil.nextLong());

		petEntry.setName(RandomTestUtil.randomString());

		petEntry.setTag(RandomTestUtil.randomString());

		petEntry.setStatus(RandomTestUtil.randomString());

		petEntry.setStatusDate(RandomTestUtil.nextDate());

		_petEntries.add(_persistence.update(petEntry));

		return petEntry;
	}



	private List<PetEntry> _petEntries = new ArrayList<PetEntry>();
	private PetEntryPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}