#include <iostream>

void printarray(int a[], int n);

void SelectionSort(int a[],int n)
{
    int i, j, max;
    for (i = n - 1; i >= 0; i--)
    {
        max = i;
        for (j = i; j >= 0; j--)
        {
            if (a[j] > a[max]) max = j;
        }
        int h = a[i];
        a[i] = a[max];
        a[max] = h;
        printarray(a, n);
    }
    std::cout << std::endl;
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

    SelectionSort(a, n);
    printarray(a, n);

    return 0;
}
