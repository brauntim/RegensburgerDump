import numpy as np

def compute_m_mT(matrix):
    """
    Berechnet das Produkt M * M^T.

    :param matrix: numpy.ndarray, die Matrix M
    :return: numpy.ndarray, das Produkt M * M^T
    """
    if not isinstance(matrix, np.ndarray):
        raise ValueError("Eingabe muss eine numpy.ndarray sein")
    
    return np.dot(matrix, matrix.T)

# Beispielmatrix M
M = np.array([[-1, 1, 0, 0, 0],
              [0, -1, 1, 0, 0],
              [1, 0, 0, -1, 0],
              [0, -1, 0, 1, 0],
              [0, 0, 0, 1, -1]])

# Berechnung von M * M^T
result = compute_m_mT(M)
print("M * M^T:")
print(result)
