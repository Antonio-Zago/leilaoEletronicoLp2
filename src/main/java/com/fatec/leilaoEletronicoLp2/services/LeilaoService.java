package com.fatec.leilaoEletronicoLp2.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fatec.leilaoEletronicoLp2.dtos.*;
import com.fatec.leilaoEletronicoLp2.models.DispositivoInformatica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.fatec.leilaoEletronicoLp2.exceptions.DispositivosInformaticaTemLancesException;
import com.fatec.leilaoEletronicoLp2.exceptions.LeilaoSemEntidadesFinanceirasAssociadas;
import com.fatec.leilaoEletronicoLp2.models.EntidadeFinanceira;
import com.fatec.leilaoEletronicoLp2.models.Leilao;
import com.fatec.leilaoEletronicoLp2.models.Veiculos;
import com.fatec.leilaoEletronicoLp2.repositorys.DispositivosInformaticaRepository;
import com.fatec.leilaoEletronicoLp2.repositorys.EntidadesFinanceirasRepository;
import com.fatec.leilaoEletronicoLp2.repositorys.LeilaoRepository;
import com.fatec.leilaoEletronicoLp2.repositorys.VeiculosRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LeilaoService {
	
	@Autowired
	private LeilaoRepository leilaoRepository;
	

	
	@Autowired
	private EntidadesFinanceirasRepository entidadesFinanceirasRepository;
	
	@Autowired
	private VeiculosRepository veiculosRepository;
	
	@Autowired
	private DispositivosInformaticaRepository dispositivosInformaticaRepository;
	

	
	public ResponseEntity<List<LeilaoDto>> getAll(){
		List<Leilao> leiloes= leilaoRepository.findAll();
		
		List<LeilaoDto> leiloesDtos = new ArrayList<LeilaoDto>();
		
		for (Leilao leilao : leiloes) {
			leiloesDtos.add(converteParaDto(leilao));
		}
		return ResponseEntity.ok().body(leiloesDtos);
	}
	
	public ResponseEntity<List<LeilaoDto>> getAllOrderByDataOcorrencia(){
		List<Leilao> leiloes = leilaoRepository.findAll(Sort.by(Order.by("leiDataOcorrencia")).descending());
		
		List<LeilaoDto> leiloesDtos = new ArrayList<LeilaoDto>();
		
		for (Leilao leilao : leiloes) {
			leiloesDtos.add(converteParaDto(leilao));
		}
		return ResponseEntity.ok().body(leiloesDtos);
	}
	
	public ResponseEntity<LeilaoDto> save(LeilaoForm leilaoForm) {
		
		if(leilaoForm.getIdEntidadesFinanceiras().isEmpty()) {
			throw new LeilaoSemEntidadesFinanceirasAssociadas("Necessário informar ao menos uma entidade financeira para o leilão!!!");
		}
		
		List<EntidadeFinanceira> entidadeFinanceiras = new ArrayList<EntidadeFinanceira>();
		
		for (Integer idEntidadeFinanceira : leilaoForm.getIdEntidadesFinanceiras()) {
			EntidadeFinanceira entidadeFinanceira = entidadesFinanceirasRepository.findById(idEntidadeFinanceira).orElseThrow(() -> new EntityNotFoundException("Não encontrado registro de id: " + idEntidadeFinanceira + " na classe: " + EntidadeFinanceira.class.toString() ));;
			entidadeFinanceiras.add(entidadeFinanceira);
		}
		
		
		
		Leilao leilao = new Leilao(
				leilaoForm.getLeiDataOcorrencia(),
				leilaoForm.getLeiDataVisitacao(),
				leilaoForm.getLeiEndereco(),
				leilaoForm.getLeiCidade(),
				leilaoForm.getLeiestado(),
				leilaoForm.getLeiEnderecoWeb(),
				entidadeFinanceiras,
				leilaoForm.getLeiHoraFim()
				);
		
		
		return ResponseEntity.ok().body(converteParaDto(leilaoRepository.save(leilao)));
	}
	
	public ResponseEntity<LeilaoDto>  update(LeilaoForm leilaoForm, Integer id) {
		
		if(leilaoForm.getIdEntidadesFinanceiras().isEmpty()) {
			throw new LeilaoSemEntidadesFinanceirasAssociadas("Necessário informar ao menos uma entidade financeira para o leilão!!!");
		}
		
		List<EntidadeFinanceira> entidadeFinanceiras = new ArrayList<EntidadeFinanceira>();
		
		for (Integer idEntidadeFinanceira : leilaoForm.getIdEntidadesFinanceiras()) {
			EntidadeFinanceira entidadeFinanceira = entidadesFinanceirasRepository.findById(idEntidadeFinanceira).orElseThrow(() -> new EntityNotFoundException("Não encontrado registro de id: " + idEntidadeFinanceira + " na classe: " + EntidadeFinanceira.class.toString() ));;
			entidadeFinanceiras.add(entidadeFinanceira);
		}
		
		Leilao leilao = leilaoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não encontrado registro de id: " + id + " na classe: " + Leilao.class.toString() ));                   
		
		
		leilao.setLeiCidade(leilaoForm.getLeiCidade());
		leilao.setLeiDataOcorrencia(leilaoForm.getLeiDataOcorrencia());
		leilao.setLeiDataVisitacao(leilaoForm.getLeiDataVisitacao());
		leilao.setLeiEndereco(leilaoForm.getLeiEndereco());
		leilao.setLeiEnderecoWeb(leilaoForm.getLeiEnderecoWeb());
		leilao.setLeiEstado(leilaoForm.getLeiestado());
		leilao.setEntidadesFinanceiras(entidadeFinanceiras);
		leilao.setLeiDataHorafim(leilaoForm.getLeiHoraFim());
		
		return ResponseEntity.ok().body(converteParaDto(leilaoRepository.save(leilao)));
	}
	
	public void delete(Integer id) {
		
		leilaoRepository.deleteById(id);
	}
	
	public ResponseEntity<LeilaoDto> getById(Integer id){
		return ResponseEntity.ok().body(converteParaDto(leilaoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não encontrado registro de id: " + id + " na classe: " + Leilao.class.toString()))));
	}
	
	private LeilaoDto converteParaDto(Leilao leilao) {
		
		List<String> entidadeFinanceirasNomes = new ArrayList<String>();
		
		for (EntidadeFinanceira entidadeFinanceira : leilao.getEntidadesFinanceiras()) {
			entidadeFinanceirasNomes.add(entidadeFinanceira.getEntfinNome());
		}
		
		return new LeilaoDto(
				leilao.getLeiId(),
				leilao.getLeiDataOcorrencia(),
				leilao.getLeiDataVisitacao(),
				leilao.getLeiEndereco(),
				leilao.getLeiCidade(),
				leilao.getLeiEstado(),
				leilao.getLeiEnderecoWeb(),
				entidadeFinanceirasNomes
		);
	}

	public LeilaoDetalhesDto getDetalhes(Integer id) {
		Leilao leilao = leilaoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não encontrado registro de id: " + id + " na classe: " + Leilao.class.toString()));
		
		LeilaoDetalhesDto dto = new LeilaoDetalhesDto();
		
		List<Veiculos> veiculos = veiculosRepository.findVeiculosByLeilao(id);
		
		List<DispositivoInformatica> dis = dispositivosInformaticaRepository.findDiByLeilao(id);
		
		List<String> nomesProdutos = new ArrayList<String>();
		
		for (DispositivoInformatica dispositivoInformatica : dis) {
			nomesProdutos.add(dispositivoInformatica.getDiMarca());

		}
		for (Veiculos veiculo : veiculos) {
			nomesProdutos.add(veiculo.getVeiMarca());

		}
		
		Collections.sort(nomesProdutos);
		
		dto.setNomeProdutos(nomesProdutos);
		
		List<String> nomesEntidades = new ArrayList<String>();
		
		for (EntidadeFinanceira entidadeFinanceira : leilao.getEntidadesFinanceiras()) {
			nomesEntidades.add(entidadeFinanceira.getEntfinNome());
		}
		
		dto.setEntidadesFinanceirasNomes(nomesEntidades);
		dto.setLeiId(leilao.getLeiId());
		dto.setLeiDataOcorrencia(leilao.getLeiDataOcorrencia());
		dto.setLeiDataVisitacao(leilao.getLeiDataVisitacao());
		dto.setLeiEndereco(leilao.getLeiEndereco());
		dto.setLeiCidade(leilao.getLeiCidade());
		dto.setLeiestado(leilao.getLeiEstado());
		dto.setLeiEnderecoWeb(leilao.getLeiEnderecoWeb());
		dto.setLeiDataHoraFim(leilao.getLeiDataHorafim());
		dto.setLeiTotalProdutos(nomesProdutos.size());
	
		
		
		return dto;
	}

/*	public List<Produto> filtrarProdutos(Integer idLeilao, Double minValorInicial, Double maxValorInicial,
										 Double minValorFinal, Double maxValorFinal, String palavraChave, String tipoProduto) {
		Leilao leilao = leilaoRepository.findById(idLeilao)
				.orElseThrow(() -> new EntityNotFoundException("Leilão não encontrado"));

		List<Produto> produtos = leilao.getProdutos(); // Supondo que Leilao tenha uma lista de produtos

		// Filtrar por faixa de valores do lance inicial
		produtos = produtos.stream()
				.filter(produto -> produto.getValorInicial() >= minValorInicial && produto.getValorInicial() <= maxValorInicial)
				.collect(Collectors.toList());

		// Filtrar por faixa de valores considerando lances adicionais
		produtos = produtos.stream()
				.filter(produto -> produto.getValorFinal() >= minValorFinal && produto.getValorFinal() <= maxValorFinal)
				.collect(Collectors.toList());

		// Filtrar por palavra-chave no nome do produto
		produtos = produtos.stream()
				.filter(produto -> produto.getNome().contains(palavraChave))
				.collect(Collectors.toList());

		// Filtrar por tipo de produto
		if (tipoProduto != null && !tipoProduto.isEmpty()) {
			produtos = produtos.stream()
					.filter(produto -> produto.getTipo().equalsIgnoreCase(tipoProduto))
					.collect(Collectors.toList());
		}

		return produtos;
	}*/

	public String getStatusById(Integer id) {
		Leilao leilao = leilaoRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Leilão não encontrado"));

		return leilao.getStatus();
	}

	}


