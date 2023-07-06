package com.ecommerce.microcommerce.produit.repository;

import com.ecommerce.microcommerce.produit.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    Optional<Produit> findById(Long id);


    List<Produit> findAll();

    Produit save(Produit existingProduit);

    void delete(Produit existingProduit);

}

