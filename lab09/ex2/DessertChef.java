package ex2;

public class DessertChef extends Chef{

    //private int minutes = 10 + (int)(Math.random() * ((30 - 10) + 1));

    private String speciality;

    public DessertChef(){
        this.speciality = "dessert";
    }

    @Override
    public void handleRequest(String request){
        if (canCook(request, this.speciality)){
            System.out.println("DessertChef: Starting to cook " + request + ". Out in 17 minutes\n");
        }
        else{
            System.out.println("DessertChef: I can't cook that\n");
            super.handleRequest(request);
        }
    }
    
}
