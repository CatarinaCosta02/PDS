package EX3;

import java.util.ArrayList;
import java.util.List;

public class AirTrafficPlaneMediator implements PlaneMediator {

    private List<Plane> planes;

    public AirTrafficPlaneMediator() {
        this.planes = new ArrayList<>();
    }
    @Override
    public void addPlane(Plane plane) {
        this.planes.add(plane);
    }

    @Override
    public void notifyPlane(Plane plane, String msg) {
        for (Plane otherPlane: planes ){
            if (otherPlane != plane){
                System.out.println("Plane " + plane.getNumber() + " sends message: " + msg);
                otherPlane.receive(msg);
            }
        }
    }
    
}
