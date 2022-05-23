package repository;

import model.Movie;
import model.Theater;
import util.JdbcConnection;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static util.AdminQueries.*;


public class MovieRepository {
    public void addMovie(Movie movie) {
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_MOVIE)) {

            preparedStatement.setString(1, movie.getName());
            preparedStatement.setString(2, movie.getType());
            preparedStatement.setString(3, movie.getTechnology());
            preparedStatement.setDouble(4, movie.getRating());
            preparedStatement.setInt(5, movie.getTheaterId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Movie> getAllMovies() {

        List<Movie> userList = new ArrayList<>();
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_MOVIES)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setId(resultSet.getInt("id"));
                movie.setName(resultSet.getString("name"));
                movie.setType(resultSet.getString("movie_type"));
                movie.setTechnology(resultSet.getString("technology"));
                movie.setRating(resultSet.getDouble("rating"));
                movie.setTheaterId(resultSet.getInt("theater_id"));
                userList.add(movie);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userList;
    }

    public static void deleteMovie(Integer id) {

        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MOVIE)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void addTheater(Theater theater) {
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_THEATER)) {

            preparedStatement.setString(1, theater.getTheaterName());
            preparedStatement.setInt(2, theater.getSeatsTotal());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Theater> getAllTheaters() {

        List<Theater> userList = new ArrayList<>();
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_THEATERS)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Theater theater = new Theater();
                theater.setTheaterId(resultSet.getInt("id"));
                theater.setTheaterName(resultSet.getString("name"));
                theater.setSeatsTotal(resultSet.getInt("seats_total"));
                userList.add(theater);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userList;
    }

}
