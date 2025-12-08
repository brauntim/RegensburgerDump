package AD.assigments.week9.aufgabe4;

public abstract class HashTable {
    protected Integer[] table;

    public HashTable(int capacity) {
        table = new Integer[capacity];
    }

    protected abstract int probe(int startIndex, int i);

    protected int hash(int key) {
        return key % table.length;
    }

    public void insert(int key) {
        int startIndex = hash(key); 

        for (int i = 0; i < table.length; i++) {
            int index = probe(startIndex, i);

            if (table[index] == null) {
                table[index] = key;
                return;
            } 
        }
        throw new RuntimeException("Hash table is full");
    }

    public void printTable() {
        for (int i = 0; i < table.length; i++) {
            System.out.println(i + ": " + table[i]);
        }
    }
}


