
// O(V + E)
int[] TopologicalSort(List<int>[] edges, int N)
{
    int[] ingoing = new int[N];
    // O(V)
    for (int i = 0; i < N; i++)
        ingoing[i] = 0;
    // O(E)
    foreach (var from in edges)
        foreach (var to in from)
            ingoing[to]++;

    List<int> sorted = [];

    // O(V)
    Queue<int> next = new();
    for (int i = 0; i < N; i++)
        if (ingoing[i] == 0)
            next.Enqueue(i);
    // O(V)
    while (next.Count > 0)
    {
        int cur = next.Dequeue();
        sorted.Add(cur);

        // O(E / V) amortized
        foreach (int to in edges[cur])
        {
            ingoing[to]--;
            if (ingoing[to] == 0)
                next.Enqueue(to);
        }
    }

    if (sorted.Count != N)
        throw new InvalidOperationException("The graph contains a cycle and cannot be topologically sorted.");

    return [.. sorted];
}

List<int>[] edges =
[
    [ 1, 4 ],
    [ 2, 4 ],
    [ ],
    [ 0 ],
    [ 2 ],
];

int[] sorted = TopologicalSort(edges, edges.Length);

Console.WriteLine(string.Join(", ", sorted)); // 3, 0, 1, 4, 2