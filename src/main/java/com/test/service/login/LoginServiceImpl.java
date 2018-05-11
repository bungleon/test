package com.test.service.login;

import com.test.domain.User;
import com.test.model.request.Login;
import com.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    UserRepository userRepository;

    @Autowired
    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User controlUser(Login login){
        return userRepository.findByUserNameAndPassword(login.getUserName(),login.getPassword());
    }
}
