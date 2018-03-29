package com.endava;


import com.endava.aspects.service.UserService;
import com.endava.config.JavaConfig;
import com.endava.model.User;
import com.endava.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        ApplicationContext application = new AnnotationConfigApplicationContext(JavaConfig.class);

        User user1 = new User("user1","123456","user1@user.ro");
        User user2 = new User("user2","123456","user2@user.ro");

        UserRepository userRepository = (UserRepository) application.getBean("userRepository");

        LOGGER.info("{}",userRepository.saveUser(user1));
        LOGGER.info("{}",userRepository.saveUser(user2));



       // UserService userService = (UserService) application.getBean("springUserService");
    }
}
