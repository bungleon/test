package com.test.service.login;

import com.test.domain.User;
import com.test.model.request.Login;

public interface LoginService {
    public User controlUser(Login login);
}
