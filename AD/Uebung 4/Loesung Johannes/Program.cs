using System.Diagnostics;

class Program {
    static Random rnd = new();

    static void Shuffle<T>(T[] values) {
        for (int i = 0; i < values.Length - 1; i++) {
            int rndIdx = rnd.Next(i, values.Length - 1);
            (values[i], values[rndIdx]) = (values[rndIdx], values[i]);
        }
    }

    static void BubbleSort<T>(T[] values) where T: IComparable<T> {
        for (int i = 0; i < values.Length; i++) {
            for (int j = values.Length - 1; j > 0; j--) {
                if (values[j - 1].CompareTo(values[j]) > 0) {
                    (values[j - 1], values[j]) = (values[j], values[j - 1]);
                }
            }
        }
    }

    static void InsertionSort<T>(T[] values) where T: IComparable<T> {
        for (int i = values.Length - 1; i >= 0; i--) {
            for (int j = i; j < values.Length - 1; j++) {
                if (values[j].CompareTo(values[j + 1]) <= 0) break;
                (values[j], values[j + 1]) = (values[j + 1], values[j]);
            }
        }
    }

    static void InsertionSortRecursive<T>(T[] values, int start = 1) where T: IComparable<T> {
        if (start >= values.Length) return;

        for (int i = start; i > 0; i--) {
            if (values[i].CompareTo(values[i - 1]) < 0) {
                (values[i], values[i - 1]) = (values[i - 1], values[i]);
            }
        }
        InsertionSortRecursive(values, start + 1);
    }

    static void SelectionSort<T>(T[] values) where T: IComparable<T> {
        for (int i = values.Length - 1; i > 0; i--) {
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

    static void QuickSort<T>(T[] values) where T: IComparable<T> {
        QuickSort(values, 0, values.Length - 1);
    }
    static void QuickSort<T>(T[] values, int start, int end) where T: IComparable<T> {
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

    static void MergeSort<T>(T[] values) where T: IComparable<T> {
        T[] temp = new T[values.Length];
        MergeSort(values, 0, values.Length - 1, temp);
    }
    static void MergeSort<T>(T[] values, int low, int high, T[] temp) where T: IComparable<T> {
        if (low >= high) return;

        if (high - low == 1) {
            if (values[low].CompareTo(values[high]) > 0) {
                (values[low], values[high]) = (values[high], values[low]);
            }
            return;
        }

        int leftLow = low, leftHigh = low + (high - low) / 2;
        int rightLow = leftHigh + 1, rightHigh = high;
        MergeSort(values, leftLow, leftHigh, temp);
        MergeSort(values, rightLow, rightHigh, temp);

        int mergedLen = 0;
        while (leftLow <= leftHigh && rightLow <= rightHigh) {
            if (values[leftLow].CompareTo(values[rightLow]) < 0) {
                temp[mergedLen++] = values[leftLow++];
            } else {
                temp[mergedLen++] = values[rightLow++];
            }
        }

        if (leftLow <= leftHigh) {
            int len = leftHigh - leftLow + 1;
            Array.Copy(values, leftLow, values, rightHigh - len + 1, len);
        }

        Array.Copy(temp, 0, values, low, mergedLen);
    }

    static void MergeSortIterative<T>(T[] values) where T: IComparable<T> {
        T[] temp = new T[values.Length];

        Stack<(int, int, bool)> ranges = new();
        ranges.Push((0, values.Length - 1, false));

        while (ranges.Count > 0) {
            var (start, end, onlyNeedsMerging) = ranges.Pop();
            if (start <= end) continue;
            if (onlyNeedsMerging) {
                // Merge
                continue;
            }

            int mid = start + (end - start) / 2;
            ranges.Push((start, end, true));
            ranges.Push((start, mid, false));
            ranges.Push((mid + 1, end, false));
        }
    }

    static void Test() {
        for (int i = 0; i < 100; i++) {
            int[] values = Enumerable.Range(0, 1000).Select(x => rnd.Next(0, 750)).ToArray();
            int[] sorted = new int[values.Length];
            Array.Copy(values, sorted, values.Length);
            Array.Sort(sorted);

            var copyMerge = (int[])values.Clone();
            MergeSort(copyMerge);
            if (!copyMerge.SequenceEqual(sorted)) {
                Console.WriteLine($"Errors in MergeSort:\nExpected: {string.Join(", ", sorted)}\nGot: {string.Join(", ", copyMerge)}");
                return;
            }

            var copyQuick = (int[])values.Clone();
            QuickSort(copyQuick);
            if (!copyQuick.SequenceEqual(sorted)) {
                Console.WriteLine($"Errors in QuickSort:\nExpected: {string.Join(", ", sorted)}\nGot: {string.Join(", ", copyQuick)}");
                return;
            }

            var copySelection = (int[])values.Clone();
            SelectionSort(copySelection);
            if (!copySelection.SequenceEqual(sorted)) {
                Console.WriteLine($"Errors in SelectionSort:\nExpected: {string.Join(", ", sorted)}\nGot: {string.Join(", ", copySelection)}");
                return;
            }

            var copyInsertion = (int[])values.Clone();
            InsertionSort(copyInsertion);
            if (!copyInsertion.SequenceEqual(sorted)) {
                Console.WriteLine($"Errors in InsertionSort:\nExpected: {string.Join(", ", sorted)}\nGot: {string.Join(", ", copyInsertion)}");
                return;
            }

            var copyInsertionRecursive = (int[])values.Clone();
            InsertionSortRecursive(copyInsertionRecursive);
            if (!copyInsertionRecursive.SequenceEqual(sorted)) {
                Console.WriteLine($"Errors in InsertionSortRecursive:\nExpected: {string.Join(", ", sorted)}\nGot: {string.Join(", ", copyInsertionRecursive)}");
                return;
            }

            var copyBubble = (int[])values.Clone();
            BubbleSort(copyBubble);
            if (!copyBubble.SequenceEqual(sorted)) {
                Console.WriteLine($"Errors in BubbleSort:\nExpected: {string.Join(", ", sorted)}\nGot: {string.Join(", ", copyBubble)}");
                return;
            }
        }
    }

    // Aufgabe 2
    // AutoBenchmark(5, 10000) -> 30900000
    static int AutoBenchmark(double targetSeconds, int step = 10, double initialFactor = 1.5) {
        int minSize = step, maxSize = step;

        // Find the initial range
        while (true) {
            Console.WriteLine("Increasing size to " + maxSize);

            int[] values = Enumerable.Range(0, maxSize).Select(x => rnd.Next(0, maxSize * 3/4)).ToArray();
            Stopwatch sw = Stopwatch.StartNew();
            MergeSort(values);
            sw.Stop();
            if (sw.Elapsed.TotalSeconds > targetSeconds) {
                break;
            }
            minSize = maxSize;
            maxSize = (int)Math.Ceiling(maxSize * initialFactor / step) * step;
        }

        // Binary search for optimal size
        while (minSize < maxSize) {
            int midSize = minSize + ((maxSize - minSize + 1) / 2 + step - 1) / step * step;
            Console.WriteLine("Testing size " + midSize);

            int[] values = Enumerable.Range(0, midSize).Select(x => rnd.Next(0, midSize * 3/4)).ToArray();
            Stopwatch sw = Stopwatch.StartNew();
            MergeSort(values);
            sw.Stop();
            if (sw.Elapsed.TotalSeconds > targetSeconds) {
                maxSize = midSize - step;
            } else {
                minSize = midSize;
            }
        }

        return minSize;
    }

    static bool Aufgabe3(int[] arr, int target) {
        MergeSort(arr);

        int l = 0, h = arr.Length - 1;
        while (l < h) {
            int sum = arr[l] + arr[h];
            if (sum == target) return true;
            if (sum > target) {
                h--;
            } else {
                l++;
            }
        }

        return false;
    }

    public static void Main() {
        Test();

        int res = AutoBenchmark(5, 10000);
        Console.WriteLine($"AutoBenchmark: {res}");
    }
}
