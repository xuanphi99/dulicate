create index IX_555D7975 on DG_PetEntry (tag[$COLUMN_LENGTH:75$]);
create index IX_3C9045A9 on DG_PetEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_9990226B on DG_PetEntry (uuid_[$COLUMN_LENGTH:75$], groupId);