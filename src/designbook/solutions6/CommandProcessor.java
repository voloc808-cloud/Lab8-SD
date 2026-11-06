package designbook.solutions6;

import java.util.ArrayList;
import java.util.List;

public class CommandProcessor {

    private final List<UndoableCommand> aCommands =
            new ArrayList<>();

    public void consume(UndoableCommand pCommand) {

        pCommand.execute();
        aCommands.add(pCommand);
    }

    public void undoLast() {

        if (aCommands.isEmpty()) {
            System.out.println("Khong co lenh de Undo!");
            return;
        }

        UndoableCommand command =
                aCommands.remove(aCommands.size() - 1);

        command.undo();
    }
}