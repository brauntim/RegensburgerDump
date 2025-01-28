public class App {
    public static void main(String[] args) throws Exception {
        Horse horse1 = new Horse();

        System.out.println("Name: " + horse1.getName());
        horse1.setName("Schimmel");
        System.out.println("Name: " + horse1.getName());
    }
}
