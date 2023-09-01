package org.example;


public class Taperware extends Container {
    public Taperware(Portion portion) {
        super(portion);
    }
    @Override
    public String toString() {
        return "Taperware with portion = " + getPortion().toString();
    }
}
    