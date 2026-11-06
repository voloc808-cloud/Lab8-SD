package designbook.solutions6;

import designbook.solutions6.Program3.Day;

public class Exercise16 {

    public static void main(String[] args) {

        Program3 program = new Program3();
        CommandProcessor processor = new CommandProcessor();

        // Them Movie 1
        processor.consume(
            program.createAddCommand(
                new Movie("Movie 1", 2000, 120),
                Day.MONDAY
            )
        );

        System.out.println("1. Sau khi them Movie 1:");
        System.out.println(program);

        // Them Movie 2
        processor.consume(
            program.createAddCommand(
                new Movie("Movie 2", 2010, 90),
                Day.WEDNESDAY
            )
        );

        System.out.println("2. Sau khi them Movie 2:");
        System.out.println(program);

        // Xoa Movie 1
        processor.consume(
            program.createRemoveCommand(Day.MONDAY)
        );

        System.out.println("3. Sau khi xoa Movie 1:");
        System.out.println(program);

        // Undo lenh xoa
        processor.undoLast();

        System.out.println("4. Undo lan 1:");
        System.out.println(program);

        // Undo lenh them Movie 2
        processor.undoLast();

        System.out.println("5. Undo lan 2:");
        System.out.println(program);

        // Undo lenh them Movie 1
        processor.undoLast();

        System.out.println("6. Undo lan 3:");
        System.out.println(program);
    }
}