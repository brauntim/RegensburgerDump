#include "binSearchTree.hpp"
#include <iostream>

//node implementation
binSearchTree::node::node(int val): val(val) {}

binSearchTree::node::~node() {}

void binSearchTree::node::insert(int val) {
    if (val == this->val)  
        return; 

    if (val < this->val) {
        if (left != nullptr) 
            left->insert(val);
        else
            left = new node(val);
    } else {
        if (right != nullptr) 
            right->insert(val);
        else
            right = new node(val);
    }
}

void binSearchTree::node::swapNextInorder() {
    node* tmp  = this->right;
    node* prev = this;
    while (tmp->left != nullptr) {
        prev = tmp;
        tmp = tmp->left;
    }

    this->val = tmp->val;
    if (prev == this) 
        prev->right = tmp->right;
    else 
        prev->left = tmp->right;
    delete tmp;
}

void binSearchTree::node::remove(int a, node &prev) {
    if (val == a) { 
        if (left == nullptr && right == nullptr) {
            if (prev.left->val == a)
                prev.left = nullptr;
            else 
                prev.right = nullptr;
            delete this;
        } else if (left != nullptr && right != nullptr) {
            this->swapNextInorder();
        } else {
            node *tmp;
            if (left == nullptr) {
                tmp = right;
            } else {
                tmp = left;
            }

            if (prev.left->val == a) 
                prev.left = tmp;
            else 
                prev.right = tmp;
            delete this;
        }
    } else if (val > a) {
        if (left != nullptr)
            left->remove(a, *this);
    } else if (val < a) {
        if (right != nullptr)
            right->remove(a, *this);
    }
}

void binSearchTree::node::inorderTreeLike(int depth) {
    if (right != nullptr)
        right->inorderTreeLike(depth+1);
    for (int i = 0; i<depth; i++) 
        std::cout << "\t";
    std::cout << val << std::endl;
    if (left != nullptr)
        left->inorderTreeLike(depth+1);
}
 
void binSearchTree::node::inorder() {
    if (left != nullptr)
        left->inorder();
    std::cout << val << " ";
    if (right != nullptr)
        right->inorder();
}
   
//binSearchTree implementation
binSearchTree::binSearchTree() {}
binSearchTree::~binSearchTree() {
    delete root;
    root = nullptr;
}

void binSearchTree::insert(int val) {
    if (root == nullptr)
        root = new node(val);
    else
        root->insert(val);
}

void binSearchTree::inorderTreeLike() {
    if (root != nullptr)
        root->inorderTreeLike(0);
}

void binSearchTree::inorder() {
    if (root != nullptr) {
        root->inorder();
        std::cout << std::endl;
    }
}

void binSearchTree::remove(int a) {
    if (root == nullptr) 
        return;
    if (root->val == a) {
        root->swapNextInorder();
    } else {
        if (a > root->val) 
            root->right->remove(a, *root);
        else 
            root->left->remove(a, *root);
    }

}
