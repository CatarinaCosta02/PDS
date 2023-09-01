package e1;

import java.util.List;

public class BubbleSortStrategy implements SortingStrategy {
    public List<Telefone> sort(List<Telefone> telefones) {
<<<<<<< HEAD
        int n = telefones.size();
        Telefone temp;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(telefones.get(j-1).getNumero() > telefones.get(j).getNumero()){
                    //swap elements
                    temp = telefones.get(j-1);
                    telefones.set(j-1, telefones.get(j));
                    telefones.set(j, temp);
                }
            }
        }
        return telefones;
=======
 
		FileDisplay fileDisplay = new FileDisplay(thermometer, "temperature.txt");
		thermometer.addThermometerListener(fileDisplay);
		FileDisplay fileDisplay = new FileDisplay(thermometer, "temperature.txt");
		thermometer.addThermometerListener(fileDisplay);       // Implementação do BubbleSort
>>>>>>> 88b909ceb909f2b178382ede2ca6101a635fa734
    }
}
