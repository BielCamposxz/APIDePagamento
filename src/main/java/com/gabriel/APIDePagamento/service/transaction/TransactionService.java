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
                transicao.getId(),
                transicao.getSenderUserId(),
                transicao.getReceiverUserId(),
                transicao.getTransitionValue()
        ));
    }

    public String makePayment(TransactionEntity transicao, int id){

        UserEntity usuarioTrasnfer = UserRepositorio.BuscarTodos().stream().filter(x -> x.getId() == transicao.getId()).findFirst().orElse(null);

        if(usuarioTrasnfer.getId() != id) {
            return "Voce pode fazer transacoes apenas da sua conta logada";
        }
        if(usuarioTrasnfer.getTypeUser() == TypeUserEnum.Logista) {
            return "Logistas nao podem fazer transacaoes";
        }
        if(usuarioTrasnfer.getUserBalance() < transicao.getTransitionValue()) {
            return "Saldo insuficiente";
        }


        UserEntity usuarioResived = UserRepositorio.BuscarTodos().stream().filter(x -> x.getId() == transicao.getReceiverUserId()).findFirst().orElse(null);
        if(usuarioResived.getTypeUser() == TypeUserEnum.Bancario) {
            return "Bancarios nao pode receber transacoes";
        }

        usuarioResived.setUserBalance(usuarioResived.getUserBalance() + transicao.getTransitionValue());
        usuarioTrasnfer.setUserBalance(usuarioTrasnfer.getUserBalance() - transicao.getTransitionValue());
        Salvar(transicao);
        NotificacaoService.createNotification();
        return "pagamento feito";

    }

    public List<TransactionEntity> getAll(int id)
    {
        UserEntity usuarioTrasnfer = UserRepositorio.BuscarTodos().stream().filter(x -> x.getId() == id).findFirst().orElse(null);

        if(usuarioTrasnfer.getTypeUser() != TypeUserEnum.Bancario) {
            return null;
        }

        return Transacaorepositorio.BuscarTodos();
    }

    public List<TransactionEntity> getByUserId(int id) {
        List<TransactionEntity> transacao = Transacaorepositorio.BuscarTodos();
        return transacao.stream().filter(x -> x.getTransitionValue() == id).toList();
    }

}
