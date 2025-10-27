= Aufgabe 2
$"let" n in NN and c in RR $
+ show or disprove "$13 + 37 + 4 in O(1) $"

  $ 13 + 37 + 4 = 54 = 54 * 1 => 13 + 37 + 4 <= 54 * 1 => 13 + 37 + 4 in O(1) $\
#let function = $ 2 n^3 + 4 n^2 + 8 n + 3 $
+ show or disprove "$#function in Omega(n^3) $"\
  #align(center)[
    $ 
      #function >= c n^3  \
      <=> #function / (n^3) >= c  \
      <=> 2 + 4/n + 8/n^2 + 3/n^3 >= c  \
      <=> c <= 2  \
      => 2 n^3 + 4 n^2 + 8 n + 3 in O(n^3) 
    $
  ] \
#let function = $ 6^(-5) n^1.25 $ 
+ show or disprove "$#function in Theta(sqrt(n)) $"
  #align(center)[
    $
      "Assume" #function  in O(sqrt(n)) => #function <= c sqrt(n) \
      <=> #function/sqrt(n) = 6^(-5) (n^(5/4))/(n^(1/2)) = 6^(-5) n^(0.75) <= c \
      <=> n -> infinity: c -> infinity => exists.not c: #function <= c sqrt(n) \
      => #function in.not O(sqrt(n)) => #function in.not Theta(sqrt(n))
    $
  ]\
#let function = $ 4^(n+1) $ 
+ show or disprove "$#function in O(4^n) $"
  #align(center)[
    $
      #function = 4 * 4^n => c = 4 => #function in O(4^n)
    $
  ]\
#let function = $ 4^(2n) $
+ show or disprove "$#function in O(4^n) $"
  #align(center)[
    $
      #function = 4^n * 4^n => c = 4^n => n -> infinity: c -> infinity => exists.not c: #function <= c * 4^n => 4^(2 n) in.not O(4^n)
    $
  ]\
#let function = $ 2 log n!$
+ show or disprove "$#function in Theta(n log n) $"
  - $"case" 1: #function in O(n log n) $ \
    #align(center)[
      $
        2 log n! = 2 log(n*(n-1)*...*1) = 2 (log(n) + log(n-1) + ... + log(1)) \
        <=> 2 * sum_(i=1)^(n) log i < 2 sum_(i=1)^(n) log n = 2n log n => c >= 2: #function <= c n log n
      $
    ]
  - $"case" 2: #function in Omega(n log n) $ \
    #align(center)[
      $
        2 log n! = 2 log(n*(n-1)*...*1) = 2 (log(n) + log(n-1) + ... + log(1)) \
        <=> 2 * sum_(i=1)^(n) log i > 2 sum_(i=n/2)^(n) log(n/2) = 2 n/2 log(n/2) \
      $
    ]
    #align(center)[
      $
        = n (log n - log 2) = n log n - n log 2 = n log n - n \
        => c = 1:  #function >= c n log n <=> #function in Omega(n log n)
      $
    ]
  $=> #function in O(n log n) and #function in Omega(n log n) => #function in Theta(n log n) $\
  \
+ show or disprove "$ 2^n in O(n!)$"
  #align(center)[
    $
      2^n <= c n! <=> (2^n)/n! <= c
    $
  ] 
  *Idea*: \
  $2^n/n! = (2*...*2)/(n*(n - 1)*...*1) = 2/n * 2/(n-1) * ... * 2/2 * 2/1 $ (n-2 Faktoren kleiner als 0 => für $n->infinity: 2^n/n! -> 0) $ \
  \
  *Test*: 
  #let n = table.cell(
    fill: gray
  )[n]
  #let fun = table.cell(
    fill: gray
  )[$2^n/n!$]
  #table(
    columns: 5,
    n,  [1], [2], [3],     [4],
    fun,[2], [2], [$4/3$], [$2/3$]
  )\

  *to prove*:  $forall n >= 4: 2^n < n! $ \
  - Induction start: $n=4$ \
    $ 2^4 = 16 <= 4! = 24 $
  - Induction step: $n->n+1$ \
    $ 2^(n+1) = 2^n * 2 <= n! * 2 " " ["Induction Start"] $ 
    $ => n! * 2 <= n! * (n + 1) " " [n >= 4] $
    $ => 2^(n+1) <= (n+1)! $
    $"from the above it follows that" n! in o(2^n) <=> 2^n in O(n!)$
  \ 

+ show or disprove "$n! in O(n^n)$"
  $ n! <= c * n^n  <=> n! / n^n <= c $
  *Idea*: analogical to number 7 \

  *to prove*: $forall n in NN: n! <= n^n$
  - Induction start: $n=1$ \
    $ 1! = 1 <= 1^1 = 1 $
  - Induction step: $n->n+1$
    $ (n+1)! = (n+1)n! <= (n+1)n^n " "["Induction start"] $
    $ => (n+1)n^n <= (n+1)(n+1)^n = (n+1)^(n+1) "therefore" n! in O(n^n)$
