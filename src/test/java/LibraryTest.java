import com.twu.biblioteca.Library;
import com.twu.biblioteca.Book;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class LibraryTest {

    @Test
    void shouldShowBookOneAvailableInLibrary() {
        Library library = new Library();
        Book bookOne = new Book("Operating Systems");
        library.addBook(bookOne);
        String expectedResult = "Operating Systems";

        String actualResult = library.viewBook();

        assertThat(expectedResult, is(equalTo(actualResult)));
    }
}