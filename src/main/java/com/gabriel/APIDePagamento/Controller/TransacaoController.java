package com.gabriel.APIDePagamento.Controller;

import com.gabriel.APIDePagamento.Model.TransacaoModel;
import com.gabriel.APIDePagamento.Model.TransacaoSemTransmiterModel;
import com.gabriel.APIDePagamento.Model.UsuarioModel;
import com.gabriel.APIDePagamento.Services.Transacao.ITransacaoService;
import com.gabriel.APIDePagamento.Services.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/{id}")
public class TransacaoController {
    @Autowired
    public ITransacaoService service;

    @GetMapping("/trasitions/ReturnAllByUser")
    public List<TransacaoModel> returnByUser(@PathVariable int id) {
        return service.RetornarTransitionUser(id);
    }

    @PutMapping("/transition/Pay")
    public String Pagar(@RequestBody TransacaoSemTransmiterModel Transicao, @PathVariable int id) {
        return service.FazerPagamento(Transicao, id);
    }

    // apenas bancarios pode usar
    @GetMapping("/transition/returnAll")
    public List<TransacaoModel> retornarTodas(@PathVariable int id){
       List<TransacaoModel> transicoes =  service.RetornarAllTrasition(id);
       return transicoes;
    }

}
