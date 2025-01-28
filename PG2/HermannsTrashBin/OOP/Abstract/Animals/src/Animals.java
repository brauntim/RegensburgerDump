public abstract class Animals {
    protected String name;
    protected int weight;

    public abstract void sound();
}

class Sheep extends Animals {
    
    public Sheep(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        return this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void sound() {
        System.out.println("Määääähhh");
    }
}
