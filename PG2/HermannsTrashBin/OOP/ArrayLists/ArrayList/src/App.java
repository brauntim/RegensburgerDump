import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<String> car = new ArrayList<String>();

        car.add("Volvo");
        car.add("BMW");

        System.out.println(car);
        for (String i : car) {
            System.out.println(i);
        }

        car.add(0, "Mercedes");
        System.out.println(car);

        System.out.println(car.size());

        car.set(0, "Opel");
        System.out.println(car);

        car.remove(0);
        System.out.println(car);

        car.clear();
        System.out.println(car);

    }
}
