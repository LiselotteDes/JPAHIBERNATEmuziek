insert into artiesten(naam) values('test');
insert into albums(artiestid,naam) values ((select id from artiesten where naam='test'), 'test');
insert into tracks(albumid,naam,tijd) values ((select id from albums where naam='test'), 'test1', 2.30);
insert into tracks(albumid,naam,tijd) values ((select id from albums where naam='test'), 'test2', 2.30);