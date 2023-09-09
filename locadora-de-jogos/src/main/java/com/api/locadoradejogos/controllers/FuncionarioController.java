package com.api.locadoradejogos.controllers;

import com.api.locadoradejogos.dtos.ClienteDto;
import com.api.locadoradejogos.dtos.FuncionarioDto;
import com.api.locadoradejogos.models.ClienteModel;
import com.api.locadoradejogos.models.FuncionarioModel;
import com.api.locadoradejogos.services.FuncionarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public ResponseEntity<Object> saveFuncionario(@RequestBody @Valid FuncionarioDto funcionarioDto){
        FuncionarioModel funcionarioModel = new FuncionarioModel();
        BeanUtils.copyProperties(funcionarioDto, funcionarioModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioService.save(funcionarioModel));
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioModel>> getTodosFuncionarios(){
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFuncionario(@PathVariable(value = "id") UUID id){
        Optional<FuncionarioModel> funcionarioModelOptional = funcionarioService.findById(id);
        if(!funcionarioModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado.");
        }
        funcionarioService.delete(funcionarioModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Funcionário deletado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateFuncionario(@PathVariable(value = "id") UUID id,
                                                 @RequestBody @Valid FuncionarioDto funcionarioDto){
        Optional<FuncionarioModel> funcionarioModelOptional = funcionarioService.findById(id);
        if(!funcionarioModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado.");
        }
        FuncionarioModel funcionarioModel = funcionarioModelOptional.get();
        funcionarioModel.setNome(funcionarioDto.getNome());
        funcionarioModel.setCpf(funcionarioDto.getCpf());
        funcionarioModel.setRg(funcionarioDto.getRg());
        funcionarioModel.setEmail(funcionarioDto.getEmail());
        funcionarioModel.setEndereco(funcionarioDto.getEndereco());
        funcionarioModel.setSalarioFunc(funcionarioDto.getSalarioFunc());
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.save(funcionarioModel));
    }
}
