#include <cstdint>
template <typename T>
class PriorityQueue {
  struct Node {
    T whatever;
    int priority;
  };

  private:
    Node * list;
    unsigned int size_of_list;
    unsigned int nr_of_used_elements;

    void increase_list_size(unsigned int factor_to_increase_by);
    unsigned int get_position_of_min();

  public:
    PriorityQueue();
    ~PriorityQueue();

    void insert_value(T new_value, int priority);
    T get_min();
    T extract_min();
    void decrease_key_of_value(unsigned int position, int new_priority);
};

template <typename T>
PriorityQueue<T>::PriorityQueue(): list {new Node [1]}, size_of_list {1}, nr_of_used_elements {0} {
}

template <typename T>
PriorityQueue<T>::~PriorityQueue() {
  delete [] this->list;
}

template <typename T>
void PriorityQueue<T>::increase_list_size(unsigned int factor_to_increase_by) {
  int new_size_of_list = this->size_of_list * factor_to_increase_by;
  Node * new_list = new Node [new_size_of_list];

  for (int i = 0; i < this->size_of_list; i++) {
    new_list[i] = this->list[i];
  }

  delete [] this->list;
  this->list = new_list;
  this->size_of_list = new_size_of_list;
}

template <typename T>
void PriorityQueue<T>::insert_value(T new_value, int priority) {
  if (this->size_of_list == this->nr_of_used_elements) {
    this->increase_list_size(2);
  }

  this->list[this->nr_of_used_elements].whatever = new_value;
  this->list[this->nr_of_used_elements].priority = priority;
  this->nr_of_used_elements += 1;
}

template <typename T>
unsigned int PriorityQueue<T>::get_position_of_min() {
  unsigned int result = 0;

  for (int i = 1; i < this->nr_of_used_elements; i++) {
    if (this->list[i].priority < this->list[result].priority) {
      result = i;
    }
  }

  return result;
}

template <typename T>
T PriorityQueue<T>::get_min() {
  return this->list[this->get_position_of_min()].whatever;
}

template <typename T>
T PriorityQueue<T>::extract_min() {
  unsigned int position_of_min = this->get_position_of_min();
  T result = this->list[position_of_min].whatever;

  for (unsigned int i = position_of_min; i < this->nr_of_used_elements-1; i++) {
    this->list[i] = this->list[i+1];
  }

  this->nr_of_used_elements -= 1;

  return result;
}

template <typename T>
void PriorityQueue<T>::decrease_key_of_value(unsigned int position, int new_priority) {
  if (position < this->nr_of_used_elements) {
    this->list[position].priority = new_priority;
  }
}

int main () {
  PriorityQueue<char> * queue = new PriorityQueue<char>();

  queue->insert_value('a', 1);
  queue->insert_value('b', 7);
  queue->insert_value('Z', 3);

  char min = queue->get_min();
  queue->decrease_key_of_value(1, -12);
  min = queue->extract_min();

  return 0;
}
