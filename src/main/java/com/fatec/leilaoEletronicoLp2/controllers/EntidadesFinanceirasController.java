package com.fatec.leilaoEletronicoLp2.controllers;

import com.fatec.leilaoEletronicoLp2.dtos.EntidadesFinanceirasDto;
import com.fatec.leilaoEletronicoLp2.dtos.EntidadesFinanceirasForm;
import com.fatec.leilaoEletronicoLp2.services.EntidadesFinanceirasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/entidadesFinanceiras")

public class EntidadesFinanceirasController {

    @Autowired
    private EntidadesFinanceirasService entidadesFinanceirasService;

    @GetMapping
    public ResponseEntity<List<EntidadesFinanceirasDto>> getAll() {

        return entidadesFinanceirasService.getAll();

    }

    @PostMapping
    public ResponseEntity<EntidadesFinanceirasDto> save(@RequestBody EntidadesFinanceirasForm entidadesFinanceirasForm) {
        return entidadesFinanceirasService.save(entidadesFinanceirasForm);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntidadesFinanceirasDto> update(@RequestBody EntidadesFinanceirasForm entidadesFinanceirasForm, @PathVariable Integer id) {
        return entidadesFinanceirasService.update(entidadesFinanceirasForm, id);
    }

    @DeleteMapping ("/{id}")
    public void delete(@PathVariable Integer id) {
        entidadesFinanceirasService.delete(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntidadesFinanceirasDto> getById (@PathVariable Integer id){
        return  entidadesFinanceirasService.getById (id);
    }

}
