package kichwen.co.ke.rasilmali.controllers;

import kichwen.co.ke.rasilmali.models.User;
import kichwen.co.ke.rasilmali.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestEndpoints {
    @Autowired
    private UserService userService;
    @RequestMapping(value="/users/getall", method = RequestMethod.GET)
    public List<User> getUsers(){
        return userService.getAllUsers();
    }
}
