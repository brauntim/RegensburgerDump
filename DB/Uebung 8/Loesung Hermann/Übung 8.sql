-- Aufgabe 2.1

create view grosser_bhf as
select *
from hbf h 
where h.kategorie = 1
with local check option;

select * from grosser_bhf gb;
select * from hbf h;
drop view grosser_bhf;

-- Aufgabe 2.2
--a)
select * from hbf h
where h.station like 'Regensburg%';

--b)
insert into hbf (station, bundesland, bf_nr, kategorie) values
('Teststadt Nord', 'Hessen', 9999, 5);

--c)
select * from hbf h
where station = 'Teststadt Nord'; --Nein

--d)
delete from bahnhoefe b
where b.bf_nr = 9999;

--e)
insert into grosser_bhf (station, bundesland, bf_nr, kategorie) values
('Teststadt Nord', 'Hessen', 9999, 5); --Geht nicht wegen check option kategorie != 1

--f)
insert into grosser_bhf (station, bundesland, bf_nr, kategorie) values
('Teststadt Nord', 'Hessen', 9999, 1);

--g)
select * from grosser_bhf gb 
where gb.bf_nr = 9999; --Nein

--h)
drop view grosser_bhf;

create view grosser_bhf as
select *
from hbf h 
where h.kategorie = 1
with cascaded check option;


--3.)
create materialized view Bahnhof_Statistik as
select b.bundesland, count(station) as anzahl_bahnhoefe
from bahnhoefe b
group by b.bundesland;

select * from bahnhof_statistik;


--4.)
select * from bahnhoefe b;
--a)
select distinct bundesland
from bahnhoefe b;

--b)
select b.bm, count(station) as anzahl_bahnhoefe
from bahnhoefe b
group by b.bm
having count(station) > 10;

--c)
select b2.station, b2.kat_vst 
from bahnhoefe b 
join bahnhoefe b2 on b.station = 'Ulm Hbf'
where b2.kat_vst = b.kat_vst;

--or more logically
select b.station, b.kat_vst
from bahnhoefe b 
join bahnhoefe b2 on b.kat_vst = b2.kat_vst
where b2.station = 'Ulm Hbf';

--d)


























