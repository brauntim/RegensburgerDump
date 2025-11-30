#include <time.h>
#include <stdlib.h>

void fillList (int list [], int size_of_list);
void insertionSort (int list [], int size_of_list);
void mergeSort (int list [], int size_of_list);

int main () {
  srand(time(NULL));

  int size_of_list = 15;
  int list [size_of_list];
  fillList(list, size_of_list);

  mergeSort(list, size_of_list);

  return 0;
}

void fillList (int list [], int size_of_list) {
  for (int current_sublist_size = 0; current_sublist_size < size_of_list; current_sublist_size+=1) {
    list[current_sublist_size] = rand() % 10;
  }
}

void insertionSort (int list [], int size_of_list) {
  if (size_of_list > 1) {
    insertionSort(list+1, size_of_list-1);

    int key = list[0];
    int current_sublist_size;

    for (current_sublist_size = 1; current_sublist_size < size_of_list && list[current_sublist_size] < key; current_sublist_size+=1) {
      list[current_sublist_size-1] = list[current_sublist_size];
    }

    list[current_sublist_size-1] = key;
  }
}

void mergeSort (int list [], int size_of_list) {
  int temporary_list [size_of_list];
  int middle_increase;
  int current_sublist_size = 1;

  while (current_sublist_size <= size_of_list) {
    current_sublist_size *= 2;

    int sublists = size_of_list / current_sublist_size;
    if (size_of_list % current_sublist_size != 0) {
      sublists += 1;
    }

    middle_increase = current_sublist_size / 2;

    for (int nr_of_currentSublist = 0; nr_of_currentSublist < sublists; nr_of_currentSublist+=1) {
      int start_of_currentSublist = nr_of_currentSublist * current_sublist_size;

      int end_of_currentSublist = start_of_currentSublist + current_sublist_size;
      if (end_of_currentSublist > size_of_list) {
        end_of_currentSublist = size_of_list;
      }

      int first = start_of_currentSublist;
      int middle = first + middle_increase;
      int second = middle;

      for (int position_in_currentSublist = start_of_currentSublist; position_in_currentSublist < end_of_currentSublist; position_in_currentSublist+=1) {
        if (first < middle) {
          if (second < end_of_currentSublist) {
            if (list[first] <= list[second]) {
              temporary_list[position_in_currentSublist] = list[first];
              first += 1;
            } else {
              temporary_list[position_in_currentSublist] = list[second];
              second += 1;
            }
          } else {
            temporary_list[position_in_currentSublist] = list[first];
            first += 1;
          }
        } else {
          temporary_list[position_in_currentSublist] = list[second];
          second += 1;
        }
      }

      for (int current = start_of_currentSublist; current < end_of_currentSublist; current+=1) {
        list[current] = temporary_list[current];
      }

    }
  }
}
