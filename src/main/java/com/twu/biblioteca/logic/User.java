package com.twu.biblioteca.logic;

import java.util.ArrayList;

abstract public class User {
    String name;
    String email;
    String contactNo;
    String libraryNumber;
    String password;
    boolean loggedIn;
    ArrayList<Book> checkedOutBooks = new ArrayList<>();
    ArrayList<Movie> checkedOutMovies = new ArrayList<>();

    public abstract void loggedIn();

    public abstract void checkoutBook(Book book);

    public abstract void checkoutMovie(Movie movie);

    public abstract void returnMovie(Movie movie);

    public abstract void returnBook(Book book);

    public void logout() {
        loggedIn = false;
    }
}


