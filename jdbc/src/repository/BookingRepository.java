package repository;

import model.Booking;

import java.sql.*;

import util.JdbcConnection;

import static util.AdminQueries.*;

import java.util.*;


public class BookingRepository {
    public void addBookings(Booking booking) {
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_BOOKINGS)) {
            preparedStatement.setInt(1, booking.getUserId());
            preparedStatement.setInt(2, booking.getMovieId());
            preparedStatement.setInt(3, booking.getSeatAmount());

            preparedStatement.setTimestamp(4, new Timestamp(booking.getDate().getTime()));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Booking> getAllBookings() {
        Booking booking = null;
        List<Booking> bookingList = new ArrayList<>();
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_BOOKINGS)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                booking = new Booking();
                booking.setId(resultSet.getInt("id"));
                booking.setUserId(resultSet.getInt("user_id"));
                booking.setMovieId(resultSet.getInt("movie_id"));
                booking.setSeatAmount(resultSet.getInt("seat_amount"));
                booking.setDate(resultSet.getDate("date"));
                bookingList.add(booking);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return bookingList;
    }

    public Booking getTicketById(Integer id) {
        Booking booking = null;
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_TICKET_DETAILS)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                booking = new Booking();
                booking.setId(resultSet.getInt("id"));
                booking.setUserId(resultSet.getInt("user_id"));
                booking.setMovieId(resultSet.getInt("movie_id"));
                booking.setSeatAmount(resultSet.getInt("seat_amount"));
                booking.setDate(resultSet.getDate("date"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return booking;
    }

    public static void deleteTicket(Integer id) {
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TICKET)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
