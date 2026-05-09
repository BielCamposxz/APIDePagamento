package com.gabriel.APIDePagamento.Controller;

import com.gabriel.APIDePagamento.Model.NotificationModel;
import com.gabriel.APIDePagamento.Repositorio.Notificacao.INotificacaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.List;

@RestController
@RequestMapping("/{id}")
public class NotificacaoController {

    @Autowired
    public INotificacaoRepositorio notificoes;

    @GetMapping("/Notificacoes/BuscarTodas")
    public List<NotificationModel> BuscarTodasNotificacoes() {
        return notificoes.BuscarTodas();
    }
}
