package e1;

public class Telefone {
    private String processador;
    private double preco;
    private int memoria;
    private String camera;
    
    // Getters e setters

    public Telefone (String processador, double preco, int memoria, String camera) {
        this.processador = processador;
        this.preco = preco;
        this.memoria = memoria;
        this.camera = camera;
    }

    public String getProcessador() {
        return processador;
    }

    public double getPreco() {
        return preco;
    }

    public int getMemoria() {
        return memoria;
    }

    public String getCamera() {
        return camera;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    @Override
    public String toString() {
        return "Telefone [camera=" + camera + ", memoria=" + memoria + ", preco=" + preco + ", processador="
                + processador + "]";
    }
    
}