package e3;

public class Emprestado implements State{

    @Override
    public void regista(Book book) {
        System.out.println("Operação não disponivel");
    }

    @Override
    public void requisita(Book book) {
        System.out.println("Operação não disponivel");
    }

    @Override
    public void reserva(Book book) {
        System.out.println("Operação não disponivel");
    }

    @Override
    public void devolve(Book book) {
        book.setState(new Disponivel());
    }

    @Override
    public void cancelaReserva(Book book) {
        System.out.println("Operação não disponivel");
    }

    public String toString(){
        return "[Emprestado]";
    }
    
}