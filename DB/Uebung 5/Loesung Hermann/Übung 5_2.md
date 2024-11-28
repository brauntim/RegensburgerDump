## Übung 5.2

```sql

--Erstmal alle Tabellen createn und befüllen

create table bahnhoefe(
bid SERIAL primary key, ort VARCHAR(50) not null, bahnhof VARCHAR(20) 
check (bahnhof in ('Hbf', 'Flughafen')) 
);

select * from bahnhoefe;

create table fahrten(
zugnr SERIAL primary key, fahrten_start INT references bahnhoefe(bid),
fahrten_ziel INT references bahnhoefe(bid)
);

select * from fahrten;

alter sequence fahrten_zugnr_seq restart with 101;

insert into fahrten(fahrten_start, fahrten_ziel) 
values (1, 2);

insert into fahrten(fahrten_start, fahrten_ziel) 
values (1, 3);

insert into fahrten(fahrten_start, fahrten_ziel)
values (3, 2);


--3. Geben Sie für jeden Ort aus, wie viele Bahnhöfe es dort gibt

select b.ort, count(*) as anzahl_der_bahnhoefe 
from bahnhoefe b 
group by b.ort;


--4. Geben Sie für jeden Ort aus, wie viele Zugfahrten 
--	 in diesem Ort starten

select b.ort, count(*) as anzahl_der_zugfahrten
from bahnhoefe b 
join fahrten f
on b.bid = f.fahrten_start 
group by b.ort
order by b.ort desc; 		--Für abfallende Aufzählung


--5. Geben Sie für jede Fahrt die Zugnummer, den Start_Ort, Start_Bahnhof,
--	 Ziel_Ort und den Ziel_Bahnhof aus

select f.*, b.ort, b.bahnhof 
from fahrten f 
join bahnhoefe b 
on f.fahrten_start = b.bid;


--6. Wo hin kann man von (irgend)einem Bahnhof in Regensburg fahren?
--	 Geben Sie diese Orte aus, jeden aber nur einmal

select distinct b2.ort
from fahrten f
join bahnhoefe b 
on f.fahrten_start = b.bid 
join bahnhoefe b2 
on f.fahrten_ziel = b2.bid 
where b.ort = 'Regensburg';

```
























