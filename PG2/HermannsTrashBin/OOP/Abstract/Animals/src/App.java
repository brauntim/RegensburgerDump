public class App {
    public static void main(String[] args) throws Exception {
        Sheep sheep = new Sheep("Shawn", 25);

        System.out.println(sheep.getName() + " weighting " + sheep.getWeight());
        sheep.sound();

    }
}
