package e1;

public interface ReBaseInterface {
    // created an adaptor interface for Database and Resgistos
    public void addEmployee(Employee emp);
    public void insere (Empregado emp);
    public void removeEmployee(int emp_num);
    public boolean isEmployee(int emp_num);
    public void listaDeEmpregados();

}

