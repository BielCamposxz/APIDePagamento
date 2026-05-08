package com.gabriel.APIDePagamento.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TransacaoModel {
    public int id;
    public int userId;
    public int idUserRecived;
    public int IdUserTransmiter;
    public int valor;
}
