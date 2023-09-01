import java.io.File;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;


public class Sopa{
    int size;
    char[][] puzzle;
    ArrayList<String> WordsToFind;
    
    public Sopa(String file){

        //read sopa01.txt
        try {
            File text = new File(file);
            Scanner sc = new Scanner(text);
            String linha = sc.nextLine();   //neste ponto, é a 1ªlinha
            size=linha.length();

            if (size>40){
                System.err.println("ERRO: o tamanho máximo é 40x40");
                System.exit(1);
            }

            //preencher a sopa de letras a partir do file
            puzzle = new char[size][size]; //puzzle quadrada de tamanho 'size'
            for (int line=0; line <size; line++){
                for (int col=0; col<size; col++){
                    puzzle[line][col]=linha.charAt(col);
                    if (puzzle[line][col]<'A' || puzzle[line][col]>'Z'){    //se não for letra maisucula
                        System.err.println("ERRO: as letras do puzzle têm de ser maiúsculas");
                        System.exit(1);
                    }
                    if (col==size-1){   //quando chegar ao fim da linha
                        if (line<size-1){   //se não for a ultima linha
                            linha=sc.nextLine();    //muda de linha
                        }
                    }
                }
            }

            WordsToFind = new ArrayList<String>();

            while (sc.hasNextLine()){
                linha=sc.nextLine();
                String[] words = linha.split("[, ;]+");
                for (String word:words){
                    if (word.length()>=3){
                        WordsToFind.add(word);
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
    }   

    //getters
    public int getSize(){
        return size;
    }

    public char[][] getPuzzle(){
        return puzzle;
    }

    public ArrayList<String> getWordsToFind(){
        return WordsToFind;
    }
    //



    //ArrayLists que contêm as linhas, colunas, diagonais, ...

    public ArrayList<String> horizontais(){
        ArrayList<String> h=new ArrayList<>();
        for (int i=0; i<size; i++){
            String s="";
            for (int j=0; j<size; j++){
                s+=puzzle[i][j];
            }
            h.add(s);
        }
        return h;
    }

    public ArrayList<String> horizontaisInv(){
        ArrayList<String> h_i=new ArrayList<>();
        for (int i=0; i<size; i++){
            String s="";
            for (int j=size-1; j>=0; j--){
                s+=puzzle[i][j];
            }
            h_i.add(s);
        }
        return h_i;
    }


    public ArrayList<String> verticais(){
        ArrayList<String> v=new ArrayList<>();
        for (int i=0; i<size; i++){
            String s="";
            for (int j=0; j<size; j++){
                s+=puzzle[j][i];
            }
            v.add(s);
        }
        return v;
    }

    public ArrayList<String> verticaisInv(){
        ArrayList<String> v_i=new ArrayList<>();
        for (int i=0; i<size; i++){
            String s="";
            for (int j=size-1; j>=0; j--){
                s+=puzzle[j][i];
            }
            v_i.add(s);
        }
        return v_i;
    }

    //diagonais -> UP-RIGHT UP-LEFT DOWN-RIGHT DOWN-LEFT

    public ArrayList<String> diagonaisUpRight(){
        ArrayList<String> d_UR=new ArrayList<>();
        int x=size-1;
        int y=size-1;
        while (x!=0 || y!=0){
            String s="";
            int index=0;
            do{
                s+=puzzle[x-index][y+index];
                index++;
            }while (x-index>=0 && y+index<size);
            if (s.length()>=3){
                d_UR.add(s);
            }

            if (y>0){
                y--;
            } else{
                x--;
            }
        }
        return d_UR;
    }

    public ArrayList<String> diagonaisUpLeft(){
        ArrayList<String> d_UL=new ArrayList<>();
        int x=size-1;
        int y=0;
        while (x!=0 || y!=size-1){
            String s="";
            int index=0;
            do{
                s+=puzzle[x-index][y-index];
                index++;
            }while (x-index>=0 && y-index>=0);
            if (s.length()>=3){
                d_UL.add(s);
            }

            if (y<size-1){
                y++;
            } else{
                x--;
            }
        }
        return d_UL;
    }
    
    public ArrayList<String> diagonaisDownLeft(){
        ArrayList<String> d_DL=new ArrayList<>();
        int x=size-1;
        int y=size-1;
        while (x!=0 || y!=0){
            String s="";
            int index=0;
            do{
                s+=puzzle[x+index][y-index];
                index++;
            }while (x+index<size && y-index>=0);
            if (s.length()>=3){
                d_DL.add(s);
            }

            if (x>0){
                x--;
            } else{
                y--;
            }
        }
        return d_DL;
    }

    public ArrayList<String> diagonaisDownRight(){
        ArrayList<String> d_DR=new ArrayList<>();
        int x=size-1;
        int y=0;
        while (x!=0 || y!=size-1){
            String s="";
            int index=0;
            do{
                s+=puzzle[x+index][y+index];
                index++;
            }while (x+index<size && y+index<size);
            if (s.length()>=3){
                d_DR.add(s);
            }

            if (x>0){
                x--;
            } else{
                y++;
            }
        }
        return d_DR;
    }
    

    public HashMap<String, String> directions(){
        HashMap<String, String> map = new HashMap<>();
        //sentido RIGHT
        for (int i=0; i<size; i++){
            String s="";
            for (int j=0; j<size; j++){
                s+=puzzle[i][j];
            }
            map.put(s, "Right");
        }

        // sentido LEFT
        for (int i=0; i<size; i++){
            String s="";
            for (int j=size-1; j>=0; j--){
                s+=puzzle[i][j];
            }
            map.put(s, "Left");
        }

        //sentido DOWN
        for (int i=0; i<size; i++){
            String s="";
            for (int j=0; j<size; j++){
                s+=puzzle[j][i];
            }
            map.put(s, "Down");
        }

        //sentido UP
        for (int i=0; i<size; i++){
            String s="";
            for (int j=size-1; j>=0; j--){
                s+=puzzle[j][i];
            }
            map.put(s, "Up");
        }

        //sentido UP-RIGHT
        int x=size-1;
        int y=size-1;
        while (x!=0 || y!=0){
            String s="";
            int index=0;
            do{
                s+=puzzle[x-index][y+index];
                index++;
            }while (x-index>=0 && y+index<size);
            if (s.length()>=3){
                map.put(s, "UpRight");
            }

            if (y>0){
                y--;
            } else{
                x--;
            }
        }

        //Sentido UP-LEFT
        x=size-1;
        y=0;
        while (x!=0 || y!=size-1){
            String s="";
            int index=0;
            do{
                s+=puzzle[x-index][y-index];
                index++;
            }while (x-index>=0 && y-index>=0);
            if (s.length()>=3){
                map.put(s, "UpLeft");
            }

            if (y<size-1){
                y++;
            } else{
                x--;
            }
        }

        //sentido DOWN-LEFT
        x=size-1;
        y=size-1;
        while (x!=0 || y!=0){
            String s="";
            int index=0;
            do{
                s+=puzzle[x+index][y-index];
                index++;
            }while (x+index<size && y-index>=0);
            if (s.length()>=3){
                map.put(s, "DownLeft");
            }

            if (x>0){
                x--;
            } else{
                y--;
            }
        }

        //sentido DOWN-RIGHT
        x=size-1;
        y=0;
        while (x!=0 || y!=size-1){
            String s="";
            int index=0;
            do{
                s+=puzzle[x+index][y+index];
                index++;
            }while (x+index<size && y+index<size);
            if (s.length()>=3){
                map.put(s, "DownRight");
            }

            if (x>0){
                x--;
            } else{
                y++;
            }

        }
        return map;
    }
}