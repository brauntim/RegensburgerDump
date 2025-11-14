#include "ring_list.cpp"
#include <cstdlib>
#include <iostream>
#include <random>
                                                    //Speicherplatz: Theta(n)
int main() {                                        //Laufzeit: Theta(n^2 + 6 + index + unknown) wobei index element of [1,49] => Theta(n^2 + unknown)
    ring_list values;
    for (int i = 1; i < 50; i++)                    //Theta(n^2)
        values.enqueue(i);

    std::random_device rd;
    std::mt19937 gen(rd());
    std::uniform_int_distribution<> distrib(1,49);

    for (int i = 0; i < 6; i++) {                    //Theta(6)
        int index = distrib(gen);                    //Theta(unknown)
        std::cout << values.dequeueAt(index) << " "; //Theta(index) 
    }
    std::cout << std::endl;
}
