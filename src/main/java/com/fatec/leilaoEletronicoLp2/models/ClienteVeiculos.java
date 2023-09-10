package com.fatec.leilaoEletronicoLp2.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTE_VEICULO")
public class ClienteVeiculos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cliveiId;
	
	@ManyToOne
	@JoinColumn(name = "veiculo")
	private Veiculos veiculo;
	
	@ManyToOne
	@JoinColumn(name = "cliente")
	private Cliente cliente;
	
	private Double cliveiValorLance;
	
	private LocalDateTime clidiDataHoraLance;
	
	public ClienteVeiculos() {}
	
	
	

	public ClienteVeiculos(Veiculos veiculo, Cliente cliente, Double cliveiValorLance, LocalDateTime clidiDataHoraLance) {
		super();
		this.veiculo = veiculo;
		this.cliente = cliente;
		this.cliveiValorLance = cliveiValorLance;
		this.clidiDataHoraLance = clidiDataHoraLance;
	}
	
	




	public LocalDateTime getClidiDataHoraLance() {
		return clidiDataHoraLance;
	}




	public void setClidiDataHoraLance(LocalDateTime clidiDataHoraLance) {
		this.clidiDataHoraLance = clidiDataHoraLance;
	}




	public Integer getCliveiId() {
		return cliveiId;
	}

	public void setCliveiId(Integer cliveiId) {
		this.cliveiId = cliveiId;
	}

	public Veiculos getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculos veiculo) {
		this.veiculo = veiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getCliveiValorLance() {
		return cliveiValorLance;
	}

	public void setCliveiValorLance(Double cliveiValorLance) {
		this.cliveiValorLance = cliveiValorLance;
	}
	
	

}
