package com.walker.learningspringsecurity.service;

import com.walker.learningspringsecurity.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User create(User user);
}
