# Lösung zu Übungsblatt 6 DB

## Aufgabe 1

1. 50Mio
2. 10Mio
3. 200k
4. 800Mio
5. 2Mio

## Aufgabe 2

`π schlagwort σ genre='Musik' ∨ genre='Musikvideo' (Videos ⨝ Schlagworte)`

## Aufgabe 3

1. Die vnr und titel von Videos, die lustig sind.
2. Alle Schlagwörter, die zu Videos gehören, die das Genre Musik oder Musikvideo haben.
3. `π Videos.titel (σ V.vnr=3517 ρ V Videos) ⨝ Schlagwörter ⨝ Videos`
4. 
```sql
select V2.titel from Videos V1
join Schlagwörter S on S.vnr = V1.vnr
join Videos V2 on V2.vnr = S.vnr
where V1.vnr=3517
```
