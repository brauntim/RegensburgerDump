
a = 4
b = 5

def kgv(x, y):
    if x == y: 
        print(x)
        return
    elif x > y:
        y += b
    elif y > x:
        x += a
    kgv(x, y)

kgv(a, b)