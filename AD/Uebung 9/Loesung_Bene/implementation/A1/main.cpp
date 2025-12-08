#include "priorityQueue.hpp"

using p = std::pair<int, int>;
int main() {
    std::vector<p> v {p(1,2), p(2,1), p(4,2), p(5,3)};
    priorityQueue<int> a(v);
    std::cout << a << std::endl;
    std::cout << a.getMin() << std::endl;
    std::cout << a.extractMin() << std::endl;
    std::cout << a << std::endl;
}
