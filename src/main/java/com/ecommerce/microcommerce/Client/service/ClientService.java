package com.ecommerce.microcommerce.Client.service;

import com.ecommerce.microcommerce.Client.dto.ClientDTO;
import com.ecommerce.microcommerce.Client.exception.ClientException;
import com.ecommerce.microcommerce.Client.model.Client;
import com.ecommerce.microcommerce.Client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ClientException("Client introuvable avec l'ID : " + id));
    }

    public Client createClient(ClientDTO client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, Client client) {
        return clientRepository.findById(id).map(existingClient -> {
            existingClient.setNom(client.getNom());
            existingClient.setPrenom(client.getPrenom());
            existingClient.setAdresse(client.getAdresse());
            existingClient.setNumTel(client.getNumTel());
            existingClient.setVille(client.getVille());
            return clientRepository.save(existingClient);
        }).orElseThrow(() -> new ClientException("Client introuvable avec l'ID : " + id));
    }

    public boolean deleteClient(Long id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            clientRepository.delete(client);
            return true;
        } else {
            throw new ClientException("Client introuvable avec l'ID : " + id);

        }
    }
}
