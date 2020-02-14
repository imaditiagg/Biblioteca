package com.twu.biblioteca.logic;

public class Librarian extends User {

    public Librarian(String libraryNumber, String password, boolean loggedIn) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.loggedIn = loggedIn;
    }

    @Override
    public void loggedIn() {
        loggedIn = true;
    }
}
