public class App {
    public static void main (String[] args) {
        
        for (int i = 1; i <= 5; i++) {
            //MultiThread myThread = new MultiThread(i);
            //myThread.start();
            RunningThread myRunningThread = new RunningThread(i);
            Thread myThread = new Thread(myRunningThread);
            myThread.start();
        } 
    }
}
