#include <iostream>
#include <array>

void printarray(int a[], int n)
{
    for (int i = 0; i < n; i++)
        std::cout << a[i] << " ";
    std::cout << std::endl;
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

bool algorithm(int a[], int s, int n) {
    MergeSort(a, 0, n-1);
    int p = 0;
    int q = n-1;
    for (int i = 0; i < n; i++) {
        int sum = a[p] + a[q];
        if (sum > s) {
            q--;
        } else if (sum < s) {
            p++;
        } else {
            return true;
        }
    }
    return false;
}

int main() {
    int a[] = {-80, 45, 12, 34, 23, 18, 38, 17, 43, 7};
    int s = -35;
    int n = sizeof(a)/sizeof(a[0]);
    bool b = algorithm(a, s, n);
    std::cout << b << " ";
    std::cout << std::endl;
}