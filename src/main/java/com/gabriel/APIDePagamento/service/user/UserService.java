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
        return userRepositorio.BuscarTodos().stream().filter(x -> x.id == id).findFirst().orElse(null);
    }

    public UserEntity BuscarUserInfo(int id) {
        return BuscarUser(id);
    }

    public String Salvar(UserEntity usuario, int id) {
        UserEntity usuarioRetornado = BuscarUser(id);

        if(usuarioRetornado.TipoUser != TypeUserEnum.Bancario) {
            return "Apenas bancarios pode fazer criar usuarios";
        }

        UserEntity usuarioInstacia = new UserEntity(
                usuario.id,
                usuario.nome,
                usuario.saldo,
                usuario.TipoUser
        );
        userRepositorio.Salvar(usuarioInstacia);
        return "Usuario criado com sucesso";
    }

    public List<UserEntity> BuscarTodos(int id) {
        UserEntity usuario = BuscarUser(id);

        if(usuario.TipoUser != TypeUserEnum.Bancario) {
            return null;
        }

        return userRepositorio.BuscarTodos();
    }

    public void CriarPrimeiroUser(UserEntity usuario) {
        userRepositorio.FistUser(usuario);
    }

}
