package com.gabriel.APIDePagamento.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TransactionEntity {
    private int id;
    private int receiverUserId;
    private int senderUserId;
    private int transitionValue;

    public static TransactionEntity createNewTransaction(TransactionEntity transaction) {
        return new TransactionEntity(
                transaction.getId(),
                transaction.getReceiverUserId(),
                transaction.getSenderUserId(),
                transaction.getTransitionValue()
        );

    }


}
