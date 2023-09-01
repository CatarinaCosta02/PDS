package EX1;

import java.util.ArrayList;

public class Gestor implements Observer{
    String nome;
    ArrayList<Produto> produtos = new ArrayList<>();

    public Gestor(String nome) {
        this.nome = nome;
    }

    public void addProduct(Produto p){
        produtos.add(p);
        p.addObserver(this);
    }

     //produto, tempo max para dar bid
    public void startLeilao(Produto p, int timetobid) {
		p.fazerLeilao(timetobid);
	}

    public void notificar(Produto p, double valor){
        if (!produtos.contains(p)){
            System.out.println("Produto não existe");
        }
        if (!produtos.contains(p) && p.getState() == State.VENDAS){
            System.out.println("Produto não existe ou não está em leilão");
        }
    }

    @Override
    public void update(String message) {
        System.out.println(message);
    }

    @Override
    public String getType() {
        return "Gestor";
    }

    @Override
    public String getName() {
        return nome;
    }

    
}
