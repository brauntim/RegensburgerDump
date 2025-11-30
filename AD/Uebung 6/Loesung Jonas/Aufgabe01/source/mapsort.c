#include "swap.h"

void mapsort (int list [], const int SIZE_OF_LIST, const int LOWEST_VALUE, const int HIGHEST_VALUE) {
  const int SIZE_OF_TEMPORARY_LIST = SIZE_OF_LIST * 1.5;
  int temporary_list [SIZE_OF_TEMPORARY_LIST];
  const float RANGE_OF_VALUES = HIGHEST_VALUE - LOWEST_VALUE;
  float positionInRange_in_percentage;
  int estimatedPosition_in_list, value;

  for (int i = 0; i < SIZE_OF_TEMPORARY_LIST; i++) {
    temporary_list[i] = -1;
  }

  for (int current_position = 0; current_position < SIZE_OF_LIST; current_position += 1) {
    value = list[current_position];
    positionInRange_in_percentage = (value - LOWEST_VALUE) / RANGE_OF_VALUES;
    estimatedPosition_in_list = SIZE_OF_TEMPORARY_LIST * positionInRange_in_percentage;

    while (temporary_list[estimatedPosition_in_list] != -1) {
      if (temporary_list[estimatedPosition_in_list] < value) {
        swap(&value, &temporary_list[estimatedPosition_in_list]);

      }

      if (estimatedPosition_in_list > 0) {
        estimatedPosition_in_list -= 1;

      } else {
        break;
      }
    }

    while (temporary_list[estimatedPosition_in_list] != -1) {
      if (temporary_list[estimatedPosition_in_list] > value) {
        swap(&value, &temporary_list[estimatedPosition_in_list]);

      }

      if (estimatedPosition_in_list <= SIZE_OF_TEMPORARY_LIST) {
        estimatedPosition_in_list += 1;

      }
      else {
        break;
      }
    }

    temporary_list[estimatedPosition_in_list] = value;

  }

  for (int i = 0, j = 0; i < SIZE_OF_TEMPORARY_LIST; i++) {
    if (temporary_list[i] != -1) {
      list[j] = temporary_list[i];
      j++;
    }
  }

  return;
}
