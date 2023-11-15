package com.fatec.leilaoEletronicoLp2.controllers;

import java.util.ArrayList;
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

import com.fatec.leilaoEletronicoLp2.dtos.ClienteDispositivoInformaticaDto;
import com.fatec.leilaoEletronicoLp2.dtos.ClienteDispositivoInformaticaForm;
import com.fatec.leilaoEletronicoLp2.dtos.ClienteVeiculoDto;
import com.fatec.leilaoEletronicoLp2.dtos.ClienteVeiculoForm;
import com.fatec.leilaoEletronicoLp2.services.ClienteDispositivoInformaticaService;
import com.fatec.leilaoEletronicoLp2.services.ClienteVeiculoService;

//Classe de lances em veículos
@RestController
@RequestMapping("/api/lanceVeiculos")
@CrossOrigin(origins = "*")
public class ClienteVeiculoController {
	@Autowired
	private ClienteVeiculoService clienVeiculoService;

	@GetMapping
	public ResponseEntity<List<ClienteVeiculoDto>> getAll() {

		return clienVeiculoService.getAll();
	}

	@PostMapping
	public ResponseEntity<ClienteVeiculoDto> save(@RequestBody ClienteVeiculoForm clienteVeiculoForm) {


		return clienVeiculoService.save(clienteVeiculoForm);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClienteVeiculoDto> update(@RequestBody ClienteVeiculoForm clienteVeiculoForm, @PathVariable Integer id) {
		return clienVeiculoService.update(clienteVeiculoForm, id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		clienVeiculoService.delete(id);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteVeiculoDto> getById(@PathVariable Integer id) {
		return clienVeiculoService.getById(id);
	}



	@GetMapping("/historico-lances/{id}")
	public ResponseEntity<List<ClienteVeiculoDto>> getHistoricoLancesVeiculo(@PathVariable Integer id) {
		List<ClienteVeiculoDto> historicoLances = clienVeiculoService.getHistoricoLancesVeiculo(id);

		if (historicoLances.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(historicoLances);
	}





}