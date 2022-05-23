package service;

import model.User;
import main.Main;
import repository.AdminRepository;

import java.util.List;

public class AdminServiceImpl implements AdminService {

   AdminRepository adminRepository=new AdminRepository();
    @Override
    public List<User> getAllUsers() {
        return adminRepository.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        adminRepository.addUser(user);
    }

    @Override
    public void loginUser(String email, String password) {
Main.auth=adminRepository.loginUser(email,password);
    }


}
