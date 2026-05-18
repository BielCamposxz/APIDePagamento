package com.gabriel.APIDePagamento.repository.user;

import com.gabriel.APIDePagamento.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Repository
public class UserRepository implements IUserRepository {
    List<UserEntity> users = new LinkedList<>();

    public void Salvar(UserEntity usuario)
    {
        users.add(usuario);
    }

    public void FistUser(UserEntity usuario) {
        users.add(new UserEntity(
                usuario.getId(),
                usuario.getName(),
                usuario.getUserBalance(),
                usuario.getTypeUser()
        ));
    }

    public List<UserEntity> BuscarTodos() {
        return users;
    }

    public UserEntity getUserById(int id) {
        return this.users.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }
}
