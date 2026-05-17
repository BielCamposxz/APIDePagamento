package com.gabriel.APIDePagamento.repository.transaction;

import com.gabriel.APIDePagamento.entity.TransactionEntity;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class TransactionRepository implements ITransactionRepository {
    List<TransactionEntity> transoes = new LinkedList();

    public void Salvar(TransactionEntity transacao) {
        transoes.add(transacao);
    }

    public List<TransactionEntity> getAllTransaction() {
        return transoes;
    }

}
