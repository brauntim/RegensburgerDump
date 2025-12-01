#include "binSearchTree.hpp"
#include <iostream>

int main() {
    binSearchTree t;
    
    t.insert(6);
    t.insert(7);
    t.insert(4);
    t.insert(5);
    t.insert(1);

    t.inorderTreeLike();
    t.inorder();
    t.preorder();

    int inorder[5]  = { 1, 4, 5, 6, 7 };
    int preorder[5] = { 6, 4, 1, 5, 7 };

    createTree(inorder, preorder, 5).inorderTreeLike();
}
