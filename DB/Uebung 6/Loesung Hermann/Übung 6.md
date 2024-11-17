# Aufgabe 2

## Überführen Sie diese Anfrage in eine äquivalente Anfrage gemäß den Heuristiken zur Anfrageoprimierung aus der Vorlesung

### πschlagwort σgenre = 'Musik' σ Videos.vnr = schlagworte.vnr (Videos × Schlagworte) ⋃ πschlagwort σgenre = 'Musikvideo' σ Videos.vnr = schlagworte.vnr (Videos × Schlagworte)

πschlagwort (σgenre = 'Musik' ∨ genre = 'Musikvideo' (Videos ⋈Videos.vnr = schlagworte.vnr (Schlagworte)))


# Aufgabe 3

## 1. Formulieren Sie in Ihren eigenen Worten, was die Anfrage 5 aus Ausgabe 1 liefert

Alle Videonummern mit ihren Titeln (falls vorhanden) aus der Videostabelle, die das Schlagwort 'lustig' beinhalten

## 2. Formulieren Sie in Ihren eigenen Worten, was die Anfrage aus Ausgabe 2 liefert

Alle Schlagwörter aus den Genres 'Musik' und 'Musikvideo'

## 3. Formulieren Sie auf dem Relationenschema von Aufgabe 1 einen Ausdruck der relationalen Algebra, der Ihnen die Titel von derjenigen Videos ausgibt, die mindestens ein Schlagwort haben, welches auch das Video mit der VNR 3517 besitzt

πVideos.titel (σSchlagworte.schlagwort > 0 ∧ Schlagworte.vnr = 3517 (Video ⋈Videos.vnr = Schlagworte.vnr Schlagworte)) //passt nicht aber kein plan tbh

## 4. Das gleiche wie 3., allerdings formulieren Sie nun bitte eine entsprechende SQL-Anfrage

SELECT DISTINCT v2.titel 
FROM Videos v1
JOIN Schlagworte s1 ON v1.vnr = s1.vnr
JOIN Schlagworte s2 ON s1.vnr = s2.vnr
JOIN Videos v2 ON s2.vnr = v2.vnr
WHERE v1.vnr = 3517 AND v2.vnr != 3517



