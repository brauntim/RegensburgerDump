
public class PriorityQueue<P, V> where P: IComparable<P> where V: IComparable<V>
{
    private List<(P prio, V value)> heap = [];

    public PriorityQueue() {}

    // O(log n)
    public void Insert(P priority, V value)
    {
        heap.Add((priority, value));
        HeapifyFromEnd(heap.Count - 1);
    }

    // O(1)
    public (P, V)? GetMin() => heap.Count == 0 ? null : heap[0];

    // O(log n)
    public void ExtractMin()
    {
        heap[0] = heap[^1];
        heap.RemoveAt(heap.Count - 1);
        Heapify(0);
    }

    // O(log n)
    public void DecreaseKey(int idx, P newPriority)
    {
        heap[idx] = (newPriority, heap[idx].value);
        HeapifyFromEnd(idx);
    }
    
    // O(n)
    // Könnte O(log n) sein, wenn die Position aller Elemente in einer Map gespeichert wird
    public void DecreaseKey(V value, P newPriority)
    {
        int idx = heap.FindIndex(x => x.value.CompareTo(value) == 0);
        if (idx == -1) return;
        DecreaseKey(idx, newPriority);
    }


    private void Heapify(int idx)
    {
        int next = idx * 2 + 1;
        if (next < heap.Count && heap[next].CompareTo(heap[idx]) < 0) {
            (heap[next], heap[idx]) = (heap[idx], heap[next]);
            Heapify(next);
        }

        next++;
        if (next < heap.Count && heap[next].CompareTo(heap[idx]) < 0) {
            (heap[next], heap[idx]) = (heap[idx], heap[next]);
            Heapify(next);
        }
    }
    private void HeapifyFromEnd(int idx)
    {
        while (idx > 0)
        {
            int parentIdx = (idx - 1) / 2;
            if (heap[parentIdx].CompareTo(heap[idx]) > 0)
            {
                (heap[parentIdx], heap[idx]) = (heap[idx], heap[parentIdx]);
            }
            idx = parentIdx;
        }
    }
}

public static class Program
{
    public static void Main()
    {
        Console.OutputEncoding = System.Text.Encoding.GetEncoding(65001);
        Console.InputEncoding  = System.Text.Encoding.GetEncoding(65001);

        // Test
        Random rnd = new(0);

        PriorityQueue<int, string> pq = new();

        for (int i = 0; i < 100; i++)
        {
            pq.Insert(rnd.Next(0, 10), $"Value {i}");
        }

        while (pq.GetMin() is not null)
        {
            var (prio, value) = pq.GetMin().Value;
            Console.WriteLine($"Priority: {prio}, Value: {value}");
            pq.ExtractMin();
        }
    }
}