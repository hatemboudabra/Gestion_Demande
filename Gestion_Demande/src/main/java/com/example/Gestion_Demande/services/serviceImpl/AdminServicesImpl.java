package com.example.Gestion_Demande.services.serviceImpl;

import com.example.Gestion_Demande.entity.Role;
import com.example.Gestion_Demande.entity.User;
import com.example.Gestion_Demande.repository.RoleRepository;
import com.example.Gestion_Demande.repository.UserRepository;
import com.example.Gestion_Demande.services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServicesImpl implements AdminServices {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Override
    public List<User> getall() {
        return userRepository.findAll();
    }

    @Override
    public void UpdateROle(Long id, String role) {

    }

    @Override
    public List<Role> getAllROles() {
        return roleRepository.findAll();
    }
}
