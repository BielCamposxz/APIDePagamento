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
    List<UserEntity> user = new LinkedList<>();

    public void Salvar(UserEntity usuario)
    {
        user.add(usuario);
    }

    public void FistUser(UserEntity usuario) {
        UserEntity primeiroUsuario = new UserEntity(
                usuario.id,
                usuario.nome,
                usuario.saldo,
                usuario.TipoUser
        );
        user.add(primeiroUsuario);
    }

    public List<UserEntity> BuscarTodos() {
        return user;
    }
}
