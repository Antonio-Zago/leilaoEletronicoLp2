package com.fatec.leilaoEletronicoLp2.dtos;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class LeilaoDto {
	
	private Integer leiId;
	
	private LocalDateTime leiDataOcorrencia;
	
	private LocalDateTime leiDataVisitacao;
	
	private String leiEndereco;
	
	private String leiCidade;
	
	private String leiestado;
	
	private String leiEnderecoWeb;
	
	private List<String> entidadesFinanceirasNomes;

	
	
	
	public LeilaoDto(Integer leiId, LocalDateTime leiDataOcorrencia, LocalDateTime leiDataVisitacao, String leiEndereco, String leiCidade,
			String leiestado, String leiEnderecoWeb, List<String> entidadesFinanceirasNomes) {
		super();
		this.leiId = leiId;
		this.leiDataOcorrencia = leiDataOcorrencia;
		this.leiDataVisitacao = leiDataVisitacao;
		this.leiEndereco = leiEndereco;
		this.leiCidade = leiCidade;
		this.leiestado = leiestado;
		this.leiEnderecoWeb = leiEnderecoWeb;
		this.entidadesFinanceirasNomes = entidadesFinanceirasNomes;
	}

	public Integer getLeiId() {
		return leiId;
	}

	public void setLeiId(Integer leiId) {
		this.leiId = leiId;
	}

	public LocalDateTime getLeiDataOcorrencia() {
		return leiDataOcorrencia;
	}

	public void setLeiDataOcorrencia(LocalDateTime leiDataOcorrencia) {
		this.leiDataOcorrencia = leiDataOcorrencia;
	}

	public LocalDateTime getLeiDataVisitacao() {
		return leiDataVisitacao;
	}

	public void setLeiDataVisitacao(LocalDateTime leiDataVisitacao) {
		this.leiDataVisitacao = leiDataVisitacao;
	}

	public String getLeiEndereco() {
		return leiEndereco;
	}

	public void setLeiEndereco(String leiEndereco) {
		this.leiEndereco = leiEndereco;
	}

	public String getLeiCidade() {
		return leiCidade;
	}

	public void setLeiCidade(String leiCidade) {
		this.leiCidade = leiCidade;
	}

	public String getLeiestado() {
		return leiestado;
	}

	public void setLeiestado(String leiestado) {
		this.leiestado = leiestado;
	}

	public String getLeiEnderecoWeb() {
		return leiEnderecoWeb;
	}

	public void setLeiEnderecoWeb(String leiEnderecoWeb) {
		this.leiEnderecoWeb = leiEnderecoWeb;
	}

	public List<String> getEntidadesFinanceirasNomes() {
		return entidadesFinanceirasNomes;
	}

	public void setEntidadesFinanceirasNomes(List<String> entidadesFinanceirasNomes) {
		this.entidadesFinanceirasNomes = entidadesFinanceirasNomes;
	}
	
	
	
}
