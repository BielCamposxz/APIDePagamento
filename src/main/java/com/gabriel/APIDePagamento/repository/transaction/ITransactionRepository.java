package com.gabriel.APIDePagamento.repository.transaction;

import com.gabriel.APIDePagamento.entity.TransactionEntity;

import java.util.List;

public interface ITransactionRepository {
    public void saveTransaction(TransactionEntity transacao);
    public List<TransactionEntity> getAllTransaction();
    public List<TransactionEntity> getTransactionByUserId(int id);
}
