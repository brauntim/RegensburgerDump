import java.io.*;
import java.util.*;


public class U1_3 {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(3, 2);
        matrix.init();
        //matrix.input();
        matrix.randomfill();
        matrix.print();
        Matrix secmatrix = new Matrix(2, 4);
        secmatrix.randomfill();
        secmatrix.print();
        //Matrix summatrix = matrix.add(secmatrix);
        Matrix productmatrix = matrix.mult(secmatrix);
    }
}

class Matrix {
    int[][] matrix;
    int m;
    int n;

    public Matrix(int m, int n) {
        this.m = m;
        this.n = n;
        matrix = new int[m][n];
    }

    void init() {
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    void print() {
        System.out.println("matrix:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(matrix[i][j]);
            }
            System.out.println();
        }
    }

    void input() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("pls enter num for " + i + " " + j);
                matrix[i][j] = sc.nextInt();
            }
        }
    }

    void randomfill() {
        Random rd = new Random();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rd.nextInt(0,99);
            }
        }
    }

    Matrix add(Matrix secmatrix) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                secmatrix.setvalue(i, j, matrix[i][j] + secmatrix.getvalue(i, j));
            }
        }
        secmatrix.print();
        return secmatrix;
    }

    Matrix mult(Matrix secmatrix) {
        Matrix tempmatrix = new Matrix(m, secmatrix.n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < secmatrix.n; j++) {
                int temp = 0;
                for (int k = 0; k < n; k++) {
                    temp += matrix[i][k] * secmatrix.getvalue(k, j); 
                }
                tempmatrix.setvalue(i, j, temp);
            }
        }
        tempmatrix.print();
        return tempmatrix;
    }

    int getvalue(int a, int b) {
        return matrix[a][b];
    }

    void setvalue(int a, int b, int value) {
        matrix[a][b] = value;
    }
}