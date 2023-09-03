package com.fatec.leilaoEletronicoLp2.dtos;

import java.time.LocalDateTime;

public class DispositivoInformaticaDto {
	
	
	
	public DispositivoInformaticaDto(Integer diId, String diEnderecoFisico, String diMarca, String diProcessador,
			String diTela, Double diArmazenamento, Double diMemoria, Integer diTensao, Integer diNumeroPortas, String tipoDiNome, LocalDateTime leilaoDataOcorrencia) {
		super();
		this.diId = diId;
		this.diEnderecoFisico = diEnderecoFisico;
		this.diMarca = diMarca;
		this.diProcessador = diProcessador;
		this.diTela = diTela;
		this.diArmazenamento = diArmazenamento;
		this.diMemoria = diMemoria;
		this.diTensao = diTensao;
		this.diNumeroPortas = diNumeroPortas;
		this.tipoDiNome = tipoDiNome;
		this.leilaoDataOcorrencia = leilaoDataOcorrencia;
	}

	private Integer diId;
	
	private String diEnderecoFisico;
	
	private String diMarca;
	
	private String diProcessador; 
	
	private String diTela;
	
	private Double diArmazenamento;
	
	private Double diMemoria;
	
	private Integer diTensao;
	
	private Integer diNumeroPortas;
	
	private String tipoDiNome;
	
	private LocalDateTime leilaoDataOcorrencia;
	
	
	
	

	public LocalDateTime getLeilaoDataOcorrencia() {
		return leilaoDataOcorrencia;
	}

	public void setLeilaoDataOcorrencia(LocalDateTime leilaoDataOcorrencia) {
		this.leilaoDataOcorrencia = leilaoDataOcorrencia;
	}

	public void setDiMemoria(Double diMemoria) {
		this.diMemoria = diMemoria;
	}

	public Integer getDiId() {
		return diId;
	}

	public void setDiId(Integer diId) {
		this.diId = diId;
	}

	public String getDiEnderecoFisico() {
		return diEnderecoFisico;
	}

	public void setDiEnderecoFisico(String diEnderecoFisico) {
		this.diEnderecoFisico = diEnderecoFisico;
	}

	public String getDiMarca() {
		return diMarca;
	}

	public void setDiMarca(String diMarca) {
		this.diMarca = diMarca;
	}

	public String getDiProcessador() {
		return diProcessador;
	}

	public void setDiProcessador(String diProcessador) {
		this.diProcessador = diProcessador;
	}

	public String getDiTela() {
		return diTela;
	}

	public void setDiTela(String diTela) {
		this.diTela = diTela;
	}

	public Double getDiArmazenamento() {
		return diArmazenamento;
	}

	public void setDiArmazenamento(Double diArmazenamento) {
		this.diArmazenamento = diArmazenamento;
	}

	public double getDiMemoria() {
		return diMemoria;
	}

	public void setDiMemoria(double diMemoria) {
		this.diMemoria = diMemoria;
	}

	public Integer getDiTensao() {
		return diTensao;
	}

	public void setDiTensao(Integer diTensao) {
		this.diTensao = diTensao;
	}

	public Integer getDiNumeroPortas() {
		return diNumeroPortas;
	}

	public void setDiNumeroPortas(Integer diNumeroPortas) {
		this.diNumeroPortas = diNumeroPortas;
	}

	public String getTipoDiNome() {
		return tipoDiNome;
	}

	public void setTipoDiNome(String tipoDiNome) {
		this.tipoDiNome = tipoDiNome;
	}

	
	
	
	
	
}
