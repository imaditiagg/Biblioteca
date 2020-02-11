package com.twu.biblioteca.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

//To provide interface to the client
public interface UserInterface {
    String welcomeMessage();

    StringBuilder displayMenu();

    void execute(int index, BufferedReader bufferedReader, PrintWriter printWriter) throws IOException;
}
