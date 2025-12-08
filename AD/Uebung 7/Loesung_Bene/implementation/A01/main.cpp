#include "binSearchTree.hpp"
#include <iostream>

int main() {
    binSearchTree t;
    
    t.insert(5);
    t.insert(6);
    t.insert(7);
    t.insert(4);
    t.insert(2);
    t.insert(1);
    t.insert(3);

    std::cout << "initial" << std::endl;
    t.inorderTreeLike();
    t.remove(5);
    std::cout << "remove 5" << std::endl;
    t.inorderTreeLike();
    t.remove(4);
    std::cout << "remove 4" << std::endl;
    t.inorderTreeLike();
    t.remove(2);
    std::cout << "remove 2" << std::endl;
    t.inorderTreeLike();
    t.remove(1);
    std::cout << "remove 1" << std::endl;
    t.inorderTreeLike();
}
