package AD.assigments.week9.aufgabe1;

public class Main {

    public static void main(String[] args) {
        int size = 3;

        PriorityQueue<Character> list = new PriorityQueue<Character>(size);

        list.insert('a', 5);
        list.insert('c', 2);
        list.insert('b', 1);

        list.printQueue();
        System.out.println("Min Value: " + list.getMin());

        list.extractMin();
        list.printQueue();

        System.out.println("After decreasing key: ");
        list.DecreaseKey(0, 5);
        list.printQueue();
    }
}