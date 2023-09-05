package com.fatec.leilaoEletronicoLp2.services;


import com.fatec.leilaoEletronicoLp2.dtos.DispositivoInformaticaDto;
import com.fatec.leilaoEletronicoLp2.dtos.VeiculosDto;
import com.fatec.leilaoEletronicoLp2.dtos.VeiculosForm;
import com.fatec.leilaoEletronicoLp2.models.DispositivoInformatica;
import com.fatec.leilaoEletronicoLp2.models.Veiculos;
import com.fatec.leilaoEletronicoLp2.repositorys.VeiculosRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VeiculosService {
    @Autowired
    private VeiculosRepository veiculosRepository;


    public ResponseEntity<List<VeiculosDto>> getAll() {
        List<Veiculos> veiculo = veiculosRepository.findAll();
        List<VeiculosDto> veiculosDto = new ArrayList<VeiculosDto>();

        for (Veiculos veiculos : veiculo) {
            veiculosDto.add(converteParaDto(veiculos));
        }
        return ResponseEntity.ok().body(veiculosDto);

    }


    public ResponseEntity<VeiculosDto> getById(Integer id) {

        return ResponseEntity.ok().body(converteParaDto(veiculosRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não encontrado registro de id: " + id + " na classe: " + Veiculos.class.toString()))));

    }


    public ResponseEntity<VeiculosDto> save(VeiculosForm veiculosForm) {
        Veiculos veiculos = new Veiculos(
        );
        return ResponseEntity.ok().body(converteParaDto(veiculosRepository.save(veiculos)));


    }

    public ResponseEntity<VeiculosDto> update(VeiculosForm veiculosForm, Integer id) {

        Veiculos veiculos = veiculosRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não encontrado registro de id: " + id + " na classe: " + Veiculos.class.toString()));
        return ResponseEntity.ok().body(converteParaDto(veiculos));
    }


    public void delete(Integer id) {

        veiculosRepository.deleteById(id);
    }

    public VeiculosDto converteParaDto(Veiculos veiculos) {
        return new VeiculosDto(
        );
    }


}


