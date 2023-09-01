package ex2;

public class PastaChef extends Chef {

    //private int minutes = 10 + (int)(Math.random() * ((30 - 10) + 1));

    private String speciality;

    public PastaChef(){
        this.speciality = "pasta";
    }

    @Override
    public void handleRequest(String request){
        if (canCook(request, this.speciality)){
            System.out.println("PastaChef: Starting to cook " + request + ". Out in 14 minutes\n");
        }
        else{
            System.out.println("PastaChef: I can't cook that\n");
            super.handleRequest(request);
        }
    }
}
