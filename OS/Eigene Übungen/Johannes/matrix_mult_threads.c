#include <pthread.h>
#include <stdlib.h>
#include <stdio.h>

int** create_matrix(int rows, int cols) {
    int** matrix = (int**) malloc(rows * sizeof(int*));
    for (int i = 0; i < rows; i++) {
        matrix[i] = (int*) malloc(cols * sizeof(int));
    }
    return matrix;
}
void free_matrix(int** matrix, int rows) {
    for (int i = 0; i < rows; i++) {
        free(matrix[i]);
    }
    free(matrix);
}

void fill_matrix(int** matrix, int rows, int cols, int maxvalue) {
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            matrix[i][j] = rand() % maxvalue;
        }
    }
}

void print_matrix(int** matrix, int rows, int cols) {
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            printf("%d ", matrix[i][j]);
        }
        printf("\n");
    }
}


typedef struct {
    int** a;
    int** b;
    int** result;
    int M;
    int N;
    int P;
    int row;
} MultParams;

void* mult_row(void* args) {
    MultParams params = *(MultParams*)args;

    for (int p = 0; p < params.P; p++) {
        params.result[params.row][p] = 0;
        for (int n = 0; n < params.N; n++) {
            params.result[params.row][p] += params.a[params.row][n] * params.b[n][p];
        }
    }

    printf("Thread %d finished\n", params.row);

    return NULL;
}

// a: MxN
// b: NxP
// c: MxP
void mult_matrices(int** a, int** b, int** result, int M, int N, int P) {
    // Each row gets a thread
    pthread_t* threads = malloc(sizeof(pthread_t) * M);
    MultParams* args = malloc(sizeof(MultParams) * M);
    for (int m = 0; m < M; m++) {
        args[m].a = a;
        args[m].b = b;
        args[m].result = result;
        args[m].M = M;
        args[m].N = N;
        args[m].P = P;
        args[m].row = m;

        pthread_create(&threads[m], NULL, mult_row, &args[m]);
    }
    for (int m = 0; m < M; m++) {
        pthread_join(threads[m], NULL);
    }

    free(threads);
    free(args);
}


int main(int argc, char** argv) {
    srand(0);

    if (argc != 4) {
        printf("Usage: %s M N P\n", argv[0]);
        return 1;
    }

    int M = atoi(argv[1]);
    int N = atoi(argv[2]);
    int P = atoi(argv[3]);

    int** a = create_matrix(M, N);
    int** b = create_matrix(N, P);
    int** result = create_matrix(M, P);

    fill_matrix(a, M, N, 10);
    fill_matrix(b, N, P, 10);

    print_matrix(a, M, N);
    printf("\n");
    print_matrix(b, N, P);
    printf("\n");

    mult_matrices(a, b, result, M, N, P);

    print_matrix(result, M, P);

    free_matrix(a, M);
    free_matrix(b, N);
    free_matrix(result, M);

    return 0;
}