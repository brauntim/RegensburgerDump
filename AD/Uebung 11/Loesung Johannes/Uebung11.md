
# AD Übung 11

## 1.

G[0, 1] != G[1, 0] => G ist gerichtet

```csharp
void dfs(bool[][] graph, bool[] visited, int node)
{
    if (visited[node])
        return;
    visited[node] = true;

    Console.Write(node + " ");

    for (int i = 0; i < graph.Length; i++)
    {
        if (graph[node][i])
            dfs(graph, visited, i);
    }
}

void bfs(bool[][] graph, int start)
{
    Queue<int> nodes = new();
    bool[] visited = new bool[graph.Length];

    nodes.Enqueue(start);
    visited[start] = true;
    
    while (nodes.Count > 0)
    {
        int node = nodes.Dequeue();
        Console.Write(node + " ");

        for (int i = 0; i < graph.Length; i++)
        {
            if (graph[node][i] && !visited[i])
            {
                nodes.Enqueue(i);
                visited[i] = true;
            }
        }
    }
}

bool[][] graph = [
    [false, true, true, false, false, false, true, false, false],
    [false, false, false, true, false, false, false, false, false],
    [true, false, false, true, true, false, false, false, false],
    [false, false, false, false, false, false, true, false, false],
    [true, false, false, false, false, true, false, false, true],
    [false, false, true, true, true, false, false, true, false],
    [false, false, false, false, false, false, false, true, false],
    [false, false, false, true, false, false, false, false, true],
    [false, false, false, false, false, true, false, false, false],
];

Console.WriteLine("DFS:");
dfs(graph, new bool[graph.Length], 0);

Console.WriteLine("\nBFS:");
bfs(graph, 0);

// DFS:
// 0 1 3 6 7 8 5 2 4 
// BFS:
// 0 1 2 6 3 4 7 5 8
```

$A^m$ gibt die Anzahl der Pfade der Länge $m$ zwischen den Knoten an.

## Aufgabe 2

$L=B\cdot B^T$ ist die Laplace-Matrix eines Graphen.

Elemente auf der Diagonalen: Anzahl der Ausgehenden Kanten
Restliche Elemente beschreiben, ob es eine Kante zwischen den Knoten gibt.

## Aufgabe 3

```csharp
void findCycle_(bool[][] graph, bool isDirected, int[] visited, int idx, int step, ref List<int> cycle, ref bool cycleComplete)
{
    if (visited[idx] != -1) {
        // directed graph: cycle has 2.. nodes
        // undirected graph: cycle has 3.. nodes
        if (!cycleComplete && (isDirected || step - visited[idx] >= 2))
            cycle = [idx];
        return;
    }
    visited[idx] = step;

    for (int i = 0; i < graph[idx].Length; i++)
    {
        if (!graph[idx][i]) continue;

        findCycle_(graph, isDirected, visited, i, step + 1, ref cycle, ref cycleComplete);

        if (cycleComplete) return;
        if (cycle.Count != 0) {
            if (idx == cycle[0]) {
                cycleComplete = true;
            }
            else {
                cycle.Add(idx);
            }
            return;
        }
    }
}
List<int>? findCycle(bool[][] graph, bool isDirected = true)
{
    int[] visited = new int[graph.Length];
    for (int i = 0; i < visited.Length; i++)
        visited[i] = -1;

    for (int i = 0; i < graph.Length; i++)
    {
        if (visited[i] != -1) continue;

        List<int> cycle = new();
        bool cycleComplete = false;
        findCycle_(graph, isDirected, visited, i, 0, ref cycle, ref cycleComplete);

        if (cycleComplete) {
            cycle.Reverse();
            return cycle;
        }
    }

    return null;
}

bool[][] graph = [
    [false, true, true, false, false, false, true, false, false],
    [false, false, false, true, false, false, false, false, false],
    [true, false, false, true, true, false, false, false, false],
    [false, false, false, false, false, false, true, false, false],
    [true, false, false, false, false, true, false, false, true],
    [false, false, true, true, true, false, false, true, false],
    [false, false, false, false, false, false, false, true, false],
    [false, false, false, true, false, false, false, false, true],
    [false, false, false, false, false, true, false, false, false],
];
List<int>? cycle = findCycle(graph);

Console.WriteLine("Cycle:");
Console.WriteLine(string.Join(", ", cycle ?? []));
```

## Aufgabe 4

```csharp
// Algorithm skips any nodes that belong to a cycle
List<int> topologicalSort(List<(int, int)> edges, int n)
{
    List<int>[] outgoing = new List<int>[n];
    HashSet<int>[] incoming = new HashSet<int>[n];

    // O(N)
    for (int i = 0; i < n; i++)
    {
        outgoing[i] = [];
        incoming[i] = [];
    }
    // O(E)
    foreach ((int from, int to) in edges)
    {
        outgoing[from].Add(to);
        incoming[to].Add(from);
    }

    // O(N)
    Queue<int> zeroIncoming = [];
    for (int i = 0; i < n; i++)
    {
        if (incoming[i].Count == 0)
            zeroIncoming.Enqueue(i);
    }

    // O(N)
    List<int> sorted = [];
    while (zeroIncoming.Count > 0)
    {
        int node = zeroIncoming.Dequeue();
        sorted.Add(node);

        foreach (int nextNode in outgoing[node])
        {
            incoming[nextNode].Remove(node);
            if (incoming[nextNode].Count == 0)
                zeroIncoming.Enqueue(nextNode);
        }
    }
    return sorted;
}

List<(int, int)> edges = [
    (7, 3),
    (7, 8),
    (3, 5),
    (3, 1),
    (8, 6),
    (5, 0),
    (1, 0),
    (6, 2),
    (0, 4),
    (2, 4)
];

List<int> sorted = topologicalSort(edges, 9);
Console.WriteLine(string.Join(" ", sorted));  // 7 3 8 5 1 6 0 2 4
```
