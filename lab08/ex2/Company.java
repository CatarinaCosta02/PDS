
import java.util.*;

public class Company {
	public static User user;
	private List<Employee> emps = new ArrayList<>();

	public void admitEmployee(Person p, double salary) {
		Employee e = new Employee(p, salary);
		emps.add(e);

	}

	public void paySalaries(int month) {
		for (Employee e : emps) {
			BankAccount ba = e.getBankAccount();
			ba.deposit(e.getSalary());
		}
	}

	public double getAvgSalary() {
		double sum = 0;
		int count = 0;
		for (Employee employee : emps) {
			sum += employee.getSalary();
			count++;
		}
		return sum / count;
	}

	public List<Employee> employees() {
		return Collections.unmodifiableList(emps);
	}

}