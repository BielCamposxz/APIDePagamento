package com.gabriel.APIDePagamento.Services.User;

import com.gabriel.APIDePagamento.Model.UsuarioModel;

import java.util.List;

public interface IUserService {
    public UsuarioModel BuscarUserInfo(int id);

    public void Salvar(UsuarioModel usuario);

    public List<UsuarioModel> BuscarTodos();
}
