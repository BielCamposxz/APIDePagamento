package com.gabriel.APIDePagamento.repository.transaction;

import com.gabriel.APIDePagamento.entity.TransactionEntity;

import java.util.List;

public interface ITransactionRepository {
    public void Salvar(TransactionEntity transacao);
    public List<TransactionEntity> BuscarTodos();
}
