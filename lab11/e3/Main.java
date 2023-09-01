package e3;

public class Main {
    public static void main(String[] args) {
        
        Biblioteca biblioteca = new Biblioteca();
        
        Book book = new Book("Java", 123, 2019, "João");
        Book book2 = new Book("A Biblia", 456, 0, "Deus");
        Book book3 = new Book("Java Anti-Stress", 789, 2017, "Khumatkli");
        Book book4 = new Book("Os Maias", 101, 1888, "Eça de Queiroz");

        biblioteca.addBook(book);
        biblioteca.addBook(book2);
        biblioteca.addBook(book3);
        biblioteca.addBook(book4);

        biblioteca.operations();


        
    }
}
