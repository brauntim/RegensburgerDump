#include <stdlib.h>

int multiply (int * first, int * second, int * result, int SIZE_OF_DIMENSION);
int sum (int * first, int * second, int * result, int SIZE_OF_DIMENSION);
int fill(int * matrix, const int SIZE_OF_DIMENSION);

int main () {
  const int SIZE_OF_DIMENSION = 4;
  const int ELEMENTS_IN_MATRIX = 16;
  
  int first [ELEMENTS_IN_MATRIX];
  fill(first, SIZE_OF_DIMENSION);

  int second [ELEMENTS_IN_MATRIX];
  fill(second, SIZE_OF_DIMENSION);

  int result [ELEMENTS_IN_MATRIX];

  multiply(first, second, result, SIZE_OF_DIMENSION);

  return 0;
}

int multiply (int * first, int * second, int * result, int SIZE_OF_DIMENSION) {
  const int NEW_SIZE_OF_DIMENSION = SIZE_OF_DIMENSION / 2;
  const int ELEMENTS_IN_MATRIX = NEW_SIZE_OF_DIMENSION * NEW_SIZE_OF_DIMENSION;

  int * first11 = first;
  int * first12 = first + ELEMENTS_IN_MATRIX;
  int * first21 = first + (2 * ELEMENTS_IN_MATRIX);
  int * first22 = first + (3 * ELEMENTS_IN_MATRIX);

  int * second11 = second;
  int * second12 = second + ELEMENTS_IN_MATRIX;
  int * second21 = second + (2 * ELEMENTS_IN_MATRIX);
  int * second22 = second + (3 * ELEMENTS_IN_MATRIX);

  int * result11 = result;
  int * result12 = result + ELEMENTS_IN_MATRIX;
  int * result21 = result + (2 * ELEMENTS_IN_MATRIX);
  int * result22 = result + (3 * ELEMENTS_IN_MATRIX);

  if (SIZE_OF_DIMENSION == 2) {
    *result11 = *first11 * *second11 + *first12 * *second21;
    *result12 = *first11 * *second12 + *first12 * *second22;
    *result21 = *first21 * *second11 + *first22 * *second21;
    *result22 = *first21 * *second12 + *first22 * *second22;

  } else {
    int * temp = malloc(ELEMENTS_IN_MATRIX);

    multiply(first11, second11, temp, NEW_SIZE_OF_DIMENSION);
    multiply(first12, second21, result11, NEW_SIZE_OF_DIMENSION);
    sum(temp, result11, result11, NEW_SIZE_OF_DIMENSION);

    multiply(first11, second12, temp, NEW_SIZE_OF_DIMENSION);
    multiply(first12, second22, result12, NEW_SIZE_OF_DIMENSION);
    sum(temp, result12, result12, NEW_SIZE_OF_DIMENSION);

    multiply(first21, second11, temp, NEW_SIZE_OF_DIMENSION);
    multiply(first22, second21, result21, NEW_SIZE_OF_DIMENSION);
    sum(temp, result21, result21, NEW_SIZE_OF_DIMENSION);

    multiply(first21, second12, temp, NEW_SIZE_OF_DIMENSION);
    multiply(first22, second22, result22, NEW_SIZE_OF_DIMENSION);
    sum(temp, result22, result22, NEW_SIZE_OF_DIMENSION);

    free(temp);
  }

  return 0;
}

int sum (int * first, int * second, int * result, int SIZE_OF_DIMENSION) {
  const int ELEMENTS_IN_MATRIX = SIZE_OF_DIMENSION * SIZE_OF_DIMENSION;

  for (int i = 0; i < ELEMENTS_IN_MATRIX; i += 1) {
    *(result + i) = *(first + i) + *(second + i);
  }

  return 0;
}

int fill (int * matrix, int SIZE_OF_DIMENSION) {
  const int ELEMENTS_IN_MATRIX = SIZE_OF_DIMENSION * SIZE_OF_DIMENSION;

  for (int i = 0; i < ELEMENTS_IN_MATRIX; i += 1) {
    *(matrix + i) = rand() % 10;
  }

  return 0;
}
