package com.enva.services.impl;


import com.enva.model.User;
import com.enva.services.SpringUserService;
import org.springframework.stereotype.Service;

@Service("springUserService")
public class SpringUserServiceImpl implements SpringUserService {
    @Override
    public User setUserId(User user, Long id) {
        user.setUserId(id);
        return user;
    }
}
