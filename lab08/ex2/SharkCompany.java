import java.util.*;        

public class SharkCompany {
	public static void main(String[] args) {
		Person[] persons= { new Person("Maria Silva"),
			new Person("Manuel Pereira"),
			new Person("Aurora Machado"),
			new Person("Augusto Lima") };
		Company shark= new Company();
		Company.user= User.COMPANY;
		/*shark.admitEmployee(persons[0], 1000);
		shark.admitEmployee(persons[1], 900);
		shark.admitEmployee(persons[2], 1200);
		shark.admitEmployee(persons[3], 1100);
		List<Employee> sharkEmps= shark.employees();
		for(Employee e: sharkEmps)
			System.out.println(e.getSalary());
		shark.paySalaries(1);
		*/

		// to test the façade ou pelo menos tentativa
		CompanyFacade cf = new CompanyFacade();
		cf.admitEmployee(persons[0], 1000);
		cf.admitEmployee(persons[1], 900);
		cf.admitEmployee(persons[2], 1200);
		cf.admitEmployee(persons[3], 1100);

		List<Employee> sharkEmps= shark.employees();
		
		String s;

		if (Company.user == User.COMPANY){
			s = "Company not allowed to park";
		}
		else{
			s = "OWNER allowed to park";
		}

		System.out.println("Seeing Balance of Bank accounts... " + s);
        for (Employee e : sharkEmps) {
            System.out.println(e.getBankAccount().balance());
        }
		// salaries
		for(Employee e: cf.getCompany().employees())
			System.out.println(e.getSalary());
		cf.getCompany().paySalaries(1);
		
		


		
	}
}
