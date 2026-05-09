package com.gabriel.APIDePagamento.Services.User;

import com.gabriel.APIDePagamento.Enum.TypeUserEnum;
import com.gabriel.APIDePagamento.Model.UsuarioModel;
import com.gabriel.APIDePagamento.Repositorio.User.IUserRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepositorio userRepositorio;

    public UsuarioModel BuscarUser(int id) {
        return userRepositorio.BuscarTodos().stream().filter(x -> x.id == id).findFirst().orElse(null);
    }

    public UsuarioModel BuscarUserInfo(int id) {
        return BuscarUser(id);
    }

    public String Salvar(UsuarioModel usuario, int id) {
        UsuarioModel usuarioRetornado = BuscarUser(id);

        if(usuarioRetornado.TipoUser != TypeUserEnum.Bancario) {
            return "Apenas bancarios pode fazer criar usuarios";
        }

        UsuarioModel usuarioInstacia = new UsuarioModel(
                usuario.id,
                usuario.nome,
                usuario.saldo,
                usuario.TipoUser
        );
        userRepositorio.Salvar(usuarioInstacia);
        return "Usuario criado com sucesso";
    }

    public List<UsuarioModel> BuscarTodos(int id) {
        UsuarioModel usuario = BuscarUser(id);

        if(usuario.TipoUser != TypeUserEnum.Bancario) {
            return null;
        }

        return userRepositorio.BuscarTodos();
    }

    public void CriarPrimeiroUser(UsuarioModel usuario) {
        userRepositorio.FistUser(usuario);
    }

}
