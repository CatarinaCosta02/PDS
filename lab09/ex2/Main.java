package ex2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> ordersList = new ArrayList<>();
        ordersList.add("veggie burger");
        ordersList.add("Pasta Carbonara");
        ordersList.add("PLAIN pizza, no toppings!");
        ordersList.add("sushi nigiri and sashimi");
        ordersList.add("salad with tuna");
        ordersList.add("strawberry ice cream and waffles dessert");


        Chef chef = new BurgerChef().setNextChef(new PastaChef()).setNextChef(new PizzaChef()).setNextChef(new SushiChef()).setNextChef(new DessertChef());
        

        for (String order : ordersList) {
            System.out.println("Can I please get a " + order + "?");
            chef.handleRequest(order);
        }

    }

    
}
