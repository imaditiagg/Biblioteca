package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.logic.Biblioteca;
import com.twu.biblioteca.logic.Library;

//Job: To represent QuitApplication Menu Item
public class QuitApplication implements MenuItem {
    private final String description;

    public QuitApplication(String description) {
        this.description = description;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public void action(Library library, Biblioteca biblioteca) {
        biblioteca.quit();
    }
}
