import com.twu.biblioteca.Library;
import com.twu.biblioteca.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class LibraryTest {

    @Test
    void shouldGetBookOneAvailableInLibrary() {
        Library library = new Library();
        Book bookOne = new Book("Operating Systems", 1990, "Galvin");
        library.addBook(bookOne);
        ArrayList<Book> expectedResult = new ArrayList<>();
        expectedResult.add(bookOne);

        ArrayList<Book> actualResult = library.books();

        Assertions.assertIterableEquals(expectedResult, actualResult);
    }

    @Test
    void shouldGetAllBooksAvailableInLibrary() {
        Library library = new Library();
        Book bookOne = new Book("Operating Systems", 1999, "Galvin");
        Book bookTwo = new Book("Data Structures", 1990, "Narsimha karumanchi");
        library.addBook(bookOne);
        library.addBook(bookTwo);
        ArrayList<Book> expectedResult = new ArrayList<>();
        expectedResult.add(bookOne);
        expectedResult.add(bookTwo);

        ArrayList<Book> actualResult = library.books();

        Assertions.assertIterableEquals(expectedResult, actualResult);
    }
}