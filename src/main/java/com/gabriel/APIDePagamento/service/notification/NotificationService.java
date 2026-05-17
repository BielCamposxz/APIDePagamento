package com.gabriel.APIDePagamento.service.notification;

import com.gabriel.APIDePagamento.objectvalue.NotificationTypeEnum;
import com.gabriel.APIDePagamento.objectvalue.TypeUserEnum;
import com.gabriel.APIDePagamento.entity.NotificationEntity;
import com.gabriel.APIDePagamento.entity.TransactionEntity;
import com.gabriel.APIDePagamento.entity.UserEntity;
import com.gabriel.APIDePagamento.repository.notification.INotificationRepository;
import com.gabriel.APIDePagamento.repository.transaction.ITransactionRepository;
import com.gabriel.APIDePagamento.repository.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class NotificationService implements INotificationService {

    private final ITransactionRepository transactionRepository;
    private final INotificationRepository notificationRepository;
    private final IUserRepository userRepository;

    public NotificationService(ITransactionRepository transactionRepository, INotificationRepository notificationRepository, IUserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
    }


    public void createNotification() {
        TransactionEntity getLastTransaction = this.transactionRepository.getAllTransaction().getLast();

        UserEntity receiverUser = this.userRepository.getUserById(getLastTransaction.getReceiverUserId());
        UserEntity senderUser = this.userRepository.getUserById(getLastTransaction.getSenderUserId());

        this.notificationRepository.saveNewNotification(
                NotificationEntity.createNewReceiverNotification(getLastTransaction, receiverUser.getName()),
                NotificationEntity.createNewSenderNotification(getLastTransaction, senderUser.getName())
        );

    }

    public List<NotificationEntity> getAllNotification(int id) {
        UserEntity user = this.userRepository.getUserById(id);
        if(user.getTypeUser() != TypeUserEnum.Bancario) return null;

        return this.notificationRepository.getAllNotification();
    }

    public List<NotificationEntity> getNotificationByUserId(int id) {
        return this.notificationRepository.getAllNotification().stream().filter(x -> x.getSenderUserId() == id || x.getReceiverUserId() == id).toList();
    }
}
