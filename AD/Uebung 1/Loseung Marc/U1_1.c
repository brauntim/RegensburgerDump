#include <stdio.h>

int ggT(int a, int b) {
    if (a % b > 0)
        ggT(b, a % b);
    else
        return b;
}

int kgV(int a, int b, int ggt) {
    return (a * b) / ggt;
}

int main (void) {
    int ggt;
    int kgv;

    for (int a = 30; a <= 40; a++) {
        for (int b = 30; b <= 40; b++) {
            ggt = ggT(a, b);
            printf("ggT(%d, %d) = %d\n", a, b, ggt);
            kgv = kgV(a, b, ggt);
            printf("kgV(%d, %d) = %d\n", a, b, kgv);
            printf("Produkt = %d\n", a * b);
        }
    }
    return 0;
}