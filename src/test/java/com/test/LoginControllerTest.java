package com.test;


import com.test.controller.LoginController;
import com.test.repository.UserRepository;
import com.test.service.login.LoginService;
import com.test.service.login.LoginServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {
    LoginController loginController;
    LoginService loginService;
    UserRepository userRepository;
    @Before
    @BeforeAll
    public void init(){
        userRepository= Mockito.mock(UserRepository.class);
        loginService=new LoginServiceImpl(userRepository);
        loginController=new LoginController(loginService);
    }
    @Test
    public void loginGetController(){
        String login=loginController.login();
        Assert.assertEquals(login,"login");
    }
}
