package com.endava.aspects;

import com.endava.aspects.service.UserService;
import com.endava.aspects.service.impl.UserServiceDefaultImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class IntroductionAspect {

//    @DeclareParents(value="com.endava.services.*+", defaultImpl=UserServiceDefaultImpl.class)
//    public static UserService userService;
}
