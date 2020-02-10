package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MenuTest {

    @Test
    void shouldAddViewBooksMenuItemToMenu() {
        MenuItem menuItemOne = new ViewBooks();
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(menuItemOne);

        Menu menu = new Menu(menuItems);

        assertEquals(1, menu.noOfMenuItems());
    }

    @Test
    void shouldAddTwoMenuItemsToMenu() {
        MenuItem menuItemOne = new ViewBooks();
        MenuItem menuItemTwo = new CheckoutBook();
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(menuItemOne);
        menuItems.add(menuItemTwo);

        Menu menu = new Menu(menuItems);

        assertEquals(2, menu.noOfMenuItems());
    }

    @Test
    void shouldAddAllMenuItemsToMenu() {
        MenuItem menuItemOne = new ViewBooks();
        MenuItem menuItemTwo = new CheckoutBook();
        MenuItem menuItemThree = new ReturnBook();
        MenuItem menuItemFour = new QuitApplication();
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(menuItemOne);
        menuItems.add(menuItemTwo);
        menuItems.add(menuItemThree);
        menuItems.add(menuItemFour);

        Menu menu = new Menu(menuItems);

        assertEquals(4, menu.noOfMenuItems());
    }
}