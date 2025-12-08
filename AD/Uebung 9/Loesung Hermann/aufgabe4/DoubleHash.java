package AD.assigments.week9.aufgabe4;

public class DoubleHash extends HashTable{

    public DoubleHash(int capacity) {
        super(capacity);
    }

    @Override
    protected int probe(int startIndex, int i) {
        int startIndexTwo = 1 + (startIndex % (table.length - 1));
        return (startIndex + i * startIndexTwo) % table.length;
    }
}
