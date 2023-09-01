package e3;

public class Book{

    private String title;
    private int ISBN;
    private int year;
    private String author;
    State state;


    public Book(String title, int ISBN, int year, String author){
        this.title = title;
        this.ISBN = ISBN;
        this.year = year;
        this.author = author;
        this.state = new Inventario();  }


    public void setState(State state){
        this.state = state;
    }

    public void regista(){
        state.regista(this);
    }

    public void requisita(){
        state.requisita(this);
    }

    public void reserva(){
        state.reserva(this);
    }

    public void devolve(){
        state.devolve(this);
    }

    public void cancelaReserva(){
        state.cancelaReserva(this);
    }

    public String title(){
        return title;
    }

    public int ISBN(){
        return ISBN;
    }

    public int year(){
        return year;
    }

    public String author(){
        return author;
    }
    
    public String state()
    {
        return this.state.toString();
    }
    


}