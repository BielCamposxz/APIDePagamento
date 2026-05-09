package com.gabriel.APIDePagamento.Repositorio.Notificacao;

import com.gabriel.APIDePagamento.Model.NotificationModel;

import java.util.List;

public interface INotificacaoRepositorio {
    public void Salvar(NotificationModel notificacaoResived, NotificationModel notificacaoTransmited);
    public List<NotificationModel> BuscarResived();
    public List<NotificationModel> BuscarTransmited();
}
