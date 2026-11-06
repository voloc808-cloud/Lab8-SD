
package designbook.solutions6;

import java.util.ArrayList;
import java.util.List;

public class CommandProcessor2 {

    private final List<UndoableCommand> aExecutedCommands =
            new ArrayList<>();

    private final List<UndoableCommand> aUndoneCommands =
            new ArrayList<>();

    // Thuc thi lenh moi
    public void consume(UndoableCommand pCommand) {
        pCommand.execute();
        aExecutedCommands.add(pCommand);

        // Lenh moi lam mat lich su Redo
        aUndoneCommands.clear();
    }

    // Hoan tac lenh cuoi
    public void undoLast() {

        if (aExecutedCommands.isEmpty()) {
            System.out.println("Khong co lenh de Undo!");
            return;
        }

        UndoableCommand command =
                aExecutedCommands.remove(
                    aExecutedCommands.size() - 1
                );

        command.undo();
        aUndoneCommands.add(command);
    }

    // Thuc thi lai lenh da Undo
    public void redoLast() {

        if (aUndoneCommands.isEmpty()) {
            System.out.println("Khong co lenh de Redo!");
            return;
        }

        UndoableCommand command =
                aUndoneCommands.remove(
                    aUndoneCommands.size() - 1
                );

        command.execute();
        aExecutedCommands.add(command);
    }
}
