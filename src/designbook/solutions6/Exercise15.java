package designbook.solutions6;

import designbook.solutions6.Program3.Day;

public class Exercise15 {

    public static void main(String[] args) {

        Program3 program = new Program3();

        UndoableCommand command =
                program.createAddCommand(
                    new Movie("Movie 1", 2000, 120),
                    Day.MONDAY
                );

        command.execute();
        System.out.println("Sau khi Add:");
        System.out.println(program);

        command.undo();
        System.out.println("Sau khi Undo Add:");
        System.out.println(program);

        command.execute();

        command = program.createAddCommand(
            new Movie("Movie 2", 2010, 90),
            Day.WEDNESDAY
        );

        command.execute();

        command = program.createRemoveCommand(Day.MONDAY);
        command.execute();

        System.out.println("Sau khi Remove:");
        System.out.println(program);

        command.undo();

        System.out.println("Sau khi Undo Remove:");
        System.out.println(program);

        command = program.createClearCommand();
        command.execute();

        System.out.println("Sau khi Clear:");
        System.out.println(program);

        command.undo();

        System.out.println("Sau khi Undo Clear:");
        System.out.println(program);
    }
}