package com.gabriel.APIDePagamento.repository.user;

import com.gabriel.APIDePagamento.entity.UserEntity;

import java.util.List;

public interface IUserRepository {

    public void saveUser(UserEntity usuario);

    public List<UserEntity> getAllUsers();
    public UserEntity getUserById(int userId);
}
