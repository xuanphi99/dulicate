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

package com.dogoo.authz.service.persistence.impl;

import com.dogoo.authz.exception.NoSuchRefreshTokenEntryException;
import com.dogoo.authz.model.RefreshTokenEntry;
import com.dogoo.authz.model.RefreshTokenEntryTable;
import com.dogoo.authz.model.impl.RefreshTokenEntryImpl;
import com.dogoo.authz.model.impl.RefreshTokenEntryModelImpl;
import com.dogoo.authz.service.persistence.RefreshTokenEntryPersistence;
import com.dogoo.authz.service.persistence.impl.constants.ATHZPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the refresh token entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {RefreshTokenEntryPersistence.class, BasePersistence.class}
)
public class RefreshTokenEntryPersistenceImpl
	extends BasePersistenceImpl<RefreshTokenEntry>
	implements RefreshTokenEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RefreshTokenEntryUtil</code> to access the refresh token entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RefreshTokenEntryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the refresh token entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching refresh token entries
	 */
	@Override
	public List<RefreshTokenEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<RefreshTokenEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<RefreshTokenEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RefreshTokenEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<RefreshTokenEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RefreshTokenEntry> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<RefreshTokenEntry> list = null;

		if (useFinderCache) {
			list = (List<RefreshTokenEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (RefreshTokenEntry refreshTokenEntry : list) {
					if (!uuid.equals(refreshTokenEntry.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_REFRESHTOKENENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RefreshTokenEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<RefreshTokenEntry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first refresh token entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching refresh token entry
	 * @throws NoSuchRefreshTokenEntryException if a matching refresh token entry could not be found
	 */
	@Override
	public RefreshTokenEntry findByUuid_First(
			String uuid, OrderByComparator<RefreshTokenEntry> orderByComparator)
		throws NoSuchRefreshTokenEntryException {

		RefreshTokenEntry refreshTokenEntry = fetchByUuid_First(
			uuid, orderByComparator);

		if (refreshTokenEntry != null) {
			return refreshTokenEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRefreshTokenEntryException(sb.toString());
	}

	/**
	 * Returns the first refresh token entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching refresh token entry, or <code>null</code> if a matching refresh token entry could not be found
	 */
	@Override
	public RefreshTokenEntry fetchByUuid_First(
		String uuid, OrderByComparator<RefreshTokenEntry> orderByComparator) {

		List<RefreshTokenEntry> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last refresh token entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching refresh token entry
	 * @throws NoSuchRefreshTokenEntryException if a matching refresh token entry could not be found
	 */
	@Override
	public RefreshTokenEntry findByUuid_Last(
			String uuid, OrderByComparator<RefreshTokenEntry> orderByComparator)
		throws NoSuchRefreshTokenEntryException {

		RefreshTokenEntry refreshTokenEntry = fetchByUuid_Last(
			uuid, orderByComparator);

		if (refreshTokenEntry != null) {
			return refreshTokenEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRefreshTokenEntryException(sb.toString());
	}

	/**
	 * Returns the last refresh token entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching refresh token entry, or <code>null</code> if a matching refresh token entry could not be found
	 */
	@Override
	public RefreshTokenEntry fetchByUuid_Last(
		String uuid, OrderByComparator<RefreshTokenEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<RefreshTokenEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public RefreshTokenEntry[] findByUuid_PrevAndNext(
			long refreshTokenId, String uuid,
			OrderByComparator<RefreshTokenEntry> orderByComparator)
		throws NoSuchRefreshTokenEntryException {

		uuid = Objects.toString(uuid, "");

		RefreshTokenEntry refreshTokenEntry = findByPrimaryKey(refreshTokenId);

		Session session = null;

		try {
			session = openSession();

			RefreshTokenEntry[] array = new RefreshTokenEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, refreshTokenEntry, uuid, orderByComparator, true);

			array[1] = refreshTokenEntry;

			array[2] = getByUuid_PrevAndNext(
				session, refreshTokenEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected RefreshTokenEntry getByUuid_PrevAndNext(
		Session session, RefreshTokenEntry refreshTokenEntry, String uuid,
		OrderByComparator<RefreshTokenEntry> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_REFRESHTOKENENTRY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(RefreshTokenEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						refreshTokenEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RefreshTokenEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the refresh token entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (RefreshTokenEntry refreshTokenEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(refreshTokenEntry);
		}
	}

	/**
	 * Returns the number of refresh token entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching refresh token entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_REFRESHTOKENENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"refreshTokenEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(refreshTokenEntry.uuid IS NULL OR refreshTokenEntry.uuid = '')";

	private FinderPath _finderPathFetchByT_K;
	private FinderPath _finderPathCountByT_K;

	/**
	 * Returns the refresh token entry where token = &#63; or throws a <code>NoSuchRefreshTokenEntryException</code> if it could not be found.
	 *
	 * @param token the token
	 * @return the matching refresh token entry
	 * @throws NoSuchRefreshTokenEntryException if a matching refresh token entry could not be found
	 */
	@Override
	public RefreshTokenEntry findByT_K(String token)
		throws NoSuchRefreshTokenEntryException {

		RefreshTokenEntry refreshTokenEntry = fetchByT_K(token);

		if (refreshTokenEntry == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("token=");
			sb.append(token);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchRefreshTokenEntryException(sb.toString());
		}

		return refreshTokenEntry;
	}

	/**
	 * Returns the refresh token entry where token = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param token the token
	 * @return the matching refresh token entry, or <code>null</code> if a matching refresh token entry could not be found
	 */
	@Override
	public RefreshTokenEntry fetchByT_K(String token) {
		return fetchByT_K(token, true);
	}

	/**
	 * Returns the refresh token entry where token = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param token the token
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching refresh token entry, or <code>null</code> if a matching refresh token entry could not be found
	 */
	@Override
	public RefreshTokenEntry fetchByT_K(String token, boolean useFinderCache) {
		token = Objects.toString(token, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {token};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByT_K, finderArgs);
		}

		if (result instanceof RefreshTokenEntry) {
			RefreshTokenEntry refreshTokenEntry = (RefreshTokenEntry)result;

			if (!Objects.equals(token, refreshTokenEntry.getToken())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_REFRESHTOKENENTRY_WHERE);

			boolean bindToken = false;

			if (token.isEmpty()) {
				sb.append(_FINDER_COLUMN_T_K_TOKEN_3);
			}
			else {
				bindToken = true;

				sb.append(_FINDER_COLUMN_T_K_TOKEN_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindToken) {
					queryPos.add(token);
				}

				List<RefreshTokenEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByT_K, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {token};
							}

							_log.warn(
								"RefreshTokenEntryPersistenceImpl.fetchByT_K(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					RefreshTokenEntry refreshTokenEntry = list.get(0);

					result = refreshTokenEntry;

					cacheResult(refreshTokenEntry);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (RefreshTokenEntry)result;
		}
	}

	/**
	 * Removes the refresh token entry where token = &#63; from the database.
	 *
	 * @param token the token
	 * @return the refresh token entry that was removed
	 */
	@Override
	public RefreshTokenEntry removeByT_K(String token)
		throws NoSuchRefreshTokenEntryException {

		RefreshTokenEntry refreshTokenEntry = findByT_K(token);

		return remove(refreshTokenEntry);
	}

	/**
	 * Returns the number of refresh token entries where token = &#63;.
	 *
	 * @param token the token
	 * @return the number of matching refresh token entries
	 */
	@Override
	public int countByT_K(String token) {
		token = Objects.toString(token, "");

		FinderPath finderPath = _finderPathCountByT_K;

		Object[] finderArgs = new Object[] {token};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_REFRESHTOKENENTRY_WHERE);

			boolean bindToken = false;

			if (token.isEmpty()) {
				sb.append(_FINDER_COLUMN_T_K_TOKEN_3);
			}
			else {
				bindToken = true;

				sb.append(_FINDER_COLUMN_T_K_TOKEN_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindToken) {
					queryPos.add(token);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_T_K_TOKEN_2 =
		"refreshTokenEntry.token = ?";

	private static final String _FINDER_COLUMN_T_K_TOKEN_3 =
		"(refreshTokenEntry.token IS NULL OR refreshTokenEntry.token = '')";

	private FinderPath _finderPathFetchByU_N;
	private FinderPath _finderPathCountByU_N;

	/**
	 * Returns the refresh token entry where userName = &#63; or throws a <code>NoSuchRefreshTokenEntryException</code> if it could not be found.
	 *
	 * @param userName the user name
	 * @return the matching refresh token entry
	 * @throws NoSuchRefreshTokenEntryException if a matching refresh token entry could not be found
	 */
	@Override
	public RefreshTokenEntry findByU_N(String userName)
		throws NoSuchRefreshTokenEntryException {

		RefreshTokenEntry refreshTokenEntry = fetchByU_N(userName);

		if (refreshTokenEntry == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("userName=");
			sb.append(userName);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchRefreshTokenEntryException(sb.toString());
		}

		return refreshTokenEntry;
	}

	/**
	 * Returns the refresh token entry where userName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userName the user name
	 * @return the matching refresh token entry, or <code>null</code> if a matching refresh token entry could not be found
	 */
	@Override
	public RefreshTokenEntry fetchByU_N(String userName) {
		return fetchByU_N(userName, true);
	}

	/**
	 * Returns the refresh token entry where userName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userName the user name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching refresh token entry, or <code>null</code> if a matching refresh token entry could not be found
	 */
	@Override
	public RefreshTokenEntry fetchByU_N(
		String userName, boolean useFinderCache) {

		userName = Objects.toString(userName, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {userName};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByU_N, finderArgs);
		}

		if (result instanceof RefreshTokenEntry) {
			RefreshTokenEntry refreshTokenEntry = (RefreshTokenEntry)result;

			if (!Objects.equals(userName, refreshTokenEntry.getUserName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_REFRESHTOKENENTRY_WHERE);

			boolean bindUserName = false;

			if (userName.isEmpty()) {
				sb.append(_FINDER_COLUMN_U_N_USERNAME_3);
			}
			else {
				bindUserName = true;

				sb.append(_FINDER_COLUMN_U_N_USERNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUserName) {
					queryPos.add(userName);
				}

				List<RefreshTokenEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByU_N, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {userName};
							}

							_log.warn(
								"RefreshTokenEntryPersistenceImpl.fetchByU_N(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					RefreshTokenEntry refreshTokenEntry = list.get(0);

					result = refreshTokenEntry;

					cacheResult(refreshTokenEntry);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (RefreshTokenEntry)result;
		}
	}

	/**
	 * Removes the refresh token entry where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 * @return the refresh token entry that was removed
	 */
	@Override
	public RefreshTokenEntry removeByU_N(String userName)
		throws NoSuchRefreshTokenEntryException {

		RefreshTokenEntry refreshTokenEntry = findByU_N(userName);

		return remove(refreshTokenEntry);
	}

	/**
	 * Returns the number of refresh token entries where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching refresh token entries
	 */
	@Override
	public int countByU_N(String userName) {
		userName = Objects.toString(userName, "");

		FinderPath finderPath = _finderPathCountByU_N;

		Object[] finderArgs = new Object[] {userName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_REFRESHTOKENENTRY_WHERE);

			boolean bindUserName = false;

			if (userName.isEmpty()) {
				sb.append(_FINDER_COLUMN_U_N_USERNAME_3);
			}
			else {
				bindUserName = true;

				sb.append(_FINDER_COLUMN_U_N_USERNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUserName) {
					queryPos.add(userName);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_U_N_USERNAME_2 =
		"refreshTokenEntry.userName = ?";

	private static final String _FINDER_COLUMN_U_N_USERNAME_3 =
		"(refreshTokenEntry.userName IS NULL OR refreshTokenEntry.userName = '')";

	public RefreshTokenEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(RefreshTokenEntry.class);

		setModelImplClass(RefreshTokenEntryImpl.class);
		setModelPKClass(long.class);

		setTable(RefreshTokenEntryTable.INSTANCE);
	}

	/**
	 * Caches the refresh token entry in the entity cache if it is enabled.
	 *
	 * @param refreshTokenEntry the refresh token entry
	 */
	@Override
	public void cacheResult(RefreshTokenEntry refreshTokenEntry) {
		entityCache.putResult(
			RefreshTokenEntryImpl.class, refreshTokenEntry.getPrimaryKey(),
			refreshTokenEntry);

		finderCache.putResult(
			_finderPathFetchByT_K, new Object[] {refreshTokenEntry.getToken()},
			refreshTokenEntry);

		finderCache.putResult(
			_finderPathFetchByU_N,
			new Object[] {refreshTokenEntry.getUserName()}, refreshTokenEntry);
	}

	/**
	 * Caches the refresh token entries in the entity cache if it is enabled.
	 *
	 * @param refreshTokenEntries the refresh token entries
	 */
	@Override
	public void cacheResult(List<RefreshTokenEntry> refreshTokenEntries) {
		for (RefreshTokenEntry refreshTokenEntry : refreshTokenEntries) {
			if (entityCache.getResult(
					RefreshTokenEntryImpl.class,
					refreshTokenEntry.getPrimaryKey()) == null) {

				cacheResult(refreshTokenEntry);
			}
		}
	}

	/**
	 * Clears the cache for all refresh token entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RefreshTokenEntryImpl.class);

		finderCache.clearCache(RefreshTokenEntryImpl.class);
	}

	/**
	 * Clears the cache for the refresh token entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RefreshTokenEntry refreshTokenEntry) {
		entityCache.removeResult(
			RefreshTokenEntryImpl.class, refreshTokenEntry);
	}

	@Override
	public void clearCache(List<RefreshTokenEntry> refreshTokenEntries) {
		for (RefreshTokenEntry refreshTokenEntry : refreshTokenEntries) {
			entityCache.removeResult(
				RefreshTokenEntryImpl.class, refreshTokenEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(RefreshTokenEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(RefreshTokenEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		RefreshTokenEntryModelImpl refreshTokenEntryModelImpl) {

		Object[] args = new Object[] {refreshTokenEntryModelImpl.getToken()};

		finderCache.putResult(_finderPathCountByT_K, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByT_K, args, refreshTokenEntryModelImpl);

		args = new Object[] {refreshTokenEntryModelImpl.getUserName()};

		finderCache.putResult(_finderPathCountByU_N, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByU_N, args, refreshTokenEntryModelImpl);
	}

	/**
	 * Creates a new refresh token entry with the primary key. Does not add the refresh token entry to the database.
	 *
	 * @param refreshTokenId the primary key for the new refresh token entry
	 * @return the new refresh token entry
	 */
	@Override
	public RefreshTokenEntry create(long refreshTokenId) {
		RefreshTokenEntry refreshTokenEntry = new RefreshTokenEntryImpl();

		refreshTokenEntry.setNew(true);
		refreshTokenEntry.setPrimaryKey(refreshTokenId);

		String uuid = PortalUUIDUtil.generate();

		refreshTokenEntry.setUuid(uuid);

		return refreshTokenEntry;
	}

	/**
	 * Removes the refresh token entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param refreshTokenId the primary key of the refresh token entry
	 * @return the refresh token entry that was removed
	 * @throws NoSuchRefreshTokenEntryException if a refresh token entry with the primary key could not be found
	 */
	@Override
	public RefreshTokenEntry remove(long refreshTokenId)
		throws NoSuchRefreshTokenEntryException {

		return remove((Serializable)refreshTokenId);
	}

	/**
	 * Removes the refresh token entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the refresh token entry
	 * @return the refresh token entry that was removed
	 * @throws NoSuchRefreshTokenEntryException if a refresh token entry with the primary key could not be found
	 */
	@Override
	public RefreshTokenEntry remove(Serializable primaryKey)
		throws NoSuchRefreshTokenEntryException {

		Session session = null;

		try {
			session = openSession();

			RefreshTokenEntry refreshTokenEntry =
				(RefreshTokenEntry)session.get(
					RefreshTokenEntryImpl.class, primaryKey);

			if (refreshTokenEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRefreshTokenEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(refreshTokenEntry);
		}
		catch (NoSuchRefreshTokenEntryException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected RefreshTokenEntry removeImpl(
		RefreshTokenEntry refreshTokenEntry) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(refreshTokenEntry)) {
				refreshTokenEntry = (RefreshTokenEntry)session.get(
					RefreshTokenEntryImpl.class,
					refreshTokenEntry.getPrimaryKeyObj());
			}

			if (refreshTokenEntry != null) {
				session.delete(refreshTokenEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (refreshTokenEntry != null) {
			clearCache(refreshTokenEntry);
		}

		return refreshTokenEntry;
	}

	@Override
	public RefreshTokenEntry updateImpl(RefreshTokenEntry refreshTokenEntry) {
		boolean isNew = refreshTokenEntry.isNew();

		if (!(refreshTokenEntry instanceof RefreshTokenEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(refreshTokenEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					refreshTokenEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in refreshTokenEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RefreshTokenEntry implementation " +
					refreshTokenEntry.getClass());
		}

		RefreshTokenEntryModelImpl refreshTokenEntryModelImpl =
			(RefreshTokenEntryModelImpl)refreshTokenEntry;

		if (Validator.isNull(refreshTokenEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			refreshTokenEntry.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(refreshTokenEntry);
			}
			else {
				refreshTokenEntry = (RefreshTokenEntry)session.merge(
					refreshTokenEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			RefreshTokenEntryImpl.class, refreshTokenEntryModelImpl, false,
			true);

		cacheUniqueFindersCache(refreshTokenEntryModelImpl);

		if (isNew) {
			refreshTokenEntry.setNew(false);
		}

		refreshTokenEntry.resetOriginalValues();

		return refreshTokenEntry;
	}

	/**
	 * Returns the refresh token entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the refresh token entry
	 * @return the refresh token entry
	 * @throws NoSuchRefreshTokenEntryException if a refresh token entry with the primary key could not be found
	 */
	@Override
	public RefreshTokenEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRefreshTokenEntryException {

		RefreshTokenEntry refreshTokenEntry = fetchByPrimaryKey(primaryKey);

		if (refreshTokenEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRefreshTokenEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return refreshTokenEntry;
	}

	/**
	 * Returns the refresh token entry with the primary key or throws a <code>NoSuchRefreshTokenEntryException</code> if it could not be found.
	 *
	 * @param refreshTokenId the primary key of the refresh token entry
	 * @return the refresh token entry
	 * @throws NoSuchRefreshTokenEntryException if a refresh token entry with the primary key could not be found
	 */
	@Override
	public RefreshTokenEntry findByPrimaryKey(long refreshTokenId)
		throws NoSuchRefreshTokenEntryException {

		return findByPrimaryKey((Serializable)refreshTokenId);
	}

	/**
	 * Returns the refresh token entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param refreshTokenId the primary key of the refresh token entry
	 * @return the refresh token entry, or <code>null</code> if a refresh token entry with the primary key could not be found
	 */
	@Override
	public RefreshTokenEntry fetchByPrimaryKey(long refreshTokenId) {
		return fetchByPrimaryKey((Serializable)refreshTokenId);
	}

	/**
	 * Returns all the refresh token entries.
	 *
	 * @return the refresh token entries
	 */
	@Override
	public List<RefreshTokenEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<RefreshTokenEntry> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<RefreshTokenEntry> findAll(
		int start, int end,
		OrderByComparator<RefreshTokenEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<RefreshTokenEntry> findAll(
		int start, int end,
		OrderByComparator<RefreshTokenEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<RefreshTokenEntry> list = null;

		if (useFinderCache) {
			list = (List<RefreshTokenEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_REFRESHTOKENENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_REFRESHTOKENENTRY;

				sql = sql.concat(RefreshTokenEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<RefreshTokenEntry>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the refresh token entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RefreshTokenEntry refreshTokenEntry : findAll()) {
			remove(refreshTokenEntry);
		}
	}

	/**
	 * Returns the number of refresh token entries.
	 *
	 * @return the number of refresh token entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_REFRESHTOKENENTRY);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "refreshTokenId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_REFRESHTOKENENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RefreshTokenEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the refresh token entry persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new RefreshTokenEntryModelArgumentsResolver(),
			new HashMapDictionary<>());

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByT_K = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByT_K",
			new String[] {String.class.getName()}, new String[] {"token"},
			true);

		_finderPathCountByT_K = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByT_K",
			new String[] {String.class.getName()}, new String[] {"token"},
			false);

		_finderPathFetchByU_N = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByU_N",
			new String[] {String.class.getName()}, new String[] {"userName"},
			true);

		_finderPathCountByU_N = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_N",
			new String[] {String.class.getName()}, new String[] {"userName"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(RefreshTokenEntryImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();
	}

	@Override
	@Reference(
		target = ATHZPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = ATHZPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ATHZPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_REFRESHTOKENENTRY =
		"SELECT refreshTokenEntry FROM RefreshTokenEntry refreshTokenEntry";

	private static final String _SQL_SELECT_REFRESHTOKENENTRY_WHERE =
		"SELECT refreshTokenEntry FROM RefreshTokenEntry refreshTokenEntry WHERE ";

	private static final String _SQL_COUNT_REFRESHTOKENENTRY =
		"SELECT COUNT(refreshTokenEntry) FROM RefreshTokenEntry refreshTokenEntry";

	private static final String _SQL_COUNT_REFRESHTOKENENTRY_WHERE =
		"SELECT COUNT(refreshTokenEntry) FROM RefreshTokenEntry refreshTokenEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "refreshTokenEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RefreshTokenEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RefreshTokenEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RefreshTokenEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class RefreshTokenEntryModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			RefreshTokenEntryModelImpl refreshTokenEntryModelImpl =
				(RefreshTokenEntryModelImpl)baseModel;

			long columnBitmask = refreshTokenEntryModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					refreshTokenEntryModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						refreshTokenEntryModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					refreshTokenEntryModelImpl, columnNames, original);
			}

			return null;
		}

		@Override
		public String getClassName() {
			return RefreshTokenEntryImpl.class.getName();
		}

		@Override
		public String getTableName() {
			return RefreshTokenEntryTable.INSTANCE.getTableName();
		}

		private static Object[] _getValue(
			RefreshTokenEntryModelImpl refreshTokenEntryModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						refreshTokenEntryModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = refreshTokenEntryModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

		private static final long _ORDER_BY_COLUMNS_BITMASK;

		static {
			long orderByColumnsBitmask = 0;

			orderByColumnsBitmask |=
				RefreshTokenEntryModelImpl.getColumnBitmask("expiryDate");

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}