package com.gabriel.APIDePagamento.Repositorio.Notificacao;

import com.gabriel.APIDePagamento.Model.NotificationModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class NotificacaoRepositorio implements INotificacaoRepositorio{
    List<NotificationModel> noticacoesResived = new LinkedList<>();
    List<NotificationModel> noticacoesTransmited = new LinkedList<>();
    List<NotificationModel> AllNotification = new LinkedList<>();

    public void Salvar(NotificationModel notificacaoResived, NotificationModel notificacaoTransmited){
        noticacoesResived.add(notificacaoResived);
        noticacoesTransmited.add(notificacaoTransmited);
    }

    public List<NotificationModel> BuscarResived() {
        return noticacoesResived;
    }
    public List<NotificationModel> BuscarTransmited() {
        return noticacoesTransmited;
    }

    public List<NotificationModel> BuscarTodas() {
        AllNotification.addAll(noticacoesResived);
        AllNotification.addAll(noticacoesTransmited);
        return AllNotification;
    }

}
