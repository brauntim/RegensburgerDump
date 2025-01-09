
void Print<T>(T[,] m) {
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

int[] GetPath(int[,] predecessor, int i, int j)
{
    if (predecessor[i, j] == -1)
        return [];

    List<int> path = [];
    path.Add(j);
    while (i != j)
    {
        j = predecessor[i, j];
        path.Add(j);
    }

    path.Reverse();
    return path.ToArray();
}

(float[,] dist, int[,] parent) FloydWarshall(float[,] graph, int V, out int A2_satisfied)
{
    A2_satisfied = -1;

    float[,] dist = (float[,]) graph.Clone();

    int[,] predecessor = new int[V, V];
    for (int i = 0; i < V; i++)
    {
        for (int j = 0; j < V; j++)
        {
            if (i == j || dist[i, j] == float.PositiveInfinity)
            {
                predecessor[i, j] = -1;
            }
            else
            {
                predecessor[i, j] = i;
            }
        }
    }

    for (int k = 0; k < V; k++)
    {
        for (int i = 0; i < V; i++)
        {
            for (int j = 0; j < V; j++)
            {
                float newDist = dist[i, k] + dist[k, j];
                if (newDist < dist[i, j])
                {
                    dist[i, j] = newDist;
                    predecessor[i, j] = predecessor[k, j];

                    if (predecessor[k, j] == k)
                        A2_satisfied = k;
                }
            }
        }
    }

    return (dist, predecessor);
}

// Aufgabe 1
// ---------

Console.WriteLine("Aufgabe 1\n");

float inf = float.PositiveInfinity;
float[,] m = new float[,] {
    {0, inf, inf, inf, -1, inf},
    {1, 0, inf, 2, inf, inf},
    {inf, 2, 0, inf, inf, -8},
    {-4, inf, inf, 0, 3, inf},
    {inf, 7, inf, inf, 0, inf},
    {inf, 5, 10, inf, inf, 0}
};
var (dist, predecessor) = FloydWarshall(m, 6, out _);

Console.WriteLine("Shortest distances:");
Print(dist);

Console.WriteLine("Predecessors:");
Print(predecessor);

Console.WriteLine("Shortest path from 2 to 4:");
Console.WriteLine(string.Join(" -> ", GetPath(predecessor, 2, 4)));
Console.WriteLine();

// Aufgabe 2
// ---------

Console.WriteLine("Aufgabe 2\n");

float[,] m2 = new float[,] {
    {0, 1, inf, inf},
    {inf, 0, 1, inf},
    {inf, inf, 0, 1},
    {1, inf, inf, 0}
};
var (dist2, predecessor2) = FloydWarshall(m2, 4, out int A2_satisfied);

Console.WriteLine("Shortest distances:");
Print(dist2);

Console.WriteLine("Predecessors:");
Print(predecessor2);

Console.WriteLine("A2 satisfied at vertex " + A2_satisfied);

// Output
// ------

/*
Aufgabe 1

Shortest distances:
 0  6  ∞  8 -1  ∞
-2  0  ∞  2 -3  ∞
-5 -3  0 -1 -6 -8
-4  2  ∞  0 -5  ∞
 5  7  ∞  9  0  ∞
 3  5 10  7  2  0

Predecessors:
-1  4 -1  1  0 -1
 3 -1 -1  1  0 -1
 3  5 -1  1  0  2
 3  4 -1 -1  0 -1
 3  4 -1  1 -1 -1
 3  5  5  1  0 -1

Shortest path from 2 to 4:
2 -> 5 -> 1 -> 3 -> 0 -> 4

Aufgabe 2

Shortest distances:
0 1 2 3
3 0 1 2
2 3 0 1
1 2 3 0

Predecessors:
-1  0  1  2
 3 -1  1  2
 3  0 -1  2
 3  0  1 -1

A2 satisfied at vertex 3
*/