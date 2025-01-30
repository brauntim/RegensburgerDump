public class RunningThread implements Runnable{
    private int threadNumber;

    public RunningThread(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("the value " + i + " is from thread: " + threadNumber);

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}
