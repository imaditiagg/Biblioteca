package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MenuTest {

    @Test
    void shouldAddViewBooksMenuItemToMenu() {
        MenuItem menuItem = new ViewBooks();

        Menu menu = new Menu(menuItem);

        assertEquals(1, menu.noOfMenuItems());
    }
}