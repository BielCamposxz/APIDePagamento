package com.gabriel.APIDePagamento.Services;

import com.gabriel.APIDePagamento.Model.NotificationModel;
import com.gabriel.APIDePagamento.Model.TransacaoModel;
import com.gabriel.APIDePagamento.Model.UsuarioModel;
import com.gabriel.APIDePagamento.Repositorio.Notificacao.INotificacaoRepositorio;
import com.gabriel.APIDePagamento.Repositorio.Transacao.ITransacaoRepositorio;
import com.gabriel.APIDePagamento.Repositorio.User.IUserRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class NotificacaoService implements INotificacaoService{

    @Autowired
    public ITransacaoRepositorio TransacaoRepositorio;

    @Autowired
    public INotificacaoRepositorio NotificaoRepositorio;

    @Autowired
    public IUserRepositorio UsuarioRepositorio;

    // melhorar esse codigo pelo amor de deus
    // fazer os metodos de retorna todas as notificacoes (para bancarios)
    // e mostrar apenas as notificacoes do usuario
    // pegar emprestimo com o banco
    public void CriarNotificacao(int id) {
        int ultimoId = 0;
        try{
            ultimoId = NotificaoRepositorio.BuscarTodas().getLast().id;
        } catch (NullPointerException | NoSuchElementException err) {
            ultimoId += 1;
        }
        String Text = "";
        List<UsuarioModel> Users = UsuarioRepositorio.BuscarTodos();
        TransacaoModel LastTrasacao = TransacaoRepositorio.BuscarTodos().getLast();
        UsuarioModel usuarioRecived = Users.stream().filter(x -> x.id == LastTrasacao.idUserRecived).findFirst().orElse(null);
        UsuarioModel Transmiterusuario = Users.stream().filter(x -> x.id == LastTrasacao.IdUserTransmiter).findFirst().orElse(null);

        if(LastTrasacao.idUserRecived == id) {
            Text = "Voce Recebeu " + LastTrasacao.valor + " de " + Transmiterusuario.nome;
        }
        if(LastTrasacao.IdUserTransmiter == id) {
            Text = "Voce Fez uma transicao de " + LastTrasacao.valor + " para " + usuarioRecived.nome;
        }

        NotificationModel notificacao = new NotificationModel(
                ultimoId,
                LastTrasacao.valor,
                LastTrasacao.idUserRecived,
                LastTrasacao.IdUserTransmiter,
                Text

        );

        NotificaoRepositorio.Salvar(notificacao);

    }
}
