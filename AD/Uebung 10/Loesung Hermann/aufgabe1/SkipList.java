package AD.assigments.week10.aufgabe1;

/*
     Init(): Initialisiert eine leere Skip-Liste
     Deinit(): Deinitialisiert eine Skip-Liste
     Print(): Gibt die aktuelle Skip-Liste aus (z.B. auf der Konsole)
     Insert(key k): Fügt einen Schlüssel k in die Skip-Liste ein
     Delete(key k): Entfernt einen Schl¨ussel k aus der Skip-Liste
     Search(key k): Gibt true zurück, wenn der Schlüssel k in der Skip-Liste vorhanden
     ist, sonst false
*/

public class SkipList {
    private Node first;
    private int level;
    private int max_level;

    public void init() {
        max_level = 10;
        level = 0;
        first = new Node(Integer.MIN_VALUE, max_level);
    }

    public void deInit() {
        if (first != null) {
            for (int i = 0; i < first.next.length; i++) {
                first.next[i] = null;
            }
            first = null;
            level = 0;
        }
    }

    public void printList() {
        for (int i = level; i >= 0; i--) {
            System.out.println("Level " + i + ": ");
            Node curr = first.next[i];
            while (curr != null) {
                System.out.printf(curr.key + " ");
                curr = curr.next[i];
            }
            System.out.println("--------");
        }
    }

    public void insert(int key) {
        Node[] update = new Node[max_level + 1];
        Node curr = this.first;

        for (int i = level; i >= 0; i--) {
            while (curr.next[i] != null && curr.next[i].key < key) {
                curr = curr.next[i];
            }
            update[i] = curr;
        }

        curr = curr.next[0];

        if (curr == null || curr.key != key) {
            int lvl = randomLevel();

            if (lvl > level) {
                for (int i = level + 1; i <= lvl; i++) {
                    update[i] = first;
                }
                level = lvl;
            }

            Node new_node = new Node(key, lvl);
            for (int i = 0; i <= lvl; i++) {
                new_node.next[i] = update[i].next[i];
                update[i].next[i] = new_node;
            }
        }
    }

    public void delete(int key) {
        Node[] update = new Node[max_level + 1];
        Node curr = this.first;

        for (int i = level; i >= 0; i--) {
            while (curr.next[i] != null && curr.next[i].key < key) {
                curr = curr.next[i];
            }
            update[i] = curr;
        }

        curr = curr.next[0];

        if (curr != null && curr.key == key) {
            for (int i = 0; i <= level; i++) {
                if(update[i].next[i] != curr) {
                    break;
                }
                update[i].next[i] = curr.next[i];
            }

            while (level > 0 && first.next[level] == null){
                level--;
            }
        }
    }

    public boolean search(int key) {
        Node curr = this.first;
        boolean match = false;
        for (int i = level; i >= 0; i--) {
            while (curr.next[i] != null && curr.next[i].key < key) {
                curr = curr.next[i];
            }
        }
        curr = curr.next[0];
        
        if (curr != null && curr.key == key){
            match = true;
        }

        return match;
    } 
    
    // Found at the internet
    public int randomLevel() {
        int lvl = 0;
        while (Math.random() < 0.5 && lvl < max_level){
            lvl++;
        }
        return lvl;
    }

    public int getMaxLevel() {
        return this.max_level;
    }
}
