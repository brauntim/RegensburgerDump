#include <time.h>
#include <stddef.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define and &&
#define or ||

struct Matrix {
  int n;
  int m;
  int * content;
};

void Matrix_inputValues(struct Matrix * matrix);

struct Matrix * Matrix_init(int n, int m) {
  struct Matrix * result = (struct Matrix*)malloc(sizeof(struct Matrix));

  result->n = n;
  result->m = m;

  int * ptr = (int*)calloc(n*m, sizeof(int));
  result->content = ptr;

  return result;
}

void Matrix_setValue(struct Matrix * matrix, int n, int m, int value) {
  matrix->content[(n * matrix->m) + m] = value;
}

int Matrix_getValue(struct Matrix * matrix, int n, int m) {
  return matrix->content[(n * matrix->m) + m];
}

struct Matrix * Matrix_input() {
  int n, m;
  printf("Größe angeben: (nxm)\n");
  scanf("%ix%i", &n, &m);
  getc(stdin);

  struct Matrix * result = Matrix_init(n, m);

  Matrix_inputValues(result); 

  return result;
}

void Matrix_inputValues(struct Matrix * matrix) {
  size_t buffer_size = 0;
  char * line = NULL;

  for (int n = 0; n < matrix->n; n+=1) {
    printf("%i. Zeile angeben (%i Komma-separierte ganzzahlen):\n", n+1, matrix->m);
    getline(&line, &buffer_size, stdin);
    char * search = line;

    for (int m = 0; m < matrix->m; m+=1) {
      char * found = strchr(search, ',');

      if (!found) {
        found = strchr(search, '\n');
      }

      if (found) {
        int lengthOfValue_in_line = found - search;

        char * value_as_string = malloc(lengthOfValue_in_line);
        memcpy(value_as_string, search, lengthOfValue_in_line);
        int value = atoi(value_as_string);

        Matrix_setValue(matrix, n, m, value);

        free(value_as_string);

        search = found + 1;
      } else {
        break;
      }
    }
  }
}

void Matrix_randomFill(struct Matrix * matrix) {
  for (int n = 0; n < matrix->n; n+=1) {
    for (int m = 0; m < matrix->m; m+=1) {
      int value = rand();
      value = value % 10;
      Matrix_setValue(matrix, n, m, value);
    }
  }
}

void Matrix_print(struct Matrix * matrix) {
  printf("%ix%i Matrix:\n" ,matrix->n , matrix->m);

  for (int n = 0; n < matrix->n; n += 1) {
    for (int m = 0; m < matrix->m; m += 1) {
      int current_number = Matrix_getValue(matrix, n, m);
      printf("%i,", current_number);
    }
    printf("\n");
  }
}

void Matrix_free(struct Matrix * matrix) {
  free(matrix->content);
  free(matrix);
}

struct Matrix * Matrix_add(struct Matrix * matrix1, struct Matrix * matrix2) {
  if (matrix1->n != matrix2->n or matrix1->m != matrix2->m) {
    return NULL;
  }

  struct Matrix * result = Matrix_init(matrix1->n, matrix1->m);

  for (int n = 0; n < result->n; n+=1) {
    for (int m = 0; m < result->m; m+=1) {
      int newValue = Matrix_getValue(matrix1, n, m) + Matrix_getValue(matrix2, n, m);

      Matrix_setValue(result, n, m, newValue);
    }
  }

  return result;
}

struct Matrix * Matrix_multiply(struct Matrix * matrix1, struct Matrix * matrix2) {

  if (matrix1->m != matrix2->n) {
    return NULL;
  }

  struct Matrix * result = Matrix_init(matrix1->n, matrix2->m);

  for (int zeilenMatrix1 = 0; zeilenMatrix1 < matrix1->n; zeilenMatrix1 += 1) {
    for (int spaltenMatrix2 = 0; spaltenMatrix2 < matrix2->m; spaltenMatrix2 += 1) {
      unsigned long int newValue = 0;

      for (int nr = 0; nr < matrix1->m; nr += 1) {
        int wertMatrix1 = Matrix_getValue(matrix1, zeilenMatrix1, nr);
        int wertMatrix2 = Matrix_getValue(matrix2, nr, spaltenMatrix2);
        newValue += (wertMatrix1 * wertMatrix2);

      }

      Matrix_setValue(
        result, zeilenMatrix1, spaltenMatrix2, newValue
      );
    }
  }

  return result;
}

void test_addition(double zielzeit_s) {
  clock_t start, end;
  double dauer_s;
  int n = 2;
  int m = 2;

  printf("Test der Addition:\n");

  do {
    printf("Addition %ix%i Matrix\n", n, m);

    struct Matrix * matrix1 = Matrix_init(n, m);
    Matrix_randomFill(matrix1);
    struct Matrix * matrix2 = Matrix_init(n, m);
    Matrix_randomFill(matrix2);

    start = clock();

    struct Matrix * ergebnis = Matrix_add(matrix1, matrix2);

    end = clock();
    dauer_s = (double)(end - start) / CLOCKS_PER_SEC;
    printf("Zeit für Addition: %lf s\n\n", dauer_s);

    if (ergebnis) {
      Matrix_free(ergebnis);
    }

    Matrix_free(matrix1);
    Matrix_free(matrix2);

    if (dauer_s < (zielzeit_s - 10)) {
      n = n * 2;
      m = m * 2;
    }
    
    if (dauer_s > (zielzeit_s + 10)) {
      n = n - (n / 4);
      m = m - (m / 4);
    }

  } while (dauer_s < (zielzeit_s - 10) or dauer_s > (zielzeit_s + 10));
}

void test_multiplikation(double zielzeit_s) {
  clock_t start, end;
  double dauer_s;
  int n = 2;
  int m = 2;

  printf("Test der Multiplikation:\n");

  do {
    printf("Multiplikation %ix%i Matrix\n", n, m);

    struct Matrix * matrix1 = Matrix_init(n, m);
    Matrix_randomFill(matrix1);
    struct Matrix * matrix2 = Matrix_init(n, m);
    Matrix_randomFill(matrix2);

    start = clock();

    struct Matrix * ergebnis = Matrix_multiply(matrix1, matrix2);

    end = clock();
    dauer_s = (double)(end - start) / CLOCKS_PER_SEC;
    printf("Zeit für Multiplikation: %lf s\n\n", dauer_s);

    if (ergebnis) {
      Matrix_free(ergebnis);
    }

    Matrix_free(matrix1);
    Matrix_free(matrix2);

    if (dauer_s < (zielzeit_s - 10)) {
      n = n * 2;
      m = m * 2;
    }
    
    if (dauer_s > (zielzeit_s + 10)) {
      n = n - (n / 4);
      m = m - (m / 4);
    }

  } while (dauer_s < (zielzeit_s - 10) or dauer_s > (zielzeit_s + 10));
}

int main () {
  test_multiplikation(60);

  test_addition(60);

  return 0;
}
