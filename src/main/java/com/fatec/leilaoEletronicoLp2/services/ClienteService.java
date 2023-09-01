package com.fatec.leilaoEletronicoLp2.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.leilaoEletronicoLp2.dtos.ClienteDto;
import com.fatec.leilaoEletronicoLp2.dtos.ClienteForm;
import com.fatec.leilaoEletronicoLp2.dtos.DispositivoInformaticaDto;
import com.fatec.leilaoEletronicoLp2.dtos.DispositivoInformaticaForm;
import com.fatec.leilaoEletronicoLp2.models.Cliente;
import com.fatec.leilaoEletronicoLp2.models.DispositivoInformatica;
import com.fatec.leilaoEletronicoLp2.models.Leilao;
import com.fatec.leilaoEletronicoLp2.models.TiposDi;
import com.fatec.leilaoEletronicoLp2.repositorys.ClienteRepository;
import com.fatec.leilaoEletronicoLp2.repositorys.DispositivosInformaticaRepository;
import com.fatec.leilaoEletronicoLp2.repositorys.LeilaoRepository;
import com.fatec.leilaoEletronicoLp2.repositorys.TiposDiRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	public ResponseEntity<List<ClienteDto>> getAll(){
		List<Cliente> clientes= clienteRepository.findAll();
		List<ClienteDto> clienteDtos = new ArrayList<ClienteDto>();
		
		for (Cliente cliente : clientes) {
			clienteDtos.add(converteParaDto(cliente));
		}
		return ResponseEntity.ok().body(clienteDtos);
	}
	
	public ResponseEntity<ClienteDto> save(ClienteForm clienteForm) {
		
		
		
		Cliente cliente = new Cliente(
				clienteForm.getCliCpf(),
				clienteForm.getCliNome(),
				clienteForm.getCliEmail()
				);
		
		
		return ResponseEntity.ok().body(converteParaDto(clienteRepository.save(cliente)));
	}
	
	public ResponseEntity<ClienteDto>  update(ClienteForm clienteForm, String cpf) {
		
		Cliente cliente = clienteRepository.findBycliCpf(cpf);                    
		

		cliente.setCliNome(clienteForm.getCliNome());
		cliente.setCliEmail(clienteForm.getCliEmail());
		
		return ResponseEntity.ok().body(converteParaDto(clienteRepository.save(cliente)));
	}
	
	@Transactional
	public void delete(String cpf) {
		
		clienteRepository.deleteBycliCpf(cpf);;
	}
	
	public ResponseEntity<ClienteDto> getById(String cpf){
		return ResponseEntity.ok().body(converteParaDto(clienteRepository.findBycliCpf(cpf)));
	}
	
	public ClienteDto converteParaDto(Cliente Cliente) {
		return new ClienteDto(Cliente.getCliCpf(), Cliente.getCliNome(), Cliente.getCliEmail());
	}
}
