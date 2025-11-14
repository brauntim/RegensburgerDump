#include <stdexcept>
#include <iostream>
class ring_list {
    /*
     * Keep in mind new node uses CopyConstructor and assignement operator
     */
    struct node {
        node* m_next; 
        int val;

        node(int value, node* next): m_next(next), val(value) {}
        friend std::ostream& operator<<(std::ostream& out, const node& in) {
            return out << in.val;
        }
    };


    node* m_head; 
    node* m_tail; 
public:

    void operator=(const ring_list) = delete;

    ring_list(): m_head(nullptr), m_tail(nullptr) {}
    ~ring_list() {
        this->flush();
    }
    const int& Head () const {
        if (m_head != nullptr) 
            return m_head->val;
        throw std::runtime_error("cannot return head of empty list");
    }
    void enqueue(int& newIn) {
        if (m_head == nullptr) {
            m_head = new node(newIn, m_head);
            m_tail = m_head;
        } else {
            m_tail->m_next = new node(newIn, m_head);
            m_tail = m_tail->m_next;
        }
    }
    int dequeue() {
        if (m_head != nullptr) {
            node* tmp = m_head->m_next;
            int res = m_head->val;
            delete m_head;
            m_head = tmp;
            m_tail->m_next = m_head;
            return res;
        }
        throw std::runtime_error("cannot dequeue empty list");
    }

    int dequeueAt(unsigned int index) {
        if (m_head == nullptr)
            throw std::runtime_error("cannot dequeue empty list");
        if (index == 0){
            node* next = m_head->m_next;
            int res = m_head->val;
            delete m_head;

            if (next == nullptr) {
                m_head = nullptr;
                m_tail = nullptr;
            } else {
                m_head = next; 
                m_tail->m_next = m_head;
            }

            return res;
        }
        node* tmp = m_head;
        node* prev;
        for (int i = 1; i <= index; i++) {
            prev = tmp;
            tmp = tmp->m_next;
        }
        prev->m_next = tmp->m_next;
        int res = tmp->val;
        delete tmp;
        return res;
    }

    void flush() {
        if (m_head != nullptr)
            m_tail->m_next = nullptr;
        while (m_head != nullptr) {
            node *tmp = m_head->m_next;
            delete m_head;
            m_head = tmp;
        }
        m_tail = nullptr;
    }

    void print() const {
        for (node *tmp = m_head; tmp != nullptr; tmp = tmp->m_next) {
            std::cout << *tmp << " ";
        }
        std::cout << std::endl;
    }

    int& operator[] (unsigned int index) {
        node *res = m_head;
        for (int i = 1; i <= index; i++) 
            res = res->m_next;
        return res->val;

    }
};
