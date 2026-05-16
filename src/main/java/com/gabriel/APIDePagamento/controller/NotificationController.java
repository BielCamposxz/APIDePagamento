package com.gabriel.APIDePagamento.controller;

import com.gabriel.APIDePagamento.entity.NotificationEntity;
import com.gabriel.APIDePagamento.service.notification.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    private final INotificationService notificationService;

    public NotificationController(INotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/user/{id}")
    public List<NotificationEntity> getNotificationsByUserId(@PathVariable int id) {
        return this.notificationService.getByUserId(id);
    }

    @GetMapping("/user/{id}/all")
    public List<NotificationEntity> getAllNotifications(@PathVariable int id) {
        return this.notificationService.getAll(id);
    }


}
