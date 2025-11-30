#include <time.h>
#include <stdlib.h>

#include "sortierAlgorithmen.h"

void fillList(int [], int);

int main () {
  const int SIZE_OF_LIST = 5;

  int list [SIZE_OF_LIST];
  fillList(list, SIZE_OF_LIST);

  quickSort(list, SIZE_OF_LIST);

  return 0;
}

void fillList(int list[], int size_of_list) {
  srand(time(NULL));

  for (int i = 0; i < size_of_list; i++) {
    list[i] = rand() % 10;
  }
}

