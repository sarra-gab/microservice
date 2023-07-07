package com.ecommerce.microcommerce.facture.controller;

import com.ecommerce.microcommerce.facture.exception.FactureException;
import com.ecommerce.microcommerce.facture.model.Facture;
import com.ecommerce.microcommerce.facture.repository.FactureRepository;
import com.ecommerce.microcommerce.facture.service.FactureService;
import com.ecommerce.microcommerce.produit.exception.ProduitException;
import com.ecommerce.microcommerce.produit.model.Produit;
import com.ecommerce.microcommerce.produit.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/factures")

public class FactureController {
    @Autowired
    private FactureService factureService;
    @Autowired
    private FactureRepository factureRepository;
    @Autowired
    private ProduitRepository produitRepository;
    @GetMapping
    public List<Facture> getAllFactures() {
        return factureService.getAllFactures();
    }



    @GetMapping("/{id}")
    public ResponseEntity<Facture> getFactureById(@PathVariable Long id) {
        Facture facture = factureService.getFactureById(id);
        if (facture != null) {
            return ResponseEntity.ok(facture);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Facture createFacture(@RequestBody Facture factureDTO) {
        return factureService.createFacture(factureDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Facture> updateFacture(@PathVariable Long id, @RequestBody Facture factureDTO) {
        Facture updatedFacture = factureService.updateFacture(id, factureDTO);
        if (updatedFacture != null) {
            return ResponseEntity.ok(updatedFacture);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public boolean deleteFacture(Long id) {
        Optional<Facture> optionalFacture = factureRepository.findById(id);
        if (optionalFacture.isPresent()) {
            Facture facture = optionalFacture.get();
            factureRepository.delete(facture);
            return true;
        } else {
            throw new FactureException("Facture introuvable avec l'ID : " + id);
        }
    }
    @PostMapping("/{factureId}/produits/{produitId}")
    public Facture ajouterProduit(Long factureId, Long produitId, int quantite) {
        Facture facture = factureRepository.findById(factureId)
                .orElseThrow(() -> new FactureException("Facture introuvable avec l'ID : " + factureId));

        Produit produit = produitRepository.findById(produitId)
                .orElseThrow(() -> new ProduitException("Produit introuvable avec l'ID : " + produitId));

        // Ajoutez votre logique pour ajouter le produit à la facture ici

        return facture;
    }

    public FactureService getFactureService() {
        return factureService;
    }
}

