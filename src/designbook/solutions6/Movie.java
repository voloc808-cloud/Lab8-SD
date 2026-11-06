package designbook.solutions6;

public class Movie implements Show {

    private String title;
    private int year;
    private int duration;

    public Movie(String title, int year, int duration) {
        this.title = title;
        this.year = year;
        this.duration = duration;
    }

    @Override
    public String description() {
        return title + " (" + year + ")";
    }

    @Override
    public int runningTime() {
        return duration;
    }

    @Override
    public Show copy() {
        return new Movie(title, year, duration);
    }
}