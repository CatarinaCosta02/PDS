package e1;

import java.util.List;

public class TelefoneList {
    private List<Telefone> telefones;
    

    public void setSortingStrategy(SortingStrategy strategy) {
        this.sortingStrategy = strategy;
    }

    public List<Telefone> sort() {
        return sortingStrategy.sort(telefones);
    }
}