package ex2;

public class PizzaChef extends Chef{

    //private int minutes = 10 + (int)(Math.random() * ((30 - 10) + 1));

    private String speciality;

    public PizzaChef(){
        this.speciality = "pizza";
    }

    @Override
    public void handleRequest(String request){
        if (canCook(request, this.speciality)){
            System.out.println("PizzaChef: Starting to cook " + request + ". Out in 7 minutes\n");
        }
        else{
            System.out.println("PizzaChef: I can't cook that\n");
            super.handleRequest(request);
        }
    }
    
}
