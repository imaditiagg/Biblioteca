package com.twu.biblioteca.logic.Menu;

import com.twu.biblioteca.constants.Message;
import com.twu.biblioteca.logic.Library;
import com.twu.biblioteca.logic.Movie;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ViewMovies extends MenuItem {

    public ViewMovies(String description, BufferedReader bufferedReader, PrintWriter printWriter) {
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
        StringBuilder moviesList = new StringBuilder();
        ArrayList<Movie> movies = library.movies();
        for (Movie movie : movies) {
            moviesList.append(movie.display(Message.MOVIES_LIST_FORMAT));
        }
        if (moviesList.length() != 0) {
            printWriter.println(Message.MOVIES_LIST);
            printWriter.println(moviesList.toString());
        } else {
            printWriter.println(Message.NO_MOVIE_AVAILABLE);
        }
    }
}
