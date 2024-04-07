package com.example.Gestion_Demande.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDto {
    private String message;
    private Date sendDate;
    private Long idDemande;

    private Long idUser;

}
