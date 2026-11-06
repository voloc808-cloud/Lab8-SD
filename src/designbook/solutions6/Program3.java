package designbook.solutions6;

import java.util.EnumMap;

public class Program3 {

    public enum Day {
        MONDAY, TUESDAY, WEDNESDAY,
        THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    private final EnumMap<Day, Show> aShows =
            new EnumMap<>(Day.class);

    public Program3() {
        clear();
    }

    // Tao lenh them phim
    public UndoableCommand createAddCommand(
            Show pShow, Day pDay) {

        return new UndoableCommand() {

            private Show previousShow;

            @Override
            public void execute() {
                previousShow = aShows.get(pDay);
                add(pShow, pDay);
            }

            @Override
            public void undo() {
                add(previousShow, pDay);
            }
        };
    }

    // Tao lenh xoa phim
    public UndoableCommand createRemoveCommand(Day pDay) {

        return new UndoableCommand() {

            private Show previousShow;

            @Override
            public void execute() {
                previousShow = aShows.get(pDay);
                remove(pDay);
            }

            @Override
            public void undo() {
                add(previousShow, pDay);
            }
        };
    }

    // Tao lenh xoa toan bo
    public UndoableCommand createClearCommand() {

        return new UndoableCommand() {

            private EnumMap<Day, Show> previousShows;

            @Override
            public void execute() {
                previousShows = new EnumMap<>(aShows);
                clear();
            }

            @Override
            public void undo() {
                aShows.putAll(previousShows);
            }
        };
    }

    private void clear() {
        for (Day day : Day.values()) {
            aShows.put(day, null);
        }
    }

    private void add(Show show, Day day) {
        aShows.put(day, show);
    }

    private void remove(Day day) {
        aShows.put(day, null);
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();

        for (Day day : Day.values()) {

            Show show = aShows.get(day);

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