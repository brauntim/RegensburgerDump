#include "matrix.hpp"
#include <iostream>
#include <string>
#include <random>
#include <climits>
#include <cmath>
#include <exception>

Matrix::Matrix(): m(0), n(0), val(nullptr) {}
Matrix::Matrix(unsigned int m, unsigned int n): m(m), n(n) {
    this->val = new int*[m];
    for (int i = 0; i < m; i++) {
        this->val[i] = new int[n];
        for (int j = 0; j < n; j++) 
            this->val[i][j] = 0;
    }
}

Matrix::Matrix(const Matrix& other): m(other.m), n(other.n) {
    this->val = new int*[m];
    for (int i = 0; i < m; i++) {
        this->val[i] = new int[n];
        for (int j = 0; j < n; j++) 
            this->val[i][j] = other.val[i][j];
    }
}

Matrix::~Matrix() {
    if (this->val != nullptr) {
        for (int i = 0; i < m; i++) 
            delete[] this->val[i];
        delete[] this->val;
    }
}

void Matrix::print() const {
    std::cout << "--------------------" << std::endl;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++)
            std::cout << this->val[i][j] << "\t";
        std::cout << std::endl;
    }
    std::cout << "--------------------" << std::endl;
}

void Matrix::operator= (const Matrix& other) {
    if (val != nullptr) 
        delete this->val;
    this->m = other.m;
    this->n = other.n;
    this->val = new int*[m];
    for (int i = 0; i < m; i++) {
        this->val[i] = new int[n];
        for (int j = 0; j < n; j++) 
            this->val[i][j] = other.val[i][j];
    }
}

const int* Matrix::operator[] (int index) const {
    if (index < 0 || index >= m)
        throw std::runtime_error("index out of bounds");
    return this->val[index];

}

void Matrix::input() {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            int tmp = 0;

            std::cout << "please give a value for input: (" << i << "/" << j << "): ";
            while (true) {
                std::cin >> tmp;
                if (std::cin.fail()) {
                    std::cin.clear();
                    std::cin.ignore(10000000000, '\n');
                    std::cout << "please give a valid value for input: (" << i << "/" << j << "): ";
                } else 
                    break;
            }

            this->val[i][j] = tmp;
        }
    }
}

void Matrix::randomFill() {
    static std::random_device rd;
    static std::mt19937 gen (rd());
    static std::uniform_int_distribution<int> dist(-100, 100); 

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            this->val[i][j] = dist(gen);
        }
    }
}

Matrix Matrix::operator+ (const Matrix& other) const {
    if (this->n != other.n || this->m != other.m) 
        throw std::runtime_error("cannot add two Matrices that don't have the same dimension");
    unsigned int iterations = 0;

    Matrix res(this->m, this->n);
    for (int i = 0; i < this->m; i++) {
        for (int j = 0; j < this->n; j++) {
            iterations++;
            res.val[i][j] = this->val[i][j] + other.val[i][j];
        }
    }
    return res;
}

Matrix Matrix::operator- (const Matrix& other) const {
    if (this->n != other.n || this->m != other.m) 
        throw std::runtime_error("cannot add two Matrices that don't have the same dimension");
    unsigned int iterations = 0;

    Matrix res(this->m, this->n);
    for (int i = 0; i < this->m; i++) {
        for (int j = 0; j < this->n; j++) {
            iterations++;
            res.val[i][j] = this->val[i][j] - other.val[i][j];
        }
    }
    return res;
}

Matrix Matrix::operator* (const Matrix&  other) const {
    if (this->n != other.m || this->m != other.n)
        throw std::runtime_error("cannot multiply two Matrices where rows and column not match");
    Matrix res(other.m, this->n);
    int iterations = 0;

    for (int row = 0; row < res.n; row++) {
        for (int column = 0; column < res.m; column++) {
            int cij = 0;
            for (int index = 0; index < res.m; index++) {
                iterations++;
                cij += this->val[row][index] * other.val[index][column];
            }
            res.val[row][column] = cij;
        }
    }


    return res;
}

void Matrix::setCell(unsigned int y, unsigned int x, int value) {
    if (y >= m || x >= n) 
        throw std::runtime_error("index out bounds error");
    this->val[y][x] = value;
}

void recursiveMult(const Matrix& M, const Matrix& N, Matrix& O) {
    if (M.n == 2) {
        O.setCell(0, 0, M[0][0] * N[0][0] + M[0][1] * N[1][0]);
        O.setCell(0, 1, M[0][0] * N[0][1] + M[0][1] * N[1][1]);
        O.setCell(1, 0, M[1][0] * N[0][0] + M[1][1] * N[1][0]);
        O.setCell(1, 1, M[1][0] * N[0][1] + M[1][1] * N[1][1]);
        return;
    }

    int nHalf = M.n/2;
    Matrix M11(nHalf, nHalf);
    Matrix M12(nHalf, nHalf);
    Matrix M21(nHalf, nHalf);
    Matrix M22(nHalf, nHalf);
    Matrix N11(nHalf, nHalf);
    Matrix N12(nHalf, nHalf);
    Matrix N21(nHalf, nHalf);
    Matrix N22(nHalf, nHalf);

    for (int i = 0; i < nHalf; i++) {
        for (int j = 0; j < nHalf; j++) {
            M11.setCell(i, j, M[i        ][j        ]);
            M12.setCell(i, j, M[i        ][nHalf + j]);
            M21.setCell(i, j, M[nHalf + i][j        ]);
            M22.setCell(i, j, M[nHalf + i][nHalf + j]);
            N11.setCell(i, j, N[i        ][j        ]);
            N12.setCell(i, j, N[i        ][nHalf + j]);
            N21.setCell(i, j, N[nHalf + i][j        ]);
            N22.setCell(i, j, N[nHalf + i][nHalf + j]);
        }
    }



    Matrix H1(nHalf, nHalf);
    Matrix H2(nHalf, nHalf);
    Matrix H3(nHalf, nHalf);
    Matrix H4(nHalf, nHalf);
    Matrix H5(nHalf, nHalf);
    Matrix H6(nHalf, nHalf);
    Matrix H7(nHalf, nHalf);
    
    recursiveMult(M11 + M22, N11 + N22, H1);
    recursiveMult(M21 + M22, N11      , H2);
    recursiveMult(M11      , N12 - N22, H3);
    recursiveMult(M22      , N21 - N11, H4);
    recursiveMult(M11 + M12, N22      , H5);
    recursiveMult(M21 - M11, N11 + N12, H6);
    recursiveMult(M12 - M22, N21 + N22, H7);

    for (int i = 0; i < nHalf; i++) {
        for (int j = 0; j < nHalf; j++) {
            O.setCell(i, j, H1[i][j] + H4[i][j] - H5[i][j] + H7[i][j]);
            O.setCell(i        , nHalf + j, H3[i][j] + H5[i][j]);
            O.setCell(nHalf + i, j        , H2[i][j] + H4[i][j]);
            O.setCell(nHalf + i, nHalf + j, H1[i][j] - H2[i][j] + H3[i][j] + H6[i][j]);
        }
    }
}

Matrix Matrix::mult(const Matrix& other) const {
    if (n == 0 || m == 0 || other.n == 0 || other.m == 0) {
        throw std::runtime_error("cannot multiply empty Matrices");
    }else if (n != other.n || m != other.m || n != m) {
        throw std::runtime_error("cannot multiply non square shaped matrices recursively");
    } else if (std::fmod(log2(n), 1) != 0) {
        throw std::runtime_error("cannot multiply matrices that are not in R^(2^ix2^i) recursively");
    }
    
    Matrix O(n,n);
    recursiveMult(*this, other, O);

    return O;
}
