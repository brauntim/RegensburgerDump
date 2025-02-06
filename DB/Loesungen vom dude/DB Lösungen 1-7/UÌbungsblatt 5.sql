-- Aufgabe 1

-- 1.1
SELECT COUNT(*) FROM Professoren WHERE Rang = 'C4';


-- 1.2
SELECT Name FROM hoeren H
      JOIN Studenten S ON H.MatrNr = S.MatrNr
      JOIN Vorlesungen V ON H.VorlNr = V.VorlNr
      WHERE V.Titel = 'Grundzüge';


-- 1.3
SELECT P.Name, SUM(V.SWS) FROM Professoren P
      JOIN Vorlesungen V ON P.PersNr = V.gelesenVon
      GROUP BY P.Name
      HAVING COUNT(*) >= 2;


-- 1.4
SELECT DISTINCT S2.Name FROM Studenten S1
      JOIN hoeren h1 ON S1.MatrNr = h1.MatrNr
      JOIN hoeren h2 ON h1.VorlNr = h2.VorlNr
      JOIN Studenten S2 ON h2.MatrNr = S2.MatrNr
      WHERE S1.Name LIKE 'Feuerbach'
      AND S2.Name NOT LIKE 'Feuerbach';



-- Aufgabe 2

-- 2.1
CREATE TABLE Bahnhoefe (
      BID SERIAL PRIMARY KEY,
      Ort VARCHAR(100),
      Bahnhof VARCHAR(50)
);

CREATE TABLE Fahrten (
      ZugNr INT PRIMARY KEY,
      Start INT REFERENCES Bahnhoefe(BID),
      Ziel INT REFERENCES Bahnhoefe(BID)
);


-- 2.2
INSERT INTO Bahnhoefe (Ort, Bahnhof) VALUES ('Regensburg', 'Hbf');
INSERT INTO Bahnhoefe (Ort, Bahnhof) VALUES ('München', 'Flughafen');
INSERT INTO Bahnhoefe (Ort, Bahnhof) VALUES ('München', 'Hbf');

INSERT INTO Fahrten (ZugNr, Start, Ziel) VALUES (101, 1, 2);
INSERT INTO Fahrten (ZugNr, Start, Ziel) VALUES (102, 1, 3);
INSERT INTO Fahrten (ZugNr, Start, Ziel) VALUES (103, 3, 2);


-- 2.3
SELECT Ort, COUNT(*) FROM Bahnhoefe GROUP BY Ort;


-- 2.4
SELECT Ort, COUNT(*) FROM Bahnhoefe B JOIN Fahrten F ON B.BID = F.Start GROUP BY B.Ort;


-- 2.5
SELECT F.ZugNr AS Zugnummer, B1.Ort AS Start_Ort, B1.Bahnhof AS Start_Bahnhof,
       B2.Ort AS Ziel_Ort, B2.Bahnhof AS Ziel_Bahnhof
       FROM Fahrten F
       JOIN Bahnhoefe B1 ON F.Start = B1.BID
       JOIN Bahnhoefe B2 ON F.Ziel = B2.BID;


-- 2.6
SELECT DISTINCT B2.Ort FROM Fahrten F
        JOIN Bahnhoefe B1 ON F.Start = B1.BID
        JOIN Bahnhoefe B2 ON F.Ziel = B2.BID
        WHERE B1.Ort = 'Regensburg';