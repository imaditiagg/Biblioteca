import com.twu.biblioteca.Library;
import com.twu.biblioteca.Book;
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
        library = new Library(books);

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
        library = new Library(books);

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
        library = new Library(books);
        String bookName = "Operating Systems";

        library.checkout(bookName);

        assertFalse(library.books().contains(bookOne));
    }
}
