#include <iostream>
#include <vector>
#include <cstdint>

std::vector<uint64_t> sieve_of_erastothenes(uint64_t n) {
    std::vector<uint64_t> primes;
    primes.push_back(2);
    std::vector<bool> is_prime((n - 1) / 2, true); // nur ungerade Zahlen ab 3
    for (uint64_t i = 0; i < is_prime.size(); i++) {
        if (!is_prime[i]) continue;

        uint64_t p = 2 * i + 3;
        primes.push_back(p);
        for (uint64_t j = i + p; j < is_prime.size(); j += p) {
            is_prime[j] = false;
        }
    }
    return primes;
}

int main() {
    uint64_t n = 100000;
    std::vector<uint64_t> primes = sieve_of_erastothenes(n);
    for (uint64_t p : primes) {
        std::cout << p << std::endl;
    }
    return 0;
}