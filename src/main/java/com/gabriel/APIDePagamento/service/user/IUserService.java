package com.gabriel.APIDePagamento.service.user;

import com.gabriel.APIDePagamento.entity.UserEntity;

import java.util.List;

public interface IUserService {
    public UserEntity getUser(int id);

    public String saveUser(UserEntity usuario, int id);

    public List<UserEntity> getAllUsers(int id);

    public void CriarPrimeiroUser(UserEntity usuario);
}
