#include <stdlib.h>
#include <time.h>
#include <stdio.h>

void fill_list(int list [], int size_of_list);
void print_list(int list [], int size_of_list);

void test_algorithm(int list [], int size_of_list, int sum);
int algorithm(int list [], int size_of_list, int sum);

int main () {
  srand(time(NULL));

  int size_of_list = 5;
  int list [size_of_list];
  fill_list(list, size_of_list);
  int sum = rand() % 18;

  test_algorithm(list, size_of_list, sum);

  return 0;
}

void fill_list(int list [], int size_of_list) {
  for (int i = 0; i < size_of_list; i+=1) {
    list[i] = rand() % 10;
  }
}

void print_list(int list [], int size_of_list) {
  for (int i = 0; i < size_of_list-1; i+=1) {
    printf("%i, ", list[i]);
  }
  printf("%i", list[size_of_list-1]);
}

void test_algorithm(int list [], int size_of_list, int sum) {
  int result = algorithm(list, size_of_list, sum);

  printf("Test mit Summe: %i, Liste: ", sum);
  print_list(list, size_of_list);
  printf(" ergibt sich: %i", result);
}

int algorithm(int list [], int size_of_list, int sum) {
  int position01, position02;

  for (position01 = 0; position01 < size_of_list; position01 += 1) {
    for (position02 = position01; position02 < size_of_list; position02 += 1) {
      if (list[position01] + list[position02] == sum) {
        return 1;
      }
    }
  }

  return 0;
}
