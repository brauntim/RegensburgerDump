#include <vector>
#include <utility>
#include <stdexcept>
#include <iostream>

template<typename T> class priorityQueue {
    std::vector<std::pair<int, T>> values;

    void sort(); //T(n) = Theta(n log n)
    void buildMinHeap();//T(n) = Theta(n log n)
    void minHeapify(int, int, int);//T(n) = Theta(log n)
    void swap(std::pair<int, T>&, std::pair<int, T>&);

public:
    priorityQueue(std::vector<std::pair<int, T>> = std::vector<std::pair<int, T>>());
    void insert(T, int);
    T getMin();
    T extractMin();
    void decreaseKey(unsigned int, unsigned int);

    template<typename U> friend std::ostream& operator<<(std::ostream&, const priorityQueue<U>&);
};

template<typename T> 
priorityQueue<T>::priorityQueue(std::vector<std::pair<int, T>> values) : values(values) {
    sort();
}

//interface member function
template<typename T> void priorityQueue<T>::insert(T element, int key) {
    values.push_back(std::pair<int, T> (key, element)); //T(n) = Theta(n)
    sort();
}

template<typename T> T priorityQueue<T>::getMin() {
    if (values.empty())
        throw std::runtime_error("priorityQueue is empty");
    return values.front().second; //T(n) = Theta(1)
}

template<typename T> T priorityQueue<T>::extractMin() {
    if (values.empty())
        throw std::runtime_error("priorityQueue is empty");
    T res = values.front().second;//T(n) = Theta(1)
    values.erase(values.begin()); //T(n) = Theta(1)
    sort();
    return res;
}

template<typename T> 
void priorityQueue<T>::decreaseKey(unsigned int pos, unsigned int delta) {
    if (pos >= values.size())
        throw std::runtime_error("index out of bounds");
    values[pos].first -= delta;
}

//private members
template<typename T> 
void priorityQueue<T>::swap(std::pair<int, T> &a, std::pair<int, T> &b) {
    std::pair<int, T> tmp = a;
    a = b;
    b = tmp;
}
template<typename T> void priorityQueue<T>::buildMinHeap() { //T(n) = Theta(n log n)
    int lastIndex = values.size() - 1;
    int startPos  = (lastIndex - 1) / 2;
    for (int i = startPos; i>=0; i--)
        minHeapify(i, 0, lastIndex);
}

template<typename T> void priorityQueue<T>::minHeapify(int root, int first, int last) { //T(n) = Theta(log n)
    int smallest;
    int left = first + root * 2 + 1;
    int right = left + 1;

    if (left <= last && values[root].first > values[left].first)
        smallest = left;
    else 
        smallest = root;
    if (right <= last && values[smallest].first > values[right].first)
        smallest = right;

    if (smallest != root) {
        swap(values[smallest], values[root]);
        minHeapify(smallest, first, last);
    }
}

template<typename T> void priorityQueue<T>::sort() { //T(n) = Theta(n log n)
    if (values.size() == 0) 
        return;
    buildMinHeap();
    for (int i = 0; i < values.size(); i++) {
        swap(values[i], values[0]);
        minHeapify(0, i-1, values.size() - 1);
    }
}

template<typename T> std::ostream& operator<<(std::ostream& out, const priorityQueue<T>& in) {
        for (std::pair<int, T> v : in.values) {
            out << "(k:" << v.first << "|v:" << v.second << ") ";
        }
        return out;
}
