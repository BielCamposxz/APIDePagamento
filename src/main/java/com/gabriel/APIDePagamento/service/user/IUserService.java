package com.gabriel.APIDePagamento.service.user;

import com.gabriel.APIDePagamento.entity.UserEntity;

import java.util.List;

public interface IUserService {
    public UserEntity BuscarUserInfo(int id);

    public String Salvar(UserEntity usuario, int id);

    public List<UserEntity> BuscarTodos(int id);

    public void CriarPrimeiroUser(UserEntity usuario);
}
