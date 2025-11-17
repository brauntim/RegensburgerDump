#include <stdio.h>
#include <stdlib.h>
#include <ctime>
#include <cmath>
#include <iostream>

const int n = 10;

struct object
{
    double v;
    double w;
    double rel;
    double a;
};

class tree_element1 {
    public: 
        object *t;
        tree_element1 *left;
        tree_element1 *right;
        void nValues(double v, double w);
};
void tree_element1::nValues(double v, double w) {
    t->v = v;
    t->w = w;
}
class searchtree1 {
    private: 
        void Insert(tree_element1 *currRoot, tree_element1 *elem);
        void DeleteTree(tree_element1 *root);
        void Print(tree_element1 *root);
    public: 
        tree_element1 *root;
        searchtree1();
        ~searchtree1();
        void Insert(object &o);
        bool Contains(object o);
        void DeleteValue(object o);
        tree_element1 getbiggestElem();
        void Print();
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
        delete root->t;   // wichtig!
        delete root;
    }
}
bool searchtree1::Contains(object o) {
    tree_element1 *curr=root;
    while (curr!=NULL) {
        if (curr->t->rel==o.rel) return true;
        else {
            if (o.rel<=curr->t->rel) curr=curr->left;
            else curr=curr->right;
        }
    }
    return false;
}
void searchtree1::Insert(object &o) {
    tree_element1 *elem = new tree_element1;
    elem->t = new object;  // neues Object auf dem Heap
    *(elem->t) = o;        // Kopie des übergebenen Objekts
    elem->left = elem->right = NULL;
    if (root == NULL) root = elem;
    else Insert(root, elem);
}
void searchtree1::Insert(tree_element1 *currRoot, tree_element1 *elem) {
    if (elem->t->rel <= currRoot->t->rel) {
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
    biggest.t = new object;
    *(biggest.t) = *(cur->t); // kopiere das Objekt

    if (parent) {
        parent->right = cur->left;
    } else {
        root = cur->left; // das größte Element war die Wurzel
    }

    delete cur->t;
    delete cur;
    return biggest;
}

void setRel(object *o) {
    o->rel = o->v / o->w;
    double value = (int)(o->rel * 100 + .5);
    o->rel = (double) value / 100;
}

void Backpackfill(object a[], int cap) {
    searchtree1 s;
    for (int i = 0; i < n; i++) {                           //O(n)
        setRel(&a[i]);
        s.Insert(a[i]);
    }
    for (int i = 0; i < n; i++) {
        tree_element1 elem = s.getbiggestElem();            //O(nlog(n))
        a[i] = *(elem.t);
        if (cap - a[i].w >= 0) {
            cap -= a[i].w;
            a[i].a = 1;
            std::cout <<"object o with "<<a[i].v<<", "<<a[i].w<<", "<<a[i].rel<<", "<<a[i].a<<std::endl;
        } else {
            a[i].a = cap / a[i].w;
            std::cout<<"object o with "<<a[i].v<<", "<<a[i].w<<", "<<a[i].rel<<", "<<a[i].a<<std::endl;
            break;
        }
    }
}

int main() {
    srand(time(0));

    object a[n];
    for (int i = 0; i < n; i++) {
        object o;
        a[i] = o;
        a[i].v = rand() % 51;
        a[i].w = rand() % 201;
        a[i].rel = 0;
        a[i].a = 0;
    }
    double cap = rand() % 1001;

    std::cout<<cap<<std::endl;

    Backpackfill(a, cap);

    return 0;
}


//wäre für V2 schlecht da "Lücken" nicht gefüllt werden => in V2 müsste man nach größentechnisch passenden objekten suchen