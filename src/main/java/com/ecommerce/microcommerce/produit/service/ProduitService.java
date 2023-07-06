package com.ecommerce.microcommerce.produit.service;

import com.ecommerce.microcommerce.produit.exception.ProduitException;
import com.ecommerce.microcommerce.produit.model.Produit;
import com.ecommerce.microcommerce.produit.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Produit getProduitById(Long id) {
        return produitRepository.findById(id)
                .orElseThrow(() -> new ProduitException("Produit introuvable avec l'ID : " + id));
    }


    public Produit updateProduit(long id, Produit produit) {
        Produit existingProduit = getProduitById(id);
        existingProduit.setType(produit.getType());
        existingProduit.setReference(produit.getReference());
        existingProduit.setDesc(produit.getDesc());
        existingProduit.setPrix(produit.getPrix());
        return produitRepository.save(existingProduit);
    }

    public boolean deleteProduit(long id) {
        Produit existingProduit = getProduitById(id);
        produitRepository.delete(existingProduit);
        return true;
    }
}
