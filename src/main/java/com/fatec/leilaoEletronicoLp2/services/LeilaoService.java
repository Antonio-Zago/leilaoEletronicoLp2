package com.fatec.leilaoEletronicoLp2.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.fatec.leilaoEletronicoLp2.dtos.LeilaoDto;
import com.fatec.leilaoEletronicoLp2.dtos.LeilaoForm;
import com.fatec.leilaoEletronicoLp2.exceptions.DispositivosInformaticaTemLancesException;
import com.fatec.leilaoEletronicoLp2.exceptions.LeilaoSemEntidadesFinanceirasAssociadas;
import com.fatec.leilaoEletronicoLp2.models.EntidadeFinanceira;
import com.fatec.leilaoEletronicoLp2.models.Leilao;
import com.fatec.leilaoEletronicoLp2.repositorys.EntidadesFinanceirasRepository;
import com.fatec.leilaoEletronicoLp2.repositorys.LeilaoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LeilaoService {
	
	@Autowired
	private LeilaoRepository leilaoRepository;
	
	@Autowired
	private EntidadesFinanceirasRepository entidadesFinanceirasRepository;
	

	
	public ResponseEntity<List<LeilaoDto>> getAll(){
		List<Leilao> leiloes= leilaoRepository.findAll();
		
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
				entidadeFinanceiras
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
	

}
