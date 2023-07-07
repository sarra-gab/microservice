package com.ecommerce.microcommerce.facture.service;

import com.ecommerce.microcommerce.facture.exception.FactureException;
import com.ecommerce.microcommerce.facture.model.Facture;
import com.ecommerce.microcommerce.facture.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FactureService {
    @Autowired
    private FactureRepository factureRepository;

    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }

    public Facture getFactureById(Long id) {
        Optional<Facture> optionalFacture = factureRepository.findById(id);
        return optionalFacture.orElseThrow(() -> new FactureException("Facture introuvable avec l'ID : " + id));
    }

    public Facture createFacture(Facture facture) {
        return factureRepository.save(facture);
    }

    public Facture updateFacture(Long id, Facture facture) {
        Optional<Facture> optionalFacture = factureRepository.findById(id);
        if (optionalFacture.isPresent()) {
            Facture existingFacture = optionalFacture.get();
            existingFacture.setMontant(facture.getMontant());
            existingFacture.setDate(facture.getDate());
            // Mise à jour d'autres attributs de la facture
            return factureRepository.save(existingFacture);
        } else {
            throw new FactureException("Facture introuvable avec l'ID : " + id);
        }
    }

    public void deleteFacture(Long id) {
        factureRepository.deleteById(id);
    }

}
