package e3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    List<Book> books = new ArrayList<Book>();

    public void addBook(Book book){
        books.add(book);
    }

    public List<Book> getBooks(){
        return books;
    }


    public void showCatalogo(){
        int maxSizeTitulo=0;
		int maxSizeAutor=0;
		int maxSizeEstado=0;
		
		for(Book book : books) {
			if(book.title().length()>maxSizeTitulo)
				maxSizeTitulo=book.title().length();
			
			if(book.author().length()>maxSizeAutor)
				maxSizeAutor=book.author().length();
			
			if(book.state().length()>maxSizeEstado)
				maxSizeEstado=book.state().length();
		}
		
		int counter=0;
		System.out.println("*** Biblioteca ***");
		for(Book book:books) {
			counter++;
               //alinhar 
			System.out.printf("%"+String.valueOf(Math.floor(books.size()/10)).length()+"d\t%-"+maxSizeTitulo+"s\t%-"+maxSizeAutor+"s\t%-"+maxSizeEstado+"s\n", counter, book.title(), book.author(), book.state());
		}
		System.out.println("<livro>, <operação: (1)regista; (2)requisita; (3)devolve; (4)reserva; (5)cancela");
		System.out.println("");
    }

    public void operations(){
        while(true){
            showCatalogo();
            System.out.print(">> ");
            try (Scanner scanner = new Scanner(System.in)) {
                String input = scanner.nextLine();
                String[] resposta = input.split(",");

                if(resposta.length!=2){
                    System.out.println("Comando inválido");
                    continue;
                }

                Book book = books.get(Integer.parseInt(resposta[0]));
                if(resposta[1].equals("1")){
                    book.regista();
                }else if(resposta[1].equals("2")){
                    book.requisita();
                }else if(resposta[1].equals("3")){
                    book.devolve();
                }else if(resposta[1].equals("4")){
                    book.reserva();
                }else if(resposta[1].equals("5")){
                    book.cancelaReserva();
                }else{
                    System.out.println("Esta operação não existe");
                    continue;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

        }
    }
    
}
