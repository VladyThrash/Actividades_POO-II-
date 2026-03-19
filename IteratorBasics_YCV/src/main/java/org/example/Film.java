package org.example;

public class Film {
    private String title;
    private int year;

    public Film (String title, int year)
    {
        this.title = title;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Film: " + title + " (" + year + ")";
    }
}
