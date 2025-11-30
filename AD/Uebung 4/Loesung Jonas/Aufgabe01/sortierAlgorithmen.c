#include <stdlib.h>

#define and &&

void swap(int *, int *);

void swap(int *a, int *b) {
  int swap = *a;
  *a = *b;
  *b = swap;
}

void insertionSort(int list[], int size_of_list) {
  int i, j, key;

  for (j = size_of_list-2; j >= 0; j--) {
    key = list[j];
    i = j+1;

    while (i < size_of_list and list[i] < key) {
      list[i-1] = list[i];
      i = i+1;
    }

    list[i-1] = key;
  }
}

void bubbleSort(int list[], int size_of_list) {
  for (int last = size_of_list - 1; last  > 0; last--) {
    for (int current = 0; current < last ; current ++) {
      if (list[current] > list[current+1]) {
        int swap = list[current];
        list[current] = list[current+1];
        list[current+1] = swap;
      }
    }
  }
}

void selectionSort(int list[], int size_of_list) {
  for (int last = size_of_list-1; last > 0; last--) {
    int index_of_maximum = last;

    for (int current = 1; current <= last ; current++) {
      if (list[current] > list[index_of_maximum]) {
        index_of_maximum = current;
      }
    }

    if (index_of_maximum != last) {
      int swap = list[index_of_maximum];
      list[index_of_maximum] = list[last];
      list[last] = swap;
    }
  }
}

void quickSort(int list[], int size_of_list) {
  if (size_of_list > 1) {
    int initial_pivot_position = rand() % size_of_list;
    int pivot = list[initial_pivot_position];

    swap(&list[initial_pivot_position], &list[0]);
    int pivot_position = 0;

    for (int current = 1; current < size_of_list; current++) {
      if (list[current] <= pivot) {
        pivot_position++;
        swap(&list[current], &list[pivot_position]);
      }
    }

    swap(&list[0], &list[pivot_position]);

    quickSort(list, pivot_position);
    quickSort(
      list + pivot_position + 1, // Listenpointer nach Pivot Element
      size_of_list - pivot_position - 1 // Länge Liste rechts von Pivot Element
    );
  }
}

void sort(int list[], int size_of_list) {
  int first = 0;
  int last = size_of_list-1;

  int iMin, iMax, i, swap;

  while (first != last) {
    iMin = first;
    iMax = last;

    for (i = first; i <= last; i++) {
      if (list[i] < list[iMin]) {
        iMin = i;
      }
      if (list[i] > list[iMax]) {
        iMax = i;
      }
    }

    if (iMin != first) {
      swap = list[iMin];
      list[iMin] = list[first];
      list[first] = swap;
    }

    if (iMax != last) {
      swap = list[iMax];
      list[iMax] = list[last];
      list[last] = list[iMax];
    }

    first++;
    last--;
  }
}
