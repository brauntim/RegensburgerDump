
public static class Program
{
    // O(n log n)
    public static double GetValueV1(List<(double, double)> weight_value, double targetWeight)
    {
        double totalWeight = 0, totalValue = 0;
        foreach (var (weight, value) in weight_value.OrderBy(x => x.Item1 / x.Item2)) {
            double remainingWeight = targetWeight - totalWeight;
            if (remainingWeight <= 0) break;
            
            double factor = Math.Min(remainingWeight / weight, 1);
            totalValue += factor * value;
            totalWeight += factor * weight;
        }
        return totalValue;
    }

    // O(2^n)
    public static double GetValueV2(List<(double, double)> weight_value, double targetWeight, int offset = 0) {
        if (offset == weight_value.Count) return 0;

        var (weight, value) = weight_value[offset];

        double with = 0;
        if (targetWeight >= weight) {
            with = value + GetValueV2(weight_value, targetWeight - weight, offset + 1);
        }
        double without = GetValueV2(weight_value, targetWeight, offset + 1);
        return Math.Max(with, without);
    }

    public static int Main()
    {
        List<(double, double)> weight_value = [
            (1, 7),
            (2, 6),
            (3, 18),
            (4, 22),
            (5, 28)
        ];

        double targetWeight = 5;
        double result = GetValueV2(weight_value, targetWeight);

        Console.WriteLine(result);

        return 0;
    }
}