package com.gabriel.APIDePagamento.repository.notification;

import com.gabriel.APIDePagamento.entity.NotificationEntity;

import java.util.List;

public interface INotificationRepository {
    public void Salvar(NotificationEntity notificacaoResived, NotificationEntity notificacaoTransmited);
    public List<NotificationEntity> BuscarResived();
    public List<NotificationEntity> BuscarTransmited();
    public List<NotificationEntity> BuscarTodas();
}
