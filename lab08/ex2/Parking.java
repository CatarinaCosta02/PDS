import java.util.ArrayList;
import java.util.List;

public class Parking {

    private List<Employee> empsPark = new ArrayList<>();

    public boolean allow(Employee e, Company company) {
        if (e.getSalary() > company.getAvgSalary()) {
            System.out.println("Employee allowed to park");
            empsPark.add(e);
            return true;

        } else {
            System.out.println("Employee not allowed to park");
            return false;
        }
    }
    
    public List<Employee> getEmpsPark() {
        return empsPark;
    }

}
