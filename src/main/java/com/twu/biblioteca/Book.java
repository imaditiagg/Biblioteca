package com.twu.biblioteca;

public class Book {
    private final String name;
    private final int publicationYear;
    private final String author;

    public Book(String name, int publicationYear, String author) {
        this.name = name;
        this.publicationYear = publicationYear;
        this.author = author;
    }

    String name() {
        return name;
    }

    String author() {
        return author;
    }

    int publicationYear() {
        return publicationYear;
    }
}
