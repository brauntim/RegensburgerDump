#include "matrix.hpp"
#include <iostream>
#include <string>
#include <random>
#include <climits>

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
    for (int i = 0; i < m; i++) 
        delete[] this->val[i];
    delete[] this->val;
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
    this->m = other.m;
    this->n = other.n;
    this->val = new int*[m];
    for (int i = 0; i < m; i++) {
        this->val[i] = new int[n];
        for (int j = 0; j < n; j++) 
            this->val[i][j] = other.val[i][j];
    }
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
    std::cout << "needed: " << iterations << " iterations" << std::endl;
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

    std::cout << "needed: " << iterations << " iterations" << std::endl;

    return res;
}
