#import "@preview/codly:1.3.0": *
#import "@preview/codly-languages:0.1.1": *
#import "@preview/tdtr:0.3.0": *

#let bin-tree = binary-tree-graph.with(spacing: (10pt, 10pt), node-inset:6pt, compact: false)
#let mkTree(array, content, vertical: 0pt) = {
  let val = array.map(a => str(a)).join(",")

  align(center, 
    stack(
      dir: ltr,
      align(center, 
        stack(
          v(vertical), 
          bin-tree()[#content],
          v(5pt), 
          $[#val]$
        )
      )
    )
  )
}

= Aufgabe 1
Sortiere $[-5, 13, -32, 7, -3, 17, 23, 12, -35, 19]$ mit ...
- MergeSort\
  + Divide 
    #stack(
      dir: ltr,
      mkTree((-5, 13, -32, 7, -3, 17, 23, 12, -35, 19),
        [
          - [0,9]
        ],
        vertical: 27pt
      ),
      [
        #v(30pt)
        $=>$
      ],
      mkTree((-5, 13, -32, 7, -3, "|",17, 23, 12, -35, 19),
        [
          - [0,9]
            - [0,4]
            - [5,9]
        ],
      ),
      [
        #v(30pt)
        $=>$
      ],
    )
    #stack(
      dir: ltr,
      mkTree((-5, 13, "|", -32, 7, -3, "|", 17, 23, "|", 12, -35, 19),
        [
          - [0,9]
            - [0,4]
              - [0,1]
              - [2,4]
            - [5,9]
              - [5,6]
              - [7,9]
        ],
        vertical: 27pt
      ),
      [
        #v(40pt)
        $=>$
      ],
      mkTree((-5, "|", 13, "|", -32, "|", 7, -3, "|", 17, "|", 23, "|", 12, "|", -35, 19),
        [
          - [0,9]
            - [0,4]
              - [0,1]
                - [0,0]
                - [1,1]
              - [2,4]
                - [2,2]
                - [3,4]
            - [5,9]
              - [5,6]
                - [5,5]
                - [6,6]
              - [7,9]
                - [7,7]
                - [8,9]
        ]
      ),
      [
        #v(40pt)
        $=>$
      ],
    )
    #stack(
      dir: ltr,
      mkTree((-5, "|", 13, "|", -32, "|", 7, "|", -3, "|", 17, "|", 23, "|", 12, "|", -35, "|", 19),
        [
          - [0,9]
            - [0,4]
              - [0,1]
                - [0,0]
                - [1,1]
              - [2,4]
                - [2,2]
                - [3,4]
                  - [3,3]
                  - [4,4]
            - [5,9]
              - [5,6]
                - [5,5]
                - [6,6]
              - [7,9]
                - [7,7]
                - [8,9]
                  - [8,8]
                  - [9,9]
        ],
        vertical: 27pt
      ),
    )
  + Conquor / Merge
    #stack(
      dir: ltr,
      mkTree((-5, "|", 13, "|", -32, "|", 7, "|", -3, "|", 17, "|", 23, "|", 12, "|", -35, "|", 19),
        [
          - [0,9]
            - [0,4]
              - [0,1]
                - #underline("[0,0]")
                - #underline("[1,1]")
              - [2,4]
                - [2,2]
                - [3,4]
                  - [3,3]
                  - [4,4]
            - [5,9]
              - [5,6]
                - [5,5]
                - [6,6]
              - [7,9]
                - [7,7]
                - [8,9]
                  - [8,8]
                  - [9,9]
        ],
        vertical: 27pt
      ),
      [
        #v(80pt)
        $=>$
      ],
      mkTree((-5, "|", 13, "|", -32, "|", 7, "|", -3, "|", 17, "|", 23, "|", 12, "|", -35, "|", 19),
        [
          - [0,9]
            - [0,4]
              - [0,1]
              - [2,4]
                - [2,2]
                - [3,4]
                  - #underline("[3,3]")
                  - #underline("[4,4]")
            - [5,9]
              - [5,6]
                - [5,5]
                - [6,6]
              - [7,9]
                - [7,7]
                - [8,9]
                  - [8,8]
                  - [9,9]
        ],
        vertical: 27pt
      ),
      [
        #v(80pt)
        $=>$
      ],
    )
    #stack(
      dir: ltr,
      mkTree((-5, 13, "|", 7, "|", -32, -3, "|", 17, "|", 23, "|", 12, "|", -35, "|", 19),
        [
          - [0,9]
            - [0,4]
              - [0,1]
              - [2,4]
                - #underline("[2,2]")
                - #underline("[3,4]")
            - [5,9]
              - [5,6]
                - [5,5]
                - [6,6]
              - [7,9]
                - [7,7]
                - [8,9]
                  - [8,8]
                  - [9,9]
        ],
        vertical: 27pt
      ),
      [
        #v(80pt)
        $=>$
      ],
      mkTree((-5, 13, "|", -32, -3, 7, "|", 17, "|", 23, "|", 12, "|", -35, "|", 19),
        [
          - [0,9]
            - [0,4]
              - #underline("[0,1]")
              - #underline("[2,4]")
            - [5,9]
              - [5,6]
                - [5,5]
                - [6,6]
              - [7,9]
                - [7,7]
                - [8,9]
                  - [8,8]
                  - [9,9]
        ],
        vertical: 27pt
      ),
      [
        #v(80pt)
        $=>$
      ],
    )
    #stack(
      dir: ltr,
      mkTree((-32, -5, -3, 7, 13, "|", 17, "|", 23, "|", 12, "|", -35, "|", 19),
        [
          - [0,9]
            - [0,4]
            - [5,9]
              - [5,6]
                - #underline("[5,5]")
                - #underline("[6,6]")
              - [7,9]
                - [7,7]
                - [8,9]
                  - [8,8]
                  - [9,9]
        ],
        vertical: 27pt
      ),
      [
        #v(80pt)
        $=>$
      ],
      mkTree((-32, -5, -3, 7, 13, "|", 17, 23, "|", 12, "|", -35, "|", 19),
        [
          - [0,9]
            - [0,4]
            - [5,9]
              - [5,6]
              - [7,9]
                - [7,7]
                - [8,9]
                  - #underline("[8,8]")
                  - #underline("[9,9]")
        ],
        vertical: 27pt
      ),
      [
        #v(80pt)
        $=>$
      ],
    )
    #stack(
      dir: ltr,
      mkTree((-32, -5, -3, 7, 13, "|", 17, 23, "|", 12, "|", -35, 19),
        [
          - [0,9]
            - [0,4]
            - [5,9]
              - [5,6]
              - [7,9]
                - #underline("[7,7]")
                - #underline("[8,9]")
        ],
        vertical: 27pt
      ),
      [
        #v(80pt)
        $=>$
      ],
      mkTree((-32, -5, -3, 7, 13, "|", 17, 23, "|", -35, 12, 19),
        [
          - [0,9]
            - [0,4]
            - [5,9]
              - #underline("[5,6]")
              - #underline("[7,9]")
        ],
        vertical: 54pt
      ),
      [
        #v(80pt)
        $=>$
      ],
    )
    #stack(
      dir: ltr,
      mkTree((-32, -5, -3, 7, 13, "|", -35, 12, 17, 19, 23),
        [
          - [0,9]
            - #underline("[0,4]")
            - #underline("[5,9]")
        ],
        vertical: 27pt
      ),
      [
        #v(40pt)
        $=>$
      ],
      mkTree((-35, -32, -5, -3, 7, 12, 13, 17, 19, 23),
        [
          - [0,9]
        ],
        vertical: 54pt
      )
    )

    \
    \
    \
    \
    \
    \
- HeapSort\
  + Heapify
    #stack(
      dir: ltr,
      mkTree(
        (-5, 13, -32, 7, -3, 17, 23, 12, -35, 19),
        [
          - -5
            - 13
              - 7
                - 12
                - -35
              - #underline("-3")
                - #underline("19")
            - -32
              - 17 
              - 23
        ],
      ),
      [
        #v(40pt)
        $=>$
      ],
      mkTree(
        (-5, 13, -32, 7, 19, 17, 23, 12, -35, -3),
        [
          - -5
            - 13
              - #underline("7")
                - #underline("12")
                - -35
              - 19
                - -3
            - -32
              - 17 
              - 23
        ]
      ),
      [
        #v(40pt)
        $=>$
      ],
    )
    #stack(
      dir: ltr,
      mkTree(
        (-5, 13, -32, 12, 19, 17, 23, 7, -35, -3),
        [
          - -5
            - 13
              - 12
                - 7
                - -35
              - 19
                - -3
            - #underline("-32")
              - 17 
              - #underline("23")
        ]      
      ),
      [
        #v(40pt)
        $=>$
      ],
      mkTree(
        (-5, 13, 23, 12, 19, 17, -32, 7, -35, -3), 
        [
          - -5
            - #underline("13")
              - 12
                - 7
                - -35
              - #underline("19")
                - -3
            - 23
              - 17 
              - -32
        ],
      ),
      [
        #v(40pt)
        $=>$
      ],
    )
    #stack(
      dir: ltr,
      mkTree(

        (-5, 19, 23, 12, 13, 17, -32, 7, -35, -3),
        [
          - #underline("-5")
            - 19
              - 12
                - 7
                - -35
              - 13
                - -3
            - #underline("23")
              - 17 
              - -32
        ],
      ),
      [
        #v(40pt)
        $=>$
      ],
      mkTree(
        (23, 19, -5, 12, 13, 17, -32, 7, -35, -3),
        [
          - 23
            - 19
              - 12
                - 7
                - -35
              - 13
                - -3
            - #underline("-5")
              - #underline("17")
              - -32
        ]
      ),
      [
        #v(40pt)
        $=>$
      ]
    )
    #mkTree(
      (23, 19, 17, 12, 13, -5, -32, 7, -35, -3),
      [
          - 23
            - 19
              - 12
                - 7
                - -35
              - 13
                - -3
            - 17
              - -5
              - -32

      ]
    )
    \
  + Sort
    #stack(
      dir: ltr,
      mkTree(
        (23, 19, 17, 12, 13, -5, -32, 7, -35, -3),
        [
            - #underline("23")
              - 19
                - 12
                  - 7
                  - -35
                - 13
                  - #underline("-3")
              - 17
                - -5
                - -32

        ]
      ),
      [
        #v(40pt)
        $=>$
      ],
      mkTree(
        (-3, 19, 17, 12, 13, -5, -32, 7, -35, 23),
        [
            - #underline("-3")
              - #underline("19")
                - 12
                  - 7
                  - -35
                - 13
                  - 23
              - 17
                - -5
                - -32

        ]
      ),
      [
        #v(40pt)
        $=>$
      ],
    )
    #stack(
      dir: ltr,
      mkTree(
        (19, -3, 17, 12, 13, -5, -32, 7, -35, 23),
        [
            - 19
              - #underline("-3")
                - 12
                  - 7
                  - -35
                - #underline("13")
              - 17
                - -5
                - -32

        ]
      ),
      [
        #v(40pt)
        $=>$
      ],
      mkTree(
        (19, 13, 17, 12, -3, -5, -32, 7, -35, 23),
        [
            - #underline("19")
              - 13
                - 12
                  - 7
                  - #underline("-35")
                - 3
              - 17
                - -5
                - -32

        ]
      ),
      [
        #v(40pt)
        $=>$
      ],
    )
    #stack(
      dir: ltr,
      mkTree(
        (-35, 13, 17, 12, -3, -5, -32, 7, 19, 23),
        [
            - #underline("-35")
              - 13
                - 12
                  - 7
                  - 19
                - -3
              - #underline("17")
                - -5
                - -32

        ]
      ),
      [
        #v(40pt)
        $=>$
      ],
      mkTree(
        (17, 13, -35, 12, -3, -5, -32, 7, 19, 23),
        [
            - 17
              - 13
                - 12
                  - 7
                - -3
              - #underline("-35")
                - -5
                - #underline("-32")

        ]
      ),
      [
        #v(40pt)
        $=>$
      ],
    )
    #stack(
      dir: ltr,
      mkTree(
        (17, 13, -32, 12, -3, -5, -35, 7, 19, 23),
        [
            - #underline("17")
              - 13
                - 12
                  - #underline("7")
                - -3
              - -32
                - -5
                - -35

        ]
      ),
      [
        #v(40pt)
        $=>$
      ],
      mkTree(
        (7, 13, -32, 12, -3, -5, -35, 17, 19, 23),
        [
            - #underline("7")
              - #underline("13")
                - 12
                  - 17
                - -3
              - -32
                - -5
                - -35

        ]
      ),
      [
        #v(40pt)
        $=>$
      ],
    )
    #stack(
      dir: ltr,
      mkTree(
        (13, 7, -32, 12, -3, -5, -35, 17, 19, 23),
        [
            - 13
              - #underline("7")
                - #underline("12")
                - -3
              - -32
                - -5
                - -35

        ]
      ),
      [
        #v(40pt)
        $=>$
      ],
      mkTree(
        (13, 12, -32, 7, -3, -5, -35, 17, 19, 23),
        [
            - #underline("13")
              - 12
                - 7
                - -3
              - -32
                - -5
                - #underline("-35")

        ]
      ),
      [
        #v(40pt)
        $=>$
      ],
    )
    #stack(
      dir: ltr,
      mkTree(
        (-35, 12, -32, 7, -3, -5, 13, 17, 19, 23),
        [
            - #underline("-35")
              - #underline("12")
                - 7
                - -3
              - -32
                - -5
                - 13

        ]
      ),
      [
        #v(40pt)
        $=>$
      ],
      mkTree(
        (12, -35, -32, 7, -3, -5, 13, 17, 19, 23),
        [
            - 12
              - #underline("-35")
                - #underline("7")
                - -3
              - -32
                - -5

        ]
      ),
      [
        #v(40pt)
        $=>$
      ],
    )
    #stack(
      dir: ltr,
      mkTree(
        (12, 7, -32, -35, -3, -5, 13, 17, 19, 23),
        [
            - #underline("12")
              - 7
                - -35
                - -3
              - -32
                - #underline("-5")

        ]
      ),
      [
        #v(40pt)
        $=>$
      ],
      mkTree(
        (-5, 7, -32, -35, -3, 12, 13, 17, 19, 23),
        [
            - #underline("-5")
              - #underline("7")
                - -35
                - -3
              - -32
                - 12

        ]
      ),
      [
        #v(40pt)
        $=>$
      ],
    )
    #stack(
      dir: ltr,
      mkTree(
        (7, -5, -32, -35, -3, 12, 13, 17, 19, 23),
        [
            - 7
              - #underline("-5")
                - -35
                - #underline("-3")
              - -32

        ]
      ),
      [
        #v(40pt)
        $=>$
      ],
      mkTree(
        (7, -3, -32, -35, -5, 12, 13, 17, 19, 23),
        [
            - #underline("7")
              - -3
                - -35
                - #underline("-5")
              - -32

        ]
      ),
      [
        #v(40pt)
        $=>$
      ],
    )
    #stack(
      dir: ltr,
      mkTree(
        (-5, -3, -32, -35, 7, 12, 13, 17, 19, 23),
        [
            - #underline("-5")
              - #underline("-3")
                - -35
                - 7
              - -32

        ]
      ),
      [
        #v(40pt)
        $=>$
      ],
      mkTree(
        (-3, -5, -32, -35, 7, 12, 13, 17, 19, 23),
        [
            - #underline("-3")
              - -5
                - #underline("-35")
              - -32

        ]
      ),
      [
        #v(40pt)
        $=>$
      ],
    )
    #stack(
      dir: ltr,
      mkTree(
        (-35, -5, -32, -3, 7, 12, 13, 17, 19, 23),
        [
            - #underline("-35")
              - #underline("-5")
                - -3
              - -32

        ]
      ),
      [
        #v(30pt)
        $=>$
      ],
      [
        #v(20pt)
        #mkTree(
          (-5, -35, -32, -3, 7, 12, 13, 17, 19, 23),
          [
              - #underline("-5")
                - -35
                - #underline("-32")

          ]
        ),
      ],
      [
        #v(30pt)
        $=>$
      ],
    )
    #stack(
      dir: ltr,
      mkTree(
        (-32, -35, -5, -3, 7, 12, 13, 17, 19, 23),
        [
            - #underline("-32")
              - #underline("-35")
              - -5

        ]
      ),
      [
        #v(20pt)
        $=>$
      ],
      mkTree(
        (-35, -32, -5, -3, 7, 12, 13, 17, 19, 23),
        [
            - #underline("-35")
              - #underline("-32")

        ]
      ),
      [
        #v(20pt)
        $=>$
      ],
    )
    #stack(
      dir: ltr,
      [
        #v(10pt)
        $=>$
      ],
      mkTree(
        (-35, -32, -5, -3, 7, 12, 13, 17, 19, 23),
        [
            - -35

        ]
      ),
    )

    $=> [-35, -32, -5, -3, 7, 12, 13, 17, 19, 23]$

#pagebreak()

= Aufgabe 2
  Zeige folgende Aussagen:
  + Ein Heap mit n Elementen hat die Höhe $floor(log n)$\
    Sei $h in NN$ die Höhe des Heap\
    Sei $n_i in NN_0$ die Anzahl auf der i-ten Ebene\
    Es gilt:
    $
      forall i in NN: 1 <= n_i <= 2^i 
    $
    Da ein Heap linksvoll ist muss auch gelten: 
    $
      n &= sum_(i=0)^h n_i = sum_(i=0)^(h-1) 2^i + n_h =_"endl. geom. Reihe" (2^(h-1+1) - 1) / (2-1) + n_h = (2^h - 1) / (2-1) + n_h = 2^h - 1 + n_h\
        &=> n = 2^h + n_h - 1 => 2^h - 1< n <= 2^(h+1) - 1 => "#"_"Höhe h"^"min" = 2^h and "#"_"Höhe h"^"max" = 2^(h+1) - 1\
        &=> log(2^h - 1) < log n <= log(2^(h+1)-1)\
        &=> log(2^h - 1) < log n <= log(2^(h+1)-1) < log(2^(h+1)) => log(2^h - 1) < log n < log(2^(h+1))\
        &=> log(2^h) <= log n < log(2^(h+1)) => h <= log n < h+1 => h = floor(log n)
    $
    \
  + Ein Heap mit n Elementen hat höchstens $ceil(n/(2^(h + 1)))$ viele Knoten der Höhe h\
    Sei H ein linksvoller Heap mit n Elementen. Dann gilt: $max("#"_"Knoten Höhe h") = ceil(n/2^(h+1))$\ 
    \
    Sei $"index"_"Vorgänger" (i) = floor((i-1)/2)$ und $A(i) = i + 1$ die Anzahl der Elemente bis zu einem Index\
    IA: $h=0$\

    $
      "#"_"Blätter" &= n - A("index"_"Vorgänger" (n-1)) = n - (floor((n - 2)/2) + 1) \
                    &=cases(n - ((n-2)/2 +1)",    " n mod 2 = 0, n - ((n-1-2)/2 + 1)", " n mod 2 = 1)\
                    &=cases(n/2",       " n mod 2 = 0, n/2 + 1/2", " n mod 2 = 1) = ceil(n/2)
    $
    IV: angenommen die Behauptung gilt für ein festes aber beliebiges h-1\
    IS: $h-1 -> h$\
    Aus dem Heap H wird durch streichen aller Blätter der Heap H'. Beobachtung: alle Knoten in H' die Höhe h-1 haben in H die Höhe h (eigentlich noch durch Induktion Beweisen)\
    nach IV: 
    $
      "#"_"Blätter"^"H'" = ceil((n - ceil(n/2))/2^((h-1)+1)) = ceil(floor(n/2)/2^h) <= ceil(n/2/2^h) = ceil(n/2^(h+1)) => "#"_"Knoten mit Höhe h" <= ceil(n/2^(h+1))\
      => "Die Aussage gilt für alle h"
    $
    \
    \
    \
    \
    \
    \
  + Für alle x mit $abs(x) < 1: sum_(k=0)^infinity k x^k = x/((1-x)^2)$\
    $
      forall x in RR and abs(x) < 1: sum_(k=0)^infinity k x^k = x/(1-x)^2\
      "geometrische Reihe" : sum_(k=0)^infinity x^k = 1/(1-x)\
      partial/(partial x) sum_(k=0)^infinity x^k = partial/(partial x) 1/(1-x) <=> sum_(k=0)^infinity k x^(k-1) = 1/((1-x)^2)\
      => forall 0 < abs(x) < 1: x sum_(k=0)^infinity k x^(k-1) = x 1/((1-x)^2) <=> sum_(k=0)^infinity k x^(k) = x/((1-x)^2)
    $

#pagebreak()

= Aufgabe 3
  $o_(i,j)$ gilt: $o_(i,j) = sum_(k=1)^n (m_(i,k) dot n_(k,i))$
  + \
    - Variante 1:\
      \
      #let M11 = $mat(m_(1,1), m_(1,2), ..., m_(1, n/2);
                      m_(2,1), m_(2,2), ..., m_(2, n/2);
                      dots.v, dots.v, dots.down, dots.v;
                      m_(n/2, 1), ..., ..., m_(n/2, n/2)
                  )$
      #let M12 = $mat(m_(1, n/2), m_(1, n/2+1), ..., m_(1, n);
                      m_(2, n/2), m_(2, n/2+1), ..., m_(2, n);
                      dots.v, dots.v, dots.down, dots.v;
                      m_(n/2, n/2), ..., ..., m_(n/2, n)
                  )$
      #let N11 = $mat(n_(1,1), m_(1,2), ..., n_(1, n/2);
                      n_(2,1), m_(2,2), ..., n_(2, n/2);
                      dots.v, dots.v, dots.down, dots.v;
                      n_(n/2, 1), ..., ..., n_(n/2, n/2)
                  )$
      #let N21 = $mat(m_(n/2+1, 1), m_(n/2+1, 2), ..., m_(n/2+1, n/2);
                      m_(n/2+2, 1), m_(n/2+2, 2), ..., m_(n/2+2, n/2);
                      dots.v, dots.v, dots.down, dots.v;
                      m_(n, 1), ..., ..., m_(n, n/2)
                  )$
      $O_11 = M_11 dot N_11 + M_12 dot N_12 = "MN1" + "MN2" = \
        #M11 dot #N11 + #M12 dot #N21$\
      $
        i, j in [1, n/2]: 
        "MN1"_(i,j) = sum_(k=1)^(n/2) m_(i, k) dot n_(k, i) and 
        "MN2"_(i,j) = sum_(k=n/2 + 1)^(n) m_(i, k) dot n_(k, i)\
        => "MN1"_(i,j) + "MN2"_(i,j) = sum_(k=1)^(n/2) m_(i, k) dot n_(k, i) + sum_(k=n/2 + 1)^(n) m_(i, k) dot n_(k, i) = sum_(k=1)^n m_(i,k) dot n_(k,i) = o_(i,j)
      $
      gilt für $O_(1,2), O_(2,1), O_(2,2)$ analog
      \
      \
    - Variante 2:
      $
        &H_1 := ("M"_(1,1) + "M"_(2,2)) dot ("N"_(1,1) + "N"_(2,2))\
        &H_2 := ("M"_(2,1) + "M"_(2,2)) dot "N"_(1,1)\
        &H_3 :=  "M"_(1,1) dot ("N"_(1,2) - "N"_(2,2))\
        &H_4 :=  "M"_(2,2) dot ("N"_(2,1) - "N"_(1,1))\
        &H_5 := ("M"_(1,1) + "M"_(1,2)) dot "N"_(2,2)\
        &H_6 := ("M"_(2,1) - "M"_(1,1)) dot ("N"_(1,1) + "N"_(1,2))\
        &H_7 := ("M"_(1,2) - "M"_(2,2)) dot ("N"_(2,1) + "N"_(2,2))\
        &O_(1,1) := H_1 + H_4 - H_5 + H_7\
        &O_(1,2) := H_3 + H_5\
        &O_(2,1) := H_2 + H_4\
        &O_(2,2) := H_1 - H_2 + H_3 + H_6\
      $
      $
      "Umformungen:"\
        O_(1,1) = &H_1 + H_4 - H_5 + H_7 \
                = &("M"_(1,1) + "M"_(2,2)) dot ("N"_(1,1) + "N"_(2,2)) + "M"_(2,2) dot ("N"_(2,1) - "N"_(1,1)) - ("M"_(1,1) + "M"_(1,2)) dot "N"_(2,2) + \ 
                  &("M"_(1,2) - "M"_(2,2)) dot ("N"_(2,1) + "N"_(2,2))\
                = &"M"_(1,1) dot "N"_(1,1) + "M"_(1,1) dot "N"_(2,2) + "M"_(2,2) dot "N"_(1,1) + "M"_(2,2) dot "N"_(2,2) + "M"_(2,2) dot "N"_(2,1) - "M"_(2,2) dot "N"_(1,1) -\
                  &"M"_(1,1) dot "N"_(2,2) - "M"_(1,2) dot "N"_(2,2) + "M"_(1,2) dot "N"_(2,1) + "M"_(1,2) dot "N"_(2,2) - "M"_(2,2) dot "N"_(2,1) - "M"_(2,2) dot "N"_(2,2)\
                = &("M"_(1,1) dot "N"_(1,1) + "M"_(1,2) dot "N"_(2,1)) + ("M"_(1,1) dot "N"_(2,2) - "M"_(1,1) dot "N"_(2,2)) + ("M"_(2,2) dot "N"_(1,1) - "M"_(2,2) dot "N"_(1,1))  \
                  &+ ("M"_(2,2) dot "N"_(2,2) - "M"_(2,2) dot "N"_(2,2)) + ("M"_(2,2) dot "N"_(2,1) - "M"_(2,2) dot "N"_(2,1)) + (- "M"_(1,2) dot "N"_(2,2) + "M"_(1,2) dot "N"_(2,2))\
                = &"M"_(1,1) dot "N"_(1,1) + "M"_(1,2) dot "N"_(2,1)\
        O_(1,2) = &H_3 + H_5\
                = &"M"_(1,1) dot ("N"_(1,2) - "N"_(2,2)) + ("M"_(1,1) + "M"_(1,2)) dot "N"_(2,2)\
                = &"M"_(1,1) dot "N"_(1,2) - "M"_(1,1) dot "N"_(2,2) + "M"_(1,1) dot "N"_(2,2) + "M"_(1,2) dot "N"_(2,2)\
                = &("M"_(1,1) dot "N"_(1,2) + "M"_(1,2) dot "N"_(2,2)) - "M"_(1,1) dot "N"_(2,2) + "M"_(1,1) dot "N"_(2,2)\
                = &"M"_(1,1) dot "N"_(1,2) + "M"_(1,2) dot "N"_(2,2)\
        O_(2,1) = &H_2 + H_4\
                = &("M"_(2,1) + "M"_(2,2)) dot "N"_(1,1) + "M"_(2,2) dot ("N"_(2,1) - "N"_(1,1))\
                = &"M"_(2,1) dot "N"_(1,1) + "M"_(2,2) dot "N"_(1,1) + "M"_(2,2) dot "N"_(2,1) - "M"_(2,2) dot "N"_(1,1)\
                = &"M"_(2,1) dot "N"_(1,1) + "M"_(2,2) dot "N"_(2,1)\
        O_(2,2) = &H_1 - H_2 + H_3 + H_6\
                = &("M"_(1,1) + "M"_(2,2)) dot ("N"_(1,1) + "N"_(2,2)) - ("M"_(2,1) + "M"_(2,2)) dot "N"_(1,1) + "M"_(1,1) dot ("N"_(1,2) - "N"_(2,2)) + \
                  &("M"_(2,1) - "M"_(1,1)) dot ("N"_(1,1) + "N"_(1,2))\
                = &("M"_(1,1) dot "N"_(1,1) + "M"_(1,1) dot  "N"_(2,2) + "M"_(2,2) dot "N"_(1,1) + "M"_(2,2) dot  "N"_(2,2)) - ("M"_(2,1) dot "N"_(1,1) + "M"_(2,2) dot "N"_(1,1)) +\
                  &("M"_(1,1) dot "N"_(1,2) - "M"_(1,1) dot "N"_(2,2)) + ("M"_(2,1) dot "N"_(1,1) + "M"_(2,1) dot "N"_(1,2) - "M"_(1,1) dot "N"_(1,1) - "M"_(1,1) dot "N"_(1,2))\
                = &"M"_(1,1) dot "N"_(1,1) + "M"_(1,1) dot  "N"_(2,2) + "M"_(2,2) dot "N"_(1,1) + "M"_(2,2) dot  "N"_(2,2) - "M"_(2,1) dot "N"_(1,1) - "M"_(2,2) dot "N"_(1,1) +\
                  &"M"_(1,1) dot "N"_(1,2) - "M"_(1,1) dot "N"_(2,2) + "M"_(2,1) dot "N"_(1,1) + "M"_(2,1) dot "N"_(1,2) - "M"_(1,1) dot "N"_(1,1) - "M"_(1,1) dot "N"_(1,2)\
                = &("M"_(2,1) dot "N"_(1,2) + "M"_(2,2) dot  "N"_(2,2)) + ("M"_(1,1) dot "N"_(1,1) - "M"_(1,1) dot "N"_(1,1)) + ("M"_(2,2) dot "N"_(1,1) - "M"_(2,2) dot "N"_(1,1)) + \
                  &(- "M"_(2,1) dot "N"_(1,1) + "M"_(2,1) dot "N"_(1,1) ) + ("M"_(1,1) dot "N"_(1,2) - "M"_(1,1) dot "N"_(1,2)) - "M"_(1,1) dot "N"_(2,2) + "M"_(1,1) dot  "N"_(2,2) \
                = &"M"_(2,1) dot "N"_(1,2) + "M"_(2,2) dot  "N"_(2,2)
      $
  + \
    für n gelte: $n, k in NN_0: n = 2^k$\
    - Variante 1:\
      Matrix Additionen werden durch die Konstante $4n^2$ abgeschätzt\
      $ 
        => T(n) = 8 T(n/2) + 4 n^2\
        "mit Master Methode: " 4 n^2 in O(n^(log_2 8)) => T(n) in Theta(n^3)
      $
      \
      \
    - Variante 2:\
      Matrix Additionen werden durch die Konstante $18 n^2$ abgeschätzt\
      $ 
        => 7 T(n/2) + 18 n^2\
        "mit Master Methode: " 18 n^2 in O(n^(log_2 7)) => T(n) in Theta(n^(log_2 7))
      $

#pagebreak()
= Aufgabe 4
#show: codly-init.with()

#let textMain = read("A04/main.cpp");
#let textMatrix = read("A04/matrix.hpp");
#let textMatrixCode = read("A04/matrix.cpp");

#codly(enabled:true, number-format: none)
#raw(block: true, "main.cpp:\n" + textMain + "\nmatrix.hpp:\n"+ textMatrix + "\nmatrix.cpp:\n"+ textMatrixCode, lang: "cpp")








