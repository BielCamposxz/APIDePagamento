package com.gabriel.APIDePagamento.Repositorio.User;

import com.gabriel.APIDePagamento.Model.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

public interface IUserRepositorio {

    public void Salvar(UsuarioModel usuario);

    public List<UsuarioModel> BuscarTodos();
    public void FistUser(UsuarioModel usuario);
}
