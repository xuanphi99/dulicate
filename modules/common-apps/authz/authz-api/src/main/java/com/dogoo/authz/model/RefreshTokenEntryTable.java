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

package com.dogoo.authz.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;ATHZ_RefreshTokenEntry&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see RefreshTokenEntry
 * @generated
 */
public class RefreshTokenEntryTable extends BaseTable<RefreshTokenEntryTable> {

	public static final RefreshTokenEntryTable INSTANCE =
		new RefreshTokenEntryTable();

	public final Column<RefreshTokenEntryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RefreshTokenEntryTable, Long> refreshTokenId =
		createColumn(
			"refreshTokenId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<RefreshTokenEntryTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RefreshTokenEntryTable, String> token = createColumn(
		"token", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RefreshTokenEntryTable, Date> expiryDate = createColumn(
		"expiryDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<RefreshTokenEntryTable, Date> issuedDate = createColumn(
		"issuedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<RefreshTokenEntryTable, Date> refreshedDate =
		createColumn(
			"refreshedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private RefreshTokenEntryTable() {
		super("ATHZ_RefreshTokenEntry", RefreshTokenEntryTable::new);
	}

}