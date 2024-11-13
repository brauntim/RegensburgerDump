# Abgabe 6

## Tabellen eines Videoportals

Videos(vnr, titel, genre, sprache)

Schlagworte(vnr, schlagwot)

Schlagworte.vnr ist ein Fremdschlüssel auf Videos.vnr

## Die Kardinalitäten der Tabellen bzw. Spalten sind wie folgt:

|Videos| = 100.000.000, |Schlagworte| = 400.000.000
|Videos.vnr| = 100.000.000, |Videos.titel| = 50.000.000
|Videos.genre| = 20, |Videos.sprache| = 25
|Schlagworte.vnr| = 50.000.000, |Schlagworte.schlagwort| = 400

## Nun die Schätzungen wie viele Zeilen die folgenden Ausdrücke liefern.

1. πvnr(Schlagworte) = 400.000.000

2. σgenre='Musik' ∨ genre = 'Musikvideo'(Videos) =>

3. σgenre='Musik' ∧ sprache = 'Deutsch'(Videos) =>

4. Videos ⋈Videos.vnr = Schlagworte.vnr Schlagworte =>

5. πvnr, titel σSchlagworte.schlagwort='lustig'(Videos ⋈Videos.vnr = Schlagworte.vnr Schlagworte) =>