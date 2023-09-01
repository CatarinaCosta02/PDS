package org.example;

public class Tuna extends PortionFactory implements Portion{

    public State getState() {
        return State.Solid;
    }

    public Temperature getTemperature() {
        return Temperature.COLD;
    }

    @Override
    public String toString() {
        return "Tuna: "+ "Temperature " + getTemperature() + " ,State " + getState() + "";
    }
    
}
