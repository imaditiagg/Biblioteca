package com.twu.biblioteca;

public class ReturnBook implements MenuItem {
    private final String description;

    ReturnBook(String description) {
        this.description = description;
    }

    @Override
    public String description() {
        return description;
    }
}
