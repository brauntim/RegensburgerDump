
float[,] Mult(float[,] l, float[,] m) {
    int n = m.GetLength(0);

    float[,] result = new float[n, n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            float minVal = float.PositiveInfinity;
            for (int k = 0; k < n; k++) {
                minVal = Math.Min(minVal, l[i, k] + m[k, j]);
            }
            result[i, j] = minVal;
        }
    }
    return result;
}

void Print<T>(int l, T[,] m) {
    Console.WriteLine("L = " + l);
    
    // Calculate the maximum width of any element when converted to string
    int maxLength = 0;
    for (int i = 0; i < m.GetLength(0); i++)
    {
        for (int j = 0; j < m.GetLength(1); j++)
        {
            int length = m[i, j]?.ToString()?.Length ?? 0;
            if (length > maxLength) {
                maxLength = length;
            }
        }
    }

    // Print the elements, aligned to the right
    for (int i = 0; i < m.GetLength(0); i++)
    {
        for (int j = 0; j < m.GetLength(1); j++)
        {
            string element = m[i, j]?.ToString() ?? string.Empty;
            Console.Write(element.PadLeft(maxLength) + " ");
        }
        Console.WriteLine();
    }
    Console.WriteLine();
}

void APSP(float[,] m) {
    int n = m.GetLength(0);

    int targetL = 1;
    while (targetL < n) targetL *= 2;

    float[,] result = new float[n, n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            result[i,j] = i == j ? 0 : float.PositiveInfinity;
        }
    }

    for (int l = 1; l <= targetL; l++) {
        result = Mult(result, m);
        Print(l, result);
    }
}

float inf = float.PositiveInfinity;
float[,] m = new float[,] {
    {0, inf, inf, inf, -1, inf},
    {1, 0, inf, 2, inf, inf},
    {inf, 2, 0, inf, inf, -8},
    {-4, inf, inf, 0, 3, inf},
    {inf, 7, inf, inf, 0, inf},
    {inf, 5, 10, inf, inf, 0}
};
APSP(m);