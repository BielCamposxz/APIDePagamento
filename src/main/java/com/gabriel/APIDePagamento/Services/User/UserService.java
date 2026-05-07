package com.gabriel.APIDePagamento.Services.User;

import com.gabriel.APIDePagamento.Model.UsuarioModel;
import com.gabriel.APIDePagamento.Repositorio.User.IUserRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepositorio userRepositorio;

    public UsuarioModel BuscarUserInfo(int id) {
        return userRepositorio.Retornar(id);
    }

    public void Salvar(UsuarioModel usuario) {
        userRepositorio.Salvar(usuario);

    }

    public List<UsuarioModel> BuscarTodos() {
        return userRepositorio.BuscarTodos();
    }

}
