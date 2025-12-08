package AD.assigments.week9.aufgabe1;

public class PriorityQueue<T> {
    private Node<T>[] node;
    private int size;

    public PriorityQueue(int size) {
        this.size = size;
        node = new Node[size];
        
        for (int i = 0; i < size; i++) {
            node[i] = new Node<T>(null, 0);
        }
    }

    public void insert(T new_element, int priority) {
        int position = 0;
        while (node[position].element != null) {
            position = (position + 1) % size;
        }
        
        node[position].element = new_element;
        node[position].priority = priority;
    }

    public int getMinIndex() {
        int min_index = -1;
        int min_Priority = Integer.MAX_VALUE;

        for (int i = 0; i < size; i++) {

            if (node[i].priority < min_Priority) {
                min_Priority = node[i].priority;
                min_index = i;
            }
        } 
        return min_index; 
    }

    public T getMin() {
        int min_index = getMinIndex();
        if(min_index == -1) return null;
        return node[min_index].element;
    }

    public T extractMin() {
        int min_index = getMinIndex();

        T min_element = node[min_index].element;

        node[min_index].element = null;
        node[min_index].priority = 0;

        int next_index = (min_index + 1) % size;

        while (node[next_index].element != null) {
            T element = node[next_index].element;
            int prio = node[next_index].priority;

            node[next_index].element = null;
            node[next_index].priority = 0;

            insert(element, prio);

            next_index = (next_index + 1) % size;
        }
        return min_element;
    }

    public void DecreaseKey(int index, int amount) {
        T element = node[index].element;
        int new_priority = node[index].priority - amount;

        node[index].element = null;
        node[index].priority = 0;

        int next_index = (index + 1) % size;

        while (node[next_index].element != null) {
            T tmp_element = node[next_index].element;
            int tmp_prio = node[next_index].priority;

            node[next_index].element = null;
            node[next_index].priority = 0;

            insert(tmp_element, tmp_prio);

            next_index = (next_index + 1) % size;
        }
        // new insert with decreased key
        insert(element, new_priority);
    }

    public void printQueue() {
        for (int i = 0; i < size; i++) {
            if (node[i].element != null) {
                System.out.println(node[i].element + ": " + node[i].priority);
            }
        }
    }
}
