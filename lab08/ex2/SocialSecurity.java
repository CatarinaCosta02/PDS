import java.util.ArrayList;
import java.util.List;

public class SocialSecurity {

    private List<Employee> emps = new ArrayList<>();

    public void regist(Employee e) {
        emps.add(e);
        System.out.println("Employee registered");
    }

    public List<Employee> getEmps() {
        return emps;
    }

}
