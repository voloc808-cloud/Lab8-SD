
package designbook.solutions6;

import designbook.solutions6.Program3.Day;

public class Exercise17 {

    public static void main(String[] args) {

        Program3 program = new Program3();
        CommandProcessor2 processor = new CommandProcessor2();

        // 1. Them Movie 1
        processor.consume(
            program.createAddCommand(
                new Movie("Movie 1", 2000, 120),
                Day.MONDAY
            )
        );

        System.out.println("1. Sau khi them Movie 1:");
        System.out.println(program);

        // 2. Them Movie 2
        processor.consume(
            program.createAddCommand(
                new Movie("Movie 2", 2010, 90),
                Day.WEDNESDAY
            )
        );

        System.out.println("2. Sau khi them Movie 2:");
        System.out.println(program);

        // 3. Undo lan 1
        processor.undoLast();

        System.out.println("3. Sau khi Undo lan 1:");
        System.out.println(program);

        // 4. Undo lan 2
        processor.undoLast();

        System.out.println("4. Sau khi Undo lan 2:");
        System.out.println(program);

        // 5. Redo lan 1
        processor.redoLast();

        System.out.println("5. Sau khi Redo lan 1:");
        System.out.println(program);

        // 6. Redo lan 2
        processor.redoLast();

        System.out.println("6. Sau khi Redo lan 2:");
        System.out.println(program);

        // 7. Undo va thuc thi lenh moi
        processor.undoLast();

        processor.consume(
            program.createAddCommand(
                new Movie("Movie 3", 2020, 100),
                Day.FRIDAY
            )
        );

        System.out.println("7. Sau khi them Movie 3:");
        System.out.println(program);

        // 8. Kiem tra lich su Redo
        processor.redoLast();

        System.out.println("8. Sau khi thu Redo:");
        System.out.println(program);
    }
}
