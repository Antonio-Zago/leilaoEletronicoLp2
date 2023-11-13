package com.fatec.leilaoEletronicoLp2.dtos;

import java.time.LocalDateTime;

public class VeiculoDetalhadoDto {
	private Integer veiId;

	private String veiPlaca;

    private String veiMarca;

    private Integer veiAnoFabricacao;

    private Double veiDistanciaRodada;

    private String veiCambio;

    private String veiCombustivel;

    private String veiCor;

    private Double veiPeso;
    
    private Double maiorLance;
	
	private String nomeClienteMaiorLance;
	
	private Boolean leilaoAberto;
    
    


    public Double getMaiorLance() {
		return maiorLance;
	}

	public void setMaiorLance(Double maiorLance) {
		this.maiorLance = maiorLance;
	}

	public String getNomeClienteMaiorLance() {
		return nomeClienteMaiorLance;
	}

	public void setNomeClienteMaiorLance(String nomeClienteMaiorLance) {
		this.nomeClienteMaiorLance = nomeClienteMaiorLance;
	}

	public Boolean getLeilaoAberto() {
		return leilaoAberto;
	}

	public void setLeilaoAberto(Boolean leilaoAberto) {
		this.leilaoAberto = leilaoAberto;
	}

	public VeiculoDetalhadoDto(Integer veiId, String veiPlaca, String veiMarca, Integer veiAnoFabricacao,
			Double veiDistanciaRodada, String veiCambio, String veiCombustivel, String veiCor, Double veiPeso,
			String nomeTipoVeiculo, LocalDateTime leilaoDataOcorrencia) {
		super();
		this.veiId = veiId;
		this.veiPlaca = veiPlaca;
		this.veiMarca = veiMarca;
		this.veiAnoFabricacao = veiAnoFabricacao;
		this.veiDistanciaRodada = veiDistanciaRodada;
		this.veiCambio = veiCambio;
		this.veiCombustivel = veiCombustivel;
		this.veiCor = veiCor;
		this.veiPeso = veiPeso;
		this.nomeTipoVeiculo = nomeTipoVeiculo;
		this.leilaoDataOcorrencia = leilaoDataOcorrencia;
	}

	private String nomeTipoVeiculo;
    
    private LocalDateTime leilaoDataOcorrencia;

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

	public String getNomeTipoVeiculo() {
		return nomeTipoVeiculo;
	}

	public void setNomeTipoVeiculo(String nomeTipoVeiculo) {
		this.nomeTipoVeiculo = nomeTipoVeiculo;
	}

	public LocalDateTime getLeilaoDataOcorrencia() {
		return leilaoDataOcorrencia;
	}

	public void setLeilaoDataOcorrencia(LocalDateTime leilaoDataOcorrencia) {
		this.leilaoDataOcorrencia = leilaoDataOcorrencia;
	}
}
