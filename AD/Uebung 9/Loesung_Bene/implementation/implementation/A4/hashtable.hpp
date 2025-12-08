#include <stdexcept>
#include <iostream>
enum hashType {
    linear,
    squared,
    doubleHashing
};

template<int length, hashType T = linear> class hashtable {
    unsigned int len = length;
    int** values = new int*[length];
public:
    hashtable() {
        if (values == nullptr) 
            throw std::runtime_error("no space for array for hashtable");
        for (int i = 0; i < length; i++) 
            values[i] = nullptr;
    }

    ~hashtable() {
        for (int i = 0; i < length; i++) 
            if (values[i] != nullptr)
                delete values[i];
        delete[] values;
    }

    void print() {
        std::cout << "(";
        if (*values == nullptr) 
            std::cout << "-";
        else 
            std::cout << **values;
        for (int i = 1; i < length; i++) {
            if (values[i] == nullptr) 
                std::cout << ", -";
            else 
                std::cout << ", " << *values[i];
        }
        std::cout << ")" << std::endl;
    }

    void insert(int value) {
        switch (T) {
            case hashType::linear:
                for (int i = 0; i < length; i++) {
                    unsigned int pos = (value + i) % length;
                    if (values[pos] == nullptr) {
                        values[pos] = new int(value);
                        return;
                    }
                }
                throw std::runtime_error("not enough space to add element in hastable");
            break;
            case hashType::squared:
                for (int i = 0; i < length; i++) {
                    unsigned int pos = (value + i + 3*i*i) % length;
                    if (values[pos] == nullptr) {
                        values[pos] = new int(value);
                        return;
                    }
                }
                throw std::runtime_error("not enough space to add element in hastable");
                
            break;
            case hashType::doubleHashing:
                for (int i = 0; i < length; i++) {
                    unsigned int pos = (value + i*(1+(value % (length-1)))) % length;
                    if (values[pos] == nullptr) {
                        values[pos] = new int(value);
                        return;
                    }
                }
                throw std::runtime_error("not enough space to add element in hastable");
                
            break;
            default: 
                for (int i = 0; i < length; i++) {
                    unsigned int pos = (value + i) % length;
                    if (values[pos] == nullptr) {
                        values[pos] = new int(value);
                        return;
                    }
                }
                throw std::runtime_error("not enough space to add element in hastable");
            break;
        }
    }
};
