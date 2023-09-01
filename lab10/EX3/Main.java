package EX3;

public class Main {
    public static void main(String[] args) {
        AirTrafficPlaneMediator mediator = new AirTrafficPlaneMediator();

        Plane plane1 = new Plane(1, mediator);
        Plane plane2 = new Plane(2, mediator);
        Plane plane3 = new Plane(3, mediator);
        Plane plane4 = new Plane(4, mediator);

        mediator.addPlane(plane1);
        mediator.addPlane(plane2);
        mediator.addPlane(plane3);
        mediator.addPlane(plane4);

        plane1.fly();
    }
    
}
