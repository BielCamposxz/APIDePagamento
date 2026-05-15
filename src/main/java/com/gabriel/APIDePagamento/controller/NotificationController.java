package com.gabriel.APIDePagamento.controller;

import com.gabriel.APIDePagamento.entity.NotificationEntity;
import com.gabriel.APIDePagamento.repository.notification.INotificationRepository;
import com.gabriel.APIDePagamento.service.notification.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/{id}/Notificacoes")
public class NotificationController {

    @Autowired
    public INotificationRepository notificoesRepositorio;

    @Autowired
    public INotificationService notificacaoService;

    @GetMapping("/ReturnByUser")
    public List<NotificationEntity> BuscarPorId(@PathVariable int id) {
        return notificacaoService.BuscarPorId(id);
    }

    @GetMapping("/ReturnAll")
    public List<NotificationEntity> ReturnAll(@PathVariable int id) {
        return notificacaoService.RetornarAll(id);
    }


}
