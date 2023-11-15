package com.fatec.leilaoEletronicoLp2.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fatec.leilaoEletronicoLp2.dtos.*;
import com.fatec.leilaoEletronicoLp2.exceptions.GenericException;
import com.fatec.leilaoEletronicoLp2.exceptions.LeilaoFechadoException;
import com.fatec.leilaoEletronicoLp2.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.fatec.leilaoEletronicoLp2.repositorys.ClienteDispositivoInformaticaRepository;
import com.fatec.leilaoEletronicoLp2.repositorys.ClienteRepository;
import com.fatec.leilaoEletronicoLp2.repositorys.DispositivosInformaticaRepository;
import com.fatec.leilaoEletronicoLp2.repositorys.LeilaoRepository;
import com.fatec.leilaoEletronicoLp2.repositorys.TiposDiRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteDispositivoInformaticaService {
	
	@Autowired
	private ClienteDispositivoInformaticaRepository clienteDispositivosInformaticaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private DispositivosInformaticaRepository dispositivosInformaticaRepository;
	
	

	
	public ResponseEntity<List<ClienteDispositivoInformaticaDto>> getAll(){
		List<ClienteDispositivoInformatica> cliDispositivoInformaticas = clienteDispositivosInformaticaRepository.findAll();
		
		List<ClienteDispositivoInformaticaDto> clientesdispositivoInformaticaDtos = new ArrayList<ClienteDispositivoInformaticaDto>();
		
		for (ClienteDispositivoInformatica clienteDispositivoInformatica : cliDispositivoInformaticas) {
			clientesdispositivoInformaticaDtos.add(converteParaDto(clienteDispositivoInformatica));
		}
		return ResponseEntity.ok().body(clientesdispositivoInformaticaDtos);
	}
	
	public ResponseEntity<ClienteDispositivoInformaticaDto> save(ClienteDispositivoInformaticaForm clienteDispositivoInformaticaForm) {
		
		Cliente cliente = clienteRepository.findBycliCpf(clienteDispositivoInformaticaForm.getCpfCliente());
		
		DispositivoInformatica dispositivoInformatica = dispositivosInformaticaRepository.findById(clienteDispositivoInformaticaForm.getDispositivoInformatica()).orElseThrow(() -> new EntityNotFoundException("Não encontrado registro de id: " + clienteDispositivoInformaticaForm.getDispositivoInformatica() + " na classe: " + DispositivoInformatica.class.toString() ));
		
		
		
		
		
		ClienteDispositivoInformatica clienteDispositivoInformatica = new ClienteDispositivoInformatica();
		
		
		
		if(dispositivoInformatica.getLeilao().getLeiDataOcorrencia().isBefore(LocalDateTime.now()) && dispositivoInformatica.getLeilao().getLeiDataHorafim().isAfter(LocalDateTime.now())) {
			
			ClienteDispositivoInformatica  maiorLance = clienteDispositivosInformaticaRepository.findClienteWithHighestLance();
			
			List<ClienteDispositivoInformatica> lances = clienteDispositivosInformaticaRepository.findBydispositivoInformatica(dispositivoInformatica);
			
			if(!lances.isEmpty()) {
				if(maiorLance.getClidiValorLance() >= clienteDispositivoInformaticaForm.getValor()) {
					throw new GenericException("Valor do lance menor ou igual ao atual!");
				}
				if(maiorLance.getCliente().getCliCpf() == cliente.getCliCpf()) {
					throw new GenericException("Maior lance já é do seu usuário!");
				}
			}
			
			
			
			clienteDispositivoInformatica.setClidiValorLance(clienteDispositivoInformaticaForm.getValor());		
			clienteDispositivoInformatica.setCliente(cliente);	
			clienteDispositivoInformatica.setDispositivoInformatica(dispositivoInformatica);		
			clienteDispositivoInformatica.setClidiDataHoraLance(LocalDateTime.now());		
			
		}
		else {
			throw new LeilaoFechadoException("O leilão está fechado !!!");
		}
		
		
				
		
		
		return ResponseEntity.ok().body(converteParaDto(clienteDispositivosInformaticaRepository.save(clienteDispositivoInformatica)));
	}
	
	public ResponseEntity<ClienteDispositivoInformaticaDto>  update(ClienteDispositivoInformaticaForm clienteDispositivoInformaticaForm, Integer id) {
		
		ClienteDispositivoInformatica clienteDispositivoInformatica = clienteDispositivosInformaticaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não encontrado registro de id: " + id + " na classe: " + ClienteDispositivoInformatica.class.toString() ));                   
		
		Cliente cliente = clienteRepository.findBycliCpf(clienteDispositivoInformaticaForm.getCpfCliente());
		
		DispositivoInformatica dispositivoInformatica = dispositivosInformaticaRepository.findById(clienteDispositivoInformaticaForm.getDispositivoInformatica()).orElseThrow(() -> new EntityNotFoundException("Não encontrado registro de id: " + clienteDispositivoInformaticaForm.getDispositivoInformatica() + " na classe: " + DispositivoInformatica.class.toString() ));

		clienteDispositivoInformatica.setClidiValorLance(clienteDispositivoInformaticaForm.getValor());
		clienteDispositivoInformatica.setCliente(cliente);
		clienteDispositivoInformatica.setDispositivoInformatica(dispositivoInformatica);
		
		
		return ResponseEntity.ok().body(converteParaDto(clienteDispositivosInformaticaRepository.save(clienteDispositivoInformatica)));
	}
	
	public void delete(Integer id) {
		
		clienteDispositivosInformaticaRepository.deleteById(id);
	}
	
	public ResponseEntity<ClienteDispositivoInformaticaDto> getById(Integer id){
		return ResponseEntity.ok().body(converteParaDto(clienteDispositivosInformaticaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não encontrado registro de id: " + id + " na classe: " + ClienteDispositivoInformatica.class.toString()))));
	}

	public List<ClienteDispositivoInformaticaDto> getHistoricoLancesDispositivo(Integer id) {
		List<ClienteDispositivoInformatica> clienteDispositivoInformaticas = clienteDispositivosInformaticaRepository.findByclidiIdOrderByClidiIdAsc(id);

		List<ClienteDispositivoInformaticaDto> clienteDispositivoInformaticaDtos = new ArrayList<>();

		for (ClienteDispositivoInformatica clienteDispositivoInformatica : clienteDispositivoInformaticas) {
			clienteDispositivoInformaticaDtos.add(converteParaDto(clienteDispositivoInformatica));
		}

		return clienteDispositivoInformaticaDtos;
	}

	public ClienteDispositivoInformaticaDto converteParaDto(ClienteDispositivoInformatica clienteDispositivoInformatica) {
		return new ClienteDispositivoInformaticaDto(
				clienteDispositivoInformatica.getClidiId(),
				clienteDispositivoInformatica.getClidiValorLance(),
				clienteDispositivoInformatica.getCliente().getCliNome(),
				clienteDispositivoInformatica.getCliente().getCliCpf(),
				clienteDispositivoInformatica.getDispositivoInformatica().getDiId(),
				clienteDispositivoInformatica.getClidiDataHoraLance()
		);
	}
}
