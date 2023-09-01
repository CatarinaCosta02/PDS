package org.example;

public class PortionFactory{

    public static Portion create(String product, Temperature temperature) {
        //throw new UnsupportedOperationException("Unimplemented method 'create'");
        if (product.equals("Meat") && temperature.equals(Temperature.WARM)) {
            return new Pork();
        } else if (product.equals("Meat") && temperature.equals(Temperature.COLD)) {
            return new Tuna();
        } else if (product.equals("Beverage") && temperature.equals(Temperature.WARM)) {
            return new Milk();
        } else if (product.equals("Beverage") && temperature.equals(Temperature.COLD)) {
            return new FruitJuice();
        } else {
            return null;
        }
    }

    // condição que possa devolver qualquer um dos 4 tipos de comida

}
