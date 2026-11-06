
package designbook.solutions6;

import java.util.EnumMap;

public class Program {

    public enum Day {
        MONDAY, TUESDAY, WEDNESDAY,
        THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    private final EnumMap<Day, Show> shows =
            new EnumMap<>(Day.class);

    private final CommandProcessor18 processor;

    public Program(CommandProcessor18 processor) {
        this.processor = processor;
    }

    // Them phim
    public void add(Show show, Day day) {

        processor.consume(new UndoableCommand() {

            private Show previousShow;

            @Override
            public void execute() {
                previousShow = shows.put(day, show);
            }

            @Override
            public void undo() {
                restore(day, previousShow);
            }
        });
    }

    // Xoa phim
    public void remove(Day day) {

        processor.consume(new UndoableCommand() {

            private Show previousShow;

            @Override
            public void execute() {
                previousShow = shows.remove(day);
            }

            @Override
            public void undo() {
                restore(day, previousShow);
            }
        });
    }

    // Xoa toan bo lich chieu
    public void clear() {

        processor.consume(new UndoableCommand() {

            private EnumMap<Day, Show> previousShows;

            @Override
            public void execute() {
                previousShows = new EnumMap<>(shows);
                shows.clear();
            }

            @Override
            public void undo() {
                shows.clear();
                shows.putAll(previousShows);
            }
        });
    }

    // Khoi phuc phim cu
    private void restore(Day day, Show show) {
        if (show == null) {
            shows.remove(day);
        } else {
            shows.put(day, show);
        }
    }

    // Hoan tac
    public void undoLast() {
        processor.undoLast();
    }

    // Thuc thi lai
    public void redoLast() {
        processor.redoLast();
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();

        for (Day day : Day.values()) {

            Show show = shows.get(day);

            result.append(day).append(": ");

            if (show != null) {
                result.append(show.description());
            } else {
                result.append("Empty");
            }

            result.append("\n");
        }

        return result.toString();
    }
}
