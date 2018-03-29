package com.endava.repository.impl;

import com.endava.model.User;
import com.endava.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {
    private final Map<String, User> userTable = new HashMap<>();


    public User getUserByName(String name) {
        return userTable.get(name);
    }

    public User saveUser(User user) {
        userTable.put(user.getUserName(), user);
        return user;
    }

    public boolean deleteUser(User user) {
        User userExits = getUserByName(user.getUserName());
        if (userExits != null) {
            userTable.remove(user.getUserName());
            return true;
        }
        return false;
    }
}
