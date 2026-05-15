package com.gabriel.APIDePagamento.controller;

import com.gabriel.APIDePagamento.entity.UserEntity;
import com.gabriel.APIDePagamento.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{id}")
public class UserController {

    @Autowired
    private UserService service;

    // apenas bancarios pode usar
    @GetMapping("/Usuario/ReturnAll")
    public List<UserEntity> BuscarTodos(@PathVariable int id) {
        return service.BuscarTodos(id);
    }

    @GetMapping("/Usuario/Informacoes")
    public UserEntity MostrarUsuario(@PathVariable int id) {
        return service.BuscarUserInfo(id);
    }

    // apenas bancarios podem fazer isso
    @PostMapping("/Usuario/Salvar")
    public String Salvar(@RequestBody UserEntity usuario, @PathVariable int id) {
        service.Salvar(usuario, id);
        return "Usuario salvo com sucesso";
    }

    @PostMapping("/PrimeiroUser")
    public void Primeiro(@RequestBody UserEntity usuario) {
        service.CriarPrimeiroUser(usuario);
    }

}
