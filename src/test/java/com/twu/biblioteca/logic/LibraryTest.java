package com.twu.biblioteca.logic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    Library library;

    @Test
    void shouldGetBookOneAvailableInLibrary() {
        Book bookOne = new Book("Operating Systems", 1990, "Galvin");
        ArrayList<Book> books = new ArrayList<>();
        books.add(bookOne);
        library = new Library(books, null);

        ArrayList<Book> actualBooks = library.books();

        assertIterableEquals(books, actualBooks);
    }

    @Test
    void shouldGetAllBooksAvailableInLibrary() {
        Book bookOne = new Book("Operating Systems", 1999, "Galvin");
        Book bookTwo = new Book("Data Structures", 1990, "Narsimha karumanchi");
        ArrayList<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        library = new Library(books, null);

        ArrayList<Book> actualBooks = library.books();

        assertIterableEquals(books, actualBooks);
    }

    @Test
    void shouldCheckOutBookOneFromLibrary() {
        Book bookOne = new Book("Operating Systems", 1999, "Galvin");
        Book bookTwo = new Book("Data Structures", 1990, "Narsimha karumanchi");
        ArrayList<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        library = new Library(books, null);
        String bookName = "Operating Systems";

        library.checkoutBook(bookName);

        assertFalse(library.books().contains(bookOne));
    }

    @Test
    void shouldCheckForSuccessfulBookCheckout() {
        Book bookOne = new Book("Operating Systems", 1999, "Galvin");
        Book bookTwo = new Book("Data Structures", 1990, "Narsimha karumanchi");
        ArrayList<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        library = new Library(books, null);
        String bookName = "Operating Systems";

        library.checkoutBook(bookName);

        assertNotEquals(null, library.findInCheckoutBooks(bookName));
    }

    @Test
    void shouldNotCheckoutBookFromLibrary() {
        Book bookOne = new Book("Operating Systems", 1999, "Galvin");
        Book bookTwo = new Book("Data Structures", 1990, "Narsimha karumanchi");
        ArrayList<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        library = new Library(books, null);
        String bookName = "Operating";

        library.checkoutBook(bookName);

        assertNull(library.findInCheckoutBooks(bookName));
    }

    @Test
    void shouldReturnBookToTheLibrary() {
        Book bookOne = new Book("Operating Systems", 1999, "Galvin");
        Book bookTwo = new Book("Data Structures", 1990, "Narsimha karumanchi");
        ArrayList<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        library = new Library(books, null);
        String bookName = "Operating Systems";
        library.checkoutBook(bookName);

        library.returnBook(bookName);

        assertTrue(library.books().contains(bookOne));
    }

    @Test
    void shouldNotAllowToReturnABookThatIsNotCheckoutYet() {
        Book bookOne = new Book("Operating Systems", 1999, "Galvin");
        Book bookTwo = new Book("Data Structures", 1990, "Narsimha karumanchi");
        ArrayList<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        library = new Library(books, null);
        String bookName = "Operating Systems";

        library.returnBook(bookName);

        assertNull(library.findInCheckoutBooks(bookName));
    }

    @Test
    void shouldNotReturnAnythingWhenBookNotFoundInCheckOutList() {
        Book bookOne = new Book("Operating Systems", 1999, "Galvin");
        Book bookTwo = new Book("Data Structures", 1990, "Narsimha karumanchi");
        ArrayList<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        library = new Library(books, null);
        String bookName = "Harry Potter";

        assertNull(library.findInCheckoutBooks(bookName));
    }

    @Test
    void shouldGetMoviesFromLibrary() {
        Movie movieOne = new Movie("Uri: The Surgical Strike", " Aditya Dhar", 2019, "9");
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(movieOne);

        Library library = new Library(null, movies);

        assertIterableEquals(library.movies(), movies);
    }

    @Test
    void shouldCheckOutMovieFromLibrary() {
        Movie movie = new Movie("Uri: The Surgical Strike", " Aditya Dhar", 2019, "9");
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(movie);
        library = new Library(null, movies);
        String movieName = "Uri: The Surgical Strike";

        library.checkoutMovie(movieName);

        assertFalse(library.movies().contains(movie));
    }


    @Test
    void shouldCheckForSuccessfulMovieCheckout() {
        Movie movie = new Movie("Uri: The Surgical Strike", " Aditya Dhar", 2019, "9");
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(movie);
        library = new Library(null, movies);
        String movieName = "Uri: The Surgical Strike";

        library.checkoutMovie(movieName);

        assertNotEquals(null, library.findInCheckoutMovies(movieName));
    }

    @Test
    void shouldNotCheckoutMovieFromLibrary() {
        Movie movie = new Movie("Uri: The Surgical Strike", " Aditya Dhar", 2019, "9");
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(movie);
        library = new Library(null, movies);
        String movieName = "Uri";

        library.checkoutMovie(movieName);

        assertNull(library.findInCheckoutMovies(movieName));
    }

    @Test
    void shouldReturnMovieToTheLibrary() {
        Movie movie = new Movie("Uri: The Surgical Strike", " Aditya Dhar", 2019, "9");
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(movie);
        library = new Library(null, movies);
        String movieName = "Uri: The Surgical Strike";
        library.checkoutMovie(movieName);

        library.returnMovie(movieName);

        assertTrue(library.movies().contains(movie));
    }

    @Test
    void shouldNotAllowToReturnAMovieThatIsNotCheckoutYet() {
        Movie movie = new Movie("Uri: The Surgical Strike", " Aditya Dhar", 2019, "9");
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(movie);
        library = new Library(null, movies);
        String movieName = "Uri: The Surgical Strike";

        library.returnMovie(movieName);

        assertNull(library.findInCheckoutMovies(movieName));
    }

    @Test
    void shouldNotReturnAnythingWhenMovieNotFoundInCheckoutList() {
        Movie movie = new Movie("Uri: The Surgical Strike", " Aditya Dhar", 2019, "9");
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(movie);
        library = new Library(null, movies);
        String movieName = "Uri: The Surgical Strike";

        assertNull(library.findInCheckoutMovies(movieName));
    }

    @Test
    void shouldValidateUser() {
        Library library = new Library(null, null);
        String libraryNumber = "101-2020";
        String password = "12345";
        ArrayList<Customer> customers = new ArrayList<>();
        Customer customer = new Customer("101-2020", "12345", false, "Aditi",
                "aditi.aggarwal@thoughtworks.com", "8375939006");
        customers.add(customer);
        library.addCustomers(customers);

        assertEquals(customer, library.validateUser(libraryNumber, password));
    }
}
