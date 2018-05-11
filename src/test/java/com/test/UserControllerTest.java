package com.test;

import com.test.controller.UserController;
import com.test.domain.User;
import com.test.model.request.UserRequest;
import com.test.model.response.UserResponse;
import com.test.repository.UserRepository;
import com.test.service.user.UserService;
import com.test.service.user.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

/*@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
    UserController userController;
    UserRepository userRepository;
    UserService userService;

    public void init(){
        this.userRepository = Mockito.mock(UserRepository.class);
        this.userService=new UserServiceImpl(userRepository);
        this.userController=new UserController(userService);
    }

    @Test
    public void testUserList(){
        this.init();

        UserRequest userRequest=new UserRequest();
        UserResponse userResponse=userController.getToString(userRequest);
        Assert.assertNotNull(userResponse);
        Assert.assertEquals(userResponse.getName(),"Erman ÖZ");
        Assert.assertEquals(userResponse.getId(),"123");
    }
    @Test
    public void testUserSave(){
        this.init();
        UserRequest userRequest=new UserRequest();
        userRequest.setUserName("demo@bumin.io");
        userRequest.setPassword("123456");
        User user = new User();
        user.setUserName("demo@bumin.io");
        user.setPassword("123456");
        //Mocklama
        Mockito.when(userRepository.findByUserNameAndPassword(Mockito.anyString(),Mockito.anyString())).thenReturn(user);
        String userResponse=userController.saveUser(userRequest);
        Assert.assertNotNull(userResponse);
        Assert.assertEquals(userResponse,"User{userName='DOLU', password='DOLU'}");
    }
}*/