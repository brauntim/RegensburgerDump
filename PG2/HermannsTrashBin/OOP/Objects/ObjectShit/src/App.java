public class App {
    public static void main(String[] args) throws Exception {
       Vehicle car = new Car("BMW", "white");

       System.out.println("Name: " + car.name + "\nColour: " + car.colour);
       car.drive();
        
    }
}
