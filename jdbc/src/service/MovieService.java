package service;

import model.Movie;
import model.Theater;

import java.util.List;

public interface MovieService {
    void addMovie(Movie movie);

    List<Movie> getAllMovies();

    void deleteMovie(Integer id);

    void addTheater(Theater theater);

    List<Theater> getAllTheaters();

}
