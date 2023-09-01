package ex2;

public class BurgerChef extends Chef{

    // This is a Java expression that generates a random integer between 10 and 30 (inclusive) and assigns it to the minutes variable.
    // had to created cus it was only passed to the sushi chef
    //private int minutes = 10 + (int)(Math.random() * ((30 - 10) + 1));

    private String speciality;

    public BurgerChef(){
        this.speciality = "burger";
    }

    @Override
    public void handleRequest(String request){
        if (canCook(request, this.speciality)){
            System.out.println("BurgerChef: Starting to cook " + request + ". Out in 19 minutes\n");
        }else{
            System.out.println("BurgerChef: I can't cook that\n");
            super.handleRequest(request);
        }
    }
    
}
