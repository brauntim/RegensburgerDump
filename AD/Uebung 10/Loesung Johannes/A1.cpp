#include <random>
#include <ctime>

using namespace std;

struct SkipListNode {
    int value;
    SkipListNode* next;
    SkipListNode* down;
};

class SkipList {
    SkipListNode* head;
    int maxLevel;
    int size;
    double probability;

    SkipList(int maxLevel, double probability) {
        this->maxLevel = maxLevel;
        this->probability = probability;
        this->size = 0;
        this->head = new SkipListNode();
    }

    int randomLevel() {
        int level = 1;
        while (level < maxLevel && rand() % 2 == 0) {
            level++;
        }
        return level;
    }

    void insert(int value) {
        SkipListNode* current = head;
        SkipListNode* last = nullptr;

        while (current != nullptr) {
            if (current->next != nullptr && current->next->value <= value) {
                current = current->next;
                continue;
            }
            
            if (current->down != nullptr) {
                last = current;
                current = current->down;
                continue;
            }
            
            SkipListNode* newNode = new SkipListNode();
            newNode->value = value;
            newNode->next = current->next;
            current->next = newNode;

            if (last != nullptr) {
                last->down = newNode;
            }

            last = newNode;
            current = current->down;
        }

        size++;
    }
};


int main() {
    srand(time(0));
}