public class App {
    public static void main(String[] args){
        try {
            method1();        
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void method1() {
        throw new RuntimeException("Something went wrong!");
    }
}
