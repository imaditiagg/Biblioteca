package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.logic.Biblioteca;
import com.twu.biblioteca.logic.Library;

import java.util.ArrayList;

//Job: To Represent Menu
public class Menu {
    private final ArrayList<MenuItem> menuItems;

    public Menu(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public int noOfMenuItems() {
        return menuItems.size();
    }

    public StringBuilder display() {
        StringBuilder menuOutput = new StringBuilder();
        int index = 1;
        for (MenuItem option : menuItems) {
            menuOutput.append(index).append(".  ");
            menuOutput.append(option.description());
            menuOutput.append("\n");
            index++;
        }
        return menuOutput;
    }

    public void onOptionSelect(int index, Library library, Biblioteca biblioteca) {
        menuItems.get(index).action(library, biblioteca);
    }
}
