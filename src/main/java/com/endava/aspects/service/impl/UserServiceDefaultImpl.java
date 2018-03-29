package com.endava.aspects.service.impl;


import com.endava.aspects.service.UserService;
import com.endava.model.User;
import com.endava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceDefaultImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceDefaultImpl(UserRepository userRepository) {
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
