package com.gabriel.APIDePagamento.Services.Notificacao;

import com.gabriel.APIDePagamento.Enum.TypeUserEnum;
import com.gabriel.APIDePagamento.Model.NotificationModel;
import com.gabriel.APIDePagamento.Model.TransacaoModel;
import com.gabriel.APIDePagamento.Model.UsuarioModel;
import com.gabriel.APIDePagamento.Repositorio.Notificacao.INotificacaoRepositorio;
import com.gabriel.APIDePagamento.Repositorio.Transacao.ITransacaoRepositorio;
import com.gabriel.APIDePagamento.Repositorio.User.IUserRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class NotificacaoService implements INotificacaoService {

    @Autowired
    public ITransacaoRepositorio TransacaoRepositorio;

    @Autowired
    public INotificacaoRepositorio NotificaoRepositorio;

    @Autowired
    public IUserRepositorio UsuarioRepositorio;


    public void CriarNotificacao() {
       int ultimaNotificacaoId = UltimaNotificacao();

        TransacaoModel LastTrasacao = TransacaoRepositorio.BuscarTodos().getLast();
        List<UsuarioModel> Users = UsuarioRepositorio.BuscarTodos();
        UsuarioModel usuarioRecived = Users.stream().filter(x -> x.id == LastTrasacao.idUserRecived).findFirst().orElse(null);
        UsuarioModel Transmiterusuario = Users.stream().filter(x -> x.id == LastTrasacao.IdUserTransmiter).findFirst().orElse(null);

        String TextResived = "Voce Recebeu " + LastTrasacao.valor + " de " + Transmiterusuario.nome;
        String TextTransmiter = "Voce Fez uma transicao de " + LastTrasacao.valor + " para " + usuarioRecived.nome;

        NotificationModel notificationResived = new NotificationModel(
                ultimaNotificacaoId,
                LastTrasacao.valor,
                LastTrasacao.idUserRecived,
                LastTrasacao.IdUserTransmiter,
                TextResived

        );
        NotificationModel NotificationTransmiter = new NotificationModel(
                ultimaNotificacaoId,
                LastTrasacao.valor,
                LastTrasacao.idUserRecived,
                LastTrasacao.IdUserTransmiter,
                TextTransmiter

        );


        NotificaoRepositorio.Salvar(notificationResived, NotificationTransmiter);

    }

    public int UltimaNotificacao() {
        List<NotificationModel> Notificacoes = NotificaoRepositorio.BuscarTransmited();
        return Notificacoes.isEmpty() ? 1 : Notificacoes.getFirst().id + 1;
    }

    public List<NotificationModel> RetornarAll(int id) {
        UsuarioModel usuario = UsuarioRepositorio.BuscarTodos().stream().filter(x -> x.id == id).findFirst().orElse(null);
        if(usuario.TipoUser != TypeUserEnum.Bancario) {
            return null;
        }

        return NotificaoRepositorio.BuscarTodas();
    }

    public List<NotificationModel> BuscarPorId(int id) {
        List<NotificationModel> transtion = NotificaoRepositorio.BuscarTransmited().stream().filter(x -> x.IdUserTransmiter == id).toList();
        List<NotificationModel> resived = NotificaoRepositorio.BuscarResived().stream().filter(x -> x.idUserRecived == id).toList();
        List<NotificationModel> Notification = new LinkedList<>();
        Notification.addAll(transtion);
        Notification.addAll(resived);
        return Notification;
    }
}
