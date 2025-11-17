#include <iostream>

void iterMergeSort(int a[], int n)                      //Teta(nlogn)
{
    int* temp = new int[n];
    for (int size = 1; size < n; size *= 2)
    {
        for (int l = 0; l < n - size; l += 2 * size)
        {
            int m = l + size;
            int r = std::min(l + 2 * size - 1, n - 1);
            int i = l;
            int j = m;
            int k = l;
            while (i < m && j <= r)
            {
                if (a[i] <= a[j])
                    temp[k++] = a[i++];
                else
                    temp[k++] = a[j++];
            }
            while (i < m)
                temp[k++] = a[i++];

            while (j <= r)
                temp[k++] = a[j++];
        }
        for (int i = 0; i < n; i++)
            a[i] = temp[i];
    }
    delete[] temp;
}

void rekInsertionSort(int a[], int n, int j) {  //Teta(n^2)
    if (j < n) {
        int key = a[j];
        int i = j - 1;
        while (i >= 0 && a[i] > key) {
            a[i+1] = a[i];
            i = i-1;
        }
        a[i+1] = key;
        j++;
        rekInsertionSort(a, n, j);
    }
}

void printarray(int a[], int n)
{
    for (int i = 0; i < n; i++)
    {
        std::cout << a[i] << " ";
    }
    std::cout << std::endl;
}

int main() {
    int j = 1;
    int a[] = {-80, 45, 12, 34, 23, 18, 38, 17, 43, 7};
    int n = sizeof(a) / sizeof(a[0]);
    rekInsertionSort(a, n, j);
    iterMergeSort(a, n);

    printarray(a, n);

    return 0;
}