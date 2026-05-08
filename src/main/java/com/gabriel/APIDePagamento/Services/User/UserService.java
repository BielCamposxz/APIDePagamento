package com.gabriel.APIDePagamento.Services.User;

import com.gabriel.APIDePagamento.Model.UsuarioModel;
import com.gabriel.APIDePagamento.Repositorio.User.IUserRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepositorio userRepositorio;

    public UsuarioModel BuscarUserInfo(int id) {
        List<UsuarioModel> user = userRepositorio.BuscarTodos();
        return user.stream().filter(x -> x.id == id)
                .findFirst().orElse(null);
    }

    public void Salvar(UsuarioModel usuario) {
        UsuarioModel usuarioInstacia = new UsuarioModel(
                usuario.id,
                usuario.nome,
                usuario.saldo,
                usuario.TipoUser
        );
        userRepositorio.Salvar(usuarioInstacia);
    }

    public List<UsuarioModel> BuscarTodos() {
        return userRepositorio.BuscarTodos();
    }

}
