package com.efg.clientbackend.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.efg.clientbackend.entities.User;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import com.efg.clientbackend.service.UserService;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private static final Logger LOG = getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Map<String, List<User>> getUsersGroups() {
        final Map<String, List<User>> usersGroups = userService.findAllGroupByGroupId();
        usersGroups.forEach((group, users) -> LOG.info("Retrieving group {} users {}", group, Arrays.toString(users.toArray())));
        return usersGroups;
    }

    @PostMapping("/user")
    void addUser(@RequestBody User user) {
        LOG.info("Saving user {}", user);
        userService.save(user);
    }

    @DeleteMapping("/user")
    void deleteUser(@RequestParam String userId) {
        LOG.info("Deleting user with id {}", userId);
        userService.delete(userId);
    }
}