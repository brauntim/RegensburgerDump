package AD.assigments.week10.aufgabe1;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    static final int MIN_VALUE = 0;
    static final int MAX_VALUE = 10;
    
    public static void main(String[] args) {
        SkipList list = new SkipList();
        
        list.init();

        for (int i = 0; i < list.getMaxLevel(); i++) {
            int random_value = ThreadLocalRandom.current().nextInt(MIN_VALUE, MAX_VALUE);
            list.insert(random_value);
        }

        list.printList();
    }
}
