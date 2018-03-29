package com.enva.aspects.service;

import com.enva.model.User;

public interface UserService {

    User getUserByName(String name);
    User saveUser(User user);
    boolean deleteUser(User user);
}
