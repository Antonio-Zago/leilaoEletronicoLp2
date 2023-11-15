package com.fatec.leilaoEletronicoLp2.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fatec.leilaoEletronicoLp2.dtos.ClienteDispositivoInformaticaDto;
import com.fatec.leilaoEletronicoLp2.dtos.ClienteDispositivoInformaticaForm;
import com.fatec.leilaoEletronicoLp2.dtos.ClienteVeiculoDto;
import com.fatec.leilaoEletronicoLp2.dtos.ClienteVeiculoForm;
import com.fatec.leilaoEletronicoLp2.dtos.VeiculosDto;
import com.fatec.leilaoEletronicoLp2.models.Cliente;
import com.fatec.leilaoEletronicoLp2.models.ClienteDispositivoInformatica;
import com.fatec.leilaoEletronicoLp2.models.ClienteVeiculos;
import com.fatec.leilaoEletronicoLp2.models.DispositivoInformatica;
import com.fatec.leilaoEletronicoLp2.models.Veiculos;
import com.fatec.leilaoEletronicoLp2.repositorys.ClienteDispositivoInformaticaRepository;
import com.fatec.leilaoEletronicoLp2.repositorys.ClienteRepository;
import com.fatec.leilaoEletronicoLp2.repositorys.ClienteVeiculoRepository;
import com.fatec.leilaoEletronicoLp2.repositorys.DispositivosInformaticaRepository;
import com.fatec.leilaoEletronicoLp2.repositorys.VeiculosRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteVeiculoService {
	
	@Autowired
	private ClienteVeiculoRepository clienteVeiculoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private VeiculosRepository veiculosRepository;
	

	
	public ResponseEntity<List<ClienteVeiculoDto>> getAll(){
		List<ClienteVeiculos> clienteVeiculos = clienteVeiculoRepository.findAll();
		
		List<ClienteVeiculoDto> clienteVeiculoDtos = new ArrayList<ClienteVeiculoDto>();
		
		for (ClienteVeiculos clienteVeiculo : clienteVeiculos) {
			clienteVeiculoDtos.add(converteParaDto(clienteVeiculo));
		}
		return ResponseEntity.ok().body(clienteVeiculoDtos);
	}
	
	public ResponseEntity<ClienteVeiculoDto> save(ClienteVeiculoForm clienteVeiculoForm) {
		
		Cliente cliente = clienteRepository.findBycliCpf(clienteVeiculoForm.getCpfCliente());
		
		Veiculos veiculos = veiculosRepository.findById(clienteVeiculoForm.getVeiculo()).orElseThrow(() -> new EntityNotFoundException("Não encontrado registro de id: " + clienteVeiculoForm.getVeiculo() + " na classe: " + Veiculos.class.toString() ));

		ClienteVeiculos clienteVeiculos = new ClienteVeiculos(
				veiculos,
				cliente,
				clienteVeiculoForm.getValorLance(),
				LocalDateTime.now()
				);
		
		
		return ResponseEntity.ok().body(converteParaDto(clienteVeiculoRepository.save(clienteVeiculos)));
	}
	
	public ResponseEntity<ClienteVeiculoDto>  update(ClienteVeiculoForm clienteVeiculoForm, Integer id) {
		
		ClienteVeiculos clienteVeiculos = clienteVeiculoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não encontrado registro de id: " + id + " na classe: " + ClienteVeiculos.class.toString() ));                   
		
		Cliente cliente = clienteRepository.findBycliCpf(clienteVeiculoForm.getCpfCliente());
		
		Veiculos veiculos = veiculosRepository.findById(clienteVeiculoForm.getVeiculo()).orElseThrow(() -> new EntityNotFoundException("Não encontrado registro de id: " + clienteVeiculoForm.getVeiculo() + " na classe: " + Veiculos.class.toString() ));

		clienteVeiculos.setCliveiValorLance(clienteVeiculoForm.getValorLance());
		clienteVeiculos.setCliente(cliente);
		clienteVeiculos.setVeiculo(veiculos);
		
		
		return ResponseEntity.ok().body(converteParaDto(clienteVeiculoRepository.save(clienteVeiculos)));
	}
	
	public void delete(Integer id) {
		
		clienteVeiculoRepository.deleteById(id);
	}
	
	public ResponseEntity<ClienteVeiculoDto> getById(Integer id){
		return ResponseEntity.ok().body(converteParaDto(clienteVeiculoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não encontrado registro de id: " + id + " na classe: " + ClienteVeiculos.class.toString()))));
	}


	public List<ClienteVeiculoDto> getHistoricoLancesVeiculo(Integer id) {
		List<ClienteVeiculos> clienteVeiculos = clienteVeiculoRepository.findBycliveiIdOrderByCliveiIdAsc(id);

		List<ClienteVeiculoDto> clienteVeiculoDtos = new ArrayList<>();

		for (ClienteVeiculos clienteVeiculo : clienteVeiculos) {
			clienteVeiculoDtos.add(converteParaDto(clienteVeiculo));
		}

		return clienteVeiculoDtos;
	}


	public ClienteVeiculoDto converteParaDto(ClienteVeiculos clienteVeiculos) {
		return new ClienteVeiculoDto(
				clienteVeiculos.getCliveiId(),
				clienteVeiculos.getVeiculo().getVeiId(),
				clienteVeiculos.getCliente().getCliNome(),
				clienteVeiculos.getCliente().getCliCpf(),
				clienteVeiculos.getCliveiValorLance()
		);
	}
	
}
