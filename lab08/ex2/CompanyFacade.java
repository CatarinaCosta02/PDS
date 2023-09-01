import java.util.ArrayList;
import java.util.List;

public class CompanyFacade extends Company{

    private int cardNum = 1;
    private Company company = new Company();
    private Parking parking = new Parking();
    private List<EmployeeCard> cards = new ArrayList<EmployeeCard>();
    private SocialSecurity socialSecurity = new SocialSecurity();
    private Insurance insurance = new Insurance();

    // will interact with the facade, not directly with the company
    public void admitEmployee(Person p, double salary) {
        Employee e = new Employee(p, salary);
        e.setEmpCard(this.cardNum);
        this.cardNum++;
        company.admitEmployee(p, salary);
        EmployeeCard card = new EmployeeCard(e);
        cards.add(card);
        System.out.println("Employee admitted new card created" + card.getCardNum());
        parking.allow(e, company);
        socialSecurity.regist(e);
        insurance.regist(e);
    }

    public Company getCompany() {
        return company;
    }
    
}
