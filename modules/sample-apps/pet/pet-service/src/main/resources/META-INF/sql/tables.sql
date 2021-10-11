create table DG_PetEntry (
	uuid_ VARCHAR(75) null,
	petId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	creatorId LONG,
	scopeOrgId LONG,
	name VARCHAR(75) null,
	tag VARCHAR(75) null,
	status VARCHAR(75) null,
	statusDate DATE null
);