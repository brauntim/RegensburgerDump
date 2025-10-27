= Aufgabe 4:
+ prove or disprove $sum_(k=0)^(infinity) k^2 / 2^k = O(1)$
  - applying ratio rule for series: $"let" S_k = sum_(n = 0)^(k) a_n and lim_(n->infinity)(a_(n+1)/a_n) < 1: exists l in RR: lim_(k->infinity)(S_k) = l$
  #align(center)[
    $ => ((k+1)^2/2^(k+1)) / (k^2/2^k) <=> ((k+1)^2 * 2^k)/(k^2 * 2^(k+1)) = (k+1)^2 / (2 k^2) <=> 1/2 * ((k+1)/k)^2 => lim_(k->infinity)( 1/2 * ((k+1)/k) ^ 2) = 1/2 * 1 < 1$
  ]
  $=> exists l in RR: lim_(k->infinity)(S_k) = l => sum_(k=0)^(infinity)(k^2 / 2^k) <= c * 1 => c >= l => sum_(k=0)^infinity (k^2/2^k) in O(1)$
  \
  \
+ prove or disprove $n^m = O(alpha^n) " "forall m in NN and alpha > 1$ \
  evaluate: 
    #align(center)[
      $
        lim_(n->infinity) n^m/alpha^n <=> "using l'Hôpital: " lim_(n->infinity) (diff^m/(diff n^m) n^m)/(diff^m/(diff n^m) alpha^n) = lim_(n->infinity) m!/(alpha^n * ln(alpha)) = 0 \
        => n^m in Omega(alpha^n) => alpha^n in O(n^m)
      $
    ]\
    other why\
    #align(center)[
      $e^x = sum_(k=0)^infinity (x^k/k!)$ \
      show $n^m = O(alpha^n)$
      to show $n^m <= c alpha^n$
      $alpha^n = e^(n ln alpha) = sum_(k=0)^infinity ((n ln alpha)^k)/k! >= (n ln alpha)^m / m!$\
      $=> n^m <= m!/((ln alpha)^m) alpha^n$

    ]
+ prove or disprove $n ln n in O(n^(3/2))$\
  from the definition of $O(n^(3/2))$\
  #align(center)[
    $n ln n <= c n^(3/2) <=> ln n <= c n^(1/2)$
    $<=> c >= (ln n)/sqrt(n)$\
  ]
  apply limit: 
  #align(center)[
    $lim_(n->infinity)((ln n)/sqrt(n)) <=> "using l'Hôpital": lim_(n->infinity) ((1/n)/(1/(2sqrt(n)))) = lim_(n->infinity) (2sqrt(n) / n) = 0$\
    $=> sqrt(n)^3 in Omega(n ln n) => n ln n in O(sqrt(n)^3)$
  ]\

+ prove or disprove $5^(log_3 n) in O(n^2)$\
  from the definition of $O(n^2)$\
  #align(center)[
    $5^(log_3 n) <= c n^2 <=> 5^(log_3 n) / n^2 <= c <=> 5^((ln n)/(ln 3)) / n^2 <= c <=> 5^(ln n) / (5^(ln 3) n^2) <= c$ \
    using the equality: $ a^x = e^(ln (a) x) $ 
    $ =>5^(ln n) / (5^(ln 3) n^2) = e^(ln (5)ln (n)) / (5^(ln 3) n^2) = n^(ln (5)) / (5^(ln 3) n^2) <= c $
    taking the limit: $ lim_(n->infinity) n^(ln (5)) / (5^(ln 3) n^2) approx lim_(n->infinity) n^1.609 / (5^(ln 3) n^2) = 0 $
    $ => 5^(log_3 n) in Omega(n^2) => n^2 in O(5^(log_3 n))$
  ]
