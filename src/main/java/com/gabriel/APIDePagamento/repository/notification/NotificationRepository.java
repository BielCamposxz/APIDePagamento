package com.gabriel.APIDePagamento.repository.notification;

import com.gabriel.APIDePagamento.entity.NotificationEntity;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class NotificationRepository implements INotificationRepository {
    List<NotificationEntity> allNotification = new LinkedList<>();

    public void saveNewNotification(NotificationEntity receiverNotification, NotificationEntity senderNotification){
        this.allNotification.add(receiverNotification);
        this.allNotification.add(senderNotification);
    }

    public List<NotificationEntity> getAllNotification() {
        return this.allNotification;
    }

    public List<NotificationEntity> getNotificationByUserId(int id) {
        return this.allNotification.stream().filter(x -> x.getReceiverUserId() == id).toList();
    }


}
