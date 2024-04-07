package com.example.Gestion_Demande.services.serviceImpl;

import com.example.Gestion_Demande.entity.Demande;
import com.example.Gestion_Demande.repository.DemandeRepo;
import com.example.Gestion_Demande.services.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DemandeServiceImpl implements DemandeService {
    @Autowired
    DemandeRepo demandeRepo;
    @Override
    public Demande save(Demande demande) {
        return demandeRepo.save(demande);
    }

    @Override
    public Demande findById(Long id) {
        return demandeRepo.findById(id).get();
    }
    @Override
    public Demande updatedemande(Demande d, long id) {

        Demande demandeExistante = demandeRepo.findById(id).orElse(null);

        if (demandeExistante != null) {

            demandeExistante.setDescription(d.getDescription());
            demandeExistante.setDateDemande(d.getDateDemande());
            demandeExistante.setTraite(d.isTraite());
            demandeExistante.setClient(d.getClient());


            demandeRepo.save(demandeExistante);
        }

        return demandeExistante;
    }


    @Override
    public List<Demande> findAll() {
        return demandeRepo.findAll();
    }

    @Override
    public void delete(Long id) {
demandeRepo.deleteById(id);
    }
}
