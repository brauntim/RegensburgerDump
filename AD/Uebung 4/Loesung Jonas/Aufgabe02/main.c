#include <stdlib.h>
#include <time.h>
#include <stdio.h>

#include "../Aufgabe01/sortierAlgorithmen.h"

void fillList(int list [], int size_of_list);
int getAmountOfSortableNumbersInOneMinute(void (*sortfunction)(int [], int));

void mergeSort (int [], int);
void merge (int list [], int size_of_list, int middle);

int main () {
  srand(time(NULL));

  printf("\nTest sortieren mit quick Sort\n");
  getAmountOfSortableNumbersInOneMinute(&quickSort);

  printf("Test sortieren mit bubble Sort\n");
  getAmountOfSortableNumbersInOneMinute(&bubbleSort);

  printf("\nTest sortieren mit merge Sort\n");
  getAmountOfSortableNumbersInOneMinute(&mergeSort);

  return 0;
}

void mergeSort (int list [], int size_of_list) {
  if (size_of_list > 1) {
    int middle = size_of_list / 2;
    mergeSort(list, middle);
    mergeSort(list+middle, size_of_list-middle);
    merge(list, size_of_list, middle);
  }
}

void merge (int list [], int size_of_list, int middle) {
  int temporary_list [size_of_list];
  int left = 0;
  int right = middle;

  for (int current = 0; current < size_of_list; current+=1) {
    if (left < middle) {
      if (right < size_of_list) {
        if (list[left] <= list[right]) {
          temporary_list[current] = list[left];
          left+=1;
        }
        else {
          temporary_list[current] = list[right];
          right+=1;
        }
      } else {
        temporary_list[current] = list[left];
        left+=1;
      }
    } else {
      temporary_list[current] = list[right];
      right+=1;
    }
  }

  for (int current = 0; current < size_of_list; current+=1) {
    list[current] = temporary_list[current];
  }

  return;
}

int getAmountOfSortableNumbersInOneMinute(void (*sortfunction)(int [], int)) {
  int greater = 0, smaller = 0;
  double seconds = 0.0;
  time_t start, end;

  int size_of_list = 100000;

  while (seconds < 55 || seconds > 65) {
    if (greater != 0 && smaller != 0) {
      size_of_list = smaller + (
        (greater - smaller) / 2
      );
    } else {
      size_of_list = size_of_list + (size_of_list / 2);
    }

    int list [size_of_list];
    fillList(list, size_of_list);

    start = time(NULL);

    sortfunction(list, size_of_list); 

    end = time(NULL);
    seconds = difftime(end, start);

    printf("Sortierung von %i Zahlen in %f Sekunden\n", size_of_list, seconds);

    if (seconds > 65) {
      greater = size_of_list;
    }
    if (seconds < 55) {
      smaller = size_of_list;
    }
  }

  return size_of_list;
}

void fillList(int list[], int size_of_list) {
  int i;
  for (i = 0; i < size_of_list; i+=1) {
    list[i] = rand();
  }
}
