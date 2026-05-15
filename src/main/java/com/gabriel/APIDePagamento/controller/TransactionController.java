package com.gabriel.APIDePagamento.controller;

import com.gabriel.APIDePagamento.entity.TransactionEntity;
import com.gabriel.APIDePagamento.entity.TransacaoSemTransmiterModel;
import com.gabriel.APIDePagamento.service.transaction.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{id}")
public class TransactionController {
    @Autowired
    public ITransactionService service;

    @GetMapping("/trasitions/ReturnAllByUser")
    public List<TransactionEntity> returnByUser(@PathVariable int id) {
        return service.RetornarTransitionUser(id);
    }

    @PutMapping("/transition/Pay")
    public String Pagar(@RequestBody TransacaoSemTransmiterModel Transicao, @PathVariable int id) {
        return service.FazerPagamento(Transicao, id);
    }

    // apenas bancarios pode usar
    @GetMapping("/transition/returnAll")
    public List<TransactionEntity> retornarTodas(@PathVariable int id){
       List<TransactionEntity> transicoes =  service.RetornarAllTrasition(id);
       return transicoes;
    }

}
