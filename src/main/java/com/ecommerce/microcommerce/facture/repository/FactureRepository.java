package com.ecommerce.microcommerce.facture.repository;

import com.ecommerce.microcommerce.Client.model.Client;
import com.ecommerce.microcommerce.facture.model.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {

}
