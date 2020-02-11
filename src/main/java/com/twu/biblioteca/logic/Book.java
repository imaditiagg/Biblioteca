package com.twu.biblioteca.logic;

//Job: To Represent Book
public class Book {
    private final String name;
    private final int publicationYear;
    private final String author;

    public Book(String name, int publicationYear, String author) {
        this.name = name;
        this.publicationYear = publicationYear;
        this.author = author;
    }

    public String name() {
        return name;
    }

    public String display() {
        return name + " ; " + author + " ; " + publicationYear + "\n";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book that = (Book) o;
        return this.name.equals(that.name) && this.publicationYear == that.publicationYear
                && this.author.equals(that.author);
    }
}
