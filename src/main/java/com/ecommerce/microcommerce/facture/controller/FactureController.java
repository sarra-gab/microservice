package com.ecommerce.microcommerce.facture.controller;

import com.ecommerce.microcommerce.facture.exception.FactureException;
import com.ecommerce.microcommerce.facture.model.Facture;
import com.ecommerce.microcommerce.facture.repository.FactureRepository;
import com.ecommerce.microcommerce.facture.service.FactureService;
import com.ecommerce.microcommerce.produit.model.Produit;
import com.ecommerce.microcommerce.produit.service.ProduitService;
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
    private ProduitService produitService;
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
    public ResponseEntity<Facture> ajouterProduit(@PathVariable Long factureId, @PathVariable Long produitId, @RequestParam int quantite) {
        Facture facture = factureService.getFactureById(factureId);
        Produit produit = produitService.getProduitById(produitId);

        if (facture != null && produit != null) {
            factureService.ajouterProduitAFacture(facture, produit, quantite);
            return ResponseEntity.ok(facture);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{factureId}/produits/{produitId}")
    public ResponseEntity<Facture> supprimerProduitDeFacture(@PathVariable Long factureId, @PathVariable Long produitId) {
        Facture facture = factureService.getFactureById(factureId);
        Produit produit = produitService.getProduitById(produitId);

        if (facture != null && produit != null) {
            factureService.supprimerProduitDeFacture(facture, produit);
            return ResponseEntity.ok(facture);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public FactureService getFactureService() {
        return factureService;
    }
}

