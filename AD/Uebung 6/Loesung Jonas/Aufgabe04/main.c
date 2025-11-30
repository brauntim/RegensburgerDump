#include <stdlib.h>
#include <time.h>

struct ValueAndWeight {
  int value;
  int weight;
};

struct ValueToWeightRatio {
  int position_in_initialList;
  float value_to_weight_ratio;
};

void fill_list (struct ValueAndWeight list [], const int SIZE_OF_LIST, const int MINIMUM_WEIGHT, const int MAXIMUM_WEIGHT, const int MINIMUM_VALUE, const int MAXIMUM_VALUE);

void solve_with_mergeSort (struct ValueAndWeight list [], const int SIZE_OF_LIST, const int MAXIMUM_WEIGHT, float result []);
void mergeSort (struct ValueAndWeight list [], struct ValueToWeightRatio temporary_list [], const int LEFTMOST_POSITION, const int RIGHTMOST_POSITION);
void merge (struct ValueToWeightRatio list [], const int LEFTMOST_POSITION, const int RIGHTMOST_POSITION, const int MIDDLE);

int main () {
  const int SIZE_OF_LIST = 10;
  
  struct ValueAndWeight list [SIZE_OF_LIST];
  fill_list(list, SIZE_OF_LIST, 1, 10, 1, 100);

  float result [SIZE_OF_LIST];

  solve_with_mergeSort(list, SIZE_OF_LIST, 20, result);

  return 0;
}

void fill_list (struct ValueAndWeight list [], const int SIZE_OF_LIST, const int MINIMUM_WEIGHT, const int MAXIMUM_WEIGHT, const int MINIMUM_VALUE, const int MAXIMUM_VALUE) {
  srand(time(NULL));

  for (int i = 0; i < SIZE_OF_LIST; i++) {
    list[i].value = MINIMUM_VALUE + ( rand() % (MAXIMUM_VALUE - MINIMUM_VALUE) );
    list[i].weight = MINIMUM_WEIGHT + ( rand() % (MAXIMUM_WEIGHT - MINIMUM_WEIGHT) );

  }
}

void solve_with_mergeSort (struct ValueAndWeight list [], const int SIZE_OF_LIST, const int MAXIMUM_WEIGHT, float result []) {
  struct ValueToWeightRatio valueToWeightRatio_list [SIZE_OF_LIST];
  int current_weight = 0;

  mergeSort(list, valueToWeightRatio_list, 0, SIZE_OF_LIST-1);

  for (int current_position = 0; current_position < SIZE_OF_LIST; current_position += 1) {
    int position_in_initialList = valueToWeightRatio_list[current_position].position_in_initialList;

    if (current_weight == MAXIMUM_WEIGHT) {
      result[position_in_initialList] = 0;

    } else {
      if (current_weight + list[position_in_initialList].weight <= MAXIMUM_WEIGHT) {
        result[position_in_initialList] = 1;
        current_weight += list[position_in_initialList].weight;

      } else {
        result[position_in_initialList] = (float)(MAXIMUM_WEIGHT - current_weight) / list[position_in_initialList].weight;
        current_weight = MAXIMUM_WEIGHT;

      }
    }
  }

  return;
}

void mergeSort (struct ValueAndWeight list [], struct ValueToWeightRatio temporary_list [], const int LEFTMOST_POSITION, const int RIGHTMOST_POSITION) {
  if (LEFTMOST_POSITION == RIGHTMOST_POSITION) {
    temporary_list[LEFTMOST_POSITION].position_in_initialList = LEFTMOST_POSITION;
    temporary_list[LEFTMOST_POSITION].value_to_weight_ratio = (float)list[LEFTMOST_POSITION].value / list[LEFTMOST_POSITION].weight;

  } else {
    const int MIDLLE_POSITION = LEFTMOST_POSITION + ( (RIGHTMOST_POSITION - LEFTMOST_POSITION) / 2 );

    mergeSort(list, temporary_list, LEFTMOST_POSITION, MIDLLE_POSITION);
    mergeSort(list, temporary_list, MIDLLE_POSITION+1, RIGHTMOST_POSITION);

    merge(temporary_list, LEFTMOST_POSITION, RIGHTMOST_POSITION, MIDLLE_POSITION);

  }

  return;
}

void merge (struct ValueToWeightRatio list [], const int LEFTMOST_POSITION, const int RIGHTMOST_POSITION, const int MIDDLE) {
  const int SIZE_OF_LIST = RIGHTMOST_POSITION - LEFTMOST_POSITION + 1;
  struct ValueToWeightRatio temporary_list [SIZE_OF_LIST];
  const int TEMPORARY_MIDDLE = SIZE_OF_LIST / 2;

  for (int current_position = 0, left = LEFTMOST_POSITION, right = MIDDLE+1; current_position < SIZE_OF_LIST; current_position += 1) {
    if (left <= MIDDLE) {
      if (right <= RIGHTMOST_POSITION) {
        if (list[left].value_to_weight_ratio > list[right].value_to_weight_ratio) {
          temporary_list[current_position] = list[left];
          left += 1;

        } else {
          temporary_list[current_position] = list[right];
          right += 1;

        }
      } else {
        temporary_list[current_position] = list[left];
        left += 1;

      }
    } else {
      temporary_list[current_position] = list[right];
      right += 1;

    }
  }

  for (int current_position = 0; current_position < SIZE_OF_LIST; current_position += 1) {
    list[LEFTMOST_POSITION + current_position] = temporary_list[current_position];
  }

  return;
}
