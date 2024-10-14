
class Program {

    static int MaxSubarraySum2D(int[,] a) {
        int[,] colSums = new int[a.GetLength(0)+1, a.GetLength(1)];
        for (int x = 0; x < a.GetLength(1); x++) {
            colSums[0,x] = 0;
        }
        for (int y = 0; y < a.GetLength(0); y++) {
            for (int x = 0; x < a.GetLength(1); x++) {
                colSums[y+1,x] = colSums[y,x] + a[y,x];
            }
        }

        int bestSum = int.MinValue;

        for (int yl = 0; yl < a.GetLength(0); yl++) {
            for (int yh = yl; yh < a.GetLength(0); yh++) {
                int bestRowSum = int.MinValue, curSum = int.MinValue / 2;
                for (int x = 0; x < a.GetLength(1); x++) {
                    int colSubarraySum = colSums[yh+1,x] - colSums[yl,x];

                    curSum = Math.Max(curSum + colSubarraySum, colSubarraySum);
                    bestRowSum = Math.Max(bestRowSum, curSum);
                }

                bestSum = Math.Max(bestSum, bestRowSum);
            }
        }

        return bestSum;
    }

    public static void Main() {
        int[,] a = new int[,] {
            {  1,  2, -1,  -4, -20 },
            { -8, -3,  4,   2,  1 },
            {  3,  8,  10,  1,  3 },
            { -4, -1,  1,   7, -6 }
        };

        Console.WriteLine(MaxSubarraySum2D(a)); // 29
    }
}