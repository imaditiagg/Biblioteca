package com.twu.biblioteca;

public class QuitApplication implements MenuItem {
    private final String description;

    QuitApplication(String description) {
        this.description = description;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public void action(Library library, Biblioteca biblioteca) {
        System.exit(0);
    }
}
