package EX1;

public class Cliente implements Observer{
    String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    @Override
    public void update(String message) {
        System.out.println(message);
    }

    @Override
    public String getType() {
        return "Cliente";
    }

    @Override
    public String getName() {
        return nome;
    }

    public void licitar(Produto p, double valor){
        if(p != null){
            p.aposta(valor, this);
        }else{
            System.out.println("Não é possível licitar um produto que não existe");
        }
    }
    
}
