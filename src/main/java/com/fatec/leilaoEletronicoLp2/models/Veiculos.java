package com.fatec.leilaoEletronicoLp2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "VEICULOS")
public class Veiculos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer veiId;
	
	private String veiPlaca;
	
	private String veiMarca;
	
	private Integer veiAnoFabricacao;
	
	private Double veiDistanciaRodada;
	
	private String veiCambio;
	
	private String veiCombustivel;
	
	private String veiCor;
	
	private Double veiPeso;
	
	@ManyToOne
	@JoinColumn(name = "tipo_veiculo")
	private TiposVeiculos tipoVeiculo;

	public Integer getVeiId() {
		return veiId;
	}

	public void setVeiId(Integer veiId) {
		this.veiId = veiId;
	}

	public String getVeiPlaca() {
		return veiPlaca;
	}

	public void setVeiPlaca(String veiPlaca) {
		this.veiPlaca = veiPlaca;
	}

	public String getVeiMarca() {
		return veiMarca;
	}

	public void setVeiMarca(String veiMarca) {
		this.veiMarca = veiMarca;
	}

	public Integer getVeiAnoFabricacao() {
		return veiAnoFabricacao;
	}

	public void setVeiAnoFabricacao(Integer veiAnoFabricacao) {
		this.veiAnoFabricacao = veiAnoFabricacao;
	}

	public Double getVeiDistanciaRodada() {
		return veiDistanciaRodada;
	}

	public void setVeiDistanciaRodada(Double veiDistanciaRodada) {
		this.veiDistanciaRodada = veiDistanciaRodada;
	}

	public String getVeiCambio() {
		return veiCambio;
	}

	public void setVeiCambio(String veiCambio) {
		this.veiCambio = veiCambio;
	}

	public String getVeiCombustivel() {
		return veiCombustivel;
	}

	public void setVeiCombustivel(String veiCombustivel) {
		this.veiCombustivel = veiCombustivel;
	}

	public String getVeiCor() {
		return veiCor;
	}

	public void setVeiCor(String veiCor) {
		this.veiCor = veiCor;
	}

	public Double getVeiPeso() {
		return veiPeso;
	}

	public void setVeiPeso(Double veiPeso) {
		this.veiPeso = veiPeso;
	}

	public TiposVeiculos getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(TiposVeiculos tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}
	
	
}
