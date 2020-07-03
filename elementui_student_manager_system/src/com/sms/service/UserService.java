package com.sms.service;

import com.sms.domain.User;

public interface UserService {
    User login(String username, String password);
}
