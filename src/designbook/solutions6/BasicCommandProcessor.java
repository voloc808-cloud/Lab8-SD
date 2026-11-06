
package designbook.solutions6;

import java.util.ArrayList;
import java.util.List;

public class BasicCommandProcessor
        implements CommandProcessor18 {

    private final List<UndoableCommand> executed =
            new ArrayList<>();

    private final List<UndoableCommand> undone =
            new ArrayList<>();

    @Override
    public void consume(UndoableCommand command) {
        command.execute();
        executed.add(command);
        undone.clear();
    }

    @Override
    public void undoLast() {
        if (executed.isEmpty()) {
            System.out.println("Khong co lenh de Undo!");
            return;
        }

        UndoableCommand command =
                executed.remove(executed.size() - 1);

        command.undo();
        undone.add(command);
    }

    @Override
    public void redoLast() {
        if (undone.isEmpty()) {
            System.out.println("Khong co lenh de Redo!");
            return;
        }

        UndoableCommand command =
                undone.remove(undone.size() - 1);

        command.execute();
        executed.add(command);
    }
}
