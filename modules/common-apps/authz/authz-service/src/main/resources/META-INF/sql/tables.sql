create table ATHZ_RefreshTokenEntity (
	uuid_ VARCHAR(75) null,
	refreshTokenId LONG not null primary key,
	userName VARCHAR(75) null,
	token VARCHAR(75) null,
	expiryDate DATE null
);

create table ATHZ_RefreshTokenEntry (
	uuid_ VARCHAR(75) null,
	refreshTokenId LONG not null primary key,
	userName VARCHAR(75) null,
	token VARCHAR(75) null,
	expiryDate DATE null,
	issuedDate DATE null,
	refreshedDate DATE null
);

create table DG_RefreshTokenEntity (
	uuid_ VARCHAR(75) null,
	refreshTokenId LONG not null primary key,
	userName VARCHAR(75) null,
	token VARCHAR(75) null,
	expiryDate DATE null
);