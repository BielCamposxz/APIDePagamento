package com.gabriel.APIDePagamento.repository.notification;

import com.gabriel.APIDePagamento.entity.NotificationEntity;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class NotificationRepository implements INotificationRepository {
    List<NotificationEntity> AllNotification = new LinkedList<>();

    public void saveNewNotification(NotificationEntity receiverNotification, NotificationEntity senderNotification){
        this.AllNotification.add(receiverNotification);
        this.AllNotification.add(senderNotification);
    }

    public List<NotificationEntity> getAllNotification() {
        return this.AllNotification;
    }


}
