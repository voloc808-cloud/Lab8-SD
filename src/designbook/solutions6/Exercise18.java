
package designbook.solutions6;

import designbook.solutions6.Program.Day;

public class Exercise18 {

    public static void main(String[] args) {

        Program program = new Program(
                new BasicCommandProcessor()
        );

        // 1. Them Movie 1
        program.add(
            new Movie("Movie 1", 2000, 120),
            Day.MONDAY
        );

        System.out.println("1. Sau khi them Movie 1:");
        System.out.println(program);

        // 2. Them Movie 2
        program.add(
            new Movie("Movie 2", 2010, 90),
            Day.WEDNESDAY
        );

        System.out.println("2. Sau khi them Movie 2:");
        System.out.println(program);

        // 3. Xoa Movie 1
        program.remove(Day.MONDAY);

        System.out.println("3. Sau khi xoa Movie 1:");
        System.out.println(program);

        // 4. Undo Remove
        program.undoLast();

        System.out.println("4. Sau khi Undo Remove:");
        System.out.println(program);

        // 5. Clear
        program.clear();

        System.out.println("5. Sau khi Clear:");
        System.out.println(program);

        // 6. Undo Clear
        program.undoLast();

        System.out.println("6. Sau khi Undo Clear:");
        System.out.println(program);

        // 7. Redo Clear
        program.redoLast();

        System.out.println("7. Sau khi Redo Clear:");
        System.out.println(program);

        // 8. Undo Clear
        program.undoLast();

        System.out.println("8. Sau khi Undo lan cuoi:");
        System.out.println(program);
    }
}
