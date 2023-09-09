package com.api.locadoradejogos.services;

import com.api.locadoradejogos.models.ClienteModel;
import com.api.locadoradejogos.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {

    final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public ClienteModel save(ClienteModel clienteModel){
        return clienteRepository.save(clienteModel);
    }

    public List<ClienteModel> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<ClienteModel> findById(UUID id){
        return clienteRepository.findById(id);
    }

    @Transactional
    public void delete(ClienteModel clienteModel){
        clienteRepository.delete(clienteModel);
    }

}
