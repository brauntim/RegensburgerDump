#include <stdlib.h>
#include <time.h>

struct RingListElement {
  int value;
  struct RingListElement * nextElement;
};

struct RingListElement * get_new ();
void free_ringList_by_element (struct RingListElement * element);
struct RingListElement * get_ringListElement_from_ringListElement_by_distance (struct RingListElement * start, int distance);

int main () {
  struct RingListElement * current = get_new();

  srand(time(NULL));
  const int SIZE_OF_LIST = 6;
  int list [SIZE_OF_LIST];

  for (int i = 0; i < SIZE_OF_LIST; i+=1) {
    int distance = 1 + (rand() % 48);
    
    current = get_ringListElement_from_ringListElement_by_distance(current, distance);
    list[i] = current->value;
  }

  free_ringList_by_element(current);

  return 0;
}

struct RingListElement * get_ringListElement_from_ringListElement_by_distance (struct RingListElement * start, int distance) {
  if (distance == 0) {
    return start;
  }
  else {
    return get_ringListElement_from_ringListElement_by_distance(start->nextElement, distance - 1);
  }
}

struct RingListElement * get_new () {
  const int SIZE_OF_LIST = 49;

  struct RingListElement * result = malloc(sizeof(struct RingListElement));
  result->value = 1;

  struct RingListElement * current = result;
  for (int i = 2; i <= SIZE_OF_LIST; i+=1) {
    current->nextElement = malloc(sizeof(struct RingListElement));
    current = current->nextElement;
    current->value = i;
  }

  current->nextElement = result;

  return result;
}

void free_ringList_by_element (struct RingListElement * element) {
  struct RingListElement * current = element, * next;

  do {
    next = current->nextElement;
    free(current);
    current = next;
  } while (next != element);
}
