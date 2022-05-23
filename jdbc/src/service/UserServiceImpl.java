package service;

import model.User;
import repository.UserRepository;

public class UserServiceImpl implements UserService {
    UserRepository userRepository = new UserRepository();

    @Override
    public User getUserById(Integer id) {
        return userRepository.getUserById(id);
    }
}
