package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.logic.Library;
import com.twu.biblioteca.logic.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import static com.twu.biblioteca.constants.Message.*;

//Job: To represent login Menu Item
public class Login extends MenuItem {

    public Login(String description, BufferedReader bufferedReader, PrintWriter printWriter) {
        this.description = description;
        this.bufferedReader = bufferedReader;
        this.printWriter = printWriter;
    }

    @Override
    String description() {
        return description;
    }

    @Override
    void action(Library library) throws IOException {
        User user;
        printWriter.println(ENTER_USERNAME);
        String userName = bufferedReader.readLine();
        printWriter.println(ENTER_PASSWORD);
        String password = bufferedReader.readLine();
        user = library.validateUser(userName, password);
        if (user == null)
            printWriter.println(INVALID_USERNAME_OR_PASSWORD_TRY_AGAIN);
        else {
            printWriter.println(SUCCESSFUL_LOGIN);
            user.logIn();
        }
    }
}
