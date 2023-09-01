package e1;

import java.util.concurrent.TimeUnit;

public class Start {
	public static void main(String[] args) throws InterruptedException {
		
		Product p1 = new Product(1,"p1", 1);
		Product p2 = new Product(2,"p2", 2);
		Product p3 = new Product(3,"p3", 3);
		Product p4 = new Product(4,"p4", 4);
		Product p5 = new Product(5,"p5", 5);
		
		Client c1 = new Client("c1");
		Client c2 = new Client("c2");
		Client c3 = new Client("c3");
		
		Manager m1 = new Manager("Herman Jose");
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
		c1.bid(p1, 10);
		
		TimeUnit.SECONDS.sleep(1);
		p2.addObserver(c3);
		c3.bid(p2, 20);
		
		p3.addObserver(c3);
		c3.bid(p3, 300);
		
		TimeUnit.SECONDS.sleep(1);
		p4.addObserver(c1);
		c1.bid(p4, 100);
	
		p5.addObserver(c2);
		c2.bid(p5, 200);
		
		TimeUnit.SECONDS.sleep(1);
		p1.addObserver(c2);
		c2.bid(p1, 20000); 
	}
}