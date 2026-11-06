package designbook.solutions6;

public interface UndoableCommand extends Command {
    void undo();
}