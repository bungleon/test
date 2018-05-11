package com.test;


import com.test.domain.User;
import com.test.model.request.Login;
import com.test.repository.UserRepository;
import com.test.service.login.LoginService;
import com.test.service.login.LoginServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {
    LoginService loginService;
    UserRepository userRepository;
    @Before
    public void init(){
        //mock to database connection class
        userRepository= Mockito.mock(UserRepository.class);
        loginService=new LoginServiceImpl(userRepository);
    }

    @Test
    public void contolUserTest(){
        User user;
        Login login=new Login();
        login.setUserName("erman");
        login.setPassword("oz");
        User userControl=new User();
        userControl.setPassword("123456");
        userControl.setUserName("erman");
        Mockito.when(userRepository.findByUserNameAndPassword(Mockito.anyString(),Mockito.anyString())).thenReturn(userControl);
        user=loginService.controlUser(login);
        Assert.assertNotNull(user);
        Assert.assertEquals(user.getUserName(),"erman");
        Assert.assertEquals(user.getPassword(),"123456");
    }

}
