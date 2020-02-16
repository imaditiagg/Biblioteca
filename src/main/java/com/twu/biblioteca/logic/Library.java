package com.twu.biblioteca.logic;

import com.twu.biblioteca.constants.Message;

import java.util.ArrayList;

import static com.twu.biblioteca.constants.Message.NO_BOOK_CHECKOUT;
import static com.twu.biblioteca.constants.Message.NO_MOVIE_CHECKOUT;

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
            if (bookName.equals(book.name())) {
                checkoutBooks.add(book);
                User user = loggedInUser();
                if (user != null)
                    user.checkoutBook(book);
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
            User user = loggedInUser();
            if (user != null)
                user.returnBook(book);
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
                User user = loggedInUser();
                if (user != null)
                    user.checkoutMovie(movie);
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
            User user = loggedInUser();
            if (user != null)
                user.returnMovie(movie);
            movies.add(movie);
        }
    }

    public User validateUser(String userName, String password) {
        if (librarian != null && userName.equals(librarian.libraryNumber) && password.equals(librarian.password)) {
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

    public User loggedInUser() {
        if (librarian != null && librarian.loggedIn) return librarian;
        else {
            for (Customer customer : customers) {
                if (customer.loggedIn) {
                    return customer;
                }
            }
        }
        return null;
    }

    public StringBuilder obtainCheckoutDetails() {
        StringBuilder result = new StringBuilder();
        for (Customer customer : customers) {
            result.append("----------").append(customer.name).append("----------\n");
            if (customer.checkedOutBooks.size() > 0) {
                result.append("\n").append(Message.CHECKOUT_BOOKS).append("\n");
                for (Book book : customer.checkedOutBooks) {
                    result.append(book.name()).append("\n");
                }
            } else {
                result.append("\n").append(NO_BOOK_CHECKOUT).append("\n");
            }
            if (customer.checkedOutMovies.size() > 0) {
                result.append("\n").append(Message.CHECKOUT_MOVIES).append("\n");
                for (Movie movie : customer.checkedOutMovies) {
                    result.append(movie.name()).append("\n");
                }
            } else {
                result.append("\n").append(NO_MOVIE_CHECKOUT).append("\n");
            }
        }
        result.append("\n");
        return result;
    }

    public StringBuilder obtainUserDetails() {
        User user = loggedInUser();
        StringBuilder result = new StringBuilder();
        if (user != null)
            result.append(user.name).append("  ; ").append(user.email).append(" ; ").append(user.contactNo);
        return result;
    }
}
