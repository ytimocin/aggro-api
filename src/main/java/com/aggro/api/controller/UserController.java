package com.aggro.api.controller;

import com.aggro.api.entity.User;
import com.aggro.api.model.addBadge.AddBadgeResponse;
import com.aggro.api.model.login.LoginRequest;
import com.aggro.api.model.login.LoginResponse;
import com.aggro.api.model.register.RegisterResponse;
import com.aggro.api.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yeko on 17/10/15.
 */
@RestController
@RequestMapping("/aggro/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public RegisterResponse register(@RequestBody User newUser) {
        RegisterResponse registerResponse = userService.register(newUser);
        return registerResponse;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
        return loginResponse;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/{aggroID}/addBadge/{badgeID}", method = RequestMethod.POST)
    public AddBadgeResponse addBadge(@PathVariable String aggroID, @PathVariable String badgeID) {
        return userService.addBadge(aggroID, badgeID);
    }

    @RequestMapping(value = "/{aggroID}/badges", method = RequestMethod.GET)
    public LinkedList<String> getUserBadges(@PathVariable String aggroID) {
        return userService.getUserBadges(aggroID);
    }

    /*
    @RequestMapping(value = "/facebookID/{facebookID}", method = RequestMethod.GET)
    public Student register(@PathVariable String facebookID) {
        return studentService.getStudentByFacebookID(facebookID);
    }
    */

    /*
    @RequestMapping(method = RequestMethod.GET)
    public List<Student> getAll() {
        return repo.findAll();
    }

    @RequestMapping(method = RequestMethod.GET)
    public Student get(@RequestParam("facebookID") String facebookID) {
        return repo.findByFacebookID(facebookID);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Student create(@RequestBody Student student) {
        return repo.save(student);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable String id) {
        repo.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public Student update(@PathVariable String id, @RequestBody Student tebeshirUser) {
        Student update = repo.findOne(id);
        update.setFacebookID(tebeshirUser.getFacebookID());
        update.setEmail(tebeshirUser.getEmail());
        update.setName(tebeshirUser.getName());
        update.setPictureURL(tebeshirUser.getPictureURL());
        return repo.save(update);
    }
    */
}
