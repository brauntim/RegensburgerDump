#include <stdlib.h>
#include <time.h>
#include <string.h>

#include "countsort.h"
#include "heapsort.h"
#include "mapsort.h"

void fillList (int list [], const int SIZE_OF_LIST, const int LOWEST_VALUE, const int HIGHTEST_VALUE);
void swap (int * first, int * second);

int main () {
  const int SIZE_OF_LIST = 1000000;
  const int LOWEST_VALUE = 1000;
  const int HIGHTEST_VALUE = 10000;

  int list [SIZE_OF_LIST];
  fillList(list, SIZE_OF_LIST, LOWEST_VALUE, HIGHTEST_VALUE);

  int templist [SIZE_OF_LIST];
  
  memcpy(templist, list, SIZE_OF_LIST * sizeof(int));
  countSort(templist, SIZE_OF_LIST, HIGHTEST_VALUE);

  memcpy(templist, list, SIZE_OF_LIST * sizeof(int));
  heapSort(templist, SIZE_OF_LIST);

  memcpy(templist, list, SIZE_OF_LIST * sizeof(int));
  mapsort(list, SIZE_OF_LIST, LOWEST_VALUE, HIGHTEST_VALUE);

  return 0;
}

void fillList (int list [], const int SIZE_OF_LIST, const int LOWEST_VALUE, const int HIGHTEST_VALUE) {
  srand(time(NULL));

  for (int i = 0; i < SIZE_OF_LIST; i += 1) {
    list[i] = LOWEST_VALUE + ( rand() % (HIGHTEST_VALUE - LOWEST_VALUE) );
  }
}

