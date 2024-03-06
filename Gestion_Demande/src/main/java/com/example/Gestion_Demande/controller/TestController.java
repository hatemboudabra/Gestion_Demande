package com.example.Gestion_Demande.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
@Tag(name = "Test")
public class TestController {
    @Operation(description = "allAccess")
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @Operation(description = "user")
    @GetMapping("/user")
    @PreAuthorize("hasRole(' ROLE_User') or hasRole('ROLE_ADMIN')")
    public String membreAccess() {
        return " ROLE_User Content.";
    }


    @Operation(description = "admin")
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }

}
