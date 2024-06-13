package com.education.liberedu.controller;

import com.education.liberedu.persistence.entity.User;
import com.education.liberedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<User> findUser(@PathVariable("id") Long id) {
        return userService.finalUserById(id);
    }

    @GetMapping
    public Optional<List<User>> findAllUsers() {
        return userService.findAllUsers();
    }

    @PutMapping(path = "/{id}")
    public User updateUser(@PathVariable("id") Long id,
                           @RequestBody User request) {
        return userService.updateUser(id, request);
    }

    @DeleteMapping(path = "/{id}")
    public Boolean deleteUser(@PathVariable("id") Long id) {
        return userService.deleteById(id);
    }
}
