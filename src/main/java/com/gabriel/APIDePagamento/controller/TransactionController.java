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

    @GetMapping("/user/{id}/history")
    public List<TransactionEntity> getTransactionHistoryByUserId(@PathVariable int id) {
        return this.transactionService.getTransactionByUserId(id);
    }

    @PostMapping("/payment")
    public String payment(@RequestBody TransactionEntity transaction) {
        return this.transactionService.makePayment(transaction);
    }

    @GetMapping("/user/{id}/history/all")
    public List<TransactionEntity> getAllTransactionHistory(@PathVariable int id){
        return this.transactionService.getAllTransaction(id);
    }

}
