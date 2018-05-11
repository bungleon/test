package com.test.service.user;

import com.test.domain.User;
import com.test.model.request.UserRequest;
import com.test.model.response.UserResponse;

public interface UserService {
    public UserResponse userList(UserRequest userRequest);
    public User saveUser(UserRequest userRequest);
}
