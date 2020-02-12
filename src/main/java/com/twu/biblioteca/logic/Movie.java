package com.twu.biblioteca.logic;

public class Movie {

    private final String name;
    private final String director;
    private final int year;
    private final String rating;

    Movie(String name, String director, int year, String rating) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
}
