package com.fatec.leilaoEletronicoLp2.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.fatec.leilaoEletronicoLp2.dtos.LeilaoDto;
import com.fatec.leilaoEletronicoLp2.dtos.LeilaoForm;
import com.fatec.leilaoEletronicoLp2.models.Leilao;
import com.fatec.leilaoEletronicoLp2.repositorys.LeilaoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LeilaoService {
	
	@Autowired
	private LeilaoRepository leilaoRepository;
	

	
	public ResponseEntity<List<LeilaoDto>> getAll(){
		List<Leilao> leiloes= leilaoRepository.findAll();
		
		List<LeilaoDto> leiloesDtos = new ArrayList<LeilaoDto>();
		
		for (Leilao leilao : leiloes) {
			leiloesDtos.add(converteParaDto(leilao));
		}
		return ResponseEntity.ok().body(leiloesDtos);
	}
	
	public ResponseEntity<LeilaoDto> save(LeilaoForm leilaoForm) {
		
		
		Leilao leilao = new Leilao(
				leilaoForm.getLeiDataOcorrencia(),
				leilaoForm.getLeiDataVisitacao(),
				leilaoForm.getLeiEndereco(),
				leilaoForm.getLeiCidade(),
				leilaoForm.getLeiestado(),
				leilaoForm.getLeiEnderecoWeb()
				);
		
		
		return ResponseEntity.ok().body(converteParaDto(leilaoRepository.save(leilao)));
	}
	
	public ResponseEntity<LeilaoDto>  update(LeilaoForm leilaoForm, Integer id) {
		
		Leilao leilao = leilaoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não encontrado registro de id: " + id + " na classe: " + Leilao.class.toString() ));                   
		
		
		leilao.setLeiCidade(leilaoForm.getLeiCidade());
		leilao.setLeiDataOcorrencia(leilaoForm.getLeiDataOcorrencia());
		leilao.setLeiDataVisitacao(leilaoForm.getLeiDataVisitacao());
		leilao.setLeiEndereco(leilaoForm.getLeiEndereco());
		leilao.setLeiEnderecoWeb(leilaoForm.getLeiEnderecoWeb());
		leilao.setLeiEstado(leilaoForm.getLeiestado());
		
		return ResponseEntity.ok().body(converteParaDto(leilaoRepository.save(leilao)));
	}
	
	public void delete(Integer id) {
		
		leilaoRepository.deleteById(id);
	}
	
	public ResponseEntity<LeilaoDto> getById(Integer id){
		return ResponseEntity.ok().body(converteParaDto(leilaoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não encontrado registro de id: " + id + " na classe: " + Leilao.class.toString()))));
	}
	
	private LeilaoDto converteParaDto(Leilao leilao) {
		return new LeilaoDto(
				leilao.getLeiId(),
				leilao.getLeiDataOcorrencia(),
				leilao.getLeiDataVisitacao(),
				leilao.getLeiEndereco(),
				leilao.getLeiCidade(),
				leilao.getLeiEstado(),
				leilao.getLeiEnderecoWeb()
		);
	}
	

}
