limit = 100000

def foo(limit):
    #setup
    arr = [True] * (limit + 1)
    arr[0] = arr[1] = False

    for i in range(2, int(limit**0.5) + 1):
        if arr[i]:
            for j in range(i * i, limit + 1, i):
                arr[j] = False

    #output
    for i in range(limit + 1):
        if arr[i]:
            print(i)

foo(limit)