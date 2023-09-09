package com.api.locadoradejogos.services;

import com.api.locadoradejogos.models.JogosModel;
import com.api.locadoradejogos.repositories.JogosRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JogosService {

    final  JogosRepository jogosRepository;

    public JogosService(JogosRepository jogosRepository) {
        this.jogosRepository = jogosRepository;
    }

    @Transactional
    public JogosModel save(JogosModel jogosModel){
        return jogosRepository.save(jogosModel);
    }

    public List<JogosModel> findAll() {
        return jogosRepository.findAll();
    }

    public Optional<JogosModel> findById(UUID id){
       return jogosRepository.findById(id);
    }

    @Transactional
    public void delete(JogosModel jogosModel){
        jogosRepository.delete(jogosModel);
    }
}
