package repository;

import model.TimeTable;
import util.JdbcConnection;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static util.AdminQueries.*;

public class TimeTableRepository {
    public void addTimetable(TimeTable timeTable) {
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_TIMETABLE)) {

            preparedStatement.setDate(1, timeTable.getDate());
            preparedStatement.setInt(2, timeTable.getMovie_id());
            preparedStatement.setTime(3, timeTable.getStartTime());
            preparedStatement.setTime(4, timeTable.getEndTime());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<TimeTable> getAllTimeTablesByMovieId(Integer movie_id) {
        List<TimeTable> userList = new ArrayList<>();
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_TIMETABLESBYID)) {
            preparedStatement.setInt(1, movie_id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                TimeTable timeTable = new TimeTable();
                timeTable.setDate(resultSet.getDate("date"));
                timeTable.setMovie_id(resultSet.getInt("movie_id"));
                timeTable.setStartTime(resultSet.getTime("startTime"));
                timeTable.setEndTime(resultSet.getTime("endTime"));
                userList.add(timeTable);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userList;
    }
}

