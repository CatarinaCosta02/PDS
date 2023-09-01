package org.example;
public class PlasticBottle extends Container {
        public PlasticBottle(Portion portion) {
            super(portion);
        }

        @Override
        public String toString() {
            return "PlasticBottle with portion = " + getPortion().toString();
        }
}