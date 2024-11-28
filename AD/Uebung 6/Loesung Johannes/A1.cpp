#include <algorithm>

// 2k + 3n
void count_sort(int nums[], int size) {
    // n
    int maxVal = 0;
    for (int i = 0; i < size; i++) {
        maxVal = std::max(maxVal, nums[i]);
    }

    // k
    int* counts = new int[maxVal + 1];
    for (int i = 0; i <= maxVal; i++) {
        counts[i] = 0;
    }

    // n
    for (int i = 0; i < size; i++) {
        counts[nums[i]]++;
    }

    // k + n
    int i = 0;
    for (int j = 0; j <= maxVal; j++) {
        for (; counts[nums[j]] > 0; counts[nums[j]]--) {
            nums[i] = nums[j];
            i++;
        }
    }
}