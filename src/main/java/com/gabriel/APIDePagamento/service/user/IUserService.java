package com.gabriel.APIDePagamento.service.user;

import com.gabriel.APIDePagamento.entity.UserEntity;

import java.util.List;

public interface IUserService {
    public UserEntity getUser(int userId);

    public String saveNewUser(UserEntity user, int userId);

    public List<UserEntity> getAllUsers(int userId);

}
