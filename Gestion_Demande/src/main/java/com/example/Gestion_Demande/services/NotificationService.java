package com.example.Gestion_Demande.services;

import com.example.Gestion_Demande.dto.NotificationDto;
import com.example.Gestion_Demande.entity.Notification;

import java.util.List;
import java.util.Optional;

public interface NotificationService {
    public List<Notification> getAllNotification();
    public Optional<Notification> getNotificationById(Long id);
    public Notification addNotification(NotificationDto notificationDto );

    public void deleteNotification(Long id);
}