package com.gabriel.APIDePagamento.repository.notification;

import com.gabriel.APIDePagamento.entity.NotificationEntity;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class NotificationRepository implements INotificationRepository {
    List<NotificationEntity> noticacoesResived = new LinkedList<>();
    List<NotificationEntity> noticacoesTransmited = new LinkedList<>();
    List<NotificationEntity> AllNotification = new LinkedList<>();

    public void Salvar(NotificationEntity notificacaoResived, NotificationEntity notificacaoTransmited){
        noticacoesResived.add(notificacaoResived);
        noticacoesTransmited.add(notificacaoTransmited);
    }

    public List<NotificationEntity> BuscarResived() {
        return noticacoesResived;
    }
    public List<NotificationEntity> BuscarTransmited() {
        return noticacoesTransmited;
    }

    public List<NotificationEntity> BuscarTodas() {
        AllNotification.addAll(noticacoesResived);
        AllNotification.addAll(noticacoesTransmited);
        return AllNotification;
    }

}
