import random

class ListElement:
    def __init__(self, value):
        self.value = value
        self.next = None
    
    def set_next(self, next):
        self.next = next

    def get_next(self):
        return self.next
    
    def set_value(self, value):
        self.value = value
    
    def get_value(self) -> int:
        return self.value

class LinkedList:
    def __init__(self, value):
        self.first = ListElement(value)
        self.last = self.first

        self.size = 1
    
    def get_size(self) -> int:
        return self.size
    
    def insert_first(self, value):
        new_head = ListElement(value)
        old_head = self.first

        new_head.set_next(old_head)

        self.first = new_head

        if self.size == 1:
            self.last = self.first

        self.size += 1
    
    def print(self):
        print("Liste mit ", self.get_size(), " Elementen:")

        if self.get_size() > 0:
            current = self.first

            if self.get_size() > 100:
                for position in range(1, 99):
                    print(current.get_value(), end=", ")
                    current = current.get_next()
                
                print(current.get_value(), "...")

            else:
                for position in range(0, self.get_size() - 1):
                    print(current.get_value(), end=", ")
                    current = current.get_next()

                print(current.get_value())

        return

def test ():
    list = LinkedList(0)

    list.insert_first(1)

    list.print()

    return

def print_linkedList_by_firstElement(firstElement: ListElement):
    current = firstElement
    while current.get_next() is not None:
        print(current.get_value(), end = ", ")
        current = current.get_next()
    
    print(current.get_value())

def get_new_random_linkedList(size_of_list, min_value, max_value) -> LinkedList:
    if size_of_list > 0:
        list = LinkedList(random.randint(min_value, max_value))

        while list.get_size() < size_of_list:
            list.insert_first(random.randint(min_value, max_value))
        
        return list

def quicksort_linkedList(list: LinkedList):
    quicksort_linkedList_by_firstElement(list.first)

def quicksort_linkedList_by_firstElement(listElement: ListElement):
    if listElement is None or listElement.get_next() is None:
        return

    pivot = listElement
    pivot_value = pivot.get_value()
    last_left = None

    current = listElement.get_next()
    while current is not None:
        if current.get_value() <= pivot_value:
            last_left = pivot
            pivot = pivot.get_next()

            swap = pivot.get_value()
            pivot.set_value(current.get_value())
            current.set_value(swap)

        current = current.get_next()

    listElement.set_value(pivot.get_value())
    pivot.set_value(pivot_value)

    if last_left is None:
        quicksort_linkedList_by_firstElement(pivot.get_next())
    
    else:
        temp = last_left.get_next()
        last_left.set_next(None)

        quicksort_linkedList_by_firstElement(listElement)
        quicksort_linkedList_by_firstElement(pivot.get_next())

        last_left.set_next(temp)

def main ():
    list = get_new_random_linkedList(100, 0, 10)
    list.print()

    quicksort_linkedList(list)
    list.print()

    return

main()