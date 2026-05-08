package com.gabriel.APIDePagamento.Controller;

import com.gabriel.APIDePagamento.Model.UsuarioModel;
import com.gabriel.APIDePagamento.Services.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UsuarioController {

    @Autowired
    private UserService service;

    @GetMapping("/{id}/Usuario/ReturnAll")
    public List<UsuarioModel> BuscarTodos(@PathVariable int id) {
        return  service.BuscarTodos();
    }

    @GetMapping("/{id}/Usuario/Informacoes")
    public UsuarioModel MostrarUsuario(@PathVariable int id) {
        return service.BuscarUserInfo(id);
    }

    @PostMapping("/Usuario/Salvar")
    public String Salvar(@RequestBody UsuarioModel usuario) {
        service.Salvar(usuario);
        return "Usuario salvo com sucesso";
    }

}
