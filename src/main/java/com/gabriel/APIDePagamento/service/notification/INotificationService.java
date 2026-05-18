package com.gabriel.APIDePagamento.service.notification;

import com.gabriel.APIDePagamento.entity.NotificationEntity;
import com.gabriel.APIDePagamento.entity.TransactionEntity;

import java.util.List;

public interface INotificationService {
    public void createNotification(TransactionEntity transaction);
    public List<NotificationEntity> getNotificationByUserId(int id);
    public List<NotificationEntity> getAllNotification(int id);
}
