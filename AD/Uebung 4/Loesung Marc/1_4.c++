#include <iostream>
#include <cstdlib>
#include <ctime>

void printarray(int a[], int n);
void swap(int &a, int &b);

void PreparePartition(int a[], int f, int l, int &p)
{
    int pivot = a[f]; 
    p = f;

    for (int i = f + 1; i <= l; i++)
    {
        if (a[i] < pivot)
        {
            p++;
            swap(a[i], a[p]);
        }
    }
    swap(a[f], a[p]);
}

void swap(int &a, int &b)
{
    int h = a;
    a = b;
    b = h;
}

void Quicksort(int a[], int f, int l)
{
    if (f < l)
    {
        int randPivot = f + rand() % (l - f + 1);
        swap(a[f], a[randPivot]);

        int part;
        PreparePartition(a, f, l, part);
        Quicksort(a, f, part - 1);
        Quicksort(a, part + 1, l);
    }
}

void printarray(int a[], int n)
{
    for (int i = 0; i < n; i++)
        std::cout << a[i] << " ";
    std::cout << std::endl;
}

int main()
{
    srand(time(0));

    int a[] = {34, 45, 12, 34, 23, 18, 38, 17, 43, 51};
    int n = sizeof(a) / sizeof(a[0]);

    Quicksort(a, 0, n - 1);
    printarray(a, n);

    return 0;
}
