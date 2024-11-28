# Abgabe 5

## 1. Wie viele Professoren, die den Rang C4 haben, gibt es?

```sql
    select count(*) 
    from professoren 
    where rang = 'C4';
```

## 2. Geben Sie die Namen der Studierenden aus, die die Vorlesung "Grundzüge" hören.

```sql
    select studenten.name 
    from studenten, vorlesungen, hoeren 
    where studenten.matrnr = hoeren.matrnr 
    and vorlesungen.vorlnr = hoeren.vorlnr 
    and vorlesungen.titel = 'Grundzüge';
```

## 3. Geben Sie zu jedem Professor, der mindestens zwei vorlesungen hält, den Namen sowie die Gesamt-SWS-Zahl der von ihm oder ihr gehaltenen Vorlesungen aus.

```sql
    select professoren.name, sum(vorlesungen.sws) 
    from professoren, vorlesungen 
    where professoren.persnr = vorlesungen.gelesenvon 
    group by professoren.name 
    having count(vorlesungen.vorlnr) >= 2;
```

## 4. Wie sind die Namen der Studierenden, die zusammen mit dem Studtenten namen "Feuerbach" zumindest eine gemeinsame Vorlesung hören? Geben Sie keine Namen doppelt aus. 

```sql
    select distinct s2.name 
    from studenten as s1
    join hoeren as h1 on s1.matrnr = h1.matrnr 
    join hoeren as h2 on h1.vorlnr = h2.vorlnr
    join studenten as s2 on h2.matrnr = s2.matrnr
    where s1.name = 'Feuerbach' and s2.name != 'Feuerbach'; 
```


