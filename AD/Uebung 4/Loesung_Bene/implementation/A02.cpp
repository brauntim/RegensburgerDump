#include <iostream>
#include <vector>
#include <chrono>
#include <random>

#include "./sorting.hpp"


int main(int argc, char** argv) {
    int startLen1 = 50;
    int startLen2 = startLen1;
    std::vector<int> values(startLen1);
    std::random_device rd;
    std::mt19937 gen(rd());
    std::uniform_int_distribution<int> dist;

    int fun = atoi(argv[1]);
    for (int i = 0; i < startLen1; i++) {
        values.push_back(dist(gen));
    }

    if (fun == 0) 
        std::cout << "BubbleSort" << std::endl;
    else if (fun == 1) 
        std::cout << "Quicksort" << std::endl;
    else if (fun == 2) 
        std::cout << "MergeSort" << std::endl;
    while (true) {
        auto startT = std::chrono::system_clock::now();
        std::cout << "vector of len: " << startLen1 << std::endl;
        if (fun == 0) {
            BubbleSort<std::vector<int>> (values, startLen1);
        } else if (fun == 1) {
            QuickSort<std::vector<int>> (values, 0, values.size()-1);
        } else { 
            MergeSort<std::vector<int>> (values, 0, values.size()-1);
        }
        auto endT = std::chrono::system_clock::now();

        auto deltaT =std::chrono::duration_cast<std::chrono::seconds> (endT - startT).count();
        std::cout << "needed: " << deltaT << "seconds" << std::endl;
        if (deltaT > 60){
            break;
        } else {
            startLen2 = startLen1;
            startLen1 = startLen1 * 2;
            for (int i = 0; i<startLen2; i++) 
                values.push_back(dist(gen));
        }
    }
    std::cout << "somwhere between " << startLen2 << " and " << startLen1 << std::endl;

}
