package service;

import model.User;

import java.util.List;

public interface AdminService {

   List<User> getAllUsers();

    void addUser(User user);

    void loginUser(String email, String password);

}
