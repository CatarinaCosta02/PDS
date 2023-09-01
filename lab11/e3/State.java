package e3;
public interface State{
    public void regista(Book book);
    public void requisita(Book book);
    public void reserva(Book book);
    public void devolve(Book book);
    public void cancelaReserva(Book book);
    public String toString();
}