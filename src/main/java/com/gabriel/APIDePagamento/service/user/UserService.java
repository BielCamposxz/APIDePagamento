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

    public UserEntity BuscarUser(int id) {
        return userRepositorio.BuscarTodos().stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }

    public UserEntity getUser(int id) {
        return BuscarUser(id);
    }

    public String saveUser(UserEntity usuario, int id) {
        UserEntity usuarioRetornado = BuscarUser(id);

        if(usuarioRetornado.getTypeUser() != TypeUserEnum.Bancario) {
            return "Apenas bancarios pode fazer criar usuarios";
        }

        UserEntity usuarioInstacia = new UserEntity(
                usuario.getId(),
                usuario.getName(),
                usuario.getUserBalance(),
                usuario.getTypeUser()
        );
        userRepositorio.Salvar(usuarioInstacia);
        return "Usuario criado com sucesso";
    }

    public List<UserEntity> getAllUsers(int id) {
        UserEntity usuario = BuscarUser(id);

        if(usuario.getTypeUser() != TypeUserEnum.Bancario) {
            return null;
        }

        return userRepositorio.BuscarTodos();
    }

    public void CriarPrimeiroUser(UserEntity usuario) {
        userRepositorio.FistUser(usuario);
    }

}
