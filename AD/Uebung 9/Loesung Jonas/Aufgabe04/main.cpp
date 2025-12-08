#include <iostream>
class Hashmap {
  class Cell {
    public:
      int value;
      bool is_used;
      bool was_used;

      Cell(): is_used {false}, was_used {false} {
      }
    
      void set_value(int new_value) {
        this->value = new_value;
        this->is_used = true;
        this->was_used = true;
      }
      void delete_value() {
        this->value = 0;
        this->is_used = false;
      }

      bool is_containing_value(int value) {
        if (this->is_used && this->value == value) {
          return true;
        } else {
          return false;
        }
      }
  };

  private:
    Cell * map_start;
    int size_of_map;

    int get_position_by_value(int value) {
      return value % this->size_of_map;
    }

    int get_insertPosition_by_quadraticProbing(int initial_position) {
      int result = initial_position;
      int y;

      for (int i = 1; i < this->size_of_map; i++) {
        result = (initial_position + (i * i) ) % this->size_of_map;

        if (this->map_start[result].is_used == false) {
          break;
        }

      }

      return result;
    }

    int get_insertPosition_by_doubleHashing(int value) {
      return 1 + (value % (this->size_of_map - 1));
    }

    int get_insertPosition_by_linearProbing(int initial_position) {
      int result = initial_position;

      for (int i = 0; i < this->size_of_map; i++) {
        if (result == this->size_of_map - 1) {
          result = 0;

        } else {
          result += 1;

        }

        if (this->map_start[result].is_used == false) {
          break;
        }
      }

      return result;
    }
    
    int search_value_by_linearProbing(int value_to_delete) {
      int position = this->get_position_by_value(value_to_delete);
      int result = -1;

      for (int i = 0; i < this->size_of_map; i++) {
        if (this->map_start[position].was_used == false) {
          break;
        }

        if (this->map_start[position].is_used && this->map_start[position].value == value_to_delete) {
          result = position;
          break;
        }

        if (position == this->size_of_map - 1) {
          position = 0;

        } else {
          position += 1;

        }
      }

      return result;
    }


    int search_value_by_quadraticProbing(int value) {
      int initial_position, current_position, result;

      initial_position = this->get_position_by_value(value);
      result = -1;

      for (int i = 0; i < this->size_of_map; i++) {
        current_position = (initial_position + (i * i)) % this->size_of_map;

        if (this->map_start[current_position].was_used) {
          if (this->map_start[current_position].is_containing_value(value)) {
            result = current_position;
            break;
          }

        } else {
          break;
        }

      }

      return result;
    }

    int search_value_by_doubleHashing(int value) {
      int position, result;

      position = this->get_position_by_value(value);
      result = -1;

      if (this->map_start[position].was_used) {
        if (this->map_start[position].is_containing_value(value)) {
          result = position;

        } else {
          position = 1 + (value % (this->size_of_map - 1));

          if (this->map_start[position].is_containing_value(value)) {
            result = position;

          }
        }
      }

      return result;
    }

  public:
    Hashmap(int initial_size): map_start {new Cell [initial_size]}, size_of_map {initial_size} {
    }
    ~Hashmap() {
      delete [] this->map_start;
    }

    void insert_value(int new_value) {
      int position = get_position_by_value(new_value);

      if (this->map_start[position].is_used) {
        position = get_insertPosition_by_quadraticProbing(position);

      }

      this->map_start[position].set_value(new_value);
    }

    void print() {
      for (int i = 0; i < this->size_of_map-1; i++) {
        std::cout<<this->map_start[i].value<<", ";
      }
      std::cout<<this->map_start[size_of_map-1].value<<std::endl;
    }

    void delete_value(int value_to_delete) {
      int position = this->search_value_by_quadraticProbing(value_to_delete);

      if (position != -1) {
        this->map_start[position].delete_value();

      }
    }
};

int main () {
  Hashmap * map = new Hashmap(11);

  const int SIZE_OF_VALUES = 9;
  int values [SIZE_OF_VALUES] = {10, 22, 31, 4, 15, 28, 17, 88, 59};

  for (int i = 0; i < SIZE_OF_VALUES; i++) {
    map->insert_value(values[i]);
  }

  map->print();

  map->delete_value(4);
  map->delete_value(20);

  map->print();

  return 0;
}
