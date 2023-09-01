import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WordSearchGenerator {
    public static void main(String[] args) throws FileNotFoundException{
        List<String> WordsKey = new ArrayList<>();
        int size=0;
        String iFile="", oFile="";
        boolean ThereIsOutput=false;
        
        //validate arguments
        if(args.length==0){
            System.out.println("ERRO : Argumentos em Falta \n Argumentos: -i <ficheiro input> -s <tamanho da sopa> -o <ficheiro output> ");
            System.exit(0);
        }
        
        if(!Arrays.stream(args).anyMatch("-i"::equals) || !Arrays.stream(args).anyMatch("-s"::equals)){
            System.out.println("ERRO : Argumentos em Falta \n Argumentos: -i <ficheiro input> -s <tamanho da sopa> -o <ficheiro output> ");
            System.exit(0);
        }

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-i")) {
                i++;
                if (i < args.length && !args[i].equals("-o") && !args[i].equals("-s")) {
                    iFile = args[i];
                } else {
                    System.err.println("ERRO: Ficheiro input inválido");
                    System.exit(0);
                }
            } else if (args[i].equals("-s")) {
                i++;
                if (i < args.length && !args[i].equals("-o") && !args[i].equals("-i")) {
                    size = Integer.parseInt(args[i]);
                } else {
                    System.err.println("ERRO: Tamanho inválido");
                    System.exit(0);
                }
            } else if (args[i].equals("-o")) {
                i++;
                if (i < args.length && !args[i].equals("-s") && !args[i].equals("-i")) {
                    oFile = args[i];
                    ThereIsOutput=true;
                }
            }
        }
        if (ThereIsOutput==false){  //se não houver arguemnto para o nome de saida
            oFile=iFile.replace(".txt", "")+"_result.txt";
            ThereIsOutput=true;
        }
        
        //ler ficheiro de entrada com listas de palavras 
        try {
            File wordlist = new File(iFile);
            Scanner sc = new Scanner(wordlist);
            String linha;

            while (sc.hasNextLine()){
                linha=sc.nextLine();
                String[] words = linha.split("[, ;]+");
                for (String word:words){
                    if (word.length()>=3){
                        WordsKey.add(word); 
                    }
                    else{
                        System.err.println("ERRO: As palavras têm de ter pelo menos 3 caracteres.");
                    }
                }
            }
            sc.close();
            } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }
        WordsKey.sort(Comparator.comparing(String::length));    //ordenar a lista do maior comprimento pra o menor
        Collections.reverse(WordsKey);

        
        try (PrintWriter out = new PrintWriter(new File("./"+oFile))) {    

            //create puzzle
            char[][] puzzle = new char[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    puzzle[i][j] = '.';
                }
            }
            
            //add words to puzzle
            int numTentativas;
            int x;
            int y;
            int direction;
            int wordLength;
            boolean valid;
            boolean done;
            for (String key: WordsKey){
                done=false;
                numTentativas=0;
                wordLength = key.length();
                while (numTentativas<1000 && done==false){
                    x = (int) (Math.random() * size);
                    y = (int) (Math.random() * size);
                    direction = (int) (Math.random() * 8);
                    valid=true;
                    switch (direction) {
                        case 0://up
                            if (x - wordLength < 0) {
                                numTentativas++;
                                break;
                            }
                            for (int i = 0; i < wordLength; i++) {
                                if (puzzle[x - i][y] != '.') {
                                    valid=false;
                                    break;
                                }
                            }
                            
                            if (valid) {
                                for (int i = 0; i < wordLength; i++) {
                                    puzzle[x - i][y] = key.charAt(i);
                                }
                                done=true;
                            }else{
                                numTentativas++;
                            }
                            break;
                            
                        case 1: //down
                            if (x + wordLength > size-1) {
                            numTentativas++;
                            break;
                            }
                            for (int i = 0; i < wordLength; i++) {
                                if (puzzle[x + i][y] != '.') {
                                    valid=false;
                                    break;
                                }
                            }

                            if (valid) {
                                for (int i = 0; i < wordLength; i++) {
                                    puzzle[x + i][y] = key.charAt(i);
                                }
                                done=true;
                            }else{
                                numTentativas++;
                            }
                            break;
                            

                        case 2://left
                            if (y - wordLength < 0) {
                                numTentativas++;
                                break;
                            }
                            for (int i = 0; i < wordLength; i++) {
                                if (puzzle[x][y-i] != '.') {
                                    valid=false;
                                    break;
                                }
                            }
                            
                            if (valid) {
                                for (int i = 0; i < wordLength; i++) {
                                    puzzle[x][y-i] = key.charAt(i);
                                }
                                done=true;
                            }else{
                                numTentativas++;
                            }
                            break;
                        
                        case 3://right
                            if (y + wordLength > size-1) {
                                numTentativas++;
                                break;
                            }
                            for (int i = 0; i < wordLength; i++) {
                                if (puzzle[x][y+i] != '.') {
                                    valid=false;
                                    break;
                                }
                            }
                            
                            if (valid) {
                                for (int i = 0; i < wordLength; i++) {
                                    puzzle[x][y+i] = key.charAt(i);
                                }
                                done=true;
                            }else{
                                numTentativas++;
                            }
                            break;

                        case 4://upleft
                            if (x - wordLength < 0 || y - wordLength<0) {
                                numTentativas++;
                                break;
                            }
                            for (int i = 0; i < wordLength; i++) {
                                if (puzzle[x - i][y - i] != '.') {
                                    valid=false;
                                    break;
                                }
                            }
                            
                            if (valid) {
                                for (int i = 0; i < wordLength; i++) {
                                    puzzle[x - i][y - i] = key.charAt(i);
                                }
                                done=true;
                            }else{
                                numTentativas++;
                            }
                            break;
                        

                        case 5://upright
                            if (x - wordLength < 0 || y + wordLength>size-1) {
                                numTentativas++;
                                break;
                            }
                            for (int i = 0; i < wordLength; i++) {
                                if (puzzle[x - i][y + i] != '.') {
                                    valid=false;
                                    break;
                                }
                            }
                            
                            if (valid) {
                                for (int i = 0; i < wordLength; i++) {
                                    puzzle[x - i][y + i] = key.charAt(i);
                                }
                                done=true;
                            }else{
                                numTentativas++;
                            }
                            break;
                        case 6://downleft
                            if (x + wordLength > size-1 || y - wordLength<0) {
                                numTentativas++;
                                break;
                            }
                            for (int i = 0; i < wordLength; i++) {
                                if (puzzle[x + i][y - i] != '.') {
                                    valid=false;
                                    break;
                                }
                            }
                            if (valid) {
                                for (int i = 0; i < wordLength; i++) {
                                    puzzle[x + i][y - i]= key.charAt(i);
                                }
                                done=true;
                            }else{
                                numTentativas++;
                            }
                            break;

                        case 7://downright
                            
                            if (x + wordLength > size-1 || y + wordLength>size-1) {
                                numTentativas++;
                                break;
                            }
                            for (int i = 0; i < wordLength; i++) {
                                if (puzzle[x + i][y + i] != '.') {
                                    valid=false;
                                    break;
                                }
                            }
                            
                            if (valid) {
                                for (int i = 0; i < wordLength; i++) {
                                    puzzle[x + i][y + i] = key.charAt(i);
                                }
                                done=true;
                            }else{
                                numTentativas++;
                            }
                            break;                                
                    }
                }
            }
            
            for (int i=0; i<size; i++){
                for (int j=0; j<size; j++){
                    if (puzzle[i][j] == '.'){
                        puzzle[i][j] = (char) (Math.random() * 26 + 'A');
                    }
                    else{
                        puzzle[i][j] = Character.toUpperCase(puzzle[i][j]);
                    }
                }
            }

            for (int i=0; i<size; i++){
                for (int j=0; j<size; j++){
                    System.out.print(puzzle[i][j]);
                    out.print(puzzle[i][j]);
                }
                System.out.println();
                out.println();
                
                
            }
            
            //print words
            int tab;
            String t="";
            for (String s: WordsKey){
                tab = (int) (Math.random()*3);
                switch (tab){
                    case 0: t=";";
                        break;
                    case 1: t=" ";
                        break;
                    case 2: t="\n";
                        break;
                }
                
                System.out.print(s+t);
                out.print(s+t);
                
            }


            
        }     
    }
}

    