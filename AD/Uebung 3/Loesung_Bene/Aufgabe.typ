= Aufgabe 1
Bestimme untere und obere Schranke der folgenden Rekursionsgleichungen mit Hilfe Iterations- und Substitutionsmethode
+ $T(1) = 1, T(n) = 4 T(n/2) + n ", " forall n > 1$\
  Iterationsmethode:
    - Iteriere: $T(n) = 4 T(n/2) + n = 4 (4 T(n/4) + n) + n = 4 (4 (4 T(n/8) + n) + n) + n$ \
    - Struktur: $4^i T(n/(2^i)) + n sum_(k=0)^(i-1) 2^k$
    - Löse $i = 2^(log n) : 4^(log n) T(n/(2^(log n))) + n sum_(k=0)^(log(n) - 1) 2^k = n^2 + n (2^(log n) - 1) / (2-1) = n^2 + n^2 - n in O(n^2)$
  Substitutionsmethode: 
    - Behauptung: $T(n) in Theta(n^2)$\
      Z. Z.: $T(n) = 1 dot n^2$ \
      IA: $n = 1: T(1) = 1^2$\
      IV: Behauptung gilt auch für $n/2$\
      IS: $n/2->n: T(n) = 4 T(n/2) + n = 4 dot (n/2)^2 + n = 1 dot n^2 + n in Theta(n^2)$
+ $T(1) = 1, T(n) = 2T(n/4) + sqrt(n)" " forall n > 1$\
  Iterationsmethode: 
    - Iteriere: \
      $T(n) = 2 T(n/4) + sqrt(n) = 2( 2 T(n/4^2) + sqrt(n/4)) + sqrt(n) &= 2( 2 (2 T(n/4^3) +sqrt(n/4^2)) + sqrt(n/4)) + sqrt(n)\
      &= 2^3 T(n/4^3) + 4 sqrt(n/4^2) + 2 sqrt(n/4) + sqrt(n)\
      &= 2^3 T(n/4^3) + sum_(k = 0)^2 (2^k sqrt(n/4^k))
      $
    - Struktur:\
      $T(n) = 2^i T(n/4^i) + sum_(k=0)^(i-1)(2^k sqrt(n/4^k))$
    - Löse $i = log_4(n)$\
      $T(n) = 2^(log_4 n) T(n/(4^(log_4 n))) + sum_(k=0)^(log_4(n)-1)(2^k sqrt(n/4^k)) &= 2^(log_4 n)  + sqrt(n) sum_(k=0)^(log_4(n)-1) 2^k dot 2^(-k)\
      &= 2^(log_4 n)  + sqrt(n) sum_(k=0)^(log_4(n)-1) 1 \
      &= sqrt(n) + sqrt(n) dot log_4(n) - sqrt(n)\
      &= sqrt(n) dot log_4(n) \
      &=> T(n) in Theta(sqrt(n) dot log n)
      $
  Substitutionsmethode: \
    - Behauptung: $T(n) = 2 T(n/4) + sqrt(n) in Theta(sqrt(n) log n)$
    - Induktions Anfang: $n = 4: T(4) = 2 T(4/4) + sqrt(4) = 2 + 2 = 4 <= 4 = 2 dot 2 = sqrt(4) log(4)$\
    - Induktions Vorraussetung: es gibt ein n für das die Aussage gilt \
    - Induktions Schritt: $n/4 -> n$\
      $T(n) = 2 T(n/4) + sqrt(n) = 2 dot sqrt(n/4) log(n/4) + sqrt(n) &= sqrt(n) (log(n) - log(4)) + sqrt(n)\
      &= sqrt(n) log(n) - sqrt(n) log(4) + sqrt(n)\
      &=> T(n) in Theta(sqrt(n) log(n))
      $

      \
      \
      \
      \
      \
      \
+ $T(1) = 1, T(2) = 1, T(3) = 1, T(n) = 2 T(n-1) + n^2 " "forall n>3$\
  Iterationsmethode:
    - Iteriere: \
      $T(n) = 2 T(n-1) + n^2 &= 2 ( 2 T(n-2) + (n-1)^2) + n^2\
      &= 2 ( 2 ( 2 T(n-3) + (n-2)^2) + (n-1)^2) + n^2\
      &= 2^3 T(n-3) + 2^2(n-2)^2 + 2^1(n-1)^2 + n^2\
      &= 2^3 T(n-3) + sum_(k=0)^2 2^k (n-k)^2$
  #[
  #show math.equation.where(block:false): it => math.display(it)
    - Struktur: \
      $T(n) = 2^i T(n-i) + sum_(k=0)^(i-1) 2^k (n-k)^2$ 
    - Löse $i = n-1$:\
      $T(n) = 2^(n-1) T(n-(n-1)) + sum_(k=0)^(n-1-1) 2^k (n-k)^2 = 2^(n-1) + sum_(k=0)^(n-2) 2^k (n-k)^2
      $\
      Lösungsidee: \
      $sum_(k=0)^(n-2) 2^k (n-k)^2 &= n^2 + 2(n-1)^2 + 4(n-2)^2 + ... + 2^(n-3) (3)^2 + 2^(n-2)(2)^2\
      &=2^(n-2) 2^2 + 2^(n-3) 3^2 + ... + 4(n-2)^2 + 2(n-1)^2 + n^2
      $\
      Aus der Lösungsidee:\
      $T(n) = 2^(n-1) + sum_(k=0)^(n-2) 2^k (n-k)^2 = sum_(k=0)^(n-1) 2^k (n-k)^2 = 2^(n-1) sum_(k=0)^(n-1) (2^k)/2^(n-1) dot (n-k)^2$\
      \
      mit dem Quotientenkriterium: $lim_(n->infinity) |a_(n+1)/a_n|$\
      $lim_(n->infinity) (2^k/2^n (n+1 - k)) / (2^k/2^(n-1) (n - k)) = lim_(n->infinity)(2^(n-1)(n+1-k))/(2^n (n-k)) = lim_(n->infinity) (n + 1 - k) /(2^n (n-k)) = 0 < 1\ 
      => exists l in RR : lim_(n->infinity) sum_(k=0)^(n-1) (2^k)/2^(n-1) dot (n-k)^2 = l\
      => T(n) = 2^(n-1) dot Theta(1) in Theta(2^n)
      $

  ]\
  Subsitutionsmethode: 
    - Behauptung B: $T(n) = 2 T(n-1) + n^2 in Theta(2^n)$
    - Zu zeigen: $T(n) = 1/2 dot 2^n$
    - Induktions anfang: $n = 1$\
      $T(1) = 1 = 1/2 dot 2^1 = 1$
    - Induktions Vorraussetzung: $exists n in NN: B(n-1) "gilt"$
    - Induktions Behauptung: Für dieses $n-1$ gilt auch $B(n)$
    - Induktions Schritt: $n-1->n$\
      $
        T(n) = 2 T(n-1) + n^2 = 2 dot 1/2 dot 2^(n-1) + n = 1/2 dot 2^n + n in Theta(2^n)

      $
\
\
\
\
= Aufgabe 2
Sei f(n) die n.te Fibonacci Zahl, die wie folgt definiert ist: \
$
  f: NN -> NN "mit" f(1) = 1, f(2) = 1, f(n) = f(n-1) + f(n-2) " "forall n>=3
$
a) folgern Sie mit vollständiger Induktion, dass gilt: 
$
  f(n) = (Phi^n - hat(Phi)^n)/sqrt(5) " mit " Phi = (1+sqrt(5))/2 " und " hat(Phi) = (1-sqrt(5))/2
$
b) Folgern Sie, dass eine rekursive Implementierung zur Berechnung der Fibonacci Zahlen die Laufzeit $T(n) = Theta(Phi^n)$

==== a)
Induktions Anfang: $n=1$, $n=2$
  $
    f(1) = (Phi^1 - hat(Phi)^1) / sqrt(5) = ((1+sqrt(5))/2 - (1 - sqrt(5))/2)/sqrt(5) = 1\ 
    f(2) = (Phi^2 - hat(Phi)^2) / sqrt(5) = (((1+sqrt(5))/2)^2 - ((1 - sqrt(5))/2)^2)/sqrt(5) = ((6+2sqrt(5))/4 - (6-2sqrt(5))/4)/sqrt(5) = ( 6 - 6 + 4sqrt(5))/(4sqrt(5)) = 1
  $
Induktions Vorraussetzung: es gibt ein n für das die Aussage gilt\
Induktions Schritt: $n->n+1$\
  $
    f(n+1) = f(n) + f(n-1) &=^"IV" (Phi^n - hat(Phi)^n)/sqrt(5) + (Phi^(n-1) - hat(Phi)^(n-1)) / sqrt(5) = (Phi^n - hat(Phi)^n + Phi^(n-1) - hat(Phi)^(n-1))/sqrt(5)\
    &= (Phi^(n-1) (Phi + 1) - hat(Phi)^(n-1)(hat(Phi) + 1))/sqrt(5)\
  $
  mit $Phi^2 = ((1+sqrt(5))/2)^2 = (1+2sqrt(5)+5)/4 = 6/4 + sqrt(5)/2 = 1 + 1/2 + sqrt(5)/2 = 1 + (1+sqrt(5))/2 = 1 + Phi$ \
  und $hat(Phi)^2 = ((1-sqrt(5))/2)^2 = (1-2sqrt(5) +5)/4 = 1 + 1/2 - sqrt(5) = 1 + (1-sqrt(5))/2= 1 + hat(Phi) $\
  $
    => f(n+1) &= (Phi^(n-1) (Phi + 1) - hat(Phi)^(n-1)(hat(Phi) + 1))/sqrt(5) =(Phi^(n-1) Phi^2  - hat(Phi)^(n-1) hat(Phi)^2)/sqrt(5) = (Phi^(n+1) - hat(Phi)^(n+1))/sqrt(5) \
  $
==== b)
$
  T(1) = 1," " T(2) = 1," " T(n) = T(n-1) + T(n-2)
$
#underline[Substitutionsmethode:]\
Behauptung: $Theta(T(n)) = Theta(Phi^n)$\
Induktions Anfang: $n=1$ , $n=2$:
$
  c_1 dot Phi^1 <= T(1) = 1 <= c_2 dot Phi^1 \
  => c_1 <= 1/Phi and c_2 >= 1/Phi\
  \
  c_1 dot Phi^2 <= T(2) = 1 <= c_2 dot Phi^2 \
  => c_1 <= 1/Phi^2 and c_2 >= 1/Phi^2
$\
Induktions Schritt: $n -> n+1$:\
- Case O(T(n)):
$
  T(n+1) = T(n) + T(n-1) <=^"IV" c_2 dot Phi^n + c_2 dot Phi^(n-1) = c_2 Phi^(n-1) (Phi + 1) = c_2 Phi^(n-1) dot Phi^2 = c_2 Phi^(n+1)
$
- Case $Omega(T(n))$:
$
  T(n+1) =  T(n) + T(n-1) >=^"IV" c_1 dot Phi^n + c_1 dot Phi^(n-1) = c_1 Phi^(n-1) (Phi + 1) = c_1 Phi^(n+1)
$

also gilt: Für $ c_1 <= 1/Phi^2 and c_2>= 1/Phi: T(n) in Theta(Phi^n)$
= Aufgabe 3
Beweise mit Master Methode: 
+ $T(1) = 1, T(2) = 1, T(n) = T(n/2) + 1 " " forall n > 2 => T(n) in Theta(log n)$:\
  $a = 1,  b = 2, f(n) = 1$\
  $n^(log_b a) = n^(log_2 (1)) = n^0 = 1 => f(n) in Theta(1) => T(n) in Theta(n^(log_2 1) log n) = Theta(log n)
  $\ 
+ $T(1) = 1, T(2) = 1, T(n) = 3T(n/4) + n log n" " forall n > 2 => T(n) in Theta(n log n)$\
  $a=3, b=4, f(n) = n log n$\ 
  $forall n: n^(log_4 3) <= n^1 <= n log n=> n^(log_4 3) in O(n log n) => f(n) = n log n in Omega(n^(log_4 3))$\
  Teste: $a f(n/b) = 3 f(n/4)  <= c f(n) $\
  $ 3(n/4 log n/4) &= 3/4 n log n/4 = 3/4 n (log n - log 4) = 3/4 n log n - 3/4 n log 4 = 3/4 n log n - 3/2 n \
  &= 3/2 n (log n - 1) <= 3/2 n log n => T(n)  in Theta(n log n) $

+ $T(1) = 1, T(2) = 1, T(n) = 7T(n/2) + n^2 " " forall n > 2 => T(n) in Theta(n^2.81)$\
  $a = 7, b = 2, f(n) = n^2$\
  $n^(log_2 7) >= n^2 => n^(log_2 7) in Omega(n^2) => f(n) = n^2 in O(n^(log_2 7)) => T(n) in Theta(n^(log_2 7)) approx Theta(n^2.81)$

= Aufgabe 4

$ f(n, m) = cases(
  m+1 ", "               &n=0,
  f(n-1, 1) ", "         &m=0 " " and " " n>=1,
  f(n-1, f(n, m-1)) ", " &"sonst"
)
$
Behauptung $D(f(n,m)) = NN_0 times NN_0$\

- Induktionsanfang: $n=0$\
  - Unterbehauptung: $forall m in NN_0: f(0,m) in NN$\
  - Induktionsanfang $m=0$\
    $
      f(0,0) = 0 + 1 in NN
    $
  - Induktionsvorraussetzung: $exists m in NN_0: f(0,m) in NN$ [IV1]
  - Induktionsschritt: $m->m+1$\
    $ 
      f(0,m+1) = (m+1) + 1 in NN
    $
  $=> forall m in NN_0: f(0, m) in NN$
- Induktionsvorraussetzung: $forall m in NN_0: exists n in NN_0: f(n,m) in NN$
- Induktionsschritt: $n->n+1$\
  - Unterbehauptung: $forall m in NN_0: f(n+1,m) in NN$\
  - Induktionsanfang: $m=0$
    $ 
      f(n+1, 0) = f(n, 1)
    $
    Aus IV1 folgt: $f(n,1) in NN$
  - Induktionsvorraussetzung: $exists m : f(n+1, m) in NN$ [IV2]
  - Induktionsschritt: $m->m+1$
    $
      f(n+1,m+1) = f(n, f(n+1,m)) =>_"IV2" exists l in NN: f(n,f(n+1, m)) = f(n,l)\
    $\
    Aus IV1 folgt: $f(n,l) in NN$
$=> forall n,m in NN_0: D(f(n,m)) in NN$
  
\
\
\
\
\
\
\
\
\
\
\
\
\


$
  f(n,m) &= f(n-1, f(n, m-1))\ 
  &= f(n-1, f(n-1, f(n, m-2)))\
  &= f(n-1, f(n-1, f(n-1, f(n, m-3))))
$
