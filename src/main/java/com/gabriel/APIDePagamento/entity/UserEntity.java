package com.gabriel.APIDePagamento.entity;

import com.gabriel.APIDePagamento.objectvalue.TypeUserEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserEntity {
    public int id;
    public String nome;
    public int saldo;
    public TypeUserEnum TipoUser;

}
