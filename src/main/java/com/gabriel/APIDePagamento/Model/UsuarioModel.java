package com.gabriel.APIDePagamento.Model;

import com.gabriel.APIDePagamento.Enum.TypeUserEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioModel {
    public int id;
    public String nome;
    public int saldo;
    public TypeUserEnum TipoUser;

}
