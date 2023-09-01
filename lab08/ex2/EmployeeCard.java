
public class EmployeeCard {
    // Criação de um cartão de funcionário
    private int cardNum;
    private Employee employee;

    public EmployeeCard(Employee employee) {
        cardNum += 1;
        this.employee = employee;
    }

    public int getCardNum() {
        return cardNum;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String toString() {
        return "EmployeeCard{" + "cardNum=" + cardNum + ", employee=" + employee + '}';
    }


}
