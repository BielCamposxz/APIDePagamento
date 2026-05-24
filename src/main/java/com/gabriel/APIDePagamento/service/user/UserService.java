package com.gabriel.APIDePagamento.service.user;

import com.gabriel.APIDePagamento.infra.exception.ForbiddenException;
import com.gabriel.APIDePagamento.infra.exception.NotFoundException;
import com.gabriel.APIDePagamento.infra.security.SecurityConfiguration;
import com.gabriel.APIDePagamento.objectvalue.TypeUserEnum;
import com.gabriel.APIDePagamento.entity.UserEntity;
import com.gabriel.APIDePagamento.repository.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository userRepositorio;

    @Autowired
    private SecurityConfiguration securityConfiguration;

    public UserEntity getUser(int userId) {
        return this.userRepositorio.getUserById(userId);
    }

    public String saveNewUser(UserEntity user, int userId) {
        user.setPassword(this.securityConfiguration.passwordEncoder().encode(user.getPassword()));

        if(this.userRepositorio.getAllUsers().isEmpty()) {
            userRepositorio.saveUser(UserEntity.CreateNewUser(user));
            return "Usuario criado com sucesso";
        }

        UserEntity userById = this.userRepositorio.getUserById(userId);
        if(userById == null) throw new NotFoundException("Nenhum usuario encontrado");
        if(userById.getTypeUser() != TypeUserEnum.Bancario) throw new ForbiddenException("Apenas bancarios podem criar usuarios");


        userRepositorio.saveUser(UserEntity.CreateNewUser(user));
        return "Usuario criado com sucesso";
    }

    public List<UserEntity> getAllUsers(int userId) {
        UserEntity user = this.userRepositorio.getUserById(userId);
        if(user == null) throw new NotFoundException("Nenhum usuario encontrado");
        if(user.getTypeUser() != TypeUserEnum.Bancario) throw new ForbiddenException("Apenas bancarios podem ver todos os usuarios");

        return userRepositorio.getAllUsers();
    }


}
