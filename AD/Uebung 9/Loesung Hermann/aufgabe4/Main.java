package AD.assigments.week9.aufgabe4;

public class Main {
    public static void insertValue(HashTable table, int... value) {
        for (int v : value) {
            table.insert(v);
        }
    }

    public static void main(String[] args) {
        int m = 11;
        
        HashTable linearTable = new LinearHash(m);
        HashTable squareTable = new SquareHash(m);
        HashTable doubleTable = new DoubleHash(m);

        insertValue(linearTable, 10,22,31,4,15,28,17,88,59);
        insertValue(squareTable, 10,22,31,4,15,28,17,88,59);
        insertValue(doubleTable, 10,22,31,4,15,28,17,88,59);

        
        System.out.println("Linear probing: ");
        linearTable.printTable();
        System.out.println("--------------------------");
        System.out.println("quadratic probing: ");
        squareTable.printTable();
        System.out.println("Double hashing: ");
        doubleTable.printTable();

        //Linear probing ascending order: 22, 88, null, null, 4, 15, 28, 17, 59, 31, 10
        //Quadratic probing ascending order: 22, 17, null, 59, 4. 88, 28, null, 15, 31, 10
        //Double hashing ascending order: 22, 88, 17, 15, 4, null, 28, null, 59, 31, 10
    }
}
