#import "@preview/tdtr:0.3.0": *

= Aufgabe 1
== 1.1 Konstruiere einen RS-Baum mit Wurzel v wobei bh(v) = 4
#let red = metadata("red")
#let dot   = $dot$
#red-black-tree-graph[
  - #dot
    - #dot
      - #dot
        - #dot
          - 0
        - #dot
          - 0
      - #dot
        - #dot
          - 0
        - #dot
          - 0
    - #dot
      - #dot
        - #dot
          - 0
        - #dot
          - 0
      - #dot
        - #dot
          - 0
        - #dot
          - 0
]\
("0"er sollten ein Blatt RS-Blatt sein allerdings bin ich mir nicht sicher wie ich das in Typst setze ^^)
== 1.2 Zeigen Sie, dass ein längster Pfad von einem Knoten v zu einem RS-Blatt höchstens doppelt so lang ist wie ein kürzester Pfad von v zu einem RS-Blatt
Sei B ein beliebiger RS-Teilbaum mit root Knoten v und bh$(v) = h$. Sei s(v) die Länge der Pfade aus v bis RS-Blatt.
- Kürzester Pfad: Man muss mindestens die Schwarzhöhe an Schwarzen Knoten übergehen 
    $ => s_min (v) >= "bh"(v) $
- Längster Pfad: für jeden Knoten im Kürzesten Pfad füge man einen neuen roten Knoten ein. Diese Konstellation da maximal viele Schwarze Knoten im Pfad liegen und zusätzlich keine weiteren roten Knoten eingefügt werden können  
  $ => s_max (v) = 2 "bh"(v) $
$
  &=> s_max (v) = 2 dot "bh"(v) <= 2 dot s_min (v)\
  &=> s_max (v) <= 2 dot s_min (v)
$
  
= Aufgabe 2 Füge Zahlen in einen B-Baum der Ordnung 5 ein und gebe Inorder Nachfolger von 4, 18, 21 an
[13,16,10,11,24,4,12,2,15,18,22,26,17,14,25,1,7,3,21,8,19,5,23,6,20,9]\

#[
  #let arrow = align(horizon)[#math.arrow.double]
  #let treeRows = (
    (
      (
        tree: [ 
          - #math.dot
        ],
        transition: 13
      ),
      (
        tree: [ 
          - 13
        ],
        transition: 16
      ),
      (
        tree: [ 
          - 13, 16
        ],
        transition: 10
      ),
      (
        tree: [ 
          - 10, 13, 16
        ],
        transition: 11
      ),
      (
        tree: [ 
          - 10, 11, 13, 16
        ],
        transition: 24
      ),
      (
        tree: [ 
          - 13
            - 10, 11
            - 16, 24
        ],
        transition: 4
      ),
      (
        tree: [ 
          - 13
            - 4, 10, 11
            - 16, 24
        ],
        transition: 12
      ),
      (
        tree: [ 
          - 13
            - 4, 10, 11, 12
            - 16, 24
        ],
        transition: 2
      ),
    ),
    (
      (
        tree: [ 
          - 10, 13
            - 2, 4
            - 11, 12
            - 16, 24
        ],
        transition: 15
      ),
      (
        tree: [ 
          - 10, 13
            - 2, 4
            - 11, 12
            - 15, 16, 24
        ],
        transition: 18
      ),
      (
        tree: [ 
          - 10, 13
            - 2, 4
            - 11, 12
            - 15, 16, 18, 24
        ],
        transition: 22
      ),
      (
        tree: [ 
          - 10, 13, 18
            - 2, 4
            - 11, 12
            - 15, 16
            - 22, 24
        ],
        transition: 26
      ),
    ),
    (
      (
        tree: [ 
          - 10, 13, 18
            - 2, 4
            - 11, 12
            - 15, 16
            - 22, 24, 26
        ],
        transition: 17
      ),
      (
        tree: [ 
          - 10, 13, 18
            - 2, 4
            - 11, 12
            - 15, 16, 17
            - 22, 24, 26
        ],
        transition: 14
      ),
      (
        tree: [ 
          - 10, 13, 18
            - 2, 4
            - 11, 12
            - 14, 15, 16, 17
            - 22, 24, 26
        ],
        transition: 25
      ),
    ),
    (
      (
        tree: [ 
          - 10, 13, 18
            - 2, 4
            - 11, 12
            - 14, 15, 16, 17
            - 22, 24, 25, 26
        ],
        transition: 1
      ),
      (
        tree: [ 
          - 10, 13, 18
            - 1, 2, 4
            - 11, 12
            - 14, 15, 16, 17
            - 22, 24, 25, 26
        ],
        transition: 7
      ),
    ),
    (
      (
        tree: [ 
          - 10, 13, 18
            - 1, 2, 4, 7
            - 11, 12
            - 14, 15, 16, 17
            - 22, 24, 25, 26
        ],
        transition: 3
      ),
      (
        tree: [ 
          - 3, 10, 13, 18
            - 1, 2, 
            - 4, 7
            - 11, 12
            - 14, 15, 16, 17
            - 22, 24, 25, 26
        ],
        transition: 21
      ),
    ),
    (
      (
        tree: [ 
          - 13
            - 3, 10
              - 1, 2
              - 4, 7
              - 11, 12
            - 18, 24
              - 14, 15, 16, 17
              - 21, 22, 
              - 25, 26
        ],
        transition: 8
      ),
      (
        tree: [ 
          - 13
            - 3, 10
              - 1, 2
              - 4, 7, 8
              - 11, 12
            - 18, 24
              - 14, 15, 16, 17
              - 21, 22, 
              - 25, 26
        ],
        transition: 19
      ),
    ),
    (
      (
        tree: [ 
          - 13
            - 3, 10
              - 1, 2
              - 4, 7, 8
              - 11, 12
            - 18, 24
              - 14, 15, 16, 17
              - 19, 21, 22, 
              - 25, 26
        ],
        transition: 5
      ),
      (
        tree: [ 
          - 13
            - 3, 10
              - 1, 2
              - 4, 5, 7, 8
              - 11, 12
            - 18, 24
              - 14, 15, 16, 17
              - 19, 21, 22, 
              - 25, 26
        ],
        transition: 23
      ),
    ),
    (
      (
        tree: [ 
          - 13
            - 3, 10
              - 1, 2
              - 4, 5, 7, 8
              - 11, 12
            - 18, 24
              - 14, 15, 16, 17
              - 19, 21, 22, 23
              - 25, 26
        ],
        transition: 6
      ),
    ),
    (
      (
        tree: [ 
          - 13
            - 3, 6, 10
              - 1, 2
              - 4, 5
              - 7, 8
              - 11, 12
            - 18, 24
              - 14, 15, 16, 17
              - 19, 21, 22, 23
              - 25, 26
        ],
        transition: 20
      ),
    ),
    (
      (
        tree: [ 
          - 13
            - 3, 6, 10
              - 1, 2
              - 4, 5
              - 7, 8
              - 11, 12
            - 18, 21, 24
              - 14, 15, 16, 17
              - 19, 20
              - 22, 23
              - 25, 26
        ],
        transition: 9
      ),
    ),
    (
      (
        tree: [ 
          - 13
            - 3, 6, 10
              - 1, 2
              - 4, 5
              - 7, 8, 9
              - 11, 12
            - 18, 21, 24
              - 14, 15, 16, 17
              - 19, 20
              - 22, 23
              - 25, 26
        ],
        transition: ""
      ),
    ),
  )

  #for row in treeRows {
    let content = row.map(e => {
      (
        tidy-tree-graph(e.at("tree")) , 
        math.attach(sym.arrow.double, b: [#e.at("transition")])
      )
    }
    ).flatten()

    if (row == treeRows.last()) {
      let _ = content.pop()
    }

    align(left)[
      #block()[
        #align(horizon)[
          #stack(
            dir: ltr,
            spacing: 0.5em,
              ..content
         )
        ]
      ]
    ]
  }
]
#table(
  columns: 4,
  inset: 0.5em,
  align: horizon,
  [value], [4], [18], [21],
  [inorder successor], [5],[19],[22]
)
#pagebreak()
= Aufgabe 3 Entferne die Knoten des B-Baums aus A2 in umgekehrter Inorder Reihenfolge
Inorder-Reihenfolge: [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26]\
umgekehrte Inorder-Reihenfolge: [26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1]
#[
  #let treeRows = (
    (
      (
        tree: [ 
          - 13
            - 3, 6, 10
              - 1, 2
              - 4, 5
              - 7, 8, 9
              - 11, 12
            - 18, 21, 24
              - 14, 15, 16, 17
              - 19, 20
              - 22, 23
              - 25, 26
        ],
        transition: 26
      ),
    ),
    (
      (
        tree: [ 
          - 13
            - 3, 6, 10
              - 1, 2
              - 4, 5
              - 7, 8, 9
              - 11, 12
            - 18, 21
              - 14, 15, 16, 17
              - 19, 20
              - 22, 23, 24, 25
        ],
        transition: 25
      ),
    ),
    (
      (
        tree: [ 
          - 13
            - 3, 6, 10
              - 1, 2
              - 4, 5
              - 7, 8, 9
              - 11, 12
            - 18, 21
              - 14, 15, 16, 17
              - 19, 20
              - 22, 23, 24
        ],
        transition: 24
      ),
    ),
    (
      (
        tree: [ 
          - 13
            - 3, 6, 10
              - 1, 2
              - 4, 5
              - 7, 8, 9
              - 11, 12
            - 18, 21
              - 14, 15, 16, 17
              - 19, 20
              - 22, 23
        ],
        transition: 23
      ),
      (
        tree: [ 
          - 10
            - 3, 6
              - 1, 2
              - 4, 5
              - 7, 8, 9
            - 13, 18
              - 11, 12
              - 14, 15, 16, 17
              - 19, 20, 21, 22
        ],
        transition: 22
      ),
    ),
    (
      (
        tree: [ 
          - 10
            - 3, 6
              - 1, 2
              - 4, 5
              - 7, 8, 9
            - 13, 18
              - 11, 12
              - 14, 15, 16, 17
              - 19, 20, 21
        ],
        transition: 21
      ),
      (
        tree: [ 
          - 10
            - 3, 6
              - 1, 2
              - 4, 5
              - 7, 8, 9
            - 13, 18
              - 11, 12
              - 14, 15, 16, 17
              - 19, 20
        ],
        transition: 20
      ),
    ),
    (
      (
        tree: [ 
          - 10
            - 3, 6
              - 1, 2
              - 4, 5
              - 7, 8, 9
            - 13, 17
              - 11, 12
              - 14, 15, 16
              - 18, 19
        ],
        transition: 19
      ),
      (
        tree: [ 
          - 10
            - 3, 6
              - 1, 2
              - 4, 5
              - 7, 8, 9
            - 13, 16
              - 11, 12
              - 14, 15
              - 17, 18
        ],
        transition: 18
      ),
    ),
    (
      (
        tree: [ 
          - 3, 6, 10, 13
            - 1, 2
            - 4, 5
            - 7, 8, 9
            - 11, 12
            - 14, 15, 16, 17
        ],
        transition: 17
      ),
      (
        tree: [ 
          - 3, 6, 10, 13
            - 1, 2
            - 4, 5
            - 7, 8, 9
            - 11, 12
            - 14, 15, 16
        ],
        transition: 16
      ),
    ),
    (
      (
        tree: [ 
          - 3, 6, 10, 13
            - 1, 2
            - 4, 5
            - 7, 8, 9
            - 11, 12
            - 14, 15
        ],
        transition: 15
      ),
      (
        tree: [ 
          - 3, 6, 10
            - 1, 2
            - 4, 5
            - 7, 8, 9
            - 11, 12, 13, 14
        ],
        transition: 14
      ),
      (
        tree: [ 
          - 3, 6, 10
            - 1, 2
            - 4, 5
            - 7, 8, 9
            - 11, 12, 13
        ],
        transition: 13
      ),
    ),
    (
      (
        tree: [ 
          - 3, 6, 10
            - 1, 2
            - 4, 5
            - 7, 8, 9
            - 11, 12
        ],
        transition: 12
      ),
      (
        tree: [ 
          - 3, 6, 9
            - 1, 2
            - 4, 5
            - 7, 8
            - 10, 11
        ],
        transition: 11
      ),
      (
        tree: [ 
          - 3, 6
            - 1, 2
            - 4, 5
            - 7, 8, 9, 10
        ],
        transition: 10
      ),
      (
        tree: [ 
          - 3, 6
            - 1, 2
            - 4, 5
            - 7, 8, 9
        ],
        transition: 9
      ),
    ),
    (
      (
        tree: [ 
          - 3, 6
            - 1, 2
            - 4, 5
            - 7, 8
        ],
        transition: 8
      ),
      (
        tree: [ 
          - 3
            - 1, 2
            - 4, 5, 6, 7
        ],
        transition: 7
      ),
      (
        tree: [ 
          - 3
            - 1, 2
            - 4, 5, 6
        ],
        transition: 6
      ),
      (
        tree: [ 
          - 3
            - 1, 2
            - 4, 5
        ],
        transition: 5
      ),
      (
        tree: [ 
          - 1, 2, 3, 4
        ],
        transition: 4
      ),
      (
        tree: [ 
          - 1, 2, 3
        ],
        transition: 3
      ),
      (
        tree: [ 
          - 1, 2
        ],
        transition: 2
      ),
      (
        tree: [ 
          - 1
        ],
        transition: 1
      ),
      (
        tree: [ 
          - #math.dot
        ],
        transition: 1
      ),
    ),
  )

  #for row in treeRows {
    let content = row.map(e => {
      (
        tidy-tree-graph(e.at("tree")) , 
        math.attach(sym.arrow.double, b: [#e.at("transition")])
      )
    }
    ).flatten()

    if (row == treeRows.last()) {
      let _ = content.pop()
    }

    align(left)[
      #block()[
        #align(horizon)[
          #stack(
            dir: ltr,
            spacing: 0.5em,
              ..content
         )
        ]
      ]
    ]
  }
]
= Aufgabe 4 Konstruiere alle B-Bäume der Ordnung 4 mit [1,3,4,5,7]. Was ändert sich bei Ordnung 6
\
#let order4 = (
  tidy-tree-graph[
    - 3
      - 1
      - 4, 5, 7
  ],
  tidy-tree-graph[
    - 4
      - 1, 3
      - 5, 7
  ],
  tidy-tree-graph[
    - 5
      - 1, 3, 4
      - 7
  ],
  tidy-tree-graph[
    - 3, 5
      - 1
      - 4
      - 7
  ],
)
#let order6 = (
  tidy-tree-graph[
    - 1, 3, 4, 5, 7
  ],
  tidy-tree-graph[
    - 4
      - 1, 3
      - 5, 7
  ],
)

#align(center, 
  stack(dir: ltr, spacing: 5em,
    h(5em),
    grid(columns: 2, gutter: 1em, grid.cell(colspan: 2, [Ordnung 4]), ..order4),
    grid(columns: 2, gutter: 1em, grid.cell(colspan: 2, [Ordnung 6]), ..order6),
    h(8em),
  )
)
