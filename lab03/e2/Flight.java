package e2;
import java.util.*;

public class Flight {
    private String code;
    public Airplane plane;
    // numero da reserva
    public Map<Integer,Reservation> reservations = new HashMap<Integer,Reservation>();

    public Flight(String code, Airplane plane) {
        this.code = code;
        this.plane = plane;
    }

    public String getCode() {
        return code;
    }

    public Airplane getPlane() {
        return plane;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPlane(Airplane plane) {
        this.plane = plane;
    }

    
}
