create index IX_567E76C8 on ATHZ_RefreshTokenEntity (token[$COLUMN_LENGTH:75$]);
create index IX_9584EA13 on ATHZ_RefreshTokenEntity (uuid_[$COLUMN_LENGTH:75$]);

create index IX_4210AF49 on ATHZ_RefreshTokenEntry (token[$COLUMN_LENGTH:75$]);
create index IX_65F58D8A on ATHZ_RefreshTokenEntry (userName[$COLUMN_LENGTH:75$]);
create index IX_81172294 on ATHZ_RefreshTokenEntry (uuid_[$COLUMN_LENGTH:75$]);

create index IX_D23BE5C6 on DG_RefreshTokenEntity (token[$COLUMN_LENGTH:75$]);
create index IX_11425911 on DG_RefreshTokenEntity (uuid_[$COLUMN_LENGTH:75$]);