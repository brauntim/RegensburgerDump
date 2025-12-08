#include <stdio.h>
#include <limits.h>

int mts1D(int *arr, int n) {
    int max_sum = arr[0];
    int current_sum = arr[0];
    for (int i = 1; i < n; i++) {
        if (current_sum < 0)
            current_sum = arr[i];
        else
            current_sum += arr[i];

        if (current_sum > max_sum)
            max_sum = current_sum;
    }
    return max_sum;
}

int mts2D(int n, int matrix[n][n]) {
    int max_sum = INT_MIN;

    for (int top = 0; top < n; top++) {
        int temp[n];
        for (int i = 0; i < n; i++)
            temp[i] = 0;

        for (int bottom = top; bottom < n; bottom++) {
            for (int col = 0; col < n; col++)
                temp[col] += matrix[bottom][col];

            int current_max = mts1D(temp, n);
            if (current_max > max_sum)
                max_sum = current_max;
        }
    }
    return max_sum;
}

int main() {
    int n;
    printf("please enter matrix: ");
    scanf("%d", &n);

    int matrix[n][n];
    printf("please enter values for %d x %d matrix:\n", n, n);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            scanf("%d", &matrix[i][j]);
        }
    }

    int result = mts2D(n, matrix);
    printf("max 2D-sum: %d\n", result);

    return 0;
}
