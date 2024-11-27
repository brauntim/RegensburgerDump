# Übung 7

## Aufgabe 2: Normalisierung

### Überführen Sie die Tabelle aus Aufgabe 1 in die dritte Normalform. Überlegen Sie sich passende Namen für die Tabellen.



## Aufgabe 3: Normalisierung

### Bringen Sie die folgende Relation "serien_folge" zuerst in 1NF, dann in 2NF, dann 3NF. Kennzeichnen Sie Primärschlüssel und Fremdschlüssel.

#### serien_folge(<u>serie, staffel, folge</u>, titel, produzent, regisseur, sprache, {schauspieler}) &rarr; schauspieler ist ein mengenwertiges Attribut

- serie &rarr; produzent
- serie, staffel &rarr; regisseur
- serie, staffel, folge &rarr; titel
- produzent &rarr; sprache

1NF &rArr; Folgen(<u>serie, staffel, folge</u>, titel, produzent, regisseur, sprache) und Schauspieler(<u>serie, staffel, folge</u>, schauspieler)

2NF &rArr; Folgen(<u>serie, staffel, folge</u>, titel), Serie(<u>serie</u>, produzent) {Serie.serie ist Fremdschlüssel auf Folgen.serie},
           Produzent(<u>produzent</u>, sprache),   