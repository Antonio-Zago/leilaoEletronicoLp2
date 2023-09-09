package com.fatec.leilaoEletronicoLp2.dtos;

public class ClienteVeiculoDto {
	
	private Integer id;
	
	private Integer veiculo;
	
	private String nomeCliente;
	
	private String cpfCliente;
	
	private Double valorLance;
	
	

	public ClienteVeiculoDto(Integer id, Integer veiculo, String nomeCliente, String cpfCliente, Double valorLance) {
		super();
		this.id = id;
		this.veiculo = veiculo;
		this.nomeCliente = nomeCliente;
		this.cpfCliente = cpfCliente;
		this.valorLance = valorLance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Integer veiculo) {
		this.veiculo = veiculo;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public Double getValorLance() {
		return valorLance;
	}

	public void setValorLance(Double valorLance) {
		this.valorLance = valorLance;
	}
	
	
	
	
}
