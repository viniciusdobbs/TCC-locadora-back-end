package com.api.locadoradejogos.controllers;

import com.api.locadoradejogos.dtos.JogosDto;
import com.api.locadoradejogos.models.JogosModel;
import com.api.locadoradejogos.services.JogosService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/jogos")
public class JogosController {

    final JogosService jogosService;

    public JogosController(JogosService jogosService) {
        this.jogosService = jogosService;
    }

    @PostMapping
    public ResponseEntity<Object> saveJogos(@RequestBody @Valid JogosDto jogosDto){
        JogosModel jogosModel = new JogosModel();
        BeanUtils.copyProperties(jogosDto, jogosModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(jogosService.save(jogosModel));
    }

    @GetMapping
    public ResponseEntity<List<JogosModel>> getTodosJogos(){
        return ResponseEntity.status(HttpStatus.OK).body(jogosService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteJogos(@PathVariable(value = "id") UUID id){
        Optional<JogosModel> jogosModelOptional = jogosService.findById(id);
        if(!jogosModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Jogo não encontrado.");
        }
        jogosService.delete(jogosModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Jogo deletado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateJogos(@PathVariable(value = "id") UUID id,
                                              @RequestBody @Valid JogosDto jogosDto){
        Optional<JogosModel> jogosModelOptional = jogosService.findById(id);
        if(!jogosModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Jogo não encontrado.");
        }
        JogosModel jogosModel = jogosModelOptional.get();
        jogosModel.setNome(jogosDto.getNome());
        jogosModel.setGenero(jogosDto.getGenero());
        jogosModel.setConsole(jogosDto.getConsole());
        jogosModel.setPreco(jogosDto.getPreco());
        return ResponseEntity.status(HttpStatus.OK).body(jogosService.save(jogosModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<JogosModel>> getJogoById(@PathVariable(value = "id") UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(jogosService.findById(id));
    }
}
