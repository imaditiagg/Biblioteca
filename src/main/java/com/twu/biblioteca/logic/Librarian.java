package com.twu.biblioteca.logic;

//To represent Librarian
public class Librarian extends User {

    public Librarian(String libraryNumber, String password, boolean loggedIn, String name, String email, String contactNo) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.loggedIn = loggedIn;
        this.name = name;
        this.email = email;
        this.contactNo = contactNo;
    }


    @Override
    public void logIn() {
        loggedIn = true;
    }

    @Override
    public void checkoutBook(Book book) {
        checkedOutBooks.add(book);
    }

    @Override
    public void checkoutMovie(Movie movie) {
        checkedOutMovies.add(movie);
    }

    @Override
    public void returnMovie(Movie movie) {
        checkedOutMovies.remove(movie);
    }

    @Override
    public void returnBook(Book book) {
        checkedOutBooks.remove(book);
    }
}
