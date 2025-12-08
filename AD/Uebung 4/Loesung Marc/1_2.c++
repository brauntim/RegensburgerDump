#include <iostream>

void printarray(int a[], int n);

void BubbleSort(int a[],int n)
{
    for (int i = n - 1; i >= 0; i--)
    {
        for (int j = 1; j <= i; j++)
        {
            if (a[j] < a[j-1])
            {
                int h = a[j];
                a[j] = a[j-1];
                a[j-1] = h;
            }
            printarray(a, n);
        }
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

    BubbleSort(a, n);
    printarray(a, n);

    return 0;
}
