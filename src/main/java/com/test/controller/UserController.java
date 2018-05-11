package com.test.controller;

import com.test.domain.User;
import com.test.model.request.UserRequest;
import com.test.model.response.UserResponse;
import com.test.repository.UserRepository;
import com.test.service.user.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }


    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public UserResponse getToString(@RequestBody UserRequest userRequest) {
        try {
            if (userRequest.equals(null)) {
                return null;
            } else {

                return userService.userList(userRequest);
            }
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@RequestBody UserRequest userRequest) {
        try {
            return userService.saveUser(userRequest).toString();
        } catch (Exception e) {
            return "Exception";
        }
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.POST)
    public List<User> getPageableUser() {
        PageRequest request = new PageRequest(1, 4);
        return userRepository.findByStatusTrue(request);
    }

    @RequestMapping(value = "/getlist", method = RequestMethod.POST)
    public List<User> getList() {
        PageRequest request = new PageRequest(0, 4);
        return userRepository.findByStatusTrueAndNoBetweenAndId(0, 100, UUID.fromString("051623fd-8cbb-413d-a5f7-15b4d2ef0900"),request);
    }
}
