#include <stdio.h>

int rekursiv (int n, int m) {
  int result;

  if (n == 0) {
    result = m + 1;

  }
  else {
    if (m == 0) {
      result = rekursiv(n - 1, 1);

    }
    else {
      result = rekursiv(
        n - 1,
        rekursiv(n, m - 1)
      );
    }
  }

  return result;
}

int iterativ(int n, int m) {
  int stack[10000];
  int sp, result = 0;

  while (1) {
    if (n == 0) {
      m += 1;

      if (sp == 0) {
        result = m;
        break;
      }

      sp--;
      n = stack[sp];
    }
    else if (m == 0) {
      n = n - 1;
      m = 1;
    }
    else {
      stack[sp] = n - 1;
      sp++;
      m -= 1;
    }
  }

  return result;
}

void print_rekursiv(int n, int m) {
  int result = rekursiv(n, m);

  printf("f(%i, %i) = %i\n", n, m, result);

  return;
}

void print_iterativ(int n, int m) {
  int result = iterativ(n, m);

  printf("f(%i, %i) = %i\n", n, m, result);

  return;
}

int main () {
  print_rekursiv(0, 0);
  print_rekursiv(1, 0);
  print_rekursiv(0, 1);
  print_rekursiv(1, 1);
  print_rekursiv(2, 3);

  print_iterativ(0, 0);
  print_iterativ(1, 0);
  print_iterativ(0, 1);
  print_iterativ(1, 1);
  print_iterativ(2, 3);

  return 0;
}
