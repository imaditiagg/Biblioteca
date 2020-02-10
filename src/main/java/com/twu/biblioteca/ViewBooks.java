package com.twu.biblioteca;

public class ViewBooks implements MenuItem {
    private final String description;

    ViewBooks(String description) {
        this.description = description;
    }

    @Override
    public String description() {
        return description;
    }
}
