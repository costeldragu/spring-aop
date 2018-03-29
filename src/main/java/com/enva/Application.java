package com.enva;


import com.enva.aspects.service.UserService;
import com.enva.config.JavaConfig;
import com.enva.model.User;
import com.enva.repository.UserRepository;
import com.enva.services.SpringUserService;
import com.enva.services.impl.SpringUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        ApplicationContext application = new AnnotationConfigApplicationContext(JavaConfig.class);

        User user1 = new User("user1", "123456", "user1@user.ro");
        User user2 = new User("user2", "123456", "user2@user.ro");
        User user3 = new User("user3", "123456", "user3@user.ro");

        UserRepository userRepository = (UserRepository) application.getBean("userRepository");

        LOGGER.info("{}", userRepository.saveUser(user1));
        LOGGER.info("{}", userRepository.saveUser(user2));


        SpringUserService springUserService = (SpringUserService) application.getBean("springUserService");
        springUserService.setUserId(user3, 1L);
        ((UserService) springUserService).setUserRepository(userRepository);
        LOGGER.info("{}", ((UserService) springUserService).saveUser(user3));
    }
}
