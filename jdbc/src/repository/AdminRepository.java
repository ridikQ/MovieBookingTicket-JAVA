package repository;

import model.AuthenticatedUser;
import model.User;
import util.JdbcConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static util.AdminQueries.*;

public class AdminRepository {

    public AuthenticatedUser loginUser(String email, String password) {
        AuthenticatedUser auth = null;
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(LOGIN_USER)) {
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                auth = new AuthenticatedUser();
                auth.setName(resultSet.getString(1));
                auth.setId(resultSet.getInt(2));
                auth.setRole(resultSet.getString(3));
                auth.setEmail(resultSet.getString(4));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return auth;
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USERS)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User newUser = new User();
                newUser.setId(resultSet.getInt("id"));
                newUser.setName(resultSet.getString("name"));
                newUser.setSurname(resultSet.getString("surname"));
                newUser.setBirthdate(resultSet.getDate("birthdate"));
                newUser.setRole(resultSet.getString("role"));
                newUser.setEmail(resultSet.getString("email"));
                newUser.setTelephone(resultSet.getString("telephone"));
                userList.add(newUser);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userList;
    }

    public void addUser(User user) {
        try (Connection connection = JdbcConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setTimestamp(3, new Timestamp(user.getBirthdate().getTime()));
            preparedStatement.setString(4, user.getRole());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.setString(7, user.getTelephone());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
