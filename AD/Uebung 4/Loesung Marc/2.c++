#include <iostream>
#include <cstdlib>
#include <ctime>

void printarray(int a[], int n)
{
    for (int i = 0; i < n; i++)
        std::cout << a[i] << " ";
    std::cout << std::endl;
}

void BubbleSort(int a[],int n)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = n-2; j >=i; j--)
        {
            if (a[j] > a[j+1])
            {
                int h = a[j];
                a[j] = a[j+1];
                a[j+1] = h;
            }
        }
    }
}

void swap(int &a,int &b)
{
    int h=b;
    b=a;
    a=h;
}

void PreparePartition(int a[],int f,int l,int &p)
{
    int pivot = a[f]; p = f-1;
    for (int i = f; i <= l; i++)
    {
        if (a[i] <= pivot)
        {
        p++; swap(a[i],a[p]);
        }
    }
    swap(a[f],a[p]);
}

void Quicksort(int a[],int f,int l)
{
    int part;
    if (f<l) {
        PreparePartition(a,f,l,part);
        Quicksort(a,f,part-1);
        Quicksort(a,part+1,l);
    }
}

void Merge(int a[],int f,int l,int m) {
    int i, n = l - f + 1;
    int a1f = f, a1l = m-1;
    int a2f = m, a2l = l;
    int *anew = new int[n];
    for (i = 0;i < n; i++)
    { 
        if (a1f <= a1l) {
            if (a2f <= a2l){ 
                if (a[a1f] <= a[a2f]) {
                    anew[i]=a[a1f++];
                } else {
                    anew[i]=a[a2f++];
                } 
            } else {
                anew[i]=a[a1f++]; 
            }
        } else {
            anew[i]=a[a2f++];
        } 
    }
    for (i=0;i<n;i++) {
        a[f+i]=anew[i];
    }
    delete [] anew; 
}

void MergeSort(int a[], int f, int l)
{ 
    if (f<l) {
        int m = (f+l+1)/2;
        MergeSort(a,f,m-1);
        MergeSort(a,m,l);
        Merge(a,f,l,m); 
    }
}

int main() {
    srand(time(0));
    const int n = 100000;
    int a[n], b[n], c[n];

    for (int i = 0; i < n; i++) {
        int val = rand() % 10001;
        a[i] = val;
        b[i] = val;
        c[i] = val;
    }

    clock_t start, end;
    double time_used;

    start = clock();
    BubbleSort(a, n);
    end = clock();
    time_used = ((double)(end - start)) / CLOCKS_PER_SEC;
    std::cout << "BubbleSort: " << time_used << " s\n";

    start = clock();
    Quicksort(b, 0, n - 1);
    end = clock();
    time_used = ((double)(end - start)) / CLOCKS_PER_SEC;
    std::cout << "QuickSort: " << time_used << " s\n";

    start = clock();
    MergeSort(c, 0, n - 1);
    end = clock();
    time_used = ((double)(end - start)) / CLOCKS_PER_SEC;
    std::cout << "MergeSort: " << time_used << " s\n";

    // printarray(a, n);
    // printarray(b, n);
    // printarray(c, n);

    return 0;
}