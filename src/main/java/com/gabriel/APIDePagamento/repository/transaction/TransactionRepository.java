package com.gabriel.APIDePagamento.repository.transaction;

import com.gabriel.APIDePagamento.entity.TransactionEntity;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class TransactionRepository implements ITransactionRepository {
    List<TransactionEntity> allTransaction = new LinkedList<>();

    public void saveTransaction(TransactionEntity transaction) {
        this.allTransaction.add(transaction);
    }

    public List<TransactionEntity> getAllTransaction() {
        return this.allTransaction;
    }

    public List<TransactionEntity> getTransactionByUserId(int id) {
        return this.allTransaction.stream().filter(x -> x.getReceiverUserId() == id || x.getSenderUserId() == id).toList();
    }

}
