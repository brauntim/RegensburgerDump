public class Horse {
    private int weight;
    private int speed;
    private String name;

    public Horse() {
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getName() {
        return this.name;
    }

    public String setName (String name) {
        return this.name = name;
    }

    public void running() {
        System.out.println("Das Viech rennt wie sau");
    }
}
