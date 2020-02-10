package com.twu.biblioteca;

import java.util.ArrayList;

public class Menu {
    private final ArrayList<MenuItem> menuItems;

    public Menu(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public int noOfMenuItems() {
        return menuItems.size();
    }
}
