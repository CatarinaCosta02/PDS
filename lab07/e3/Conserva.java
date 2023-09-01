package e3;

public class Conserva extends Item{
    private String name;
    private float weight;

    public Conserva(String name, float weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String draw(){
        return "Conserva " + name + "- Weight : " + weight;
    }

    @Override
    public String toString() {
        return "Conserva " + name + "- Weight : " + weight;
    }
}