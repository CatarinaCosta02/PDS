package e3;

public class Disponivel implements State{

    @Override
    public void regista(Book book) {
        System.out.println("Operação não disponivel");
    }

    @Override
    public void requisita(Book book) {
        book.setState(new Emprestado());
    }

    @Override
    public void reserva(Book book) {
        book.setState(new Reservado());
    }

    @Override
    public void devolve(Book book) {
        System.out.println("Operação não disponivel");
    }

    @Override
    public void cancelaReserva(Book book) {
        System.out.println("Operação não disponivel");
    }

    public String toString(){
        return "[Disponivel]";
    }
    
}