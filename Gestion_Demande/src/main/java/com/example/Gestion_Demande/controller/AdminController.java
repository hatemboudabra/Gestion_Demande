package com.example.Gestion_Demande.controller;

import com.example.Gestion_Demande.entity.Role;
import com.example.Gestion_Demande.entity.User;
import com.example.Gestion_Demande.repository.UserRepository;
import com.example.Gestion_Demande.services.AdminServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
@Tag(name = "Admin")
public class AdminController {
    @Autowired
    AdminServices adminServices;
    @Autowired
    UserRepository userRepository;

    @Operation(description = "getAllUsers")
    @GetMapping(path = "/getAllUsers")
    List<User> getAllUsers() {
        return adminServices.getall();
    }

    @Operation(description = "add user")
    @PostMapping(path = "/updateUser/{id}")
    void UpdatUser(@PathVariable Long id, @RequestBody String role) {
        adminServices.UpdateROle(id, role);
    }

    @Operation(description = "getAllRole")
    @GetMapping(path = "/getAllRole")
    List<Role> getAllRole() {
        return adminServices.getAllROles();

    }
}
