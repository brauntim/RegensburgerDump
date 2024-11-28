# Abgabe 7

## Aufgabe 2

### Betrachten Sie das folgende Relationenschema mit den dazugehörigen funktionalen Abhängigkeiten

#### musikunterricht(wochentag, uhrzeit, instrument, raum, lehrer, schüler)
- wochentag, lehrer &rarr; raum
- schüler &rarr; instrument
- wochentag, uhrzeit, raum &rarr; lehrer, schüler

## Welche der folgenden Aussagen sind wahr?

1. Ein Schüler kann Unterricht für mehrere verschiedene Instrumente nehmen. 
   Falsch. 

2. Es gilt: lehrer &rarr; instrument 
   Falsch. 

3. Es gilt: schüler, lehrer &rArr; instrument 
   Falsch. 

4. {wochentag, uhrzeit, instrument, raum} ist ein Superschlüssel. 
    Wahr. 

5. {wochentag, uhrzeit, instrument, raum} ist ein Schlüsselkandidat.
    Falsch. 

6. {wochentag, uhrzeit, lehrer} ist ein Schlüsselkandidat.
    Wahr.

7. In der Tabelle "musikunterricht" gibt es nur einen Schlüsselkandidaten.
   Falsch. 

8. Die Tabelle "musikunterricht" ist in 1NF.
   Wahr. 

9. Die Tabelle "musikunterricht" ist in 2NF.
   Falsch. 

10. Die Tabelle "musikunterricht" ist in 3NF.
    Falsch.