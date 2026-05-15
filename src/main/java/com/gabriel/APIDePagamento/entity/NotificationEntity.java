package com.gabriel.APIDePagamento.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class NotificationEntity {
    public int id;
    public int valor;
    public int idUserRecived;
    public int IdUserTransmiter;
    public String texto;
}
