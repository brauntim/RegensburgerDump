package AD.assigments.week9.aufgabe4;

public class LinearHash extends HashTable{

    public LinearHash(int capacity) {
            super(capacity);
    }

    @Override
    protected int probe(int startIndex, int i){
        return (startIndex + i) % table.length;
    }
}

    
