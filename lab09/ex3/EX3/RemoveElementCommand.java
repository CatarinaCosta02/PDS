package EX3;

import java.util.*;

public class RemoveElementCommand<E> implements Command<E> {
    private final Collection<E> collection;
    private final E element;
    private boolean executed;

    public RemoveElementCommand(Collection<E> collection, E element) {
        this.collection = collection;
        this.element = element;
        this.executed = false;
    }

    @Override
    public void execute() {
        if (!executed) {
            collection.remove(element);
            executed = true;
        }
    }

    @Override
    public void undo() {
        if (executed) {
            collection.add(element);
            executed = false;
        }
    }
}