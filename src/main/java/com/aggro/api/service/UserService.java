package com.aggro.api.service;

import com.aggro.api.entity.Badge;
import com.aggro.api.entity.User;
import com.aggro.api.model.addBadge.AddBadgeResponse;
import com.aggro.api.model.login.LoginResponse;
import com.aggro.api.model.register.RegisterResponse;
import com.aggro.api.repository.BadgeRepository;
import com.aggro.api.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yeko on 17/10/15.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BadgeRepository badgeRepository;

    public RegisterResponse register(User newUser) {

        RegisterResponse registerResponse = new RegisterResponse();

        if (userRepository.findByEmail(newUser.getEmail()) == null) {
            LinkedList<String> badges = new LinkedList<>();
            User user = new User();
            user.setBadges(badges);
            user.setEmail(newUser.getEmail());
            user.setPassword(newUser.getPassword());
            user.setUsername(newUser.getUsername());
            userRepository.save(user);
            registerResponse.setRegisterResponseCode(0);
            registerResponse.setRegisterResponseDesc("Successfully Registered!");
            registerResponse.setRegisteredUser(user);
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

    public AddBadgeResponse addBadge(String aggroID, String badgeID) {
        Badge badge = badgeRepository.findByBadgeID(badgeID);
        AddBadgeResponse addBadgeResponse = new AddBadgeResponse();
        if (badge == null) {
            addBadgeResponse.setAddBadgeResponseCode(-2);
            addBadgeResponse.setAddBadgeResponseDesc("Badge Does Not Exist!");
        } else {
            User user = userRepository.findByAggroID(aggroID);
            user.getBadges().add(badgeID);
            user.setBadges(user.getBadges());
            userRepository.save(user);
            addBadgeResponse.setAddBadgeResponseCode(0);
            addBadgeResponse.setAddBadgeResponseDesc("Add Badge Successful!");
            badge.setUsers(badge.getUsers() + 1);
            badgeRepository.save(badge);
        }
        return addBadgeResponse;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public LinkedList<String> getUserBadges(String aggroID) {
        return userRepository.findByAggroID(aggroID).getBadges();
    }

}
