def getMaxTeilsumme2d(input: list[list[int]], n: int) -> int:
    maxTeilsumme = 0

    for i01 in range(0, n):
        for i02 in range(i01, n):
            for j01 in range(0, n):
                for j02 in range(j01, n):
                    teilsumme = 0

                    for i in range(i01, i02+1):
                        if j01 == j02:
                            teilsumme += input[i][j01]
                        else:
                            teilsumme += getMaxTeilsumme1d(input[i][j01:j02], j02-j01)

                    if maxTeilsumme == None or maxTeilsumme < teilsumme:
                        maxTeilsumme = teilsumme
                        maxi01 = i01
                        maxi02 = i02
                        maxj01 = j01
                        maxj02 = j02

    print(f"Max: {maxTeilsumme} für i01: {maxi01}, i02: {maxi02}, j01: {maxj01}, j02: {maxj02}")

    return maxTeilsumme

def getMaxTeilsumme1d(input: list[int], n: int):
    maxTeilsumme = None
    aktuelleSumme = 0
    summe = 0

    for i in range(0, n):
        summe += input[i]

        if summe > aktuelleSumme:
            aktuelleSumme = summe
        else:
            aktuelleSumme = input[i]

        if maxTeilsumme == None or aktuelleSumme > maxTeilsumme:
            maxTeilsumme = aktuelleSumme

    return maxTeilsumme

def main():
    getMaxTeilsumme2d(
        [
            [-1, 2, 5, -3],
            [3, -4, 2, -1],
            [5, -2, 4, 5],
            [-3, -1, 4, -2]
        ],
        4
    )

main()