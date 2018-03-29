package com.enva.aspects.service;

import com.enva.model.User;
import com.enva.repository.UserRepository;

public interface UserService {

    void setUserRepository(UserRepository userRepository);
    User getUserByName(String name);
    User saveUser(User user);
    boolean deleteUser(User user);
}
