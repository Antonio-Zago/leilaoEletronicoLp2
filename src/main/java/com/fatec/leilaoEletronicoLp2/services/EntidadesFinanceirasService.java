package com.fatec.leilaoEletronicoLp2.services;

import com.fatec.leilaoEletronicoLp2.controllers.EntidadesFinanceirasController;
import com.fatec.leilaoEletronicoLp2.dtos.EntidadesFinanceirasDto;
import com.fatec.leilaoEletronicoLp2.dtos.EntidadesFinanceirasForm;
import com.fatec.leilaoEletronicoLp2.dtos.VeiculosDto;
import com.fatec.leilaoEletronicoLp2.models.EntidadeFinanceira;
import com.fatec.leilaoEletronicoLp2.models.Veiculos;
import com.fatec.leilaoEletronicoLp2.repositorys.EntidadesFinanceirasRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntidadesFinanceirasService {

    @Autowired
    EntidadesFinanceirasRepository entidadesFinanceirasRepository;

    //GetALL
    public ResponseEntity<List<EntidadesFinanceirasDto>> getAll() {
        List<EntidadeFinanceira> entidadesFinanceiras = entidadesFinanceirasRepository.findAll();
        List<EntidadesFinanceirasDto> entidadesFinanceirasDto = new ArrayList<EntidadesFinanceirasDto>();

        for (EntidadeFinanceira entidadesFinanceira : entidadesFinanceiras) {
            entidadesFinanceirasDto.add(converteParaDto(entidadesFinanceira));
        }
        return ResponseEntity.ok().body(entidadesFinanceirasDto);

    }

    //GetById
    public ResponseEntity<EntidadesFinanceirasDto> getById(Integer id) {
        return ResponseEntity.ok().body(converteParaDto(entidadesFinanceirasRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não encontrado registro de id: " + id + " na classe: " + EntidadeFinanceira.class.toString()))));
    }

    //Post
    public ResponseEntity<EntidadesFinanceirasDto> save(EntidadesFinanceirasForm entidadesFinanceirasForm) {

        EntidadeFinanceira entidadesFinan = new EntidadeFinanceira(entidadesFinanceirasForm.getEntfinNome());

        return ResponseEntity.ok().body(converteParaDto(entidadesFinanceirasRepository.save(entidadesFinan)));
    }

    //Put
    public ResponseEntity<EntidadesFinanceirasDto> update(EntidadesFinanceirasForm entidadesFinanceirasForm, Integer id) {
        EntidadeFinanceira entidadesFinan = entidadesFinanceirasRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não encontrado registro de id: " + id + " na classe: " + EntidadesFinanceirasController.class.toString()));
        
        entidadesFinan.setEntfinNome(entidadesFinanceirasForm.getEntfinNome());
        
        return ResponseEntity.ok().body(converteParaDto(entidadesFinanceirasRepository.save(entidadesFinan)));
    }

    //Delete

    public void delete(Integer id) {

        entidadesFinanceirasRepository.deleteById(id);

    }

    //Converter
    public EntidadesFinanceirasDto converteParaDto(EntidadeFinanceira EntidadesFinanceiras) {
        return new EntidadesFinanceirasDto(EntidadesFinanceiras.getEntfinId(), EntidadesFinanceiras.getEntfinNome());
    }


}
