#pragma once
class Matrix {
private:
    unsigned int m, n;
    int** val;

public:
    Matrix();
    Matrix(unsigned int m, unsigned n);
    Matrix(const Matrix& other);
    ~Matrix();
    void print() const;
    void input();
    void randomFill();
    Matrix mult(const Matrix&) const;
    void operator=(const Matrix& B);
    Matrix operator+(const Matrix& B) const;
    Matrix operator-(const Matrix& B) const;
    Matrix operator*(const Matrix& B) const;
    const int* operator[](int) const;
    void setCell(unsigned int, unsigned int, int);

    friend void recursiveMult(const Matrix& M, const Matrix& N, Matrix& O); 
};
