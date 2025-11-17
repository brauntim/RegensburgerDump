#include <stdio.h>
#include <iostream>
#include <ctime>
#include <stdlib.h>

typedef int object;
class element1 {
    public: 
        object val;
        element1 *next;
};
class list1 {
    private: 
        element1 *head; // Zeiger auf den Anfang
    public: 
        list1();
        ~list1();
        void Append(object o); // Fügt einen Wert hinzu
        void DeleteList(element1 *first); // Liste entfernen
        void DeleteValue(object o); // Wert entfernen
        void Print(); // Liste ausgeben
        void lotto(int s[]);
};
list1::list1() {
    head=NULL; 
}
list1::~list1() {
    DeleteList(head);
    head=NULL;
}
void list1::Append(object o) {
    element1 *elem=new element1;
    elem->val=o;
    elem->next=head;
    if (head==NULL) {
        head=elem;
    } else {
        element1 *cur = head;
        if (cur->next) {
            while (cur->next != head) {
                cur = cur->next;
            }
            cur->next = elem;
        } else {
            cur->next = elem;
        }
    }
}
void list1::DeleteList(element1 *first)
{ 
    if (first != NULL) {
        if (first->next != head)
        DeleteList(first->next);
        delete first; 
    }
}
void list1::Print()
{ 
    element1 *curr=head;
    while (curr->next!=head) {
        std::cout<<curr->val<<" ";
        curr=curr->next; 
    }
    std::cout<<std::endl;
}
void list1::DeleteValue(object o) {
    element1 *curr=head, *prev=NULL;
    while (curr->next!=head) {
        if (curr->val==o) {
            if (prev==NULL) {
                head=curr->next;
            } else {
                prev->next=curr->next;
            }
            element1 *h=curr; curr=curr->next;
            delete h; 
        } else {
            prev=curr; curr=curr->next;
        } 
    } 
    if (curr->next == head) {
        if (curr->val == o) {
            prev->next = head;
            delete curr;
        }
    }
}

void list1::lotto(int s[]) {
    int i;
    for (i = 1; i <= 50; i++) {
        object o = i;
        Append(o);
    }
    Print();
    for (i = 0; i < 6; i++) {
        element1 *curr = head;
        element1 *prev = NULL;
        while (s[i] != 0) {
            prev = curr;
            curr = curr->next;
            s[i]--;
        }
        std::cout<<curr->val<<" ";
        prev ? prev->next = curr->next : head = curr->next;
        delete curr;
    }
    std::cout<<std::endl;
    Print();
}

int main () {
    srand(time(0));

    int s[6];
    for (int i = 0; i < 6; i++) {
        s[i] = (rand() % (50 - i)) + 1;
        std::cout<<s[i]<<" ";
    } 
    std::cout<<std::endl;

    list1 list;
    list.lotto(s);

    return 0;
}