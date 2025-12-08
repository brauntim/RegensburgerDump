#include <iostream>

void InsertionSort(int a[],int n)
{
    int i, j, key;
    for (j = n - 2; j >= 0; j--)
    {
        key = a[j];
        i = j+1;
        while (i < n && a[i] < key)
        {
            a[i-1] = a[i];
            i = i+1;
        }
        a[i-1] = key;
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

int main()
{
    int a[] = {34, 45, 12, 34, 23, 18, 38, 17, 43, 51};
    int n = sizeof(a) / sizeof(a[0]);

    InsertionSort(a, n);
    printarray(a, n);

    return 0;
}
