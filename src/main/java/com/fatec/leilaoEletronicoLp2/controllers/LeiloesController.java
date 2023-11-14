package com.fatec.leilaoEletronicoLp2.controllers;

import java.util.List;

import com.fatec.leilaoEletronicoLp2.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fatec.leilaoEletronicoLp2.services.DispositivosInformaticaService;
import com.fatec.leilaoEletronicoLp2.services.LeilaoService;

@RestController
@RequestMapping("/api/leilao")
@CrossOrigin(origins="*")
public class LeiloesController {
	
	@Autowired
	private LeilaoService leilaoService;
	
	@GetMapping
	public ResponseEntity<List<LeilaoDto>> getAll() {

		return leilaoService.getAll();
	}
	
	@GetMapping(value = "/dataOcorrencia")
	public ResponseEntity<List<LeilaoDto>> getAllOrderByDataOcorrencia(){
		return leilaoService.getAllOrderByDataOcorrencia();
	}
	
	@PostMapping
	public ResponseEntity<LeilaoDto> save(@RequestBody LeilaoForm leilaoForm) {
		
		
		return leilaoService.save(leilaoForm);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<LeilaoDto> update(@RequestBody LeilaoForm leilaoForm, @PathVariable Integer id) {
		return leilaoService.update(leilaoForm, id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		leilaoService.delete(id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LeilaoDto> getById(@PathVariable Integer id){
		return leilaoService.getById(id);
	}

	@GetMapping("/{id}/detalhes")
	public ResponseEntity<LeilaoDetalhesDto> getDetalhes(@PathVariable Integer id) {
		LeilaoDetalhesDto detalhes = leilaoService.getDetalhes(id);
		return ResponseEntity.ok(detalhes);
	}

/*
	@GetMapping("/{id}/produtos")
	public ResponseEntity<List<Produto>> filtrarProdutos(@PathVariable Integer id,
														 @RequestParam(required = false) Double minValorInicial,
														 @RequestParam(required = false) Double maxValorInicial,
														 @RequestParam(required = false) Double minValorFinal,
														 @RequestParam(required = false) Double maxValorFinal,
														 @RequestParam(required = false) String palavraChave,
														 @RequestParam(required = false) String tipoProduto) {
		List<Produto> produtos = leilaoService.filtrarProdutos(id, minValorInicial, maxValorInicial,
				minValorFinal, maxValorFinal, palavraChave, tipoProduto);
		return ResponseEntity.ok().body(produtos);
	}
*/

	@GetMapping("/{id}/status")
	public ResponseEntity<String> getStatus(@PathVariable Integer id) {
		String status = leilaoService.getStatusById(id);
		return ResponseEntity.ok().body(status);
	}
}
