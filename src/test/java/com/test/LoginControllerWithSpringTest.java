package com.test;

import com.test.controller.LoginController;
import com.test.domain.User;
import com.test.model.request.Login;
import com.test.service.login.LoginService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginControllerWithSpringTest {
    @Autowired
    LoginController loginController;
    @Autowired
    LoginService loginService;

    @Test
    public void testLoginGet(){
        String loginRetValue=loginController.login();
        Assert.assertEquals(loginRetValue,"login");
    }

    @Test
    public void testLoginService(){
        Login login=new Login();
        login.setUserName("demo@bumin.io");
        login.setPassword("123456");
        User user=loginService.controlUser(login);
        Assert.assertNotNull(user);
        Assert.assertEquals(user.getPassword(),"123456");
        Assert.assertEquals(user.getUserName(),"demo@bumin.io");
        Login login2=new Login();
        login2.setUserName("üüafgdsfıhfg");
        login2.setPassword("fkdfdfıo");
        User user2=loginService.controlUser(login2);
        Assert.assertNull(user2);
    }
}
