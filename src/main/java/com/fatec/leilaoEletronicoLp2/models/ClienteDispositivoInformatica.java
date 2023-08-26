package com.fatec.leilaoEletronicoLp2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTE_DISPOSITIVO_INFORMATICA")
public class ClienteDispositivoInformatica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clidiId;
	
	private double clidiValorLance;
	
	@ManyToOne
	@JoinColumn(name = "cliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "dispositivo_informatica")
	private DispositivoInformatica dispositivoInformatica;

	public int getClidiId() {
		return clidiId;
	}

	public void setClidiId(int clidiId) {
		this.clidiId = clidiId;
	}

	public double getClidiValorLance() {
		return clidiValorLance;
	}

	public void setClidiValorLance(double clidiValorLance) {
		this.clidiValorLance = clidiValorLance;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public DispositivoInformatica getDispositivoInformatica() {
		return dispositivoInformatica;
	}

	public void setDispositivoInformatica(DispositivoInformatica dispositivoInformatica) {
		this.dispositivoInformatica = dispositivoInformatica;
	}
	
	
	
}
