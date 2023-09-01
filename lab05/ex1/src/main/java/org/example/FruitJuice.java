package org.example;

public class FruitJuice extends PortionFactory implements Portion{

    public State getState() {
        return State.Liquid;
    }

    public Temperature getTemperature() {
        return Temperature.COLD;
    }

    @Override
    public String toString() {
        return "FruitJuice: "+ "Temperature " + getTemperature() + " ,State " + getState() + "";
    }

    

    
}
