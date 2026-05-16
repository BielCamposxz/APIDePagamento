package com.gabriel.APIDePagamento.service.transaction;

import com.gabriel.APIDePagamento.objectvalue.TypeUserEnum;
import com.gabriel.APIDePagamento.entity.*;
import com.gabriel.APIDePagamento.repository.transaction.ITransactionRepository;
import com.gabriel.APIDePagamento.repository.user.IUserRepository;
import com.gabriel.APIDePagamento.service.notification.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements ITransactionService {
    @Autowired
    public ITransactionRepository Transacaorepositorio;

    @Autowired
    public IUserRepository UserRepositorio;

    @Autowired
    public INotificationService NotificacaoService;

    public void Salvar(TransactionEntity transicao) {
        Transacaorepositorio.Salvar(new TransactionEntity(
                transicao.id,
                transicao.userId,
                transicao.idUserRecived,
                transicao.userId,
                transicao.valor
        ));
    }

    public String makePayment(TransactionEntity transicao, int id){

        UserEntity usuarioTrasnfer = UserRepositorio.BuscarTodos().stream().filter(x -> x.id == transicao.userId).findFirst().orElse(null);

        if(usuarioTrasnfer.id != id) {
            return "Voce pode fazer transacoes apenas da sua conta logada";
        }
        if(usuarioTrasnfer.TipoUser == TypeUserEnum.Logista) {
            return "Logistas nao podem fazer transacaoes";
        }
        if(usuarioTrasnfer.saldo < transicao.valor) {
            return "Saldo insuficiente";
        }


        UserEntity usuarioResived = UserRepositorio.BuscarTodos().stream().filter(x -> x.id == transicao.idUserRecived).findFirst().orElse(null);
        if(usuarioResived.TipoUser == TypeUserEnum.Bancario) {
            return "Bancarios nao pode receber transacoes";
        }

        usuarioResived.setSaldo(usuarioResived.saldo + transicao.valor);
        usuarioTrasnfer.setSaldo(usuarioTrasnfer.saldo - transicao.valor);
        Salvar(transicao);
        NotificacaoService.CriarNotificacao();
        return "pagamento feito";

    }

    public List<TransactionEntity> getAll(int id)
    {
        UserEntity usuarioTrasnfer = UserRepositorio.BuscarTodos().stream().filter(x -> x.id == id).findFirst().orElse(null);

        if(usuarioTrasnfer.TipoUser != TypeUserEnum.Bancario) {
            return null;
        }

        return Transacaorepositorio.BuscarTodos();
    }

    public List<TransactionEntity> getByUserId(int id) {
        List<TransactionEntity> transacao = Transacaorepositorio.BuscarTodos();
        return transacao.stream().filter(x -> x.userId == id).toList();
    }

}
