package com.twu.biblioteca;

public class Menu {
    private final MenuItem menuItem;

    public Menu(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public int noOfMenuItems() {
        return 1;
    }
}
