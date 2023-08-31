package com.fatec.leilaoEletronicoLp2.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fatec.leilaoEletronicoLp2.dtos.DispositivoInformaticaDto;
import com.fatec.leilaoEletronicoLp2.dtos.DispositivoInformaticaForm;
import com.fatec.leilaoEletronicoLp2.models.DispositivoInformatica;
import com.fatec.leilaoEletronicoLp2.models.Leilao;
import com.fatec.leilaoEletronicoLp2.models.TiposDi;
import com.fatec.leilaoEletronicoLp2.repositorys.DispositivosInformaticaRepository;
import com.fatec.leilaoEletronicoLp2.repositorys.LeilaoRepository;
import com.fatec.leilaoEletronicoLp2.repositorys.TiposDiRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DispositivosInformaticaService {
	
	@Autowired
	private DispositivosInformaticaRepository dispositivosInformaticaRepository;
	
	@Autowired
	private TiposDiRepository tipoDiRepository;
	
	@Autowired
	private LeilaoRepository leilaoRepository;
	
	public ResponseEntity<List<DispositivoInformaticaDto>> getAll(){
		List<DispositivoInformatica> dispositivoInformaticas= dispositivosInformaticaRepository.findAll();
		List<DispositivoInformaticaDto> dispositivoInformaticaDtos = new ArrayList<DispositivoInformaticaDto>();
		
		for (DispositivoInformatica dispositivoInformatica : dispositivoInformaticas) {
			dispositivoInformaticaDtos.add(converteParaDto(dispositivoInformatica));
		}
		return ResponseEntity.ok().body(dispositivoInformaticaDtos);
	}
	
	public ResponseEntity<DispositivoInformaticaDto> save(DispositivoInformaticaForm dispositivoInformaticaForm) {
		
		TiposDi tipoDi = tipoDiRepository.findById(dispositivoInformaticaForm.getTipoDi()).orElseThrow(() -> new EntityNotFoundException("Não encontrado registro de id: " + dispositivoInformaticaForm.getTipoDi() + " na classe: " + TiposDi.class.toString()));
		
		Leilao leilao = leilaoRepository.findById(dispositivoInformaticaForm.getLeilao()).orElseThrow(() -> new EntityNotFoundException("Não encontrado registro de id: " + dispositivoInformaticaForm.getLeilao() + " na classe: " + Leilao.class.toString()));
		
		DispositivoInformatica dispositivoInformatica = new DispositivoInformatica(
				dispositivoInformaticaForm.getDiEnderecoFisico(),
				dispositivoInformaticaForm.getDiMarca(),
				dispositivoInformaticaForm.getDiProcessador(),
				dispositivoInformaticaForm.getDiTela(),
				dispositivoInformaticaForm.getDiArmazenamento(),
				dispositivoInformaticaForm.getDiMemoria(),
				dispositivoInformaticaForm.getDiTensao(),
				dispositivoInformaticaForm.getDiNumeroPortas(),
				tipoDi,
				leilao
				);
		
		
		return ResponseEntity.ok().body(converteParaDto(dispositivosInformaticaRepository.save(dispositivoInformatica)));
	}
	
	public ResponseEntity<DispositivoInformaticaDto>  update(DispositivoInformaticaForm dispositivoInformaticaForm, Integer id) {
		
		DispositivoInformatica dispositivoInformatica = dispositivosInformaticaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não encontrado registro de id: " + id + " na classe: " + DispositivoInformatica.class.toString() ));                   
		
		TiposDi tipoDi = tipoDiRepository.findById(dispositivoInformaticaForm.getTipoDi()).orElseThrow(() -> new EntityNotFoundException("Não encontrado registro de id: " + dispositivoInformaticaForm.getTipoDi() + " na classe: " + TiposDi.class.toString()));
		
		Leilao leilao = leilaoRepository.findById(dispositivoInformaticaForm.getLeilao()).orElseThrow(() -> new EntityNotFoundException("Não encontrado registro de id: " + dispositivoInformaticaForm.getLeilao() + " na classe: " + Leilao.class.toString()));
		
		dispositivoInformatica.setDiArmazenamento(dispositivoInformaticaForm.getDiArmazenamento());
		dispositivoInformatica.setDiEnderecoFisico(dispositivoInformaticaForm.getDiEnderecoFisico());
		dispositivoInformatica.setDiMarca(dispositivoInformaticaForm.getDiMarca());
		dispositivoInformatica.setDiMemoria(dispositivoInformaticaForm.getDiMemoria());
		dispositivoInformatica.setDiNumeroPortas(dispositivoInformaticaForm.getDiNumeroPortas());
		dispositivoInformatica.setDiProcessador(dispositivoInformaticaForm.getDiProcessador());
		dispositivoInformatica.setDiTela(dispositivoInformaticaForm.getDiTela());
		dispositivoInformatica.setDiTensao(dispositivoInformaticaForm.getDiTensao());
		dispositivoInformatica.setTipoDi(tipoDi);
		dispositivoInformatica.setLeilao(leilao);
		
		return ResponseEntity.ok().body(converteParaDto(dispositivosInformaticaRepository.save(dispositivoInformatica)));
	}
	
	public void delete(Integer id) {
		
		dispositivosInformaticaRepository.deleteById(id);
	}
	
	public ResponseEntity<DispositivoInformaticaDto> getById(Integer id){
		return ResponseEntity.ok().body(converteParaDto(dispositivosInformaticaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não encontrado registro de id: " + id + " na classe: " + DispositivoInformatica.class.toString()))));
	}
	
	public DispositivoInformaticaDto converteParaDto(DispositivoInformatica dispositivoInformatica) {
		return new DispositivoInformaticaDto(
				dispositivoInformatica.getDiId(),
				dispositivoInformatica.getDiEnderecoFisico(),
				dispositivoInformatica.getDiMarca(),
				dispositivoInformatica.getDiProcessador(),
				dispositivoInformatica.getDiTela(),
				dispositivoInformatica.getDiArmazenamento(),
				dispositivoInformatica.getDiMemoria(),
				dispositivoInformatica.getDiTensao(),
				dispositivoInformatica.getDiNumeroPortas(),
				dispositivoInformatica.getTipoDi().getTdiNome(),
				dispositivoInformatica.getLeilao().getLeiDataOcorrencia());
	}

}
