package service;

import model.Booking;
import model.Movie;
import model.Theater;
import repository.MovieRepository;

import java.util.List;

public class MovieServiceImpl implements MovieService {
    MovieRepository movieRepository=new MovieRepository();
    Booking booking=new Booking();
    public void addMovie(Movie movie) {
        movieRepository.addMovie(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.getAllMovies();
    }

    @Override
    public void deleteMovie(Integer id) {
        movieRepository.deleteMovie(id);
    }

    @Override
    public void addTheater(Theater theater) {
        movieRepository.addTheater(theater);
    }

    @Override
    public List<Theater> getAllTheaters() {
        return movieRepository.getAllTheaters();
    }

    }
