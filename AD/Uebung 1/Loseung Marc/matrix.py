from random import randint
import time


class Matrix():
    def __init__(self, m, n):
        self.m = m
        self.n = n
        self.matrix = [[0 for _ in range(n)] for _ in range(m)]

    def print(self):
        for i in range(self.m):
            for j in range(self.n):
                print(self.matrix[i][j], end=" ")
            print()

    def input(self):
        for i in range(self.m):
            for j in range(self.n):
                print("Please enter Matrix-Value for at:", i,", ", j)
                self.matrix[i][j] = input()

    def randomFill(self):
        for i in range(self.m):
            for j in range(self.n):
                self.matrix[i][j] = randint(0,9)

    def add(self, m):
        result = Matrix(self.m, m.n)
        count = 1 #result
        for i in range(self.m):
            for j in range(self.n):
                result.matrix[i][j] = self.matrix[i][j] + m.matrix[i][j]
                count+=1
        print("action count:", count)
        return result
            
    def mult(self, m):
        if (self.n != m.m):
            print("unfitting matrix size")
            return None
        
        result = Matrix(self.m, m.n)
        count = 2 #if statement & result

        for i in range(self.m):
            for j in range(m.n):
                sum = 0
                for k in range(self.n):
                    sum += self.matrix[i][k] * m.matrix[k][j]
                    count +=1
                result.matrix[i][j] = sum
                count +=2
        print("action count:", count)
        return result    

mat = Matrix(1000, 1000)
m = Matrix(1000, 1000)

mat.randomFill()

m.randomFill()

t1 = time.time()
C = mat.add(m)
t2 = time.time()
print("time in ms:", (t2 - t1) * 1000)

t1 = time.time()
C = mat.mult(m)
t2 = time.time()
print("time in ms:", (t2 - t1) * 1000)