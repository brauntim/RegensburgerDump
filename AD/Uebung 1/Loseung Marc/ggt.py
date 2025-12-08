a = 32
b = 12

def ggt_it(a, b):
    if a <= 0 or b <= 0:
        print("param <= 0")
    r = a % b
    while r != 0:
        a = b
        b = r
        r = a % b
    print(b)

def ggt_rec(a, b, r):
    if r != 0:
        a = b
        b = r
        r = a % b
        ggt_rec(a, b, r)
    else:
        print(b)

ggt_it(a, b)

ggt_rec(a, b, a % b)