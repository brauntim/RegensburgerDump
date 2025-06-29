-- Aufgabe 1

CREATE TABLE Bestellung (
                            Bestellnummer SERIAL PRIMARY KEY,
                            Lon REAL NOT NULL,
                            Lat REAL NOT NULL,
                            Zeit TIMESTAMP DEFAULT NOW()
);

CREATE TABLE Gericht (
                         Nummer SERIAL PRIMARY KEY,
                         Bezeichnung VARCHAR(60) NOT NULL,
                         Preis DECIMAL(5,2) NOT NULL,
                         Durchmesser DECIMAL(5,2) NULL,
                         Typ_Tag CHAR(7) DEFAULT 'Gericht'
);

CREATE TABLE Zutaten (
                         Gerichtnummer INT REFERENCES Gericht(Nummer) ON DELETE CASCADE,
                         Zutat VARCHAR(100) NOT NULL,
                         PRIMARY KEY(Gerichtnummer, Zutat)
);

CREATE TABLE Bestellinhalt (
                               Bestellnummer INT REFERENCES Bestellung(Bestellnummer) ON DELETE CASCADE,
                               Gerichtnummer INT REFERENCES Gericht(Nummer),
                               Anzahl INT CHECK (Anzahl > 0),
                               PRIMARY KEY(Bestellnummer, Gerichtnummer)
);


-- Aufgabe 2

-- 1 (siehe Aufgabe 1)

-- 2
INSERT INTO Gericht (Bezeichnung, Preis) VALUES ('Spaghetti Napoli', 9.50);
INSERT INTO Zutaten (Gerichtnummer, Zutat) VALUES (1, 'Tomaten');

INSERT INTO Gericht (Bezeichnung, Preis, Durchmesser, Typ_Tag) VALUES ('Pizza Hawaii', 15.00, 30, 'Pizza');
INSERT INTO Zutaten (Gerichtnummer, Zutat) VALUES (2, 'Ananas');
INSERT INTO Zutaten (Gerichtnummer, Zutat) VALUES (2, 'Schinken');

-- 3
SELECT * FROM Gericht;

-- 4
UPDATE Gericht SET Durchmesser = 32 WHERE Bezeichnung = 'Pizza Hawaii';

-- 5
SELECT Bezeichnung FROM Gericht WHERE Typ_Tag = 'Pizza' AND LOWER(Bezeichnung) NOT LIKE 'pizza%';
