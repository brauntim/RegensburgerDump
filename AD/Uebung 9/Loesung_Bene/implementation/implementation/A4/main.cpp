#include "hashtable.hpp"

int main() {
    int values[9] = {10,22,31,4,15,28,17,88,59};
    hashtable<11> hLin;
    hashtable<11, hashType::squared> hSquared;
    hashtable<11, hashType::doubleHashing> hDouble;

    for (int i = 0; i < 9; i++)
        hLin.insert(values[i]);
    hLin.print();

    for (int i = 0; i < 9; i++)
        hSquared.insert(values[i]);
    hSquared.print();

    for (int i = 0; i < 9; i++)
        hDouble.insert(values[i]);
    hDouble.print();
}
