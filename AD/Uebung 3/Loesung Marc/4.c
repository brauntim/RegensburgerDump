#include <stdio.h>

int rekursiv(int n, int m) {
    if (n == 0) {
        return m + 1;
    } else if (m == 0 && n >= 1) {
        return rekursiv(n-1, 1);
    } else {
        return rekursiv(n-1, rekursiv(n, m-1));
    }
}

int iterativ(int n, int m) {
    int stackN[10000];
    int sp = 0; // Stack pointer

    while (1) {
        if (n == 0) {
            m = m + 1;

            // Falls Stapel leer → Ergebnis gefunden
            if (sp == 0) return m;

            // Sonst aus dem Stack holen
            sp--;
            n = stackN[sp];
        }
        else if (m == 0) {
            n = n - 1;
            m = 1;
        }
        else {
            // Rekursive Aufrufstruktur simulieren:
            //   f(n-1, f(n, m-1))
            // Zuerst f(n, m-1) lösen → n merken
            stackN[sp] = n - 1;
            sp++;
            m = m - 1;
        }
    }
}

void print_rekursiv(int n, int m) {
  int result = rekursiv(n, m);

  printf("f(%i, %i) = %i\n", n, m, result);

  return;
}

int main() {
    print_rekursiv(0,0);
    print_rekursiv(1,0);
    print_rekursiv(0,1);
    print_rekursiv(1,1);
    print_rekursiv(2,3);

    int n = 2;
    int m = 3;

    int result = iterativ(n, m);
    printf("f(%d, %d) = %d\n", n, m, result);

    return 0;
}