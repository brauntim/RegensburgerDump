using System.Diagnostics;

class Algorithms {
    public static void CountSort(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.Length; i++) {
            max = Math.Max(max, nums[i]);
        }

        int[] counts = new int[max + 1];
        for (int i = 0; i < counts.Length; i++) {
            counts[i] = 0;
        }

        for (int i = 0; i < nums.Length; i++) {
            counts[nums[i]]++;
        }

        int n = 0;
        for (int i = 0; i < counts.Length; i++) {
            for (; counts[i] > 0; counts[i]--) {
                nums[n++] = i;
            }
        }
    }


    private static void Heapify(int[] nums, int l, int r) {
        // Calc indices
        int nl = l * 2 + 1, nr = nl + 1;

        // Swap left
        if (nl < r && nums[nl] > nums[l]) {
            (nums[l], nums[nl]) = (nums[nl], nums[l]);
            Heapify(nums, nl, r);
        }
        // Swap right
        if (nr < r && nums[nr] > nums[l]) {
            (nums[l], nums[nr]) = (nums[nr], nums[l]);
            Heapify(nums, nr, r);
        }
    }

    public static void HeapSort(int[] nums) {
        // Build Heap
        for (int i = nums.Length / 2 - 1; i >= 0; i--) {
            Heapify(nums, i, nums.Length);
        }

        // Sort
        for (int i = nums.Length - 1; i >= 1; i--) {
            (nums[0], nums[i]) = (nums[i], nums[0]);
            Heapify(nums, 0, i);
        }
    }


    public static void MapSort(int[] nums, double d) {
        d = Math.Max(1, d);

        // Create buckets
        int[] buckets = new int[(int)(nums.Length * d)];
        for (int i = 0; i < buckets.Length; i++) {
            buckets[i] = -1;
        }

        // Find min and max
        int min = int.MaxValue, max = int.MinValue;
        foreach (int num in nums) {
            min = Math.Min(min, num);
            max = Math.Max(max, num);
        }

        double step = (max - min) / (double)(buckets.Length - 1);

        // Fill buckets
        foreach (int num in nums) {
            int targetBin = (int)((num - min) / step);
            int valToInsert = num;

            bool moveLeft = true;
            while (buckets[targetBin] != -1) {
                if (moveLeft) {
                    if (valToInsert > buckets[targetBin]) {
                        (valToInsert, buckets[targetBin]) = (buckets[targetBin], valToInsert);
                    }
                    if (targetBin > 0) {
                        targetBin--;
                    } else {
                        moveLeft = false;
                    }
                }
                else {
                    if (valToInsert <= buckets[targetBin]) {
                        (valToInsert, buckets[targetBin]) = (buckets[targetBin], valToInsert);
                    }
                    if (targetBin < buckets.Length - 1) {
                        targetBin++;
                    } else {
                        moveLeft = true;
                    }
                }
            }

            buckets[targetBin] = valToInsert;
        }

        // Collect sorted values
        int n = 0;
        for (int i = 0; i < buckets.Length; i++) {
            if (buckets[i] != -1) {
                nums[n++] = buckets[i];
            }
        }
    }
}

class Program {
    static Random rnd = new();

    static void TestAlgorithms(int n, int min, int max) {
        // Generate random numbers
        int[] nums = Enumerable.Range(0, n).Select(i => rnd.Next(min, max)).ToArray();

        int[] nums2 = nums.ToArray();
        var s = Stopwatch.StartNew();
        Algorithms.CountSort(nums2);
        s.Stop();
        var elapsedCount = s.Elapsed;

        nums2 = nums.ToArray();
        s.Restart();
        Algorithms.HeapSort(nums2);
        s.Stop();
        var elapsedHeap = s.Elapsed;

        nums2 = nums.ToArray();
        s.Restart();
        Algorithms.MapSort(nums2, 4/3);
        s.Stop();
        var elapsedMap = s.Elapsed;

        Console.WriteLine($"Size: {n}, Min: {min}, Max: {max}");
        Console.WriteLine($"CountSort: {elapsedCount}");
        Console.WriteLine($"HeapSort: {elapsedHeap}");
        Console.WriteLine($"MapSort: {elapsedMap}");
        Console.WriteLine();
    }

    static void Main() {
        foreach (int size in new int[] { 1000, 10000, 100000 }) {
            TestAlgorithms(size, 0, 1000);
            TestAlgorithms(size, 0, 10000);
            TestAlgorithms(size, 0, 100000);
        }
    }
}
