package com.enva.aspects;

import com.enva.aspects.service.UserService;
import com.enva.aspects.service.impl.UserServiceDefaultImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class IntroductionAspect {

    @DeclareParents(value="com.enva.services.*+", defaultImpl=UserServiceDefaultImpl.class)
    public static UserService userService;
}
