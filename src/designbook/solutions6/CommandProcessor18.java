
package designbook.solutions6;

public interface CommandProcessor18 {

    void consume(UndoableCommand command);

    void undoLast();

    void redoLast();
}
