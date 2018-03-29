package com.endava.aspects.service;

import com.endava.model.User;

public interface UserService {

    User getUserByName(String name);
    User saveUser(User user);
    boolean deleteUser(User user);
}
