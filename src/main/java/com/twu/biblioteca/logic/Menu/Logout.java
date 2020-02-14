package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.constants.Message;
import com.twu.biblioteca.logic.Library;
import com.twu.biblioteca.logic.User;

import java.io.BufferedReader;
import java.io.PrintWriter;

//Job: To represent Logout Menu Item
public class Logout extends MenuItem {

    public Logout(String description, BufferedReader bufferedReader, PrintWriter printWriter) {
        this.description = description;
        this.bufferedReader = bufferedReader;
        this.printWriter = printWriter;
    }

    @Override
    String description() {
        return description;
    }

    @Override
    void action(Library library) {
        User user = library.loggedInUser();
        user.logout();
        printWriter.println(Message.SUCCESSFUL_LOGOUT);
    }
}
