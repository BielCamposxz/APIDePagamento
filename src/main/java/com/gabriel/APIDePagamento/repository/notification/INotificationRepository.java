package com.gabriel.APIDePagamento.repository.notification;

import com.gabriel.APIDePagamento.entity.NotificationEntity;

import java.util.List;

public interface INotificationRepository {
    public void saveNewNotification(NotificationEntity receiverNotification, NotificationEntity senderNotification);
    public List<NotificationEntity> getAllNotification();
    public List<NotificationEntity> getNotificationByUserId(int id);
}
