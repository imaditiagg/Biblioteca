package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.logic.Exception.InvalidMenuOption;
import com.twu.biblioteca.logic.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

//Job: To Represent Menu
public class Menu {
    private final ArrayList<MenuItem> menuItems;

    public Menu(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
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

    public void onOptionSelect(int index, Library library, BufferedReader bufferedReader, PrintWriter printWriter) throws IOException, InvalidMenuOption {
        if (index < 0 || index >= noOfMenuItems()) {
            throw new InvalidMenuOption();
        }
        menuItems.get(index).action(library, bufferedReader, printWriter);
    }

    private int noOfMenuItems() {
        return menuItems.size();
    }
}
