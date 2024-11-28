#include <iostream>

class LinkedListElement {
public:
    int value;
    LinkedListElement* next;

    // Speicher: O(log n)   (Stack, da rekursiv)
    // Laufzeit:
    // - average case: O(n log n)
    // - worst case: O(n^2)
    static LinkedListElement* sort(LinkedListElement* head) {
        if (head == nullptr) return nullptr;

        LinkedListElement* pivot = head;

        LinkedListElement* leq = nullptr;
        LinkedListElement* ge = nullptr;

        head = head->next;
        while (head) {
            if (head->value <= pivot->value) {
                LinkedListElement* tmp = head;
                head = head->next;
                tmp->next = leq;
                leq = tmp;
            }
            else {
                LinkedListElement* tmp = head;
                head = head->next;
                tmp->next = ge;
                ge = tmp;
            }
        }

        leq = sort(leq);
        ge = sort(ge);

        pivot->next = ge;
        if (leq) {
            LinkedListElement* tmp = leq;
            while (tmp->next) tmp = tmp->next;
            tmp->next = pivot;
            return leq;
        }
        return pivot;
    }
};

class LinkedList {
    LinkedListElement* head;

public:
    LinkedList() {
        head = nullptr;
    }

    void add(int value) {
        LinkedListElement* newElement = new LinkedListElement();
        newElement->value = value;
        newElement->next = head;
        head = newElement;
    }

    void sort() {
        head = LinkedListElement::sort(head);
    }

    void print() {
        LinkedListElement* tmp = head;
        while (tmp) {
            std::cout << tmp->value << " ";
            tmp = tmp->next;
        }
        std::cout << std::endl;
    }
};


int main() {
    LinkedList list;

    int numbers[] = { 5, 3, 7, 1, 9, 2, 8, 4, 6 };
    for (int i = 0; i < 9; i++) {
        list.add(numbers[i]);
    }

    list.sort();
    list.print();
    return 0;
}
