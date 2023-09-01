import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class WorldSearchSolver {
    public static void main(String[] args) throws FileNotFoundException{
        String file = args[0];
        //criar um ficheiro de texto para guardar a solução
        try (PrintWriter out = new PrintWriter(new File("./"+file.replace(".txt", "")+"_result.txt"))) { 
             
            Sopa sopaLetras = new Sopa(file);
            int size=sopaLetras.getSize();
            ArrayList<String> keyWords = sopaLetras.getWordsToFind();

            int x;
            int y;
            int aux_x;
            int aux_y;
            String gps;

            HashMap<String, ArrayList<String>> newPuzzle = new HashMap<>();
            ArrayList<String> valores;

            for (String keyWord: keyWords){
                gps="";
                for (String key:sopaLetras.directions().keySet()){
                    if (key.contains(keyWord.toUpperCase())){
                        String direcao=sopaLetras.directions().get(key);
                        switch(direcao){
                            case "Up":  x=size-key.indexOf(keyWord.toUpperCase());
                                        y=sopaLetras.verticaisInv().indexOf(key)+1;
                                        gps+=x+","+y;
                                        valores = new ArrayList<>();
                                        valores.add(gps);
                                        valores.add(direcao);
                                        newPuzzle.put(keyWord, valores);
                                        System.out.printf("%-15s %-5s %-7s %-10s\n", keyWord, keyWord.length(), gps, sopaLetras.directions().get(key));
                                        out.printf("%-15s %-5s %-7s %-10s\n", keyWord, keyWord.length(), gps, sopaLetras.directions().get(key));
                                    
                                        break;

                            case "Down":    x=key.indexOf(keyWord.toUpperCase())+1;
                                            y=sopaLetras.verticais().indexOf(key)+1;
                                            gps+=x+","+y;
                                            valores = new ArrayList<>();
                                            valores.add(gps);
                                            valores.add(direcao);
                                            newPuzzle.put(keyWord, valores);
                                            System.out.printf("%-15s %-5s %-7s %-10s\n", keyWord, keyWord.length(), gps, sopaLetras.directions().get(key));
                                            out.printf("%-15s %-5s %-7s %-10s\n", keyWord, keyWord.length(), gps, sopaLetras.directions().get(key));
                                            
                                            break;

                            case "Left":    y=size-key.indexOf(keyWord.toUpperCase());
                                            x=sopaLetras.horizontaisInv().indexOf(key)+1;
                                            gps+=x+","+y;
                                            valores = new ArrayList<>();
                                            valores.add(gps);
                                            valores.add(direcao);
                                            newPuzzle.put(keyWord, valores);
                                            System.out.printf("%-15s %-5s %-7s %-10s\n", keyWord, keyWord.length(), gps, sopaLetras.directions().get(key));
                                            out.printf("%-15s %-5s %-7s %-10s\n", keyWord, keyWord.length(), gps, sopaLetras.directions().get(key));
                                            
                                            break;

                            case "Right":   y=key.indexOf(keyWord.toUpperCase())+1;
                                            x=sopaLetras.horizontais().indexOf(key)+1;
                                            gps+=x+","+y;
                                            valores = new ArrayList<>();
                                            valores.add(gps);
                                            valores.add(direcao);
                                            newPuzzle.put(keyWord, valores);
                                            System.out.printf("%-15s %-5s %-7s %-10s\n", keyWord, keyWord.length(), gps, sopaLetras.directions().get(key));
                                            out.printf("%-15s %-5s %-7s %-10s\n", keyWord, keyWord.length(), gps, sopaLetras.directions().get(key));
                                            
                                            break;

                            //No total, há 2*size-1 diagonais em cada direção. Como só se contaram as diagonais com 3+ palavras
                            // há 2*size-5 diagonais
                            case "UpLeft":  aux_x=sopaLetras.diagonaisUpLeft().indexOf(key)>(2*size-5)/2 ? sopaLetras.diagonaisUpLeft().indexOf(key)-(2*size-5)/2:0;
                                            x=size-aux_x-key.indexOf(keyWord.toUpperCase());
                                            aux_y=sopaLetras.diagonaisUpLeft().indexOf(key)<(2*size-5)/2 ? (2*size-5)/2-sopaLetras.diagonaisUpLeft().indexOf(key):0;
                                            y=size-aux_y-key.indexOf(keyWord.toUpperCase());
                                            gps+=x+","+y;
                                            valores = new ArrayList<>();
                                            valores.add(gps);
                                            valores.add(direcao);
                                            newPuzzle.put(keyWord, valores);
                                            System.out.printf("%-15s %-5s %-7s %-10s\n", keyWord, keyWord.length(), gps, sopaLetras.directions().get(key));
                                            out.printf("%-15s %-5s %-7s %-10s\n", keyWord, keyWord.length(), gps, sopaLetras.directions().get(key));
                                            break;

                            case "UpRight": aux_x=sopaLetras.diagonaisUpRight().indexOf(key)>(2*size-5)/2 ? sopaLetras.diagonaisUpRight().indexOf(key)-(2*size-5)/2:0;
                                            x=size-aux_x-key.indexOf(keyWord.toUpperCase());
                                            aux_y=sopaLetras.diagonaisUpRight().indexOf(key)<(2*size-5)/2 ? (2*size-5)-sopaLetras.diagonaisUpRight().indexOf(key):0;
                                            y=aux_y+key.indexOf(keyWord.toUpperCase())+1;
                                            gps+=x+","+y;
                                            valores = new ArrayList<>();
                                            valores.add(gps);
                                            valores.add(direcao);
                                            newPuzzle.put(keyWord, valores);
                                            System.out.printf("%-15s %-5s %-7s %-10s\n", keyWord, keyWord.length(), gps, sopaLetras.directions().get(key));
                                            out.printf("%-15s %-5s %-7s %-10s\n", keyWord, keyWord.length(), gps, sopaLetras.directions().get(key));
                                            break;

                            case "DownLeft": aux_x=sopaLetras.diagonaisDownLeft().indexOf(key)<(2*size-5)/2 ? (2*size-5)/2-sopaLetras.diagonaisDownLeft().indexOf(key):0;
                                            x=1+aux_x+key.indexOf(keyWord.toUpperCase());
                                            aux_y=sopaLetras.diagonaisDownLeft().indexOf(key)<(2*size-5)/2 ? 0:(2*size-5)/2-sopaLetras.diagonaisDownLeft().indexOf(key);
                                            y=size-aux_y+key.indexOf(keyWord.toUpperCase());
                                            gps+=x+","+y;
                                            valores = new ArrayList<>();
                                            valores.add(gps);
                                            valores.add(direcao);
                                            newPuzzle.put(keyWord, valores);
                                            System.out.printf("%-15s %-5s %-7s %-10s\n", keyWord, keyWord.length(), gps, sopaLetras.directions().get(key));
                                            out.printf("%-15s %-5s %-7s %-10s\n", keyWord, keyWord.length(), gps, sopaLetras.directions().get(key));
                                            break;

                            case "DownRight": aux_x=sopaLetras.diagonaisDownRight().indexOf(key)<(2*size-5)/2 ? (2*size-5)/2-sopaLetras.diagonaisDownRight().indexOf(key):0;
                                            x=1+aux_x+key.indexOf(keyWord.toUpperCase());
                                            aux_y=sopaLetras.diagonaisDownRight().indexOf(key)<(2*size-5)/2 ? 0:(2*size-5)/2-sopaLetras.diagonaisDownRight().indexOf(key);
                                            y=1+aux_y+key.indexOf(keyWord.toUpperCase());
                                            gps+=x+","+y;
                                            valores = new ArrayList<>();
                                            valores.add(gps);
                                            valores.add(direcao);
                                            newPuzzle.put(keyWord, valores);
                                            System.out.printf("%-15s %-5s %-7s %-10s\n", keyWord, keyWord.length(), gps, sopaLetras.directions().get(key));
                                            out.printf("%-15s %-5s %-7s %-10s\n", keyWord, keyWord.length(), gps, sopaLetras.directions().get(key));
                                            break;

                            default:        System.out.printf("%-15s %-13s %-10s\n", keyWord, keyWord.length(), sopaLetras.directions().get(key));
                                            out.printf("%-15s %-13s %-10s\n", keyWord, keyWord.length(), sopaLetras.directions().get(key));                 
                                            break;

                        }
                        break;
                    }
                }
        
            }

            char[][] solution = new char[size][size];
            for (int i=0; i<size; i++){
                for (int j=0; j<size; j++){
                    solution[i][j]='.';
                }
            }

            int nX;
            int nY;
            for (String key:newPuzzle.keySet()){
                String xy=newPuzzle.get(key).get(0);
                String direcao=newPuzzle.get(key).get(1);
                String[] arr_xy=xy.split(",");
                nX=Integer.parseInt(arr_xy[0])-1;
                nY=Integer.parseInt(arr_xy[1])-1;
                key=key.toUpperCase();
                
                for (int index=0; index<key.length(); index++){
                    if (direcao.equals("Up")){
                        solution[nX-index][nY]=key.charAt(index);
                    } else if (direcao.equals("Down")){
                        solution[nX+index][nY]=key.charAt(index);
                    } else if (direcao.equals("Left")){
                        solution[nX][nY-index]=key.charAt(index);
                    } else if (direcao.equals("Right")){
                        solution[nX][nY+index]=key.charAt(index);
                    } else if (direcao.equals("UpRight")){
                        solution[nX-index][nY+index]=key.charAt(index);
                    } else if (direcao.equals("UpLeft")){
                        solution[nX-index][nY-index]=key.charAt(index);
                    } else if (direcao.equals("DownLeft")){
                        solution[nX+index][nY-index]=key.charAt(index);
                    } else if (direcao.equals("DownRight")){
                        solution[nX+index][nY+index]=key.charAt(index);
                    }
                }
            }

            for (int i=0; i<size; i++){
                System.out.println();
                for (int j=0; j<size; j++){
                    System.out.printf("%-2s", solution[i][j]);
                }
            }
            for (int i=0; i<size; i++){
                out.println();
                for (int j=0; j<size; j++){
                    out.printf("%-2s", solution[i][j]);
                }
            }
            
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}
