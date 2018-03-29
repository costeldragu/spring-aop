package com.enva.aspects.service.impl;


import com.enva.aspects.service.UserService;
import com.enva.model.User;
import com.enva.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceDefaultImpl implements UserService {

    private  UserRepository userRepository;

    public UserServiceDefaultImpl() {};

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByName(String name) {
        return userRepository.getUserByName(name);
    }

    public User saveUser(User user) {
        return userRepository.saveUser(user);
    }

    public boolean deleteUser(User user) {
        return userRepository.deleteUser(user);
    }


}
