import com.twu.biblioteca.Library;
import com.twu.biblioteca.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class LibraryTest {

    @Test
    void shouldShowBookOneAvailableInLibrary() {
        Library library = new Library();
        Book bookOne = new Book("Operating Systems");
        library.addBook(bookOne);
        ArrayList<Book> expectedResult= new ArrayList<>();
        expectedResult.add(bookOne);

        ArrayList<Book> actualResult = library.viewBook();

        Assertions.assertIterableEquals(expectedResult,actualResult);
    }

    @Test
    void shouldShowAllBooksAvailableInLibrary() {
        Library library = new Library();
        Book bookOne = new Book("Operating Systems");
        Book bookTwo = new Book("Operating Systems");
        library.addBook(bookOne);
        library.addBook(bookTwo);
        ArrayList<Book> expectedResult= new ArrayList<>();
        expectedResult.add(bookOne);
        expectedResult.add(bookTwo);

        ArrayList<Book> actualResult = library.viewBook();

        Assertions.assertIterableEquals(expectedResult,actualResult);
    }
}