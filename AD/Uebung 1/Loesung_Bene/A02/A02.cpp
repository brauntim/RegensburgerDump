#include <iostream>
#include <vector>

int main(int argc, char** argv) {
    int k = atoi(argv[1]);

    std::vector<int> primeVal;

    bool primes[k+1];
    primes[0] = false;
    primes[1] = false;

    for (int i = 2; i <=k; i++)
        primes[i] = true;

    for (int i = 2; i < k; i++) {
        if (!primes[i]) 
            continue;
        
        primeVal.push_back(i);

        for (int j = 1; i*j < k; j++) {
            primes[i*j] = false;
        }
    }

    for (int val : primeVal)
        std::cout << val << std::endl;

}
