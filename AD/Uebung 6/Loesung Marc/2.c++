#include <stdio.h>
#include <iostream>
#include <ctime>
#include <stdlib.h>

typedef int object;
class element1 {
    public: object val;
    element1 *next;
};
class list1 {
    private: 
        element1 *head; // Zeiger auf den Anfang
        element1 *tail; // Zeiger auf das Ende
    public: 
        list1();
        ~list1();
        void Append(object o); // Fügt einen Wert hinzu
        void DeleteList(element1 *first); // Liste entfernen
        void DeleteValue(object o); // Wert entfernen
        void Print(); // Liste ausgeben
        void swap(element1 *a, element1 *b);
        void PreparePartition(int f,int l,int &p);
        void Quicksort(int f,int l);
        element1* GetElement(int n);
};
list1::list1() {
    head=NULL; tail=NULL; 
}
list1::~list1() {
    DeleteList(head);
    head=NULL; tail=NULL; 
}
void list1::Append(object o) {
    element1 *elem=new element1;
    elem->val=o;
    elem->next=NULL;
    if (tail==NULL) {
        head=elem; tail=elem;
    } else {
        tail->next=elem; tail=elem;
    }
}
void list1::DeleteValue(object o) {
        element1 *curr=head, *prev=NULL;
        while (curr!=NULL) {
        if (curr->val==o) {
            !prev ? head=curr->next : prev->next=curr->next;
            if (curr==tail) tail=prev;
            element1 *h=curr; curr=curr->next;
            delete h; 
        }
        else {
            prev=curr; curr=curr->next;
        } 
    } 
}
void list1::DeleteList(element1 *first) { 
    if (first != NULL) {
        if (first->next != NULL) DeleteList(first->next);
        delete first; 
    }
}
void list1::Print()
{ 
    element1 *curr=head;
    while (curr->next!=NULL) {
        std::cout<<curr->val<<" ";
        curr=curr->next; 
    }
    std::cout<<std::endl;
}
element1* list1::GetElement(int n) {
    element1 *curr = head;
    for (int i = 1; curr != NULL && i < n; i++) {
        curr = curr->next;
    }
    return curr;
}
void list1::swap(element1 *a, element1 *b)
{
    if (a == b) return;
    object tmp = a->val;
    a->val = b->val;
    b->val = tmp;
}
void list1::PreparePartition(int f, int l, int &p) {
    element1* pivot = GetElement(f);
    p = f - 1;
    for (int i = f; i <= l; i++) {
        element1* temp = GetElement(i);
        if (temp->val <= pivot->val) {
            p++;
            element1* elemp = GetElement(p);
            swap(temp, elemp);
        }
    }
    element1* elem1 = GetElement(f);
    element1* elem2 = GetElement(p);
    swap(elem1, elem2);
}
void list1::Quicksort(int f, int l) {
    int part;
    if (f<l) {
        PreparePartition(f, l, part);
        Quicksort(f, part-1);
        Quicksort(part + 1, l);
    }
}

int main() {
    list1 list;
    const int n = 10;

    srand(time(0));

    for (int i = 0; i  < n; i++) {
        object o = rand() % 51;
        list.Append(o);
    }

    list.Print();
    list.Quicksort(1, n);
    list.Print();

    return 0;
}