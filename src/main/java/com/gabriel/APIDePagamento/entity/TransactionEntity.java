package com.gabriel.APIDePagamento.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TransactionEntity {
    public int id;
    public int userId;
    public int idUserRecived;
    public int IdUserTransmiter;
    public int valor;
}
