package com.example.Gestion_Demande.controller;

import com.example.Gestion_Demande.dto.NotificationDto;
import com.example.Gestion_Demande.entity.Notification;
import com.example.Gestion_Demande.services.serviceImpl.NotificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/notification")
public class NotificationController {
    private final NotificationServiceImpl notificationService;
    @Autowired
    public NotificationController(NotificationServiceImpl notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping(path = "/addNotification")
    public Notification addNotification(@RequestBody NotificationDto notificationDto){
        return  notificationService.addNotification(notificationDto);
    }
    @GetMapping
    public List<Notification> getAllNotification(){
        return notificationService.getAllNotification();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteNotification(@PathVariable("id") long
                                                             id){
        notificationService.deleteNotification(id);
        return new ResponseEntity<String>("notification deleted successfully!.", HttpStatus.OK);
    }


}
