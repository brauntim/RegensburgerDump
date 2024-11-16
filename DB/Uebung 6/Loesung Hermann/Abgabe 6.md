# Abgabe 6

## Tabellen eines Videoportals

Videos(<u>vnr</u>, titel, genre, sprache)

Schlagworte(<u>vnr</u>, <u>schlagwort</u>)

Schlagworte.vnr ist ein Fremdschlüssel auf Videos.vnr

## Die Kardinalitäten der Tabellen bzw. Spalten sind wie folgt:

|Videos| = 100.000.000, |Schlagworte| = 400.000.000
|Videos.vnr| = 100.000.000, |Videos.titel| = 50.000.000
|Videos.genre| = 20, |Videos.sprache| = 25
|Schlagworte.vnr| = 50.000.000, |Schlagworte.schlagwort| = 400

## Nun die Schätzungen wie viele Zeilen die folgenden Ausdrücke liefern.

1. πvnr(Schlagworte) = 50.000.000

2. σgenre='Musik' ∨ genre = 'Musikvideo'(Videos) &rarr; 0,1(2/20) * 100.000.000 = 10.000.000

3. σgenre='Musik' ∧ sprache = 'Deutsch'(Videos) &rarr; (1/20 * 1/25) * 100.000.000 = 1/500 * 100.000.000 = 200.000

4. Videos ⋈ Videos.vnr = Schlagworte.vnr(Schlagworte) &rarr; 400.000.000

5. πvnr, titel σSchlagworte.schlagwort='lustig'((Videos) ⋈ Videos.vnr = Schlagworte.vnr (Schlagworte)) &rarr; (1/400 * 400.000.000) = 1.000.000