package com.gabriel.APIDePagamento.controller;

import com.gabriel.APIDePagamento.entity.TransactionEntity;
import com.gabriel.APIDePagamento.service.transaction.ITransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final ITransactionService transactionService;

    public TransactionController(ITransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/user/{userId}/history")
    public List<TransactionEntity> getTransactionHistoryByUserId(@PathVariable int userId) {
        return this.transactionService.getTransactionByUserId(userId);
    }

    @PostMapping("/payment")
    public String payment(@RequestBody TransactionEntity transaction) {
        return this.transactionService.makePayment(transaction);
    }

    @GetMapping("/user/{userId}/history/all")
    public List<TransactionEntity> getAllTransactionHistory(@PathVariable int userId){
        return this.transactionService.getAllTransaction(userId);
    }

}
