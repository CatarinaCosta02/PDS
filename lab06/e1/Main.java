package e1;

public class Main {
    public static void main(String[] args) {
    
        // Test Registos
        Registos registos = new Registos();
        
        Empregado emp1 = new Empregado("João", "Silva", 1, 1000);
        Empregado emp2 = new Empregado("Maria", "Santos", 2, 1500);
        
        registos.insere(emp1);
        registos.insere(emp2);
        
        System.out.println("Lista de empregados:");
        for (Empregado emp : registos.listaDeEmpregados()) {
            System.out.println(emp.nome() + " " + emp.apelido() + " - " + emp.salario());
        }
        
        registos.remove(2);
        
        System.out.println("Lista de empregados após remoção:");
        for (Empregado emp : registos.listaDeEmpregados()) {
            System.out.println(emp.nome() + " " + emp.apelido() + " - " + emp.salario());
        }
        
        // Test Database
        Database db = new Database();
        
        Employee employee1 = new Employee("John", 1001, 50000);
        Employee employee2 = new Employee("Jane", 1002, 60000);
        
        db.addEmployee(employee1);
        db.addEmployee(employee2);
        
        System.out.println("List of employees:");
        for (Employee emp : db.getAllEmployees()) {
            System.out.println(emp.getName() + " " + emp.getName() + " - " + emp.getSalary());
        }
        
        db.deleteEmployee(1002);
        
        System.out.println("List of employees after deletion:");
        for (Employee emp : db.getAllEmployees()) {
            System.out.println(emp.getName() + " " + emp.getName() + " - " + emp.getSalary());
        }
    }

}
