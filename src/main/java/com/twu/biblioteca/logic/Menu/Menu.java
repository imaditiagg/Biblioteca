package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.logic.Customer;
import com.twu.biblioteca.logic.Exception.InvalidMenuOption;
import com.twu.biblioteca.logic.Library;
import com.twu.biblioteca.logic.User;

import java.io.IOException;
import java.util.ArrayList;

//Job: To Represent Menu
public class Menu {
    private final ArrayList<MenuItem> defaultMenuItems;
    private final ArrayList<MenuItem> customerMenuItems;
    private final ArrayList<MenuItem> librarianMenuItems;

    public Menu(ArrayList<MenuItem> defaultMenuItems, ArrayList<MenuItem> customerMenuItems, ArrayList<MenuItem> librarianMenuItems) {
        this.defaultMenuItems = defaultMenuItems;
        this.customerMenuItems = customerMenuItems;
        this.librarianMenuItems = librarianMenuItems;
    }

    public StringBuilder display() {
        StringBuilder menuOutput = new StringBuilder();
        int index = 1;
        for (MenuItem option : defaultMenuItems) {
            menuOutput.append(index).append(".  ");
            menuOutput.append(option.description());
            menuOutput.append("\n");
            index++;
        }
        return menuOutput;
    }

    public void onOptionSelect(int index, Library library, User user) throws InvalidMenuOption, IOException {
        if (user == null) {
            if (index < 0 || index >= noOfDefaultMenuItems()) {
                throw new InvalidMenuOption();
            }
            defaultMenuItems.get(index).action(library);
        } else if (user.getClass() == Customer.class) {
            if (index < 0 || index >= noOfCustomerMenuItems()) {
                throw new InvalidMenuOption();
            }
            customerMenuItems.get(index).action(library);
        } else {
            if (index < 0 || index >= noOfLibrarianMenuItems()) {
                throw new InvalidMenuOption();
            }
            librarianMenuItems.get(index).action(library);
        }
    }

    private int noOfDefaultMenuItems() {
        return defaultMenuItems.size();
    }

    private int noOfCustomerMenuItems() {
        return customerMenuItems.size();
    }

    private int noOfLibrarianMenuItems() {
        return librarianMenuItems.size();
    }

    public StringBuilder customerDisplay() {
        StringBuilder menuOutput = new StringBuilder();
        int index = 1;
        for (MenuItem option : customerMenuItems) {
            menuOutput.append(index).append(".  ");
            menuOutput.append(option.description());
            menuOutput.append("\n");
            index++;
        }
        return menuOutput;
    }

    public StringBuilder librarianDisplay() {
        StringBuilder menuOutput = new StringBuilder();
        int index = 1;
        for (MenuItem option : librarianMenuItems) {
            menuOutput.append(index).append(".  ");
            menuOutput.append(option.description());
            menuOutput.append("\n");
            index++;
        }
        return menuOutput;
    }
}
