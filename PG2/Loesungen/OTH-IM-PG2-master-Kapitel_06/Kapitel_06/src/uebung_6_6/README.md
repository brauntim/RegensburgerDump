#### ID Generator für Personen ####

**Ziel**: Verwendung von statischen Variablen

##### Aufgabe 1 #####

Erstelle eine Klasse `Student` mit folgenden Attributen:
- `firstName`: soll den Vornamen als Text speichern (`private`)
- `lastName`: soll den Nachnamen als Text speichern (`private`)

**Weiteres**
- Erstelle `getter` und `setter` für alle privaten Attribute!
- Erstelle einen leeren Konstruktor `Student()`, welcher keine Übergabeparameter besitzt und beide Attribute mit einem leeren Wert initialisiert.

##### Aufgabe 2 #####

Erstelle eine Klasse `program.java`, welche eine `main`Funktion beinhaltet und drei Studenten anlegt:
- tomStudent { firstName: "Tom", lastName: "Teuer" }
- reginaStudent { firstName: "Regina", lastName: "Reich" }
- leaStudent { firstName: "Lea", lastName: "Lustig" }

Sie müssen die Objekte hierbei nicht auf der Konsole/Terminal ausgeben.

##### Aufgabe 3 #####
Nachdem wir jetzt drei Studenten angelegt haben, interessiert uns zusätzlich die `ID` der Studenten. Für die `ID` gilt folgendes:
- jede `ID` ist eindeutig
- sie ist eine ganze Zahl
- sie beginnt bei 1 und wird automatisch bei Erstellung eines Studenten hochgezählt
- erstelle hierfür eine private Variable `id` im Studenten, welche die ID für den Studenten speichert (getter und setter nicht vergessen)
- und erstelle einer statische Variable `static_id` im Studenten, welche die aktuell höchste ID für alle Studenten speichert
- ändere den Konstruktor der Studentenklasse, damit die Änderungen vollzogen werden können
- gebe dann in der main nach der Erstellung jedes Studenten folgendes aus: `firstName + ": " + id` (mit getter auf das Objekt zugreifen). Das Ergebnis sollte lauten:
    - Tom: 1
    - Regina: 2
    - Lea: 3




##### Hinweise #####
- Statische Variablen oder Methoden werden über den KlassenNAMEN aufgerufen
- In einer statischen Methode habt ihr KEIN Objekt der Klasse zur Verfügung, d.h. 'this' wird nicht funktionieren. Ihr könnt nur auf normale Methoden zugreifen, wenn ihr ein Objekt der Klasse erstellt (verwendet man sehr selten)

###### Beispiel ######

Klasse `Person` hat die statische Variable `numberOfEyes`, weil egal welches Objekt der Klasse `Person` immer die gleiche Anzahl an Augen besitzen wird. Daher wäre der Aufruf für diese statische Variable `Person.numberOfEyes`.
