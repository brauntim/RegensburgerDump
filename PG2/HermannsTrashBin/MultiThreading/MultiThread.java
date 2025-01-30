public class MultiThread extends Thread {
    private int threadNumber;

    public MultiThread(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("the value " + i + " is from thread: " + threadNumber);

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }

}
