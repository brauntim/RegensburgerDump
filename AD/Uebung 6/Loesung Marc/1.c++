#include <stdio.h>
#include <iostream>
#include <cstdlib>
#include <ctime>


void CountSort(int a[],int n, int k) {
	int i,j,*bin=new int[k+1];

	for (i=1;i<=k;i++) bin[i]=0;
	for (i=0;i<n;i++) bin[a[i]]++;
	i = 0;
	for (j=1;j<=k;j++) {
		while (bin[j]!=0) {
			a[i]=j; bin[j]--; i++;
		}
	}
	delete [] bin;
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
    const int n = 10000;
    int a[n];

    srand(time(0));
    int max = 100000000;
    int min = 1000;
    int range = max - min + 1;

    for (int i = 0; i < n; i++) {
        a[i] = rand() % range + min;
    }

    clock_t start, end;
    double time_used;

    start = clock();
    CountSort(a, n, max);
    end = clock();
    time_used = ((double)(end - start)) / CLOCKS_PER_SEC;
    std::cout << "Countsort: " << time_used << " s\n";

    return 0;
}