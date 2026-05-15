package com.gabriel.APIDePagamento.service.notification;

import com.gabriel.APIDePagamento.entity.NotificationEntity;

import java.util.List;

public interface INotificationService {
    public void CriarNotificacao();
    public List<NotificationEntity> BuscarPorId(int id);
    public int UltimaNotificacao();
    public List<NotificationEntity> RetornarAll(int id);
}
