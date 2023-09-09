package com.api.locadoradejogos.controllers;

import com.api.locadoradejogos.dtos.LocacaoDto;
import com.api.locadoradejogos.models.JogosModel;
import com.api.locadoradejogos.models.LocacaoModel;
import com.api.locadoradejogos.services.LocacaoService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/locacao")
public class LocacaoController {

    final LocacaoService locacaoService;

    public LocacaoController(LocacaoService locacaoService) {
        this.locacaoService = locacaoService;
    }

    @PostMapping
    public ResponseEntity<Object> saveLocacao(@RequestBody @Valid LocacaoDto locacaoDto){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date dataLocacao = calendar.getTime();
        LocacaoModel locacaoModel = new LocacaoModel();
        BeanUtils.copyProperties(locacaoDto, locacaoModel);
        locacaoModel.setDataLocacao(dataLocacao);
        int percentual = 2;
        locacaoModel.setValorDia(locacaoService.valorDia(locacaoDto.getJogo().getPreco(), percentual));
        long quantidadeJogos = locacaoService.validarLocacao(locacaoModel.getCliente());
        if(quantidadeJogos >= 2){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Cliente ja esgotou o limite de locações");
        }
        else {
            return ResponseEntity.status(HttpStatus.CREATED).body(locacaoService.save(locacaoModel));
        }
    }

    @GetMapping
    public ResponseEntity<List<LocacaoModel>> getTodasLocacoes(){
        return ResponseEntity.status(HttpStatus.OK).body(locacaoService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateLocacao(@PathVariable(value = "id") UUID id,
                                                @RequestBody LocacaoDto locacaoDto){
        Optional<LocacaoModel> locacaoModelOptional = locacaoService.findById(id);
        if(!locacaoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Locação não encontrada.");
        }
        LocacaoModel locacaoModel = locacaoModelOptional.get();
        locacaoModel.setDataDevolucao(locacaoDto.getDataDevolucao());
        //locacaoService.save(locacaoModel);
        return ResponseEntity.status(HttpStatus.OK).body(locacaoService.update(locacaoModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteLocacao(@PathVariable(value = "id") UUID id){
        Optional<LocacaoModel> locacaoModelOptional = locacaoService.findById(id);
        if(!locacaoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Locação não encontrada.");
        }
        locacaoService.delete(locacaoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Locação deletada com sucesso!");
    }
}
