package com.twu.biblioteca.logic;

import java.util.ArrayList;

//Job: To Represent Library
public class Library {
    private final ArrayList<Movie> movies;
    private ArrayList<Movie> checkoutMovies = new ArrayList<>();
    private ArrayList<Book> books;
    private ArrayList<Book> checkoutBooks = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private Librarian librarian;

    public Library(ArrayList<Book> books, ArrayList<Movie> movies) {
        this.books = books;
        this.movies = movies;
    }

    public void addLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    public void addCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public ArrayList<Book> books() {
        return books;
    }

    public void checkoutBook(String bookName) {
        for (Book book : books) {
            if (book.name().equals(bookName)) {
                checkoutBooks.add(book);
                books.remove(book);
                break;
            }
        }
    }

    public Book findInCheckoutBooks(String bookName) {
        for (Book book : checkoutBooks) {
            if (book.name().equals(bookName)) {
                return book;
            }
        }
        return null;
    }

    public void returnBook(String bookName) {
        Book book = findInCheckoutBooks(bookName);
        if (book != null) {
            checkoutBooks.remove(book);
            books.add(book);
        }
    }

    public ArrayList<Movie> movies() {
        return movies;
    }

    public void checkoutMovie(String movieName) {
        for (Movie movie : movies) {
            if (movie.name().equals(movieName)) {
                checkoutMovies.add(movie);
                movies.remove(movie);
                break;
            }
        }
    }

    public Movie findInCheckoutMovies(String movieName) {
        for (Movie movie : checkoutMovies) {
            if (movie.name().equals(movieName)) {
                return movie;
            }
        }
        return null;
    }

    public void returnMovie(String movieName) {
        Movie movie = findInCheckoutMovies(movieName);
        if (movie != null) {
            checkoutMovies.remove(movie);
            movies.add(movie);
        }
    }

    public User validateUser(String userName, String password) {
        if (userName.equals(librarian.libraryNumber) && password.equals(librarian.password)) {
            return librarian;
        } else {
            for (Customer customer : customers) {
                if (userName.equals(customer.libraryNumber) && password.equals(customer.password)) {
                    return customer;
                }
            }
        }
        return null;
    }

    public User checkLoggedInUser() {
        if (librarian.loggedIn) return librarian;
        else {
            for (Customer customer : customers) {
                if (customer.loggedIn) {
                    return customer;
                }
            }
        }
        return null;
    }
}
