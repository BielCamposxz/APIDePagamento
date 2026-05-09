package com.gabriel.APIDePagamento.Services.Transacao;

import com.gabriel.APIDePagamento.Enum.TypeUserEnum;
import com.gabriel.APIDePagamento.Model.*;
import com.gabriel.APIDePagamento.Repositorio.Notificacao.INotificacaoRepositorio;
import com.gabriel.APIDePagamento.Repositorio.Transacao.ITransacaoRepositorio;
import com.gabriel.APIDePagamento.Repositorio.User.IUserRepositorio;
import com.gabriel.APIDePagamento.Services.INotificacaoService;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService implements ITransacaoService{
    @Autowired
    public ITransacaoRepositorio Transacaorepositorio;

    @Autowired
    public IUserRepositorio UserRepositorio;

    @Autowired
    public INotificacaoService NotificacaoService;

    public void Salvar(TransacaoSemTransmiterModel transicao) {

        TransacaoModel transacaoInstacia = new TransacaoModel(
                transicao.id,
                transicao.userId,
                transicao.idUserRecived,
                transicao.userId,
                transicao.valor
        );

        Transacaorepositorio.Salvar(transacaoInstacia);
    }

    public String FazerPagamento(TransacaoSemTransmiterModel transicao, int id){

        UsuarioModel usuarioTrasnfer = UserRepositorio.BuscarTodos().stream().filter(x -> x.id == transicao.userId).findFirst().orElse(null);

        if(usuarioTrasnfer.id != id) {
            return "Voce pode fazer transacoes apenas da sua conta logada";
        }
        if(usuarioTrasnfer.TipoUser == TypeUserEnum.Logista) {
            return "Logistas nao podem fazer transacaoes";
        }
        if(usuarioTrasnfer.saldo < transicao.valor) {
            return "Saldo insuficiente";
        }


        UsuarioModel usuarioResived = UserRepositorio.BuscarTodos().stream().filter(x -> x.id == transicao.idUserRecived).findFirst().orElse(null);
        if(usuarioResived.TipoUser == TypeUserEnum.Bancario) {
            return "Bancarios nao pode receber transacoes";
        }

        usuarioResived.setSaldo(usuarioResived.saldo + transicao.valor);
        usuarioTrasnfer.setSaldo(usuarioTrasnfer.saldo - transicao.valor);
        Salvar(transicao);
        NotificacaoService.CriarNotificacao(id);
        return "pagamento feito";

    }

    public List<TransacaoModel> RetornarAllTrasition(int id)
    {
        UsuarioModel usuarioTrasnfer = UserRepositorio.BuscarTodos().stream().filter(x -> x.id == id).findFirst().orElse(null);

        if(usuarioTrasnfer.TipoUser != TypeUserEnum.Bancario) {
            return null;
        }

        return Transacaorepositorio.BuscarTodos();
    }

    public List<TransacaoModel> RetornarTransitionUser(int id) {
        List<TransacaoModel> transacao = Transacaorepositorio.BuscarTodos();
        return transacao.stream().filter(x -> x.userId == id).toList();
    }

}
