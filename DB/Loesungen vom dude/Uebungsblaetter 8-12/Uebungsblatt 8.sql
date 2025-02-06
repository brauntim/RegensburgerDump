-- Aufgabe 1

CREATE TABLE Bahnhoefe_UB8 (
    Bundesland VARCHAR(30),
    RB VARCHAR(20),
    Bahnhofsmission VARCHAR(50),
    Bahnhofsnummer INT PRIMARY KEY,
    Station VARCHAR(50),
    DS_100_Abkuerzung VARCHAR(10) UNIQUE,
    Stationskategorie INT,
    Strasse VARCHAR(100),
    PLZ VARCHAR(5),
    Ort VARCHAR(50),
    Aufgabentraeger VARCHAR(100)
);


CREATE VIEW hbf AS
    SELECT Bahnhofsnummer AS bhfnr, Bundesland, Station, Stationskategorie AS kategorie
    FROM Bahnhoefe_UB8 WHERE Station LIKE '%Hbf' OR Station LIKE '%Hauptbahnhof';


SELECT COUNT(*) FROM hbf;



-- Aufgabe 2

-- 2.1

CREATE VIEW grosse_hbf AS
    SELECT * FROM hbf WHERE kategorie = 1
WITH LOCAL CHECK OPTION;


-- 2.2 a)

SELECT * FROM hbf WHERE Station LIKE 'Regensburg%';
-- ⇒ SELECT * FROM hbf WHERE Station LIKE 'Regensburg Hbf';

-- 2.2 b)

INSERT INTO hbf (bhfnr, Bundesland, Station, kategorie) VALUES (9999, 'Hessen', 'Teststadt Nord', 5);

-- 2.2 c)

SELECT * FROM hbf WHERE bhfnr = 9999;
-- ⇒ Wird nicht gefunden, da der Name nicht auf 'Hauptbahnhof' endet

-- 2.2 d)

DELETE FROM Bahnhoefe_UB8 WHERE bahnhofsnummer = 9999;

-- 2.2 e)

INSERT INTO grosse_hbf (bhfnr, Bundesland, Station, kategorie) VALUES (9999, 'Hessen', 'Teststadt Nord', 5);
-- ⇒ Kann nicht eingefügt werden, da die Kategorie nicht passt

-- 2.2 f)

INSERT INTO grosse_hbf (bhfnr, Bundesland, Station, kategorie) VALUES (9999, 'Hessen', 'Teststadt Nord', 1);

-- 2.2 g)

SELECT * FROM grosse_hbf WHERE bhfnr = 9999;
-- ⇒ Kann nicht gefunden werden, da der Name nicht auf 'Hauptbahnhof' endet

-- 2.2 h)

DROP VIEW grosse_hbf;

CREATE VIEW grosse_hbf AS
    SELECT * FROM hbf WHERE kategorie = 1
WITH CASCADED CHECK OPTION;


-- 2.3

CREATE MATERIALIZED VIEW Bahnhof_Statistik AS
    SELECT Bundesland, COUNT(*) FROM Bahnhoefe_UB8 GROUP BY Bundesland;

SELECT * FROM Bahnhof_Statistik WHERE Bundesland = 'Hessen';

DELETE FROM Bahnhoefe_UB8 WHERE bahnhofsnummer = 9999;
REFRESH MATERIALIZED VIEW Bahnhof_Statistik;

SELECT * FROM Bahnhof_Statistik WHERE Bundesland = 'Hessen';
-- Vor dem Refresh ⇒ 431 | Nach dem Refresh ⇒ 430


-- 2.4 a)

-- Auch per GROUP BY möglich
SELECT DISTINCT Bundesland FROM Bahnhoefe_UB8;

-- 2.4 b)

SELECT Ort FROM Bahnhoefe_UB8 GROUP BY Ort HAVING COUNT(*) > 10;

-- 2.4 c)

SELECT B2.Station FROM Bahnhoefe_UB8 B1
            JOIN Bahnhoefe_UB8 B2 ON B1.Stationskategorie = B2.Stationskategorie
            WHERE B1.STATION = 'Ulm Hbf';

-- 2.4 d)

SELECT Bundesland, AVG(Bahnhofs_Anzahl) AS Bahnhof_Stadt_Verhaeltnis FROM
    (SELECT Bundesland, Ort, COUNT(*) AS Bahnhofs_Anzahl FROM Bahnhoefe_UB8 GROUP BY Bundesland, Ort) S
GROUP BY Bundesland;
