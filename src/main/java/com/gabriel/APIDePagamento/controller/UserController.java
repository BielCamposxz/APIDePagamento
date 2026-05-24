package com.gabriel.APIDePagamento.controller;

import com.gabriel.APIDePagamento.entity.UserEntity;
import com.gabriel.APIDePagamento.repository.user.IUserRepository;
import com.gabriel.APIDePagamento.service.user.IUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService userService;
    // apenas para testar o spring security
    private final IUserRepository userRepository;

    public UserController(IUserService userService, IUserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
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

    // apenas para testar o spring security
    @GetMapping("/all")
    public List<UserEntity> getAllUsers() {
        return this.userRepository.getAllUsers();
    }


}
