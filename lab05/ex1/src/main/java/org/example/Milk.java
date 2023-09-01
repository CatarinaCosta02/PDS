package org.example;

public class Milk extends PortionFactory implements Portion{

    public State getState() {
        return State.Liquid;
    }

    public Temperature getTemperature() {
        return Temperature.WARM;
    }

    @Override
    public String toString() {
        return "Milk: "+ "Temperature " + getTemperature() + " ,State " + getState() + "";
    }
    
}
