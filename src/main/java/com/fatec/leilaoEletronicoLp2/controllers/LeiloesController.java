package com.fatec.leilaoEletronicoLp2.controllers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.fatec.leilaoEletronicoLp2.dtos.*;
import com.fatec.leilaoEletronicoLp2.models.DispositivoInformatica;

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
	
	@GetMapping(value = "/param/{id}")
	public ResponseEntity<List<ProdutoDto>> getAllWithParams( @PathVariable Integer id, @RequestParam(required = false) Double valorMinimoInicial, @RequestParam(required = false)  Double valorMaximoInicial, @RequestParam(required = false)  Double valorMinimo, @RequestParam(required = false)  Double valorMaximo, @RequestParam(required = false)  String palavraChave, @RequestParam(required = false)  Integer categoria,@RequestParam(required = false)  Integer tipoProduto) {

		return leilaoService.getAllWithParams(id, valorMinimoInicial,valorMaximoInicial,valorMinimo,valorMaximo,palavraChave,categoria, tipoProduto);
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

	@GetMapping("detalhes/{id}")
	public ResponseEntity<LeilaoDetalhesDto> getDetalhes(@PathVariable Integer id) {
		LeilaoDetalhesDto detalhes = leilaoService.getDetalhes(id);
		return ResponseEntity.ok(detalhes);
	}
	
	@GetMapping("detalhes/txt/{id}")
	public String getDetalhesTxt(@PathVariable Integer id) {
		LeilaoDetalhesTxtDto detalhes = leilaoService.getDetalhestxt(id);
		
		boolean sucesso = criarArquivoTxt(detalhes);
		
		if (sucesso) {
            return "Exportação para TXT bem-sucedida!";
        } else {
            return "Falha na exportação para TXT.";
        }
	}
	
	private boolean criarArquivoTxt(LeilaoDetalhesTxtDto objeto) {
        try (FileWriter writer = new FileWriter("exportacao.txt")) {
        		writer.write("{ \n");
        		writer.write("    entidadesFinanceiras : " + objeto.getNomeEntidadeFinanceira() + ", \n");
        		writer.write("    produtosLeilao : " + objeto.getNomesProdutos() + ", \n");
        		writer.write("    clientesLeilao : " + objeto.getNomesClientes() + ", \n");
        		writer.write("    lancesLeilao : " + "[ \n");
        		for (ProdutosLancesDto lances : objeto.getHistoricoLances()) {
        			writer.write("    nomeProduto : " + lances.getNome() + ", \n");
        			writer.write("    valor : " + lances.getValor() + " \n");
				}
        		writer.write("] \n");
        		writer.write("} \n");

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


	@GetMapping("/{id}/status")
	public ResponseEntity<String> getStatus(@PathVariable Integer id) {
		String status = leilaoService.getStatusById(id);
		return ResponseEntity.ok().body(status);
	}
}
