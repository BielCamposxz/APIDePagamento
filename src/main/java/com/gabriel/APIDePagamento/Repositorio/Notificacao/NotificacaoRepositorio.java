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
    List<NotificationModel> noticacoes = new LinkedList<>();

    public void Salvar(NotificationModel notificacao){
        NotificationModel notificacaoInstacia = new NotificationModel(
                notificacao.id,
                notificacao.valor,
                notificacao.idUserRecived,
                notificacao.IdUserTransmiter,
                notificacao.texto
        );

        noticacoes.add(notificacaoInstacia);
    }

    public List<NotificationModel> BuscarTodas() {
        return noticacoes;
    }

}
