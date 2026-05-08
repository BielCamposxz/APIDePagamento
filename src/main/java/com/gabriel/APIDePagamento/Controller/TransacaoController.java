package com.gabriel.APIDePagamento.Controller;

import com.gabriel.APIDePagamento.Model.TransacaoModel;
import com.gabriel.APIDePagamento.Model.TransacaoSemTransmiterModel;
import com.gabriel.APIDePagamento.Model.UsuarioModel;
import com.gabriel.APIDePagamento.Services.Transacao.ITransacaoService;
import com.gabriel.APIDePagamento.Services.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class TransacaoController {
    @Autowired
    public ITransacaoService service;

    @GetMapping("/{id}/trasitions/ReturnAllByUser")
    public List<TransacaoModel> returnByUser(@PathVariable int id) {
        return service.RetornarTransitionUser(id);
    }

    @PostMapping("/transition/Buy")
    public String Pagar(@RequestBody TransacaoSemTransmiterModel Transicao) {
        service.Salvar(Transicao);
        return "Pagamento feito";
    }

    @GetMapping("/{id}/transition/returnAll")
    public List<TransacaoModel> retornarTodas(@PathVariable int id){
       return service.RetornarAllTrasition();
    }

}
