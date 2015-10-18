package com.aggro.api.service;

import com.aggro.api.entity.User;
import com.aggro.api.model.login.LoginResponse;
import com.aggro.api.model.register.RegisterResponse;
import com.aggro.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yeko on 17/10/15.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public RegisterResponse register(User newUser) {

        RegisterResponse registerResponse = new RegisterResponse();

        if (userRepository.findByEmail(newUser.getEmail()) == null) {
            User user = new User();
            user.setBadge(0);
            user.setEmail(newUser.getEmail());
            user.setPassword(newUser.getPassword());
            user.setUsername(newUser.getUsername());
            userRepository.save(user);
            registerResponse.setRegisterResponseCode(0);
            registerResponse.setRegisterResponseDesc("Successfully Registered!");
        } else {
            registerResponse.setRegisterResponseCode(-1);
            registerResponse.setRegisterResponseDesc("Email Already Registered!");
        }

        return registerResponse;

    }

    public LoginResponse login(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        LoginResponse loginResponse = new LoginResponse();
        if(user == null) {
            loginResponse.setLoggedInUser(null);
            loginResponse.setLoginResponseCode(-1);
            loginResponse.setLoginResponseDesc("Wrong Email or Password!");
        } else {
            loginResponse.setLoggedInUser(user);
            loginResponse.setLoginResponseCode(0);
            loginResponse.setLoginResponseDesc("Login Successful!");
        }
        return loginResponse;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
