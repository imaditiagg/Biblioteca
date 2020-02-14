package com.twu.biblioteca.logic;

public class Customer extends User {

    public Customer(String libraryNumber, String password, boolean loggedIn) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.loggedIn = loggedIn;
    }

    @Override
    public void loggedIn() {
        loggedIn = true;
    }
}
