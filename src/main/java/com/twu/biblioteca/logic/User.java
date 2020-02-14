package com.twu.biblioteca.logic;

abstract public class User {
    String libraryNumber;
    String password;
    boolean loggedIn;

    public abstract void loggedIn();
}


