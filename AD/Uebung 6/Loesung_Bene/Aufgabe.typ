#import "@preview/codly:1.3.0": *
#import "@preview/codly-languages:0.1.1": *
#show: codly-init.with()

= Aufgabe 1
  #let main = read("/implementation/A01/main.cpp");
  #let sort = read("/implementation/A01/sort.cpp");
  #codly(enabled:true, number-format: none)
  #raw(block: true, "main.cpp:\n" + main + "\nlinked_list.hpp:\n"+ sort, lang: "cpp")

= Aufgabe 2
  #let main = read("/implementation/A02/main.cpp");
  #let linked_list = read("/implementation/A02/linked_list.cpp");

  #codly(enabled:true, number-format: none)
  #raw(block: true, "main.cpp:\n" + main + "\nlinked_list.hpp:\n"+ linked_list, lang: "cpp")
  - Speicher (im Vergleich mit einem normalen C-Style Arrays): 
    + Verkette Liste: 
      - Speicher:
        - Speicher pro Node: $ "S"_"Node" ("NodeT") = 8 "Byte(Pointer)" + "sizeof(NodeT)"$
        - Speicher insgesamt bei n Elementen:\
          #v(1pt)
          $"S"_"ges" ("NodeT") = n "S"_"Node" ("NodeT") + 2 dot 8 "Byte(Head und Tail pointer)" + 4 "Byte(len)"\
          => "S"_"ges" in Theta(n)$
      - Laufzeit: 
        - Quicksort: \
          #v(1pt)
          $"T"_"QuickSort"^"BC" = n log n$\
          #v(1pt)
          $"T"_"QuickSort"^"AC" = n log n$\
          #v(1pt)
          $"T"_"QuickSort"^"WC" = n^2$\
        - Verkette Liste: Indexierung über Operator[] an i-ter Stelle\
          $"T"_"[]" (i)= i$\
          $=> "Pro PreparePartition addiert sich ein Faktor" lambda: sum_(i=f)^l i + 1 <= lambda <= 2sum_(i=f)^l i + 1$\
          $=> T(n) = 2 T(n/2) + n + lambda$
          
    + C-Style Arrays: 
      - Speicher: $"len"("Array") = n dot "sizeof"("type") => "S"_"ges" in Theta(n)$
      - Laufzeit: wie bei normalen QuickSort
          #v(1pt)
          $"T"_"QuickSort"^"BC" = n log n$\
          #v(1pt)
          $"T"_"QuickSort"^"AC" = n log n$\
          #v(1pt)
          $"T"_"QuickSort"^"WC" = n^2$\
#pagebreak()

= Aufgabe 3
  #let main      = read("implementation/A03/main.cpp")
  #let ring_list = read("implementation/A03/ring_list.cpp")
  #codly(enabled:true, number-format: none)
  #raw(block: true, "main.cpp:\n" + main + "\nlinked_list.hpp:\n"+ ring_list, lang: "cpp")
#pagebreak()

= Aufgabe 4
  #codly(enabled:true, number-format: none)

  ```python
    RucksackProblem
    calcBackpack(objects[n], maxWeight):  # Theta(n) + Theta(n log n) + Theta(n) => calcBackpack = Theta(n log n)
      ratios = []
      for i, o in enumerate(objects):     #Theta(n)
        ratios.push((o.val/o.weight, i))  
      ratios.sort()                       #Theta(n log n)

      res = (0,0)
      last = none
      addedObj = []

      for r in ratios:                    #Theta(n)
        if (res[1] >= weight):
          break;
        res[0] += r[0].val
        res[1] += r[0].weight
        addedObj.push(objects[r[1]])

      if res[1] =< weight:
        return (res, addedObj);

      res[0] -= addedObj.last().val
      res[1] -= addedObj.last().weight

      restToMaxWeight = maxWeight - res[1]
      factor = restToMaxWeight/addedObj.last().weight
      res[0] += factor * addedObj.last().val
      res[1] += factor * addedObj.last().weight

      return (res, addedObj)

  ```
  Teil 2: \
  $
    M = 21, [(v = 10, w = 2), b = (v=50, w=20)]\
    => "ratio"_a = 10/2 = 5, "ratio"_b = 50/20 = 2.5 => "nach sortieren" \
    => ["ratio"_a, "ratio"_b] => "nach algorithmus mit " a_i in {0,1} " res"_v = 10 
  $
  Das ist nicht das Optimum. Daraus folgt, dass der Algorithmus bei $a_i in {0,1}$ sehr schlecht werden kann.
