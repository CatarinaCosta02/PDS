package e1;

// decidi fazer um adaptador para o Registos e Database, mas tambem podia para os Empregado e Employee
public class ReBaseAdaptor implements ReBaseInterface {
    private Database database;
    private Registos registos;

    public ReBaseAdaptor(Database database, Registos registos) {
        this.database = database;
        this.registos = registos;
    }

    public void addEmployee(Employee emp) {
        database.addEmployee(emp);
    }

    public void removeEmployee(int emp_num) {
        database.deleteEmployee(emp_num);
        registos.remove((int) emp_num);
    }

    public boolean isEmployee(int emp_num) {
        for (Employee emp : database.getAllEmployees()) {
            if (emp.getEmpNum() == emp_num) {
                return true;
            }
        }
        return registos.isEmpregado((int) emp_num);
    }
    

    public void insere(Empregado emp) {
        registos.insere(emp);
    }

    public void listaDeEmpregados(){

        System.out.println("Lista de empregados do Registos:");
        for (Empregado emp : registos.listaDeEmpregados()) {
            System.out.println(emp);
        }

        System.out.println("Lista de empregados do Database:");
        for (Employee emp : database.getAllEmployees()) {
            System.out.println(emp);
        }
    }
}