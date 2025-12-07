#include <stdio.h>
#include <stdlib.h>
#include <ctime>
#include <cmath>
#include <iostream>

const int n = 10;

class tree_element1 {
    public: 
        int t;
        tree_element1 *left;
        tree_element1 *right;
        void nValues(int x);
};
void tree_element1::nValues(int x) {
    t = x;
}
class searchtree1 {
    private: 
        void Insert(tree_element1 *currRoot, tree_element1 *elem);
        void DeleteTree(tree_element1 *root);
    public: 
        tree_element1 *root;
        searchtree1();
        ~searchtree1();
        void Insert(int x);
        bool Contains(int x);
        void DeleteValue(int x);
        tree_element1 getbiggestElem();
        void Print(tree_element1 *temp);
};
searchtree1::searchtree1() {
    root=NULL;
}
searchtree1::~searchtree1() {
    DeleteTree(root);
    root=NULL;
}
void searchtree1::DeleteTree(tree_element1 *root) {
    if (root != NULL) {
        if (root->left != NULL) DeleteTree(root->left);
        if (root->right != NULL) DeleteTree(root->right);
        delete root;
    }
}
bool searchtree1::Contains(int x) {
    tree_element1 *curr=root;
    while (curr!=NULL) {
        if (curr->t==x) return true;
        else {
            if (x<=curr->t) curr=curr->left;
            else curr=curr->right;
        }
    }
    return false;
}
void searchtree1::Insert(int x) {
    tree_element1 *elem = new tree_element1;
    elem->t = x;  
    elem->left = elem->right = NULL;
    if (root == NULL) root = elem;
    else Insert(root, elem);
}
void searchtree1::Insert(tree_element1 *currRoot, tree_element1 *elem) {
    if (elem->t <= currRoot->t) {
        if (currRoot->left==NULL) currRoot->left=elem;
        else Insert(currRoot->left,elem); 
    } else {
        if (currRoot->right==NULL) currRoot->right=elem;
        else Insert(currRoot->right,elem); 
    } 
}
tree_element1 searchtree1::getbiggestElem() {
    if (!root) return tree_element1();

    tree_element1 *cur = root;
    tree_element1 *parent = nullptr;

    while (cur->right) {
        parent = cur;
        cur = cur->right;
    }

    tree_element1 biggest;
    biggest.t = cur->t;

    if (parent) {
        parent->right = cur->left;
    } else {
        root = cur->left; // das größte Element war die Wurzel
    }

    delete cur;
    return biggest;
}
void searchtree1::DeleteValue(int x) {
    tree_element1 *temp = root;
    tree_element1 *prev = NULL;
    bool prevleft = false;
    while (temp) {
        if (temp->t == x) {
            if (!prev) {
                delete root;
                return;
            } else {
                if (prevleft) {
                    temp->left ? prev->left = temp->left : prev->left = temp->right;
                } else {
                    temp->left ? prev->right = temp->left : prev->right = temp->right;
                }
                return;
            }
        } else {
            prev = temp;
            if (temp-> t > x) {
                temp = temp->left;
                prevleft = true;
            } else {
                temp = temp->right;
                prevleft = false;
            }
        }
    }
}
void searchtree1::Print(tree_element1 *temp) {
    if (temp == NULL) return;

    Print(temp->left);
    std::cout << temp->t << " ";
    Print(temp->right);
}

int main() {
    srand(time(0));

    searchtree1 s;

    int deleteValue;

    for (int i = 0; i < n; i++) {
        int o = rand() % 51;
        s.Insert(o);
        if (i == 3) {
            deleteValue = i;
        }
    }

    s.Print(s.root);
    std::cout<<std::endl;
    s.DeleteValue(deleteValue);
    s.Print(s.root);

    return 0;
}
