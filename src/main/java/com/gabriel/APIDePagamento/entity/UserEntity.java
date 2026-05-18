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
    private double userBalance;
    private TypeUserEnum TypeUser;

    public void deposit(double value) {
        this.userBalance += value;
    }

    public void withdraw(double value) {
        this.userBalance -= value;
    }

}
