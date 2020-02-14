package com.twu.biblioteca.logic;

public class Movie {

    private final String name;
    private final String director;
    private final int year;
    private final String rating;

    public Movie(String name, String director, int year, String rating) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    public String name() {
        return name;
    }

    public String display(String moviesListFormat) {
        return String.format(moviesListFormat, name, director, year, rating);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie that = (Movie) o;
        return this.name.equals(that.name) && this.director == that.director
                && this.rating.equals(that.rating) && this.year == that.year;
    }

}
