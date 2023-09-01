package EX3;

interface Command<E> {
    void execute();
    void undo();
}