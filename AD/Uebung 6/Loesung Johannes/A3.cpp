#include <algorithm>
#include <iostream>
#include <time.h>
#include <random>

int main() {
    // Ringliste ist hier komplett useless, also hab ich einfach ein Array genommen.

    srand(time(NULL));

    int size = 49;
    int numbers[49]; // 1 - 49
    for (int i = 0; i < size; i++) {
        numbers[i] = i + 1;
    }

    for (int i = 0; i < 6; i++) {
        int idx = rand() % size;
        std::cout << numbers[idx] << std::endl;
        std::swap(numbers[idx], numbers[--size]);
    }

    return 0;
}