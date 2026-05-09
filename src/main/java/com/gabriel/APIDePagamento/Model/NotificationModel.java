package com.gabriel.APIDePagamento.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class NotificationModel {
    public int id;
    public int valor;
    public int idUserRecived;
    public int IdUserTransmiter;
    public String texto;
}
