package com.gabriel.APIDePagamento.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TransacaoSemTransmiterModel {
    public int id;
    public int userId;
    public int idUserRecived;
    public int valor;
}
