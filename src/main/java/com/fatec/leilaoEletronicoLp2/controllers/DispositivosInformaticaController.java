package com.fatec.leilaoEletronicoLp2.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.leilaoEletronicoLp2.dtos.DispositivoInformaticaDetalhadoDto;
import com.fatec.leilaoEletronicoLp2.dtos.DispositivoInformaticaDto;
import com.fatec.leilaoEletronicoLp2.dtos.DispositivoInformaticaForm;
import com.fatec.leilaoEletronicoLp2.models.DispositivoInformatica;
import com.fatec.leilaoEletronicoLp2.services.DispositivosInformaticaService;

@RestController
@RequestMapping("/api/dispositivosinformatica")
@CrossOrigin(origins="*")
public class DispositivosInformaticaController {
	
	@Autowired
	private DispositivosInformaticaService dispositivosInformaticaService;
	
	@GetMapping
	public ResponseEntity<List<DispositivoInformaticaDto>> getAll() {

		return dispositivosInformaticaService.getAll();
	}
	
	@PostMapping
	public ResponseEntity<DispositivoInformaticaDto> save(@RequestBody DispositivoInformaticaForm dispositivoInformaticaForm) {
		
		
		return dispositivosInformaticaService.save(dispositivoInformaticaForm);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<DispositivoInformaticaDto> update(@RequestBody DispositivoInformaticaForm dispositivoInformaticaForm, @PathVariable Integer id) {
		return dispositivosInformaticaService.update(dispositivoInformaticaForm, id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		dispositivosInformaticaService.delete(id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DispositivoInformaticaDto> getById(@PathVariable Integer id){
		return dispositivosInformaticaService.getById(id);
	}
	
	@GetMapping("/detalhes/{id}")
	public ResponseEntity<DispositivoInformaticaDetalhadoDto> getByIdDetails(@PathVariable Integer id){
		return dispositivosInformaticaService.getByIdDetails(id);
	}
	
}
