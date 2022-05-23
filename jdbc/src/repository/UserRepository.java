package repository;


import model.User;
import util.JdbcConnection;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static util.AdminQueries.*;

public class UserRepository {

    public User getUserById(Integer id) {
        User user = null;
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_DETAILS)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setBirthdate(resultSet.getDate("birthdate"));
                user.setRole(resultSet.getString("role"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setTelephone(resultSet.getString("telephone"));


            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }
}
