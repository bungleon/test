package com.test.service.user;

import com.test.domain.User;
import com.test.model.request.UserRequest;
import com.test.model.response.UserResponse;
import com.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserResponse userList(UserRequest userRequest){
        UserResponse userResponse=new UserResponse();
        userResponse.setId("123");
        userResponse.setName("Erman ÖZ");
        return userResponse;
    }
    @Override
    public User saveUser(UserRequest userRequest){
        User  user = new User();
        user.setUserName(userRequest.getUserName());
        user.setPassword(userRequest.getPassword());
        User controlUser=userRepository.findByUserNameAndPassword(user.getUserName(),user.getPassword());
        //null.equals() patlar
        if(controlUser==null){
            //null ise
            System.out.print("null");
            return userRepository.save(user);
        }
        else {
            if (controlUser.getUserName().equals("") && controlUser.getPassword().equals("")){
                //is empty
                System.out.print("return empty");
                return userRepository.save(user);
            }
            else{
                //full there is a user
                System.out.print("not empty");
                user.setUserName("DOLU");
                user.setPassword("DOLU");
                return user;
            }
        }
        //return userRepository.save(user);
    }

}
