package com.fatec.leilaoEletronicoLp2.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fatec.leilaoEletronicoLp2.dtos.ClienteDispositivoInformaticaDto;
import com.fatec.leilaoEletronicoLp2.dtos.ClienteDispositivoInformaticaForm;
import com.fatec.leilaoEletronicoLp2.dtos.DispositivoInformaticaDto;
import com.fatec.leilaoEletronicoLp2.dtos.DispositivoInformaticaForm;
import com.fatec.leilaoEletronicoLp2.models.Cliente;
import com.fatec.leilaoEletronicoLp2.models.ClienteDispositivoInformatica;
import com.fatec.leilaoEletronicoLp2.models.DispositivoInformatica;
import com.fatec.leilaoEletronicoLp2.models.Leilao;
import com.fatec.leilaoEletronicoLp2.models.TiposDi;
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

		ClienteDispositivoInformatica clienteDispositivoInformatica = new ClienteDispositivoInformatica(
				clienteDispositivoInformaticaForm.getValor(),
				cliente,
				dispositivoInformatica,
				LocalDateTime.now()
				);
		
		
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
