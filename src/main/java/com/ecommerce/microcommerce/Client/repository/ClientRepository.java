package com.ecommerce.microcommerce.Client.repository;

import com.ecommerce.microcommerce.Client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findById(Long id);
    List<Client> findAll();
    Client save(Client client);
    void delete(Client client);

}
