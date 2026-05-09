package com.gabriel.APIDePagamento.Services.User;

import com.gabriel.APIDePagamento.Model.UsuarioModel;

import java.util.List;

public interface IUserService {
    public UsuarioModel BuscarUserInfo(int id);

    public String Salvar(UsuarioModel usuario, int id);

    public List<UsuarioModel> BuscarTodos(int id);

    public void CriarPrimeiroUser(UsuarioModel usuario);
}
