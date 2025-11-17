#include <stdio.h>

void matrixmultiplication(int m1[2][2], int m2[2][2], int n) {
    int o[2][2], h0, h1, h3, h4, h5, h6, h7;

    h0 = (m[0][0] + m[1][1]) * (m2[0][0] + m2[1][1]);
    h1 = (m[1][0] + m[1][1]) * m2[0][0];
    h3 = m[0][0] * (m2[0][1] - m2[1][1]);
    h4 = m[1][1] * (m2[1][0] - m2[0][0]);
    h5 = (m[0][0] + m[0][1]) * m2[1][1];
    h6 = (m[1][0] - m[0][0]) * (m2[0][0] + m2[0][1]);
    h7 = (m[0][0] - m[1][1]) * (m2[1][0] + m2[1][1]);

    o[0][0] = h0 + h4 - h5 + h7;
    o[0][1] = h3 + h5;
    o[1][0] = h1 + h4;
    o[1][1] = h0 - h1 + h3 + h6;

    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 2; j++) printf("%d ", o[i][j]);
        printf("\n");
    }
}

int main () {
    int n = 2;
    int m1[2][2] = {4, 3, 5, 1};
    int m2[2][2] = {9, 4, 1, 8};

    matrixmultiplication(m1, m2, n);

    return 0;
}
