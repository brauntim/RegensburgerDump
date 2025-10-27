#pragma once
class Matrix {
private:
    unsigned int m, n;
    int** val;
public:
    Matrix(unsigned int m, unsigned n);
    Matrix(const Matrix& other);
    ~Matrix();
    void print() const;
    void input();
    void randomFill();
    void operator=(const Matrix& B);
    Matrix operator+(const Matrix& B) const;
    Matrix operator*(const Matrix& B) const;
};
