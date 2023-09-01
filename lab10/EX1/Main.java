package EX1;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Produto p1 = new Produto(1,"p1", 1);
		Produto p2 = new Produto(2,"p2", 2);
        Produto p3 = new Produto(3,"p3", 3);
        Produto p4 = new Produto(4,"p4", 4);
        Produto p5 = new Produto(5,"p5", 5);

		
		Cliente c1 = new Cliente("c1");
		Cliente c2 = new Cliente("c2");
		Cliente c3 = new Cliente("c3");
		
		Gestor m1 = new Gestor("Herman Jose");
		m1.addProduct(p1);
		m1.addProduct(p2);
		m1.addProduct(p3);
		m1.addProduct(p4);
		m1.addProduct(p5);
		
		
		m1.startLeilao(p1, 3);
		m1.startLeilao(p3, 3);
		m1.startLeilao(p4, 3);
		m1.startLeilao(p5, 3);
		
		p1.addObserver(c1);
		c1.licitar(p1, 10);
		
		TimeUnit.SECONDS.sleep(1);
		p2.addObserver(c3);
		c3.licitar(p2, 20);
		
		p3.addObserver(c3);
		c3.licitar(p3, 300);
		
		TimeUnit.SECONDS.sleep(1);
		p4.addObserver(c1);
		c1.licitar(p4, 100);
	
		p5.addObserver(c2);
		c2.licitar(p5, 200);
		
		TimeUnit.SECONDS.sleep(1);
		p1.addObserver(c2);
		c2.licitar(p1, 20000);
    }
}
