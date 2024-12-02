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
