package com.api.locadoradejogos.services;

import com.api.locadoradejogos.models.FuncionarioModel;
import com.api.locadoradejogos.repositories.FuncionarioRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FuncionarioService {

    final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Transactional
    public FuncionarioModel save(FuncionarioModel jogosModel){
        return funcionarioRepository.save(jogosModel);
    }

    public List<FuncionarioModel> findAll() {
        return funcionarioRepository.findAll();
    }

    public Optional<FuncionarioModel> findById(UUID id){
        return funcionarioRepository.findById(id);
    }

    @Transactional
    public void delete(FuncionarioModel funcionarioModel){
        funcionarioRepository.delete(funcionarioModel);
    }

}
