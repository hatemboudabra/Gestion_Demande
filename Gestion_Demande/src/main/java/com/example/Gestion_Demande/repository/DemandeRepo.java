package com.example.Gestion_Demande.repository;
import com.example.Gestion_Demande.entity.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeRepo extends JpaRepository<Demande,Long> {
}
