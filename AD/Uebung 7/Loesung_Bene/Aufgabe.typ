#import "@preview/tdtr:0.3.0": *
#import "@preview/codly:1.3.0": *
#import "@preview/codly-languages:0.1.1": *

#let bin-tree = binary-tree-graph.with(spacing: (10pt, 10pt), node-inset:6pt, compact: false)

#show: codly-init.with()

= Aufgabe 1
#let main = read("/implementation/A01/main.cpp");
#let binSearchTree = read("/implementation/A01/binSearchTree.cpp");
#codly(enabled:true, number-format: none)
#raw(block: true, "main.cpp:\n" + main + "\nbinSeachTree.cpp:\n"+ binSearchTree, lang: "cpp")
== Laufzeitanalyse beim Löschen
#codly(enabled:true, number-format: none)
```cpp
...
void binSearchTree::node::swapNextInorder() {             //O(log n)
    node* tmp  = this->right;                             //O(1)
    node* prev = this;                                    //O(1)
    while (tmp->left != nullptr) {                        //O(2 log n) = O(log n)
        prev = tmp;                                         //O(1)
        tmp = tmp->left;                                    //O(1)
    }

    this->val = tmp->val;                                 //O(1)
    if (prev == this)                                     //O(1)
        prev->right = tmp->right;                         //O(1)
    else                                                  //O(1)
        prev->left = tmp->right;                          //O(1)
    delete tmp;                                           //O(1)
}
...

void binSearchTree::node::remove(int a, node &prev) {     //O(2 log n) = O(log n)
    if (val == a) {                                       //O(1)                    
        if (left == nullptr && right == nullptr) {        //O(1)
            if (prev.left->val == a)                      //O(1) 
                prev.left = nullptr;                      //O(1)
            else 
                prev.right = nullptr;                     //O(1) 
            delete this;                                  //O(1)
        } else if (left != nullptr && right != nullptr) { //O(1)
            this->swapNextInorder();                      //O(log n)
        } else {
            node *tmp;                                    //O(1)
            if (left == nullptr) {                        //O(1)
                tmp = right;                              //O(1)              
            } else {
                tmp = left;                               //O(1) 
            }

            if (prev.left->val == a)                      //O(1)
                prev.left = tmp;                          //O(1)
            else 
                prev.right = tmp;                         //O(1)
            delete this;                                  //O(1)
        }
    } else if (val > a) {                                 //O(1)
        if (left != nullptr)                              //O(1)
            left->remove(a, *this);                       //WC: O(2 log n) = O(log n)
    } else if (val < a) {
        if (right != nullptr)
            right->remove(a, *this);                      //WC: O(log n)
    }
}
...
void binSearchTree::remove(int a) {                       // O(log(n))
    if (root == nullptr) 
        return;
    if (root->val == a) {
        root->swapNextInorder();
    } else {
        if (a > root->val) 
            root->right->remove(a, *root);
        else 
            root->left->remove(a, *root);
    }
}
```

= Aufgabe 2
#codly(enabled:true, number-format: none)
```cpp
void binSearchTree::node::descendInPreOrder(int *inorder, int *preorder, int inStart, int inEnd, int &index) {
    if (index > inEnd)
        return;
    char restAmount = inEnd - inStart + 1;
    if (restAmount == 1) {
        if (val > preorder[index])
            left = new node(index);
        else 
            right = new node(index);
        index++;
        return;
    }  

    int posCurrentElement = inStart;
    for (; inorder[posCurrentElement] != val && posCurrentElement <= inEnd; posCurrentElement++);

    if (preorder[index] < val)
        left  = new node(preorder[index++]);
        left->descendInPreOrder(inorder, preorder, inStart, posCurrentElement-1, index);

    if (preorder[index] > val)
        right = new node(preorder[index++]);
        right->descendInPreOrder(inorder, preorder, posCurrentElement+1, inEnd, index);
}

void binSearchTree::fromInAndPreOrder(int *inorder, int *preorder, unsigned maxIndex) {
    root = new node(preorder[0]);
    int index = 1;
    root->descendInPreOrder(inorder, preorder, 0, maxIndex, index);
}

binSearchTree createTree(int *inorder, int *preorder, unsigned int amount) {
    binSearchTree res; 
    if (inorder == nullptr || preorder == nullptr || amount == 0)
        return res;

    res.fromInAndPreOrder(inorder, preorder, amount - 1);
    return res;
}

```

= Aufgabe 3
Füge zuerst [5,6,9,12,13,3,8,10,11,16,15,14,4,2,1] in dieser Reihenfolge in einen AVL-Baum ein dann entferne [13,8,5,4,3,6,15,14] in dieser Reihenfolge
- Einfügen:
  #stack(
    dir: ltr,
    stack(
      v(26pt),
      bin-tree()[
        - 5
      ]
    ),
    [
      #v(30pt)
      $=>_6$
    ],
    stack(
      v(10pt),
      bin-tree()[
        - 6
          - 5
      ]
    ),
    [
      #v(30pt)
      $=>_9$
    ],
    stack(
      v(10pt),
      bin-tree()[
        - 6
          - 5
          - 9
      ]
    ),
    [
      #v(30pt)
      $=>_12$
    ],
    stack(
      v(10pt),
      bin-tree()[
        - 6
          - 5
          - 9
            - 12
      ]
    ),
    [
      #v(30pt)
      $=>_13$
    ],
    stack(
      v(10pt),
      bin-tree()[
        - 6
          - 5
          - 12
            - 9
            - 13
      ]
    ),
    [
      #v(30pt)
      $=>_3$
    ],
    stack(
      v(10pt),
      bin-tree()[
        - 6
          - 5
            - 3
          - 12
            - 9
            - 13
      ]
    ),
    [
      #v(30pt)
      $=>_8$
    ],
    stack(
      v(10pt),
      bin-tree()[
        - 6
          - 5
            - 3
          - 12
            - 9
              - 8
            - 13
      ]
    ),
    [
      #v(30pt)
      $=>_10$
    ],
    stack(
      v(10pt),
      bin-tree()[
        - 6
          - 5
            - 3
          - 12
            - 9
              - 8
              - 10
            - 13
      ]
    ),
    [
      #v(30pt)
      $=>_11$
    ],
  )
  #stack(
    dir: ltr,
    stack(
      v(10pt),
      bin-tree()[
        - 6
          - 5
            - 3
          - 12
            - 9
              - 8
              - 10
                - 11
            - 13
      ],
      v(5pt),
      align(center)[invalid]
    ),
    [
        #v(60pt)
      $=>$
    ],
    stack(
      v(10pt),
      bin-tree()[
        - 6
          - 5
            - 3
          - 12
            - 10
              - 9
                - 8
              - 11
            - 13
      ],
      v(5pt),
      align(center)[invalid]
    ),
    [
      #v(60pt)
      $=>$
    ],
    stack(
      v(10pt),
      bin-tree()[
        - 6
          - 5
            - 3
          - 10
            - 9
              - 8
            - 12
              - 11
              - 13

      ],
    ),
    [
      #v(60pt)
      $=>_16$
    ],
    h(5pt),
    stack(
      v(10pt),
      bin-tree()[
        - 6
          - 5
            - 3
          - 10
            - 9
              - 8
            - 12
              - 11
              - 13
                - 16

      ],
      v(5pt),
      align(center)[invalid]
    ),
    [
      #v(60pt)
      $=>$
    ],
    h(5pt),
    stack(
      v(10pt),
      bin-tree()[
        - 10
          - 6
            - 5
              - 3
            - 9
              - 8
          - 12 
            - 11
            - 13
              - 16
      ],
    ),
    [
      #v(60pt)
      $=>_15$
    ],
  )
  #stack(
    dir: ltr,
    stack(
      v(10pt),
      bin-tree()[
        - 10
          - 6
            - 5
              - 3
            - 9
              - 8
          - 12 
            - 11
            - 13
              - 16
                - 15
      ],
      v(5pt),
      align(center)[invalid]
    ),
    [
      #v(60pt)
      $=>$
    ],
    stack(
      v(10pt),
      bin-tree()[
        - 10
          - 6
            - 5
              - 3
            - 9
              - 8
          - 12 
            - 11
            - 13
              - 15
                - 16
      ],
      v(5pt),
      align(center)[invalid]
    ),
    [
      #v(60pt)
      $=>$
    ],
    stack(
      v(10pt),
      bin-tree()[
        - 10
          - 6
            - 5
              - 3
            - 9
              - 8
          - 12 
            - 11
            - 15
              - 13
              - 16
      ],
    ),
    [
      #v(60pt)
      $=>_14$
    ],
    stack(
      v(10pt),
      bin-tree()[
        - 10
          - 6
            - 5
              - 3
            - 9
              - 8
          - 12 
            - 11
            - 15
              - 13
                - 14
              - 16
      ],
      v(5pt),
      align(center)[invalid]
    ),
    [
      #v(60pt)
      $=>$
    ],
  )
  #stack(
    dir: ltr,
    stack(
      v(10pt),
      bin-tree()[
        - 10
          - 6
            - 5
              - 3
            - 9
              - 8
          - 12 
            - 11
            - 13
              - 14
              - 15
                - 16  
      ],
      v(5pt),
      align(center)[invalid]
    ),
    [
      #v(60pt)
      $=>$
    ],
    stack(
      v(10pt),
      bin-tree()[
        - 10
          - 6
            - 5
              - 3
            - 9
              - 8
          - 13 
            - 12
              - 11
              - 14
            - 15
              - 16  
      ],
    ),
    [
      #v(60pt)
      $=>_4$
    ],
    stack(
      v(10pt),
      bin-tree()[
        - 10
          - 6
            - 5
              - 3
                - 4
            - 9
              - 8
          - 13 
            - 12
              - 11
              - 14
            - 15
              - 16  
      ],
      v(5pt),
      align(center)[invalid]
    ),
    [
      #v(60pt)
      $=>$
    ],
    stack(
      v(10pt),
      bin-tree()[
        - 10
          - 6
            - 3
              - 4
              - 5
            - 9
              - 8
          - 13 
            - 12
              - 11
              - 14
            - 15
              - 16  
      ],
    ),
    [
      #v(60pt)
      $=>_2$
    ],
  )
  #stack(
    dir: ltr,
    stack(
      v(10pt),
      bin-tree()[
        - 10
          - 6
            - 3
              - 4
                - 2
              - 5
            - 9
              - 8
          - 13 
            - 12
              - 11
              - 14
            - 15
              - 16  
      ],
    ),
    [
      #v(60pt)
      $=>_1$
    ],
    stack(
      v(10pt),
      bin-tree()[
        - 10
          - 6
            - 3
              - 4
                - 2
                  - 1
              - 5
            - 9
              - 8
          - 13 
            - 12
              - 11
              - 14
            - 15
              - 16  
      ],
      v(5pt),
      align(center)[invalid]
    ),
    [
      #v(60pt)
      $=>$
    ],
    stack(
      v(10pt),
      bin-tree()[
        - 10
          - 6
            - 3
              - 2
                - 1
                - 4
              - 5
            - 9
              - 8
          - 13 
            - 12
              - 11
              - 14
            - 15
              - 16  
      ],
    )
  )
- Entfernen:
  #stack(
    dir: ltr,
    stack(
      v(10pt),
      bin-tree()[
        - 10
          - 6
            - 3
              - 2
                - 1
                - 4
              - 5
            - 9
              - 8
          - 13 
            - 12
              - 11
              - 14
            - 15
              - 16  
      ],
    ),
    [
      #v(60pt)
      $=>_13$
    ],
    stack(
      v(10pt),
      bin-tree()[
        - 10
          - 6
            - 3
              - 2
                - 1
                - 4
              - 5
            - 9
              - 8
          - 15
            - 12
              - 11
              - 14
            - 16
      ],
    ),
    [
      #v(60pt)
      $=>_8$
    ],
    stack(
      v(10pt),
      bin-tree()[
        - 10
          - 3
            - 2
              - 1
              - 4
            - 6
              - 5
              - 9
          - 15
            - 12
              - 11
              - 14
            - 16
      ],
    ),
    [
      #v(60pt)
      $=>_5$
    ],
  )
  #stack(
    dir: ltr,
    stack(
      v(10pt),
      bin-tree()[
        - 10
          - 3
            - 2
              - 1
              - 4
            - 6
              - 9
          - 15
            - 12
              - 11
              - 14
            - 16
      ],
    ),
    [
      #v(60pt)
      $=>_4$
    ],
    stack(
      v(10pt),
      bin-tree()[
        - 10
          - 3
            - 2
              - 1
            - 6
              - 9
          - 15
            - 12
              - 11
              - 14
            - 16
      ],
    ),
    [
      #v(60pt)
      $=>_3$
    ],
    stack(
      v(10pt),
      bin-tree()[
        - 10
          - 6
            - 2
              - 1
            - 9
          - 15
            - 12
              - 11
              - 14
            - 16
      ],
    ),
    [
      #v(60pt)
      $=>_6$
    ],
    stack(
      v(10pt),
      bin-tree()[
        - 10
          - 9
            - 2
              - 1
          - 15
            - 12
              - 11
              - 14
            - 16
      ],
      v(5pt),
      align(center)[invalid]
    ),
    [
      #v(60pt)
      $=>$
    ],
  )
  #stack(
    dir: ltr,
    stack(
      v(10pt),
      bin-tree()[
        - 10
          - 2
            - 1
            - 9
          - 15
            - 12
              - 11
              - 14
            - 16
      ],
    ),
    [
      #v(60pt)
      $=>_15$
    ],
    stack(
      v(10pt),
      bin-tree()[
        - 10
          - 2
            - 1
            - 9
          - 16
            - 12
              - 11
              - 14
      ],
      v(5pt),
      align(center)[invalid]
    ),
    [
      #v(60pt)
      $=>$
    ],
    stack(
      v(10pt),
      bin-tree()[
        - 10
          - 2
            - 1
            - 9
          - 16
            - 14
              - 12
                - 11
      ],
      v(5pt),
      align(center)[invalid]
    ),
    [
      #v(60pt)
      $=>$
    ],
    stack(
      v(10pt),
      bin-tree()[
        - 10
          - 2
            - 1
            - 9
          - 14
            - 12
              - 11
            - 16
      ],
    ),
    [
      #v(60pt)
      $=>_14$
    ],
    stack(
      v(10pt),
      bin-tree()[
        - 10
          - 2
            - 1
            - 9
          - 16
            - 12
              - 11
      ],
      v(5pt),
      align(center)[invalid]
    ),
    [
      #v(60pt)
      $=>$
    ],
  )
  #stack(
    dir: ltr,
    stack(
      v(10pt),
      bin-tree()[
        - 10
          - 2
            - 1
            - 9
          - 12
            - 11
            - 16
      ],
    )
  )

= Aufgabe 4
#bin-tree()[
  - $dot$
    - $dot$
      - $dot$
        - $dot$
      - $dot$
        - $dot$
        - $dot$
          - $dot$
    - $dot$
      - $dot$
        - $dot$
        - $dot$
          - $dot$
      - $dot$
        - $dot$
          - $dot$
        - $dot$
          - $dot$
          - $dot$
            - $dot$
]\
Ein minimaler AVL-Baum der Höhe h setzt sich zusammen aus minimal AVL-Bäumen der Höhe h-1 und Höhe h-2 und dem Root Knoten. Also sei $A_min (h)$ die MinimalAnzahl eines AVL-Baums der Höhe h, definiert durch: 
$
  A_min (0) = 1, A_min (1) = 2, A_min (h) = A_min (h-1) + A_min (h-2) + 1
$
An jedem inneren Knoten kann man linken und rechten Teilbaum strukturell tauschen.
$
  "#"_"Bäume" (h) = 2^("#"_"innere Knoten" (h))\
$
Die Anzahl der Blätter ist nach Rekursionsformel $A_min$:
$
    A_min (0) &= "#"_"Blätter" (0) = 1; A_min (1) = "#"_"innere Knoten" (1) + "#"_"Blätter" (1) = 1+1 = 2; \
    A_min (h) &= A_min (h-1) +  A_min (h-1) + 1\
              &= "#"_"innere Knoten" (h-1) + "#"_"Blätter" (h-1) + "#"_"innere Knoten" (h-2) + "#"_"Blätter" (h-2) + 1\
              &= ("#"_"innere Knoten" (h-1)+ "#"_"innere Knoten" (h-2) + 1) + ("#"_"Blätter" (h-1) + "#"_"Blätter" (h-2))\
              &= "#"_"innere Knoten" (h) + "#"_"Blätter" (h)
$
Also gilt $"#"_"Blätter" (h) = "#"_"Blätter" (h-1) + "#"_"Blätter" (h-2)$ mit $"#"_"Blätter" (0) = 1$ und $"#"_"Blätter" (1) = 1$\
und $"#"_"innere Knoten" (h) = "#"_"Knoten" (h-1) + "#"_"innere Knoten" (h-2) + 1$ mit $"#"_"innere Knoten" (0) = 0$ und $"#"_"innere Knoten" (1) = 1$

Für h = 5:
$
  "#"_"Bäume" (5) &= 2^("#"_"innere Knoten" (5)) = 2^("#"_"innere Knoten" (4) + "#"_"innere Knoten" (3) + 1)\
                  &= 2^("#"_"innere Knoten" (3) + "#"_"innere Knoten" (2) + 1 + "#"_"innere Knoten" (2) + "#"_"innere Knoten" (1) + 1 + 1)\
                  &= 2^("#"_"innere Knoten" (2) + "#"_"innere Knoten" (1) + 1 + "#"_"innere Knoten" (1) + "#"_"innere Knoten" (0) + 1 + "#"_"innere Knoten" (1) + "#"_"innere Knoten" (0) + 1 + 1 + 3)\
                  &= 2^("#"_"innere Knoten" (1) + "#"_"innere Knoten" (0) + 1 + 1 + 1 + 0 + 1 + 0 + 7) = 2^12\ 
$
#pagebreak()
auch möglich: 
$
  n(h) := "#"_"min AVL-Bäume mit Höhe h"\
  n(0) = 1\
  n(1) = 2\
  n(h) = 2 dot n(h-1) dot n(h-2)\
$

#pagebreak()
Algorithmus für alle minimalBäume
#codly(enabled:true, number-format: none)
```python
class node:
  def __init__(self, height):
    self.height = height
    self.left   = none
    self.right  = none
  def next_depth(self, height):
    if (height == 0):
      return
    if (height == 1):
      self.right = node(0)
      return
    self.right = node(height - 1)
    self.left  = node(height - 2)

    self.right.next_depth(height-1)
    self.left.next_depth(height-2)

  def swapPrinted(self, tree):
    print(tree)
    if (self.left == none && self.right == none): #case root node
      return

    self.if (self.left == none && self.right != none || self.left != none && self.right == none): #case only one child node
      tmp = self.right
      self.right = self.left
      self.left = tmp
      print(tree)
      return

    tmp = self.right
    self.right = self.left
    self.left = tmp;

    self.left.swapPrinted();
    self.right.swapPrinted();

class tree: 
  def __init__(self):
    root = none 
  def createMinimal(h):
    if root == none:
      root = node(h);
    if (h > 0):
      root.next_depth(h)
  def getAllMinimal(self):
    if (self.root != none)
      self.root.swapPrinted(self)
```

#pagebreak()
Zusatz:\
Sei $A_min (h)$ die Anzahl von Knoten in einem minimalen AVL-Baum der Höhe h\
Zu zeigen: für die Folge $A_min (h)$: 
$
  A_min (0) = 1, A_min (1) = 2, A_min (h) = A_min (h-1) + A_min (h-2) + 1
$
gilt 
$
  A_min (h) = "Fib"(h+2) - 1
$
- Induktions Anfang $h = 0 and h = 1$:
  $
    A_min (0) = 1 = 1 + 1 - 1 = "Fib"(0) + "Fib"(1) - 1 = "Fib"(2) - 1\
    A_min (1) = 2 = 1 + 2 - 1 = "Fib"(1) + "Fib"(2) - 1 = "Fib"(3) - 1
  $ 
- Induktions Annahme: Es gibt ein h-1 und h-2 für das die Aussage gilt
- Induktions Behauptung: für die h-1 und h-2 gilt die Aussage auch für h
- Induktions Schritt: $h-1 and h-2 -> h$ 
  $
    A_min (h) = A_min (h-1) + A_min (h-2) + 1 =_"IA" F(h+1) - 1 + F(h) - 1 + 1\
    => A_min (h) = "Fib" (h+2) - 1
  $
