#include <iostream>
#include <cstdint>
#include <vector>
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

private:
    uint32_t rows;
    uint32_t cols;
    std::vector<float> data;
};


int main() {
    srand(time(nullptr));

    Matrix a(2, 3);
    a.random();
    a.print();

    std::cout << std::endl;

    Matrix b(3, 2);
    b.random();
    b.print();

    std::cout << std::endl;

    Matrix c = a * b;
    c.print();

    std::cout << std::endl;

    Matrix d(2, 2);
    d.random();
    d.print();

    std::cout << std::endl;

    Matrix e = a + d;
    e.print();

    return 0;
}
