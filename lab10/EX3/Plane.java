package EX3;

public class Plane {

    private int number;
    private PlaneMediator mediator;

    public Plane(int number, PlaneMediator mediator) {
        this.number = number;
        this.mediator = mediator;
    }

    public int getNumber() {
        return number;
    }

    public void receive(String msg) {
        System.out.println("Plane " + number + " received message: " + msg);
    }

    public void fly(){
        System.out.println("Plane " + number + " is flying");
        mediator.notifyPlane(this, "Plane " + number + " is flying");
    }
    
}
