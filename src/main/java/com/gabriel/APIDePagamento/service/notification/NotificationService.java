package com.gabriel.APIDePagamento.service.notification;

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

    @Autowired
    public ITransactionRepository TransacaoRepositorio;

    @Autowired
    public INotificationRepository NotificaoRepositorio;

    @Autowired
    public IUserRepository UsuarioRepositorio;


    public void CriarNotificacao() {
       int ultimaNotificacaoId = UltimaNotificacao();

        TransactionEntity LastTrasacao = TransacaoRepositorio.BuscarTodos().getLast();
        List<UserEntity> Users = UsuarioRepositorio.BuscarTodos();
        UserEntity usuarioRecived = Users.stream().filter(x -> x.id == LastTrasacao.idUserRecived).findFirst().orElse(null);
        UserEntity Transmiterusuario = Users.stream().filter(x -> x.id == LastTrasacao.IdUserTransmiter).findFirst().orElse(null);

        String TextResived = "Voce Recebeu " + LastTrasacao.valor + " de " + Transmiterusuario.nome;
        String TextTransmiter = "Voce Fez uma transicao de " + LastTrasacao.valor + " para " + usuarioRecived.nome;

        NotificationEntity notificationResived = new NotificationEntity(
                ultimaNotificacaoId,
                LastTrasacao.valor,
                LastTrasacao.idUserRecived,
                LastTrasacao.IdUserTransmiter,
                TextResived

        );
        NotificationEntity NotificationTransmiter = new NotificationEntity(
                ultimaNotificacaoId,
                LastTrasacao.valor,
                LastTrasacao.idUserRecived,
                LastTrasacao.IdUserTransmiter,
                TextTransmiter

        );


        NotificaoRepositorio.Salvar(notificationResived, NotificationTransmiter);

    }

    public int UltimaNotificacao() {
        List<NotificationEntity> Notificacoes = NotificaoRepositorio.BuscarTransmited();
        return Notificacoes.isEmpty() ? 1 : Notificacoes.getFirst().id + 1;
    }

    public List<NotificationEntity> RetornarAll(int id) {
        UserEntity usuario = UsuarioRepositorio.BuscarTodos().stream().filter(x -> x.id == id).findFirst().orElse(null);
        if(usuario.TipoUser != TypeUserEnum.Bancario) {
            return null;
        }

        return NotificaoRepositorio.BuscarTodas();
    }

    public List<NotificationEntity> BuscarPorId(int id) {
        List<NotificationEntity> transtion = NotificaoRepositorio.BuscarTransmited().stream().filter(x -> x.IdUserTransmiter == id).toList();
        List<NotificationEntity> resived = NotificaoRepositorio.BuscarResived().stream().filter(x -> x.idUserRecived == id).toList();
        List<NotificationEntity> Notification = new LinkedList<>();
        Notification.addAll(transtion);
        Notification.addAll(resived);
        return Notification;
    }
}
