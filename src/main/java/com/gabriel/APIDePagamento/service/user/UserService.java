package com.gabriel.APIDePagamento.service.user;

import com.gabriel.APIDePagamento.objectvalue.TypeUserEnum;
import com.gabriel.APIDePagamento.entity.UserEntity;
import com.gabriel.APIDePagamento.repository.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository userRepositorio;

    public UserEntity getUser(int userId) {
        return this.userRepositorio.getUserById(userId);
    }

    public String saveNewUser(UserEntity user, int userId) {
        if(this.userRepositorio.getAllUsers().isEmpty()) {
            userRepositorio.saveUser(UserEntity.CreateNewUser(user));
            return "Usuario criado com sucesso";
        }

        UserEntity userById = this.userRepositorio.getUserById(userId);
        if(userById.getTypeUser() != TypeUserEnum.Bancario) return "Apenas bancarios pode fazer criar usuarios";


        userRepositorio.saveUser(UserEntity.CreateNewUser(user));
        return "Usuario criado com sucesso";
    }

    public List<UserEntity> getAllUsers(int userId) {
        UserEntity user = this.userRepositorio.getUserById(userId);
        if(user.getTypeUser() != TypeUserEnum.Bancario) return List.of();

        return userRepositorio.getAllUsers();
    }


}
