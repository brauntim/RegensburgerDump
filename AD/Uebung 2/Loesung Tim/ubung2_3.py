def max_2d_subarray_sum(matrix):
    matrix_size = len(matrix)
    max_sum = float('-inf') 

    # Durchlaufe alle möglichen oberen linken Ecken (start_row, start_col) des Teilrechtecks
    for start_row in range(matrix_size):
        for start_col in range(matrix_size):
            # Durchlaufe alle möglichen unteren rechten Ecken (end_row, end_col) des Teilrechtecks
            for end_row in range(start_row, matrix_size):
                for end_col in range(start_col, matrix_size):

                    current_sum = 0
                    for row in range(start_row, end_row + 1):
                        for col in range(start_col, end_col + 1):
                            current_sum += matrix[row][col]
                    

                    max_sum = max(max_sum, current_sum)

    return max_sum

def main():

    matrix_size = int(input("Geben Sie die Größe der Matrix (n) ein, für eine n x n Matrix: "))

    # Initialisierung der Matrix
    matrix = []
    print("Geben Sie die Elemente der Matrix Zeile für Zeile ein:")
    for row_index in range(matrix_size):
        row = list(map(int, input(f"Zeile {row_index + 1}: ").split()))
        matrix.append(row)


    if any(len(row) != matrix_size for row in matrix):
        print("Fehler: Die eingegebene Matrix hat nicht die richtige Größe.")
        return


    result = max_2d_subarray_sum(matrix)
    print("Die maximale 2D-Teilsumme ist:", result)

if __name__ == "__main__":
    main()
