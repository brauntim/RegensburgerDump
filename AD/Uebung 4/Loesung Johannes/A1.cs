class Program {
    static Random rnd = new();

    static void Shuffle<T>(List<T> values) {
        for (int i = 0; i < values.Count - 1; i++) {
            int rndIdx = rnd.Next(i, values.Count - 1);
            (values[i], values[rndIdx]) = (values[rndIdx], values[i]);
        }
    }

    static void InsertionSort<T>(List<T> values) where T: IComparable<T> {
        for (int i = values.Count - 1; i >= 0; i--) {
            for (int j = i; j < values.Count - 1; j++) {
                if (values[j].CompareTo(values[j+1]) <= 0) break;
                (values[j], values[j+1]) = (values[j+1], values[j]);
            }
        }
    }

    static void BubbleSort<T>(List<T> values) where T: IComparable<T> {
        for (int i = 0; i < values.Count; i++) {
            for (int j = values.Count - 1; j > 0; j--) {
                if (values[j-1].CompareTo(values[j]) > 0) {
                    (values[j-1], values[j]) = (values[j], values[j-1]);
                }
            }
        }
    }

    static void SelectionSort<T>(List<T> values) where T: IComparable<T> {
        for (int i = values.Count - 1; i > 0; i--) {
            int maxIdx = i;
            T maxVal = values[i];
            for (int j = i; j >= 0; j--) {
                if (values[j].CompareTo(maxVal) > 0) {
                    maxVal = values[j];
                    maxIdx = j;
                }
            }
            (values[maxIdx], values[i]) = (values[i], values[maxIdx]);
        }
    }

    static void QuickSort<T>(List<T> values) where T: IComparable<T> {
        QuickSort(values, 0, values.Count - 1);
    }
    static void QuickSort<T>(List<T> values, int start, int end) where T: IComparable<T> {
        if (start >= end) return;

        int pivot = rnd.Next(start, end + 1);
        T pivotValue = values[pivot];
        (values[start], values[pivot]) = (values[pivot], values[start]);

        int low = start;
        for (int j = low + 1; j <= end; j++) {
            if (values[j].CompareTo(pivotValue) < 0) {
                low++;
                (values[low], values[j]) = (values[j], values[low]);
            }
        }
        (values[low], values[start]) = (values[start], values[low]);
        QuickSort(values, start, low - 1);
        QuickSort(values, low + 1, end);
    }
    

    public static void Main() {
        List<int> values = new(Enumerable.Range(1, 20));
        Shuffle(values);
        Console.WriteLine(string.Join(", ", values));

        List<int> copy = new(values);
        InsertionSort(copy);
        Console.WriteLine(string.Join(", ", copy));

        copy = new(values);
        BubbleSort(copy);
        Console.WriteLine(string.Join(", ", copy));

        copy = new(values);
        SelectionSort(copy);
        Console.WriteLine(string.Join(", ", copy));

        copy = new(values);
        QuickSort(copy);
        Console.WriteLine(string.Join(", ", copy));
    }
}