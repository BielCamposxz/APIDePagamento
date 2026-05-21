package com.gabriel.APIDePagamento.controller;

import com.gabriel.APIDePagamento.entity.UserEntity;
import com.gabriel.APIDePagamento.service.user.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}/all")
    public List<UserEntity> getAllUsers(@PathVariable int userId) {
        return this.userService.getAllUsers(userId);
    }

    @GetMapping("/{userId}")
    public UserEntity getUserInformationById(@PathVariable int userId) {
        return this.userService.getUser(userId);
    }

    @PostMapping("/{userId}")
    public String saveNewUser(@RequestBody UserEntity user, @PathVariable int userId) {
        return this.userService.saveNewUser(user, userId);
    }

}
