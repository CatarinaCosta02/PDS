package EX3;

import java.util.*;

class AddElementCommand<E> implements Command<E> {
    private Collection<E> collection;
    private E element;

    public AddElementCommand(E element) {
        this.element = element;
    }

    public void setCollection(Collection<E> collection) {
        this.collection = collection;
    }

    @Override
    public void execute() {
        collection.add(element);
    }

    @Override
    public void undo() {
        collection.remove(element);
    }
}