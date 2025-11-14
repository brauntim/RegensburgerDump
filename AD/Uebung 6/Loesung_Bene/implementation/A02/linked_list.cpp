#include <stdexcept>
#include <iostream>
template<typename listT> class linked_list {
    /*
     * Keep in mind new node uses CopyConstructor and assignement operator
     */
    template<typename nodeT> struct node {
        node* next; 
        nodeT val;

        node(nodeT value): next(nullptr) {
            val = nodeT(value);
        }

        friend std::ostream& operator<< (std::ostream& out, const node& in) {
            return out << in.val;
        }
    };

    using element=node<listT>;

    element* m_head; 
    element* m_tail; 
    unsigned int len = 0;

    void QuickSortRec(int f,int l) {
        auto swap = [] (int &a, int &b) {
            int tmp = a;
            a = b;
            b = tmp;
        };
        auto PreparePartition = [swap] (linked_list<listT>& a, int f, int l, int &p) {
            int pivot = a[f]; 
            p = f-1;

            for (int i = f; i <= l; i++)
            {
                if (a[i] <= pivot){
                    p++; 
                    swap(a[i],a[p]);
                }
            }
            swap(a[f],a[p]);
        };

        int part;
        if (f<l) {
            PreparePartition(*this,f,l,part);
            QuickSortRec(f,part-1);
            QuickSortRec(part+1,l);
        }
    };
public:

    void operator=(const linked_list<listT>&) = delete;

    linked_list(): m_head(nullptr), m_tail(nullptr) {}
    ~linked_list() {
        this->flush();
    }
    const listT& Head () const {
        if (m_head != nullptr) 
            return m_head->val;
        throw std::runtime_error("cannot return head of empty list");
    }
    void enqueue(listT& newIn) {
        if (m_head == nullptr) {
            m_head = new element(newIn);
            m_tail = m_head;
        } else {
            m_tail->next = new element(newIn);
            m_tail = m_tail->next;
        }
        len++;
    }
    listT dequeue() {
        if (m_head != nullptr) {
            element* tmp = m_head->next;
            listT res = m_head->val;
            delete m_head;
            m_head = tmp;
            len--;
            return res;
        }
        throw std::runtime_error("cannot dequeue empty list");
    }
    void flush() {
        while (m_head != nullptr) {
            element *tmp = m_head->next;
            delete m_head;
            m_head = tmp;
        }
        m_tail = nullptr;
        len = 0;
    }

    void print() const {
        for (element *tmp = m_head; tmp != nullptr; tmp = tmp->next) {
            std::cout << *tmp << " ";
        }
        std::cout << std::endl;
    }

    listT& operator[] (int index) {
        if (index >= len) 
            throw std::runtime_error("index out of bounds");
        element *res = m_head;
        for (int i = 1; i <= index; i++) 
            res = res->next;
        return res->val;

    }

    void Quicksort() {
        QuickSortRec(0, len-1);
    }
};
