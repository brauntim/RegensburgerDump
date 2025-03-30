# Aufgabe: 1
## Teilaufgabe: a
$$ \begin{multline}
!(a+b)+ab+c\\
!a!b+ab+c
\end{multline} $$
$$ \begin{multline}
!(a+(bc))+(c*(b+c))\\
(!a*!(bc))+c\\
(!a*(!b+!c))+c\\
!a!b+!a!c+c\\
!a!b+c+!a\\
!a+c
\end{multline} $$
## Teilaufgabe: b
### Teilaufgabe: i
$$ \begin{multline}
a\cdot(a+b)\\
aa+ab\\
a+ab\\
a
\end{multline} $$
$a+ab$ ist $a$ da, wenn $a = 1 \longrightarrow a+ab =1$, wenn $a=0 \longrightarrow a+ab=0$.
### Teilaufgabe: ii
$$ \begin{multline}
ab+a!b\\
a \cdot (b+!b)\\
a \cdot 1\\
a
\end{multline} $$
## Teilaufgabe: c
### Teilaufgabe: i

| a   | b   | !ab | a+!ab | a+b |
| --- | --- | --- | ----- | --- |
| 0   | 0   | 0   | 0     | 0   |
| 1   | 0   | 0   | 1     | 1   |
| 1   | 1   | 0   | 1     | 1   |
| 0   | 1   | 1   | 1     | 1   |
Ja die Aussage ist korrekt.
### Teilaufgabe: iii

| a   | b   | c   | !(ac) | a+c | b+c | !(ac)+(a+c)*(b+c) | b+c |
| --- | --- | --- | ----- | --- | --- | ----------------- | --- |
| 0   | 0   | 0   | 1     | 0   | 0   | 1                 | 0   |
| 1   | 0   | 0   | 1     | 1   | 0   | 1                 | 0   |
| 0   | 1   | 0   | 1     | 0   | 1   | 1                 | 1   |
| 0   | 0   | 1   | 1     | 1   | 1   | 1                 | 1   |
| 1   | 1   | 0   | 1     | 1   | 1   | 1                 | 1   |
| 0   | 1   | 1   | 1     | 1   | 1   | 1                 | 1   |
| 1   | 0   | 1   | 0     | 1   | 1   | 1                 | 1   |
| 1   | 1   | 1   | 0     | 1   | 1   | 1                 | 1   |
Nein, die Aussage ist nicht korrekt.
# Aufgabe: 2
### Teilaufgabe: a
$(a+b+c+d)*(a+b+!c+d)*(a+!b+c+d)*(a+!b+c+!d)*(!a+b+!c+d)*(!a+!b+c+!d)$
### Teilaufgabe: b
![[02b.drawio.svg]]
### Teilaufgabe: c
$$
(!a!b!cd)+(!a!bcd)+(!abc!d)+(!abcd)+(a!b!c!d)+(a!b!cd)+(a!bcd)+(ab!c!d)+(abc!d)+(abcd)
$$
### Teilaufgabe: d
$$ \begin{multline}
(!a!b!cd)+(!a!bcd)+(!abc!d)+(!abcd)+(a!b!c!d)+(a!b!cd)+(ab!c!d)+(abc!d)+(a!bcd)+(abcd)\\
(!a!bd)*(c+!c)+(!abc)*(!d+d)+(a!b!c)*(!d+d)+(ab!d)*(!c+c)+(acd)*(b+!b)\\
(!a!bd)+(ab!d)+(!abc)+(a!b!c)+(acd)\\
a*(b!d+!b!c+cd)+!a*(!bd+bc)
\end{multline} $$
### Teilaufgabe: e
![[02e.drawio.svg]]