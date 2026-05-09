package com.gabriel.APIDePagamento.Controller;

import com.gabriel.APIDePagamento.Model.UsuarioModel;
import com.gabriel.APIDePagamento.Services.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{id}")
public class UsuarioController {

    @Autowired
    private UserService service;

    // apenas bancarios pode usar
    @GetMapping("/Usuario/ReturnAll")
    public List<UsuarioModel> BuscarTodos(@PathVariable int id) {
        return service.BuscarTodos(id);
    }

    @GetMapping("/Usuario/Informacoes")
    public UsuarioModel MostrarUsuario(@PathVariable int id) {
        return service.BuscarUserInfo(id);
    }

    // apenas bancarios podem fazer isso
    @PostMapping("/Usuario/Salvar")
    public String Salvar(@RequestBody UsuarioModel usuario, @PathVariable int id) {
        service.Salvar(usuario, id);
        return "Usuario salvo com sucesso";
    }

    @PostMapping("/PrimeiroUser")
    public void Primeiro(@RequestBody UsuarioModel usuario) {
        service.CriarPrimeiroUser(usuario);
    }

}
