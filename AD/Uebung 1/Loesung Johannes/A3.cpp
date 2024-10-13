#include <iostream>
#include <cstdint>
#include <vector>
#include <math.h>
#include <ctime>


struct Matrix {
public:
    Matrix(uint32_t rows, uint32_t cols) : rows(rows), cols(cols), data(rows * cols) { }

    void print() {
        for (uint32_t i = 0; i < rows; i++) {
            for (uint32_t j = 0; j < cols; j++) {
                std::cout << data[i * cols + j] << " ";
            }
            std::cout << std::endl;
        }
    }

    void input() {
        for (uint32_t i = 0; i < rows; i++) {
            for (uint32_t j = 0; j < cols; j++) {
                std::cin >> data[i * cols + j];
            }
        }
    }

    void random() {
        for (uint32_t i = 0; i < rows; i++) {
            for (uint32_t j = 0; j < cols; j++) {
                data[i * cols + j] = rand() % 100;
            }
        }
    }

    Matrix operator+(const Matrix& other) {
        if (rows != other.rows || cols != other.cols) {
            throw std::invalid_argument("Matrix dimensions do not match");
        }

        Matrix result(rows, cols);
        for (uint32_t i = 0; i < rows; i++) {
            for (uint32_t j = 0; j < cols; j++) {
                result.data[i * cols + j] = data[i * cols + j] + other.data[i * cols + j];
            }
        }
        return result;
    }

    Matrix operator*(const Matrix& other) {
        if (cols != other.rows) {
            throw std::invalid_argument("Matrix dimensions do not match");
        }

        Matrix result(rows, other.cols);
        for (uint32_t i = 0; i < rows; i++) {
            for (uint32_t j = 0; j < other.cols; j++) {
                for (uint32_t k = 0; k < cols; k++) {
                    result.data[i * other.cols + j] += data[i * cols + k] * other.data[k * other.cols + j];
                }
            }
        }
        return result;
    }
    
    static uint32_t findMaxSize(double maxSeconds, int step) {
        uint32_t minSize = 1;
        uint32_t maxSize = 1;

        // Find matrix size that can be multiplied in MORE than maxSeconds
        while (true) {
            uint32_t size = maxSize * step;

            Matrix a(size, size);
            Matrix b(size, size);

            std::cout << size << std::endl;

            clock_t start = clock();
            a * b;
            clock_t end = clock();

            uint32_t elapsedSeconds = (end - start) / CLOCKS_PER_SEC;
            if (elapsedSeconds > maxSeconds) {
                break;
            }

            minSize = maxSize;
            
            float root3of2 = pow(2, 1.0 / 3);
            maxSize = (uint32_t)ceilf(maxSize * root3of2);
        }

        // Binary search for the exact matrix size (LESS than maxSeconds)
        while (minSize < maxSize) {
            uint32_t midSize = (maxSize + minSize + 1) / 2;
            uint32_t size = midSize * step;

            std::cout << size << std::endl;

            Matrix a(size, size);
            Matrix b(size, size);

            clock_t start = clock();
            a * b;
            clock_t end = clock();

            double elapsedSeconds = double(end - start) / CLOCKS_PER_SEC;
            if (elapsedSeconds > maxSeconds) {
                maxSize = midSize - 1;
            } else {
                minSize = midSize;
            }
        }

        return minSize * step;
    }

private:
    uint32_t rows;
    uint32_t cols;
    std::vector<float> data;
};


int main() {
    srand(time(nullptr));

    // Returns 1920 in 2 minutes on my machine
    double seconds = 5.0;
    uint32_t step = 32;

    clock_t start1 = clock();
    uint32_t maxSize = Matrix::findMaxSize(seconds, step);
    clock_t end1 = clock();

    std::cout << "Elapsed time for findMaxSize: " << double(end1 - start1) / CLOCKS_PER_SEC << " seconds" << std::endl;

    std::cout << "Max matrix size that can be multiplied in " << seconds << " second(s): " << maxSize << std::endl;

    Matrix a(maxSize, maxSize);
    Matrix b(maxSize, maxSize);
    a.random();
    b.random();

    clock_t start = clock();
    Matrix c = a * b;
    clock_t end = clock();

    std::cout << "Elapsed time: " << double(end - start) / CLOCKS_PER_SEC << " seconds" << std::endl;

    return 0;
}
