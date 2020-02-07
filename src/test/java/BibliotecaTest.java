import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Book;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class BibliotecaTest {

    @Test
    void shouldShowBookOneAvailableInLibrary() {
        Biblioteca biblioteca = new Biblioteca();
        Book bookOne = new Book("Operating Systems");
        biblioteca.addBook(bookOne);
        String expectedResult = "Operating Systems";

        String actualResult = biblioteca.viewBook();

        assertThat(expectedResult, is(equalTo(actualResult)));
    }
}