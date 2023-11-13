package com.fatec.leilaoEletronicoLp2.controllers;

import com.fatec.leilaoEletronicoLp2.dtos.DispositivoInformaticaDetalhadoDto;
import com.fatec.leilaoEletronicoLp2.dtos.VeiculoDetalhadoDto;
import com.fatec.leilaoEletronicoLp2.dtos.VeiculosDto;
import com.fatec.leilaoEletronicoLp2.dtos.VeiculosForm;
import com.fatec.leilaoEletronicoLp2.services.VeiculosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veiculos")

public class VeiculosController {

    @Autowired
    private VeiculosService veiculosService;

    @GetMapping
    //Todos as Informaçãoes do Veiculos
    public ResponseEntity<List<VeiculosDto>> getAll() {

        return veiculosService.getAll();

    }

    @PostMapping
    public ResponseEntity<VeiculosDto> save(@RequestBody VeiculosForm veiculosForm) {
        return veiculosService.save(veiculosForm);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculosDto> update(@RequestBody VeiculosForm veiculosForm, @PathVariable Integer id) {
        return veiculosService.update(veiculosForm,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        veiculosService.delete(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculosDto> getById(@PathVariable Integer id) {
        return veiculosService.getById(id);
    }
    
    @GetMapping("/detalhes/{id}")
	public ResponseEntity<VeiculoDetalhadoDto> getByIdDetails(@PathVariable Integer id){
		return veiculosService.getByIdDetails(id);
	}

}
