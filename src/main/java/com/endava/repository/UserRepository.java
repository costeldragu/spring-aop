package com.endava.repository;

import com.endava.model.User;

public interface UserRepository {

    User getUserByName(String name);
    User saveUser(User user);
    boolean deleteUser(User user);
}
