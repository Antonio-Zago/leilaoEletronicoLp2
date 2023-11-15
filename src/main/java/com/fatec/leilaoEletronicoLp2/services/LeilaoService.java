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
import com.fatec.leilaoEletronicoLp2.repositorys.ClienteDispositivoInformaticaRepository;
import com.fatec.leilaoEletronicoLp2.repositorys.ClienteVeiculoRepository;
import com.fatec.leilaoEletronicoLp2.repositorys.DispositivosInformaticaRepository;
import com.fatec.leilaoEletronicoLp2.repositorys.EntidadesFinanceirasRepository;
import com.fatec.leilaoEletronicoLp2.repositorys.LeilaoRepository;
import com.fatec.leilaoEletronicoLp2.repositorys.VeiculosRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Query;

@Service
public class LeilaoService {
	
	@Autowired
	private LeilaoRepository leilaoRepository;
	
	@Autowired
    private EntityManager entityManager;
	
	@Autowired
	private EntidadesFinanceirasRepository entidadesFinanceirasRepository;
	
	@Autowired
	private VeiculosRepository veiculosRepository;
	
	@Autowired
	private DispositivosInformaticaRepository dispositivosInformaticaRepository;
	
	@Autowired
	private ClienteVeiculoRepository clienteVeiculoRepository;
	
	@Autowired
	private ClienteDispositivoInformaticaRepository clienteDispositivoInformaticaRepository;
	

	
	public ResponseEntity<List<LeilaoDto>> getAll(){
		List<Leilao> leiloes= leilaoRepository.findAll();
		
		List<LeilaoDto> leiloesDtos = new ArrayList<LeilaoDto>();
		
		for (Leilao leilao : leiloes) {
			leiloesDtos.add(converteParaDto(leilao));
		}
		return ResponseEntity.ok().body(leiloesDtos);
	}
	
	public ResponseEntity<List<ProdutoDto>> getAllWithParams(Integer id, Double valorMinimoInicial,Double valorMaximoInicial,Double valorMinimo,Double valorMaximo,String palavraChave,Integer categoria, Integer tipoProduto){
		Leilao leilao= leilaoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não encontrado registro de id: " + id + " na classe: " + Leilao.class.toString()));
		
		List<ProdutoDto> dtos = new ArrayList<ProdutoDto>();
		
		if(categoria == 1) {
			String consulta = "SELECT DISTINCT DI.* "
					+ "FROM DISPOSITIVOS_INFORMATICA DI "
					+ "INNER JOIN (SELECT CLIDI_VALOR_LANCE, DISPOSITIVO_INFORMATICA, MIN(CLIDI_DATA_HORA_LANCE) AS DATALANCEINICIAL "
					+ "FROM CLIENTE_DISPOSITIVO_INFORMATICA GROUP BY DISPOSITIVO_INFORMATICA, CLIDI_VALOR_LANCE) LANCE "
					+ "ON LANCE.DISPOSITIVO_INFORMATICA = DI.DI_ID "
					+ "INNER JOIN CLIENTE_DISPOSITIVO_INFORMATICA CLIDI ON CLIDI.DISPOSITIVO_INFORMATICA = DI.DI_ID "
					+ "INNER JOIN LEILAO LEI ON LEI.LEI_ID = DI.LEILAO "
					+ "WHERE LEI.LEI_ID = :parametro1 "
					+ "AND LANCE.CLIDI_VALOR_LANCE >= :parametro2 AND LANCE.CLIDI_VALOR_LANCE <= :parametro3 "
					+ "AND CLIDI.CLIDI_VALOR_LANCE >= :parametro4 AND CLIDI.CLIDI_VALOR_LANCE <= :parametro5 "
					+ "AND DI.TIPO_DI = :parametro6 "
					+ "AND DI.DI_MARCA LIKE '%" +palavraChave+ "%'";
			
			Query query = entityManager.createNativeQuery(consulta, DispositivoInformatica.class);
	        query.setParameter("parametro1", id);
	        query.setParameter("parametro2", valorMinimoInicial);
	        query.setParameter("parametro3", valorMaximoInicial);
	        query.setParameter("parametro4", valorMinimo);
	        query.setParameter("parametro5", valorMaximo);
	        query.setParameter("parametro6", tipoProduto);
	        
			
			List<DispositivoInformatica> dispositivoInformaticas = query.getResultList();
			
			
			
			for (DispositivoInformatica dispositivoInformatica : dispositivoInformaticas) {
				ProdutoDto dto = new ProdutoDto();
				dto.setNome(dispositivoInformatica.getDiMarca());
				dtos.add(dto);
			}
		}
		else if(categoria == 2) {
			String consulta = "SELECT DISTINCT DI.* "
					+ "FROM VEICULOS DI "
					+ "INNER JOIN (SELECT CLIVEI_VALOR_LANCE, VEICULO, MIN(CLIVEI_VALOR_LANCE) AS DATALANCEINICIAL "
					+ "FROM CLIENTE_VEICULO GROUP BY VEICULO, CLIVEI_VALOR_LANCE) LANCE "
					+ "ON LANCE.VEICULO = DI.VEI_ID "
					+ "INNER JOIN CLIENTE_VEICULO CLIDI ON CLIDI.VEICULO = DI.VEI_ID "
					+ "INNER JOIN LEILAO LEI ON LEI.LEI_ID = DI.LEILAO "
					+ "WHERE LEI.LEI_ID = :parametro1 "
					+ "AND LANCE.CLIVEI_VALOR_LANCE >= :parametro2 AND LANCE.CLIVEI_VALOR_LANCE <= :parametro3 "
					+ "AND CLIDI.CLIVEI_VALOR_LANCE >= :parametro4 AND CLIDI.CLIVEI_VALOR_LANCE <= :parametro5 "
					+ "AND DI.TIPO_VEICULO = :parametro6 "
					+ "AND DI.VEI_MARCA LIKE '%" +palavraChave+ "%'";
			
			Query query = entityManager.createNativeQuery(consulta, Veiculos.class);
	        query.setParameter("parametro1", id);
	        query.setParameter("parametro2", valorMinimoInicial);
	        query.setParameter("parametro3", valorMaximoInicial);
	        query.setParameter("parametro4", valorMinimo);
	        query.setParameter("parametro5", valorMaximo);
	        query.setParameter("parametro6", tipoProduto);
	        
			
			List<Veiculos> veiculos = query.getResultList();
			
			
			
			for (Veiculos veiculo : veiculos) {
				ProdutoDto dto = new ProdutoDto();
				dto.setNome(veiculo.getVeiMarca());
				dtos.add(dto);
			}
		}
		
		
		
		
		
		return ResponseEntity.ok().body(dtos);
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


