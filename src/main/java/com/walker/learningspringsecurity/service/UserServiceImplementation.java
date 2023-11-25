package com.walker.learningspringsecurity.service;

import com.walker.learningspringsecurity.entity.User;
import com.walker.learningspringsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        User existUser = userRepository.findByUsername(user.getUsername());
        if(existUser != null){
            throw new Error("Usuário já cadastrado!");
        }
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }
}
