package com.gabriel.APIDePagamento.Repositorio.User;

import com.gabriel.APIDePagamento.Model.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Repository
public class UserRepositorio implements IUserRepositorio{
    List<UsuarioModel> user = new LinkedList<>();

    public void Salvar(UsuarioModel usuario)
    {
        user.add(usuario);
    }

    public List<UsuarioModel> BuscarTodos() {
        return user;
    }
}
