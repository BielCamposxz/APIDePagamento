package com.gabriel.APIDePagamento.controller;

import com.gabriel.APIDePagamento.entity.NotificationEntity;
import com.gabriel.APIDePagamento.service.notification.INotificationService;
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

    @GetMapping("/user/{userId}")
    public List<NotificationEntity> getNotificationsByUserId(@PathVariable int userId) {
        return this.notificationService.getNotificationByUserId(userId);
    }

    @GetMapping("/user/{userId}/all")
    public List<NotificationEntity> getAllNotifications(@PathVariable int userId) {
        return this.notificationService.getAllNotification(userId);
    }


}
