package com.twu.biblioteca.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

class CustomerTest {

    @Test
    void shouldLoginUser() {
        User user = new Customer("909-2020", "12345", false, "abc",
                "abc@gmail.com", "8888888888");

        user.logIn();

        assertTrue(user.loggedIn);
    }

    @Test
    void shouldCheckoutBook() {
        User user = new Customer("909-2020", "12345", false, "abc",
                "abc@gmail.com", "8888888888");
        Book book = mock(Book.class);

        user.checkoutBook(book);

        assertEquals(1, user.checkedOutBooks.size());
    }

    @Test
    void shouldReturnBook() {
        User user = new Customer("909-2020", "12345", false, "abc",
                "abc@gmail.com", "8888888888");
        Book book = mock(Book.class);
        user.checkoutBook(book);

        user.returnBook(book);

        assertEquals(0, user.checkedOutBooks.size());
    }

    @Test
    void shouldCheckoutMovie() {
        User user = new Customer("909-2020", "12345", false, "abc",
                "abc@gmail.com", "8888888888");
        Movie movie = mock(Movie.class);
        user.checkoutMovie(movie);

        user.returnMovie(movie);

        assertEquals(0, user.checkedOutMovies.size());
    }

    @Test
    void shouldReturnMovie() {
        User user = new Customer("909-2020", "12345", false, "abc",
                "abc@gmail.com", "8888888888");
        Movie movie = mock(Movie.class);
        user.checkoutMovie(movie);

        user.returnMovie(movie);

        assertEquals(0, user.checkedOutBooks.size());
    }
}