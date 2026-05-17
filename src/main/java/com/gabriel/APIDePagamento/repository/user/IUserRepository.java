package com.gabriel.APIDePagamento.repository.user;

import com.gabriel.APIDePagamento.entity.UserEntity;

import java.util.List;

public interface IUserRepository {

    public void Salvar(UserEntity usuario);

    public List<UserEntity> BuscarTodos();
    public void FistUser(UserEntity usuario);
    public UserEntity getUserById(int id);
}
