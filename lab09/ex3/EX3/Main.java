package EX3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        AddElementCommand<String> addCommand1 = new AddElementCommand<>("Elemento 1");
        AddElementCommand<String> addCommand2 = new AddElementCommand<>("Elemento 2");

        addCommand1.setCollection(collection);
        addCommand2.setCollection(collection);

        System.out.println("Início: " + collection);

        // Executar comandos
        addCommand1.execute();
        addCommand2.execute();
        System.out.println("Após adicionar elementos: " + collection);

        // Desfazer comandos
        addCommand1.undo();
        System.out.println("Desfazer adição do Elemento 1: " + collection);

        // Refazer comandos
        addCommand1.execute();
        System.out.println("Refazer adição do Elemento 1: " + collection);
    }
}
