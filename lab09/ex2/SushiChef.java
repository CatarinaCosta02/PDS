package ex2;

public class SushiChef extends Chef {

    // This is a Java expression that generates a random integer between 10 and 30 (inclusive) and assigns it to the minutes variable.

    //private int minutes = 10 + (int)(Math.random() * ((30 - 10) + 1));

    private String speciality;

    public SushiChef(){
        this.speciality = "sushi";
    }

    @Override
    public void handleRequest(String request){
        if (canCook(request, this.speciality)){
            System.out.println("SushiChef: Starting to cook " + request + ". Out in 14 minutes\n");
        }
        else{
            System.out.println("SushiChef: I can't cook that\n");
            super.handleRequest(request);
        }
    }
    
}
