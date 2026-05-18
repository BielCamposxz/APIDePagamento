package com.gabriel.APIDePagamento.service.transaction;

import com.gabriel.APIDePagamento.entity.TransactionEntity;

import java.util.List;

public interface ITransactionService {
    public List<TransactionEntity> getAllTransaction(int id);
    public List<TransactionEntity> getTransactionByUserId(int id);
    public String makePayment(TransactionEntity transicao);

}
