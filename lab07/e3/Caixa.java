package e3;

import java.util.ArrayList;
public class Caixa extends Item{ 

    private String name;
    private float weight;
    private ArrayList<Item> itens = new ArrayList<Item>();
    private float total;
    static StringBuilder sb = new StringBuilder();

    public Caixa(String name, float weight){
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public String draw() {
        for(Item i : itens){
            if (i instanceof Caixa){
                this.total += ((Caixa) i).getTotal();
            }
        }
        this.total += this.weight;

        System.out.println(sb.toString() + "* " + this.toString());
        sb.append("    ");
        for (Item i : itens){
            if (i instanceof Caixa){
                i.draw();
            }
            else{
                System.out.println(sb.toString() + "* " + i.toString());
            }
        }
        sb.setLength(sb.length() - 4);
        return sb.toString();
    }

	public void add(Item item) {
        this.itens.add(item);
        this.total += item.getWeight();
        
	}  

    public float getTotal() {
        float total = 0;
        for (Item item : itens) {
            total += item.getWeight();
        }
        return weight + total;
    }

    // make me a toString() method
    @Override
    public String toString() {
        return "Caixa " + name + "[ Weight: " + weight + "; Total: " + getTotal() + "]";
    }
    
}