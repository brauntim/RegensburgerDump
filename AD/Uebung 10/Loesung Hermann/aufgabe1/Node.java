package AD.assigments.week10.aufgabe1;;

public class Node {
    public Node[] next;
    public int key;

    public Node(int key, int level) {
        this.key = key;
        this.next = new Node[level + 1];
    }
}
