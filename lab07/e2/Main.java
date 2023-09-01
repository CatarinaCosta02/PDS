package e2;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Criar o leitor de texto
            TextReaderInterface reader = new TextReader("arquivo.txt");

            // Ler e imprimir o texto original
            System.out.println("Texto original:");
            while (reader.hasNext()) {
                System.out.println(reader.next());
            }

            // Ler e imprimir o texto com filtro de termos
            reader = new TermFilter(new TextReader("arquivo.txt"));
            System.out.println("\nTexto com filtro de termos:");
            while (reader.hasNext()) {
                System.out.println(reader.next());
            }

            // Ler e imprimir o texto com filtro de normalização
            reader = new NormalizationFilter(new TextReader("arquivo.txt"));
            System.out.println("\nTexto com filtro de normalização:");
            while (reader.hasNext()) {
                System.out.println(reader.next());
            }

            // Ler e imprimir o texto com filtro de vogais
            reader = new VowelFilter(new TextReader("arquivo.txt"));
            System.out.println("\nTexto com filtro de vogais:");
            while (reader.hasNext()) {
                System.out.println(reader.next());
            }

            // Ler e imprimir o texto com filtro de capitalização
            reader = new CapitalizationFilter(new TextReader("arquivo.txt"));
            System.out.println("\nTexto com filtro de capitalização:");
            while (reader.hasNext()) {
                System.out.println(reader.next());
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
        }
    }

}