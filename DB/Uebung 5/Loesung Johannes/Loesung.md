
# Abgabe DB Aufgabe 5

## Aufgabe 1

```sql
select count(*) from professoren where rang='C4';

select studenten.name from studenten
natural join hoeren natural join vorlesungen
where vorlesungen.titel = 'Grundzüge';

select professoren.name, sum(vorlesungen.sws) from professoren
join vorlesungen on professoren.persnr = vorlesungen.gelesenvon
group by professoren.persnr
having count(vorlesungen.vorlnr) >= 2;

select distinct s1.name
from studenten as s1
join hoeren as h1 on s1.matrnr = h1.matrnr
join hoeren as h2 on h1.vorlnr = h2.vorlnr
join studenten as s2 on h2.matrnr = s2.matrnr
where s2.name = 'Feuerbach' and s1.matrnr != s2.matrnr;
```

## Aufgabe 2

```sql
create table Bahnhoefe (
  BID int primary key,
  Ort varchar(256) not null,
  Bahnhof varchar(256) not null
);

create table Fahrten (
  ZugNr int primary key,
  Start int references Bahnhoefe(BID),
  Ziel int references Bahnhoefe(BID)
);

insert into Bahnhoefe (BID, Ort, Bahnhof) values
(1, 'Regensburg', 'Hfb'),
(2, 'München', 'Flughafen'),
(3, 'München', 'Hbf'),
(4, 'Frankfurt', 'Hbf');

insert into Fahrten (ZugNr, Start, Ziel) values
(101, 1, 2),
(102, 1, 3),
(103, 3, 2),
(104, 1, 4);


select ort, count(bahnhof) from Bahnhoefe
group by ort;

select ort, count(zugnr) from Bahnhoefe
join Fahrten on BID=Start
group by ort;

select zugnr, start.ort as so, start.bahnhof as sb, ziel.ort as zo, ziel.bahnhof as zb from Fahrten
join Bahnhoefe as start on start.bid = Fahrten.start
join Bahnhoefe as ziel on ziel.bid = Fahrten.ziel;

select distinct b2.Ort
from Bahnhoefe as b1
join Fahrten on b1.BID=Start
join Bahnhoefe as b2 on b2.BID=Ziel
where b1.Ort='Regensburg';
```