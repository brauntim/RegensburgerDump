package AD.assigments.week9.aufgabe4;

public class SquareHash extends HashTable {
    public SquareHash(int capacity) {
        super(capacity);
    }

    @Override
    protected int probe(int startIndex, int i) {
        int c1 = 1;
        int c2 = 3;
        return (startIndex + c1 * i + c2 * (int) Math.sqrt(i)) % table.length;
    }
}
