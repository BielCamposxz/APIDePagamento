package com.gabriel.APIDePagamento.service.transaction;

import com.gabriel.APIDePagamento.entity.TransactionEntity;
import com.gabriel.APIDePagamento.entity.TransacaoSemTransmiterModel;

import java.util.List;

public interface ITransactionService {
    public void Salvar(TransacaoSemTransmiterModel transicao);
    public List<TransactionEntity> RetornarAllTrasition(int id);
    public List<TransactionEntity> RetornarTransitionUser(int id);
    public String FazerPagamento(TransacaoSemTransmiterModel transicao, int id);

}
