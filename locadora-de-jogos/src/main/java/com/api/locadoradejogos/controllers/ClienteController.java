package com.api.locadoradejogos.controllers;


import com.api.locadoradejogos.dtos.ClienteDto;
import com.api.locadoradejogos.models.ClienteModel;
import com.api.locadoradejogos.models.JogosModel;
import com.api.locadoradejogos.services.ClienteService;
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
@RequestMapping("/api/clientes")
public class ClienteController {

    final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Object> saveClientes(@RequestBody @Valid ClienteDto clienteDto){
        ClienteModel clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDto, clienteModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteModel));
    }

    @GetMapping
    public ResponseEntity<List<ClienteModel>> getTodosClientes(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteClientes(@PathVariable(value = "id") UUID id){
        Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
        if(!clienteModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        clienteService.delete(clienteModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateClientes(@PathVariable(value = "id") UUID id,
                                              @RequestBody @Valid ClienteDto clienteDto){
        Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
        if(!clienteModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        ClienteModel clienteModel = clienteModelOptional.get();
        clienteModel.setNome(clienteDto.getNome());
        clienteModel.setIdadeCliente(clienteDto.getIdadeCliente());
        clienteModel.setCpf(clienteDto.getCpf());
        clienteModel.setRg(clienteDto.getRg());
        clienteModel.setEmail(clienteDto.getEmail());
        clienteModel.setEndereco(clienteDto.getEndereco());
        clienteModel.setTelefoneCliente(clienteDto.getTelefoneCliente());
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(clienteModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ClienteModel>> getClienteById(@PathVariable(value = "id") UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findById(id));
    }

}
