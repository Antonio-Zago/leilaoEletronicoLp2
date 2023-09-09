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
	
	public Veiculos() {}
	
	
	
	public Veiculos(String veiPlaca, String veiMarca, Integer veiAnoFabricacao, Double veiDistanciaRodada,
			String veiCambio, String veiCombustivel, String veiCor, Double veiPeso, TiposVeiculos tipoVeiculo,
			Leilao leilao) {
		super();
		this.veiPlaca = veiPlaca;
		this.veiMarca = veiMarca;
		this.veiAnoFabricacao = veiAnoFabricacao;
		this.veiDistanciaRodada = veiDistanciaRodada;
		this.veiCambio = veiCambio;
		this.veiCombustivel = veiCombustivel;
		this.veiCor = veiCor;
		this.veiPeso = veiPeso;
		this.tipoVeiculo = tipoVeiculo;
		this.leilao = leilao;
	}



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
	
	@ManyToOne
	@JoinColumn(name = "leilao")
	private Leilao leilao;
	
	

	public Leilao getLeilao() {
		return leilao;
	}

	public void setLeilao(Leilao leilao) {
		this.leilao = leilao;
	}

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
