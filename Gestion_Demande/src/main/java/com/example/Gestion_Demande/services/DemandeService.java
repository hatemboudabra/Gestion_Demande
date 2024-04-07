package com.example.Gestion_Demande.services;

import com.example.Gestion_Demande.entity.Demande;
import com.example.Gestion_Demande.entity.User;

import java.util.List;

public interface DemandeService {
   Demande save (Demande demande);
    Demande findById(Long id);
    List<Demande> findAll();
    Demande updatedemande(Demande d, long id);
    void delete(Long id);

}
