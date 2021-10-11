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

package com.dogoo.authz.model.impl;

import com.dogoo.authz.model.RefreshTokenEntry;
import com.dogoo.authz.model.RefreshTokenEntryModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the RefreshTokenEntry service. Represents a row in the &quot;ATHZ_RefreshTokenEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>RefreshTokenEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RefreshTokenEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RefreshTokenEntryImpl
 * @generated
 */
public class RefreshTokenEntryModelImpl
	extends BaseModelImpl<RefreshTokenEntry> implements RefreshTokenEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a refresh token entry model instance should use the <code>RefreshTokenEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "ATHZ_RefreshTokenEntry";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"refreshTokenId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"token", Types.VARCHAR},
		{"expiryDate", Types.TIMESTAMP}, {"issuedDate", Types.TIMESTAMP},
		{"refreshedDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("refreshTokenId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("token", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("expiryDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("issuedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("refreshedDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table ATHZ_RefreshTokenEntry (uuid_ VARCHAR(75) null,refreshTokenId LONG not null primary key,userName VARCHAR(75) null,token VARCHAR(75) null,expiryDate DATE null,issuedDate DATE null,refreshedDate DATE null)";

	public static final String TABLE_SQL_DROP =
		"drop table ATHZ_RefreshTokenEntry";

	public static final String ORDER_BY_JPQL =
		" ORDER BY refreshTokenEntry.expiryDate ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY ATHZ_RefreshTokenEntry.expiryDate ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TOKEN_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long USERNAME_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long EXPIRYDATE_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public RefreshTokenEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _refreshTokenId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRefreshTokenId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _refreshTokenId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return RefreshTokenEntry.class;
	}

	@Override
	public String getModelClassName() {
		return RefreshTokenEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<RefreshTokenEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<RefreshTokenEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<RefreshTokenEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((RefreshTokenEntry)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<RefreshTokenEntry, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<RefreshTokenEntry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(RefreshTokenEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<RefreshTokenEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<RefreshTokenEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, RefreshTokenEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			RefreshTokenEntry.class.getClassLoader(), RefreshTokenEntry.class,
			ModelWrapper.class);

		try {
			Constructor<RefreshTokenEntry> constructor =
				(Constructor<RefreshTokenEntry>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<RefreshTokenEntry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<RefreshTokenEntry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<RefreshTokenEntry, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<RefreshTokenEntry, Object>>();
		Map<String, BiConsumer<RefreshTokenEntry, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<RefreshTokenEntry, ?>>();

		attributeGetterFunctions.put("uuid", RefreshTokenEntry::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<RefreshTokenEntry, String>)RefreshTokenEntry::setUuid);
		attributeGetterFunctions.put(
			"refreshTokenId", RefreshTokenEntry::getRefreshTokenId);
		attributeSetterBiConsumers.put(
			"refreshTokenId",
			(BiConsumer<RefreshTokenEntry, Long>)
				RefreshTokenEntry::setRefreshTokenId);
		attributeGetterFunctions.put(
			"userName", RefreshTokenEntry::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<RefreshTokenEntry, String>)
				RefreshTokenEntry::setUserName);
		attributeGetterFunctions.put("token", RefreshTokenEntry::getToken);
		attributeSetterBiConsumers.put(
			"token",
			(BiConsumer<RefreshTokenEntry, String>)RefreshTokenEntry::setToken);
		attributeGetterFunctions.put(
			"expiryDate", RefreshTokenEntry::getExpiryDate);
		attributeSetterBiConsumers.put(
			"expiryDate",
			(BiConsumer<RefreshTokenEntry, Date>)
				RefreshTokenEntry::setExpiryDate);
		attributeGetterFunctions.put(
			"issuedDate", RefreshTokenEntry::getIssuedDate);
		attributeSetterBiConsumers.put(
			"issuedDate",
			(BiConsumer<RefreshTokenEntry, Date>)
				RefreshTokenEntry::setIssuedDate);
		attributeGetterFunctions.put(
			"refreshedDate", RefreshTokenEntry::getRefreshedDate);
		attributeSetterBiConsumers.put(
			"refreshedDate",
			(BiConsumer<RefreshTokenEntry, Date>)
				RefreshTokenEntry::setRefreshedDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@Override
	public long getRefreshTokenId() {
		return _refreshTokenId;
	}

	@Override
	public void setRefreshTokenId(long refreshTokenId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_refreshTokenId = refreshTokenId;
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUserName() {
		return getColumnOriginalValue("userName");
	}

	@Override
	public String getToken() {
		if (_token == null) {
			return "";
		}
		else {
			return _token;
		}
	}

	@Override
	public void setToken(String token) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_token = token;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalToken() {
		return getColumnOriginalValue("token");
	}

	@Override
	public Date getExpiryDate() {
		return _expiryDate;
	}

	@Override
	public void setExpiryDate(Date expiryDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_expiryDate = expiryDate;
	}

	@Override
	public Date getIssuedDate() {
		return _issuedDate;
	}

	@Override
	public void setIssuedDate(Date issuedDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_issuedDate = issuedDate;
	}

	@Override
	public Date getRefreshedDate() {
		return _refreshedDate;
	}

	@Override
	public void setRefreshedDate(Date refreshedDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_refreshedDate = refreshedDate;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, RefreshTokenEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public RefreshTokenEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, RefreshTokenEntry>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		RefreshTokenEntryImpl refreshTokenEntryImpl =
			new RefreshTokenEntryImpl();

		refreshTokenEntryImpl.setUuid(getUuid());
		refreshTokenEntryImpl.setRefreshTokenId(getRefreshTokenId());
		refreshTokenEntryImpl.setUserName(getUserName());
		refreshTokenEntryImpl.setToken(getToken());
		refreshTokenEntryImpl.setExpiryDate(getExpiryDate());
		refreshTokenEntryImpl.setIssuedDate(getIssuedDate());
		refreshTokenEntryImpl.setRefreshedDate(getRefreshedDate());

		refreshTokenEntryImpl.resetOriginalValues();

		return refreshTokenEntryImpl;
	}

	@Override
	public int compareTo(RefreshTokenEntry refreshTokenEntry) {
		int value = 0;

		value = DateUtil.compareTo(
			getExpiryDate(), refreshTokenEntry.getExpiryDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RefreshTokenEntry)) {
			return false;
		}

		RefreshTokenEntry refreshTokenEntry = (RefreshTokenEntry)object;

		long primaryKey = refreshTokenEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<RefreshTokenEntry> toCacheModel() {
		RefreshTokenEntryCacheModel refreshTokenEntryCacheModel =
			new RefreshTokenEntryCacheModel();

		refreshTokenEntryCacheModel.uuid = getUuid();

		String uuid = refreshTokenEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			refreshTokenEntryCacheModel.uuid = null;
		}

		refreshTokenEntryCacheModel.refreshTokenId = getRefreshTokenId();

		refreshTokenEntryCacheModel.userName = getUserName();

		String userName = refreshTokenEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			refreshTokenEntryCacheModel.userName = null;
		}

		refreshTokenEntryCacheModel.token = getToken();

		String token = refreshTokenEntryCacheModel.token;

		if ((token != null) && (token.length() == 0)) {
			refreshTokenEntryCacheModel.token = null;
		}

		Date expiryDate = getExpiryDate();

		if (expiryDate != null) {
			refreshTokenEntryCacheModel.expiryDate = expiryDate.getTime();
		}
		else {
			refreshTokenEntryCacheModel.expiryDate = Long.MIN_VALUE;
		}

		Date issuedDate = getIssuedDate();

		if (issuedDate != null) {
			refreshTokenEntryCacheModel.issuedDate = issuedDate.getTime();
		}
		else {
			refreshTokenEntryCacheModel.issuedDate = Long.MIN_VALUE;
		}

		Date refreshedDate = getRefreshedDate();

		if (refreshedDate != null) {
			refreshTokenEntryCacheModel.refreshedDate = refreshedDate.getTime();
		}
		else {
			refreshTokenEntryCacheModel.refreshedDate = Long.MIN_VALUE;
		}

		return refreshTokenEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<RefreshTokenEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<RefreshTokenEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<RefreshTokenEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((RefreshTokenEntry)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<RefreshTokenEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<RefreshTokenEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<RefreshTokenEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((RefreshTokenEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, RefreshTokenEntry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private long _refreshTokenId;
	private String _userName;
	private String _token;
	private Date _expiryDate;
	private Date _issuedDate;
	private Date _refreshedDate;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<RefreshTokenEntry, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((RefreshTokenEntry)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("refreshTokenId", _refreshTokenId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("token", _token);
		_columnOriginalValues.put("expiryDate", _expiryDate);
		_columnOriginalValues.put("issuedDate", _issuedDate);
		_columnOriginalValues.put("refreshedDate", _refreshedDate);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("refreshTokenId", 2L);

		columnBitmasks.put("userName", 4L);

		columnBitmasks.put("token", 8L);

		columnBitmasks.put("expiryDate", 16L);

		columnBitmasks.put("issuedDate", 32L);

		columnBitmasks.put("refreshedDate", 64L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private RefreshTokenEntry _escapedModel;

}