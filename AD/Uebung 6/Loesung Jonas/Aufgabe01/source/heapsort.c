#include "heapsort.h"
#include "swap.h"

#define FIRST 0

void heapify (int list [], int f, int l, int root);
void buildHeap (int list [], const int SIZE_OF_LIST);

void heapSort (int list [], const int SIZE_OF_LIST) {
  buildHeap(list, SIZE_OF_LIST);

  // For a valid heap, the largest number is in the first place
  for (int i = SIZE_OF_LIST-1; i>FIRST; i--) {
    // Swaps the largest number against the last one
    swap(& list[FIRST], & list[i]);
    // After this, the list is no longer a valid heap

    // So the heap needs to be rebuild, but with the last number being cut off as this one is sorted now
    heapify(list, FIRST, i-1, FIRST);
  }

  return;
}

void heapify (int list [], int f, int l, int root) {
  int largest;
  int left = (root*2) + 1;
  int right = (root*2) + 2;

  if (left <= l && list[left] > list[root]) {
    largest = left;
  } else {
    largest = root;
  }

  if (right <= l && list[right] > list[largest]) {
    largest = right;
  }

  if (largest != root) {
    swap(& list[root], & list[largest]);
    heapify(list, f, l, largest);
  }

  return;
}

void buildHeap (int list [], const int SIZE_OF_LIST) {
  for (int i = SIZE_OF_LIST / 2; i >= FIRST; i--) {
    heapify(list, FIRST, SIZE_OF_LIST - 1, i);
  }
}
