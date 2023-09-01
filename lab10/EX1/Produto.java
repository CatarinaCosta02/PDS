package EX1;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Produto {

    int id = 0;
    String descricao;
    double preco;
    State state;
    Date startTime;
    int maxTime = 0;
    List<Observer> participantes;

    public Produto(int id, String descricao, double preco){
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.state = State.STOCK;
        this.participantes = new ArrayList<>();
    }

    public boolean aposta(double valor, Observer observer){
        // começar o tempo de leilão
        Date currentTime = new Date(System.currentTimeMillis());
        int seconds = 0;

        if(startTime != null){
            seconds = (int)((currentTime.getTime() - startTime.getTime()) / 1000);
        }
        if(valor <= preco || this.state != State.LEILAO || seconds > maxTime || observer.getType() != "Client"){
            if(seconds > maxTime && valor > preco){
                state = State.VENDAS;
            }
            return false;
        }else{
            preco = valor;
            System.out.println("Elapsed " + seconds + " seconds.");
            notify(" New bid for " + valor + " by "+observer.getName()+" for "+this.descricao);
        }
        return true;
    }

    public boolean addObserver(Observer observer){
        // adicionar participante, se o leilão estiver a decorrer
        if(this.state == State.LEILAO){
            participantes.add(observer);
            return true;
        }else{
            return false;
        }
    }

    public void fazerLeilao(int mt){
        // iniciar leilão dum produtos
        this.state = State.LEILAO;
        this.startTime = new Date(System.currentTimeMillis());
        this.maxTime = mt;
    }

    public void notify(String message){
        // notificar todos os participantes
        for(Observer observer : participantes){
            observer.update("[" + observer.getType() + " - " + observer.getName() + "]" + message);
        }
    }

    public State getState() {
        return state;
    }

    
}
