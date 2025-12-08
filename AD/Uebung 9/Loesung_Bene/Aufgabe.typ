#import "@preview/codly:1.3.0": *
#import "@preview/codly-languages:0.1.1": *

#show: codly-init.with()

= Aufgabe 2
ermitteln Sie die Position dieser Keys {61,62,63,64,65} in einer Hastabelle mit m = 1000 und $h(s) = floor(m dot ((s dot x) mod_c 1))$ mit $x = (sqrt(5)-1)/2$\
- h(61) = 700
- h(62) = 318
- h(63) = 936
- h(64) = 554
- h(65) = 172
= Aufgabe 3
Sei eine Hashtabelle der Größe m gegeben, in der n Schlüssel mittels offerner Addressierung gespeichert werden sollen. Geben der folgenden Formel eine sinnvolle Bedeutung:
$
  P_k = (1/m)^k dot (1-1/m)^(n-k) dot binom(n, k)
$
$1/m$ ist die Wahrscheinlichkeit eine Zelle zu treffen. $(1/m)^k$ ist die Wahrscheinlichkeit mit k Schlüsseln die gleiche Zelle z zu treffen.\
$(1-1/m)$ ist die Gegenwahrscheinlichkeit zu $1/m$, also die Wahrscheinlichkeit nicht z zu treffen. $(1-1/m)^(n-k)$ ist die Wahrscheinlichket, dass die restlichen Schlüssel nicht z treffen.\
Nun haben wir eine Reihenfolge haben wir eine Reihenfolge, nämlich zuerst treffen k Schlüssel z und dann die restlichen n-k Schlüssel eine andere.\
Ignorieren wir nun die Reihenfolge muss in der die Schlüssel z treffen oder nicht, müssen wir diese Reihenfolgen noch dazu zählen. Diesen Faktor ergibt der Binomialkoeffizient $binom(n,k)$\
$=>$ also gibt uns diese Formel die Wahrscheinlichkeit dass bei n Schlüssel k auf die Zelle z fallen und der Rest nicht mehr
= Aufgabe 4
Implementieren Sie Hashing mit $h'(s) = s$ als Hashfunktion und folgenden Varianten zu Kolisionsauflösung:
+ Lineares Probieren
+ Quadratisches Probieren mit $c_1 = 1 and c_2 = 3$
+ Doppeltes Hashing mit $h_1 (s) = s and h_2 (s) = 1 + (s mod (m-1))$
Erstellen sie Hashtables der Größe m = 11 und fügen sie diese Werte ${10,22,31,4,15,28,17,88,59}$ je nach den drei Methoden ein. 


#codly(enabled:true, number-format: none)
