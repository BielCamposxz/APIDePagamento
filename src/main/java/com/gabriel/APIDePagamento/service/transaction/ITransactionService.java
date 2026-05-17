package com.gabriel.APIDePagamento.service.transaction;

import com.gabriel.APIDePagamento.entity.TransactionEntity;

import java.util.List;

public interface ITransactionService {
    public void Salvar(TransactionEntity transicao);
    public List<TransactionEntity> getAll(int id);
    public List<TransactionEntity> getByUserId(int id);
    public String makePayment(TransactionEntity transicao, int id);

}
