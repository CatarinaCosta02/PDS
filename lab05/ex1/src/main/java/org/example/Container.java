package org.example;

public class Container{
    private Portion portion;
    
    public Container(Portion portion) {
        this.portion = portion;
    }

    public Portion getPortion() {
        return portion;
    }
 
    public static Container create(Portion menu) {
        switch(menu.getState()) {
            case Liquid:
                if(menu.getTemperature() == Temperature.COLD) {
                    return new PlasticBottle(menu);
                } else {
                    return new TermicBottle(menu);
                }    
            case Solid:
                if(menu.getTemperature() == Temperature.COLD) {
                    return new PlasticBag(menu);
                } else {
                    return new Taperware(menu);
                }
            default:
                return null;
            }
        
    }
   
}