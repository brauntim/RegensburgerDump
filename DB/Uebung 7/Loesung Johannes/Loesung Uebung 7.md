# Loesung Uebung 7

## A1

| Aufgabe | Lösung | Begründung                                                   |
| ------- | ------ | ------------------------------------------------------------ |
| **1**   | Falsch | Schüler bestimmt Instrument                                  |
| **2**   | Falsch |                                                              |
| **3**   | Falsch | Lehrer kann weggelassen werden, es ist somit nicht voll f.A. |
| **4**   | Wahr   | Aus den Attributen und den f.A. kann $R$ hergeleitet werden. |
| **5**   | Falsch | Instrument kann weggelassen werden                           |
| **6**   | Wahr   | Der Schlüssel ist minimal (nichts kann weggelassen werden)   |
| **7**   | Falsch | Weiteres Beispiel: {wochentag, uhrzeit, raum}                |
| **8**   | Wahr   | Keine zusammengesetzten Daten etc.                           |
| **9**   | Falsch | Partielle Abhängigkeit (eg. wochentag, lehrer -> raum)       | 
| **10**  | Falsch | wochentag,uhrzeit,raum -> lehrer,schüler -> instrument       |

## A2

```
spielt(schüler, instrument)
       -------
raumbuchung(lehrer, wochentag, raum)
            -----------------
musikunterricht(wochentag, uhrzeit, lehrer, schüler)
                ------------------

musikunterricht(wochentag, lehrer) ist FK auf raumbuchung(wochentag, lehrer)
musikunterricht.schüler ist FK auf spielt.schüler
```

## A3

```
serien_folgen(serie, staffel, folge, titel, produzent, regisseur, sprache, {schauspieler})
              ---------------------
 - serie → produzent
 - serie, staffel → regisseur
 - serie, staffel, folge → titel
 - produzent → sprache
```

### NF1

```
serien_folgen(serie, staffel, folge, titel, produzent, regisseur, sprache)
              ---------------------
spielt_bei(serie, staffel, folge, schauspieler)
           -----------------------------------
```

### NF2

```
serien_folgen(serie, staffel, folge, titel, produzent, regisseur, sprache)
              ---------------------
spielt_bei(serie, staffel, folge, schauspieler)
           -----------------------------------
```
