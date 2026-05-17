package com.gabriel.APIDePagamento.entity;

import com.gabriel.APIDePagamento.objectvalue.NotificationTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class NotificationEntity {
    private int id;
    private NotificationTypeEnum notificationType;
    private int transitionValue;
    private int receiverUserId;
    private int senderUserId;
    private String notificationMessage;

    public static NotificationEntity createNewReceiverNotification(TransactionEntity lastTransaction, String receivedName) {
        String message = "Voce Recebeu " + lastTransaction.getTransitionValue() + " de " + receivedName;
        return new NotificationEntity(
                lastTransaction.getId(),
                NotificationTypeEnum.Receiver,
                lastTransaction.getTransitionValue(),
                lastTransaction.getReceiverUserId(),
                lastTransaction.getSenderUserId(),
                message
        );
    }

    public static NotificationEntity createNewSenderNotification(TransactionEntity lastTransaction, String senderName) {
        String message = "Voce Fez uma transicao de " + lastTransaction.getTransitionValue() + " para " + senderName;
        return new NotificationEntity(
                lastTransaction.getId(),
                NotificationTypeEnum.Sender,
                lastTransaction.getTransitionValue(),
                lastTransaction.getReceiverUserId(),
                lastTransaction.getSenderUserId(),
                message
        );
    }

}
