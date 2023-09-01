package org.example;

public class Pork extends PortionFactory implements Portion{

    public State getState() {
        return State.Solid;
    }

    public Temperature getTemperature() {
        return Temperature.WARM;
    }

    @Override
    public String toString() {
        return "Pork: "+ "Temperature " + getTemperature() + " ,State " + getState() + "";
    }

    
    
}
