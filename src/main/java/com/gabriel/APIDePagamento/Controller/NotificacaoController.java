package com.gabriel.APIDePagamento.Controller;

import com.gabriel.APIDePagamento.Model.NotificationModel;
import com.gabriel.APIDePagamento.Repositorio.Notificacao.INotificacaoRepositorio;
import com.gabriel.APIDePagamento.Repositorio.Notificacao.NotificacaoRepositorio;
import com.gabriel.APIDePagamento.Services.Notificacao.INotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.List;

@RestController
@RequestMapping("/{id}/Notificacoes")
public class NotificacaoController {

    @Autowired
    public INotificacaoRepositorio notificoesRepositorio;

    @Autowired
    public INotificacaoService notificacaoService;

    @GetMapping("/ReturnByUser")
    public List<NotificationModel> BuscarPorId(@PathVariable int id) {
        return notificacaoService.BuscarPorId(id);
    }
}
