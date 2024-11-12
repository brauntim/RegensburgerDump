# Frage01:
``` SQL
select
  count(*)
from
  Professoren as Professor
where
  Rang = 'C4'
```

# Frage02:
``` SQL
select
  Student.Name
from
  Vorlesungen as Vorlesung
join
  hoeren as hoert on hoert.VorlNr = Vorlesung.VorlNr
join
  Studenten as Student on Student.MatrNr = hoert.MatrNr
where
  Vorlesung.Titel = 'Grundzüge'
```

# Frage03:
``` SQL
select
  Professor.Name,
  sum(Vorlesung.SWS) as SWS_Gesamt
from
  Professoren as Professor
join
  Vorlesungen as Vorlesung on Vorlesung.GelesenVon = Professor.PersNr
group by
  Professor.Name
having
  count(Vorlesung.VorlNr) > 2
```

# Frage04:
``` SQL
select
  Andere_Studenten.Name
from
  Studenten as Feuerbach
join
  hoeren as Feuerbach_hoert
  on Feuerbach_hoert.MatrNr = Feuerbach.MatrNr
join hoeren as Andere_hoeren 
  on Andere_hoeren.VorlNr = Feuerbach_hoert.VorlNr
join Studenten as Andere_Studenten 
  on Andere_Studenten.MatrNr = Andere_hoeren.MatrNr
where 
  Feuerbach.Name = 'Feuerbach' and Andere_Studenten.MatrNr <> Feuerbach.MatrNr
group by
  Andere_Studenten.Name
```
