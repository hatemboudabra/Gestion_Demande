package com.example.Gestion_Demande.services;

import com.example.Gestion_Demande.entity.Role;
import com.example.Gestion_Demande.entity.User;

import java.util.List;

public interface AdminServices {
    List<User> getall();
    void UpdateROle(Long id,String role);
    List<Role> getAllROles();
}
