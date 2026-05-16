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

    @GetMapping("/{id}/all")
    public List<UserEntity> getAllUsers(@PathVariable int id) {
        return this.userService.getAllUsers(id);
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable int id) {
        return this.userService.getUser(id);
    }

    @PostMapping("/{id}")
    public String saveNewUser(@RequestBody UserEntity user, @PathVariable int id) {
        return this.userService.saveUser(user, id);
    }

    // tem que sumir
    @PostMapping("/CreatefistUser")
    public void Primeiro(@RequestBody UserEntity usuario) {
        this.userService.CriarPrimeiroUser(usuario);
    }

}
