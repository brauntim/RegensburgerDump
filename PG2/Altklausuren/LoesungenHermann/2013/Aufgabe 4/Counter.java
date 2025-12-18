public class Counter extends Thread{
    private static final int MAX_COUNT = 5;
    private static int currentCount = 1;
    private static final Object lock = new Object();

    @Override
    public void run() {
        while(true) {
            synchronized (lock) {
                if (currentCount > MAX_COUNT) {
                    break;
                }
                System.out.println("Counter 1: "+ currentCount);
                currentCount++;
                try {
                    sleep(100);
                } catch (InterruptedException e){
                    System.out.println(e);
                }
            }
        }
    }
}
