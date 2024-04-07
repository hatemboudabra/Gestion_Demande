package com.example.Gestion_Demande.services.serviceImpl;

import com.example.Gestion_Demande.dto.NotificationDto;
import com.example.Gestion_Demande.entity.Demande;
import com.example.Gestion_Demande.entity.Notification;
import com.example.Gestion_Demande.entity.User;
import com.example.Gestion_Demande.repository.DemandeRepo;
import com.example.Gestion_Demande.repository.NotificationRepo;
import com.example.Gestion_Demande.repository.UserRepository;
import com.example.Gestion_Demande.services.NotificationService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepo notificationRepo;
    private  final DemandeRepo demandeRepo;
    private final UserRepository userRepository;
   // private List<Notification> notifications;

    public NotificationServiceImpl(NotificationRepo notificationRepo, DemandeRepo demandeRepo, UserRepository userRepository) {
        this.notificationRepo = notificationRepo;
        this.demandeRepo = demandeRepo;
        this.userRepository = userRepository;
    }


    @Override
    public List<Notification> getAllNotification() {
        return notificationRepo.findAll();
    }

    @Override
    public Optional<Notification> getNotificationById(Long id) {
        return notificationRepo.findById(id);
    }

    @Override
    public Notification addNotification(NotificationDto notificationDto) {
        Notification notification = new Notification();
        notification.setMessage(notificationDto.getMessage());
        User user = userRepository.findById(notificationDto.getIdUser()).get();
        Demande demande= demandeRepo.findById(notificationDto.getIdDemande()).get();
        notification.setDemande(demande);
        notification.setUser(user);
        notification = notificationRepo.save(notification);
        user.getNotificationList().add(notification);
        demande.getNotifications().add(notification);
        demandeRepo.save(demande);
        userRepository.save(user);
        return notification;

    }

    @Override
    public void deleteNotification(Long id) {
        notificationRepo.deleteById(id);
    }
}
