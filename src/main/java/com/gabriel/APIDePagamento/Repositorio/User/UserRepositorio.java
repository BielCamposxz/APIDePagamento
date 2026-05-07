package com.gabriel.APIDePagamento.Repositorio.User;

import com.gabriel.APIDePagamento.Model.UsuarioModel;
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
public class UserRepositorio implements IUserRepositorio{
    List<UsuarioModel> user = new LinkedList<>();

    public void Salvar(UsuarioModel usuario)
    {
        UsuarioModel usuarioInstacia = new UsuarioModel(
                usuario.id,
                usuario.nome,
                usuario.saldo,
                usuario.TipoUser
        );
        user.add(usuarioInstacia);
    }

    public UsuarioModel Retornar(int id) {
        return user.stream().filter(x -> x.id == id)
                .findFirst().orElse(null);
    }

    public List<UsuarioModel> BuscarTodos() {
        return user;
    }
}
