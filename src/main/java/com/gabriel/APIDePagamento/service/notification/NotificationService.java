package com.gabriel.APIDePagamento.service.notification;

import com.gabriel.APIDePagamento.objectvalue.TypeUserEnum;
import com.gabriel.APIDePagamento.entity.NotificationEntity;
import com.gabriel.APIDePagamento.entity.TransactionEntity;
import com.gabriel.APIDePagamento.entity.UserEntity;
import com.gabriel.APIDePagamento.repository.notification.INotificationRepository;
import com.gabriel.APIDePagamento.repository.user.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService implements INotificationService {

    private final INotificationRepository notificationRepository;
    private final IUserRepository userRepository;

    public NotificationService(INotificationRepository notificationRepository, IUserRepository userRepository) {
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
    }

    public void createNotification(TransactionEntity transaction) {
        UserEntity receiverUser = this.userRepository.getUserById(transaction.getReceiverUserId());
        UserEntity senderUser = this.userRepository.getUserById(transaction.getSenderUserId());

        this.notificationRepository.saveNewNotification(
                NotificationEntity.createNewReceiverNotification(transaction, receiverUser.getName()),
                NotificationEntity.createNewSenderNotification(transaction, senderUser.getName())
        );

    }

    public List<NotificationEntity> getAllNotification(int id) {
        UserEntity user = this.userRepository.getUserById(id);
        if(user.getTypeUser() != TypeUserEnum.Bancario) return List.of();

        return this.notificationRepository.getAllNotification();
    }

    public List<NotificationEntity> getNotificationByUserId(int id) {
        return this.notificationRepository.getNotificationByUserId(id);
    }
}
