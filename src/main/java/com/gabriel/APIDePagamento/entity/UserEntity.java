package com.gabriel.APIDePagamento.entity;

import com.gabriel.APIDePagamento.objectvalue.TypeUserEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserEntity {
    private int id;
    private String name;
    private int userBalance;
    private TypeUserEnum TypeUser;

}
