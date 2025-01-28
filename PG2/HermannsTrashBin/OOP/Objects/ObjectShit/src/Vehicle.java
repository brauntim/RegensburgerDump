public abstract class Vehicle {
    public String name;
    public String colour;

    public abstract void drive();
}

class Car extends Vehicle {
    public Car(String name, String colour) {
        this.name = name;
        this.colour = colour;
    }
    public void drive() {
        System.out.println("The car is driving!");
    }
}
