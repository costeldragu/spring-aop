package com.enva.repository;

import com.enva.model.User;

public interface UserRepository {

    User getUserByName(String name) throws Exception;
    User saveUser(User user);
    boolean deleteUser(User user);
}
