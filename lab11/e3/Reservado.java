package e3;

public class Reservado implements State{

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
        System.out.println("Operação não disponivel");
    }

    @Override
    public void cancelaReserva(Book book) {
        book.setState(new Disponivel());
    }

    public String toString() {
		return "[Reservado]";
	}
    
}