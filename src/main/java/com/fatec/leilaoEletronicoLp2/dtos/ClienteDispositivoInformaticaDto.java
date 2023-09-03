package com.fatec.leilaoEletronicoLp2.dtos;

import java.time.LocalDateTime;

public class ClienteDispositivoInformaticaDto {
	
	private Integer id;
	
	private Double valor;
	
	private String clienteNome;
	
	private String clienteCpf;
	
	private Integer dispositivoinformatica;
	
	private LocalDateTime dataHoraLance;
	
	
	

	public ClienteDispositivoInformaticaDto(Integer id, Double valor, String clienteNome, String clienteCpf,
			Integer dispositivoinformatica, LocalDateTime dataHoraLance) {
		super();
		this.id = id;
		this.valor = valor;
		this.clienteNome = clienteNome;
		this.clienteCpf = clienteCpf;
		this.dispositivoinformatica = dispositivoinformatica;
		this.dataHoraLance = dataHoraLance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getClienteNome() {
		return clienteNome;
	}

	public void setClienteNome(String clienteNome) {
		this.clienteNome = clienteNome;
	}

	public String getClienteCpf() {
		return clienteCpf;
	}

	public void setClienteCpf(String clienteCpf) {
		this.clienteCpf = clienteCpf;
	}

	public Integer getDispositivoinformatica() {
		return dispositivoinformatica;
	}

	public void setDispositivoinformatica(Integer dispositivoinformatica) {
		this.dispositivoinformatica = dispositivoinformatica;
	}

	public LocalDateTime getDataHoraLance() {
		return dataHoraLance;
	}

	public void setDataHoraLance(LocalDateTime dataHoraLance) {
		this.dataHoraLance = dataHoraLance;
	}
	
	
	
	
}
