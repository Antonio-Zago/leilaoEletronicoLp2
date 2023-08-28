package com.fatec.leilaoEletronicoLp2.dtos;

import java.util.Date;

public class LeilaoForm {
	
	private Date leiDataOcorrencia;
	
	private Date leiDataVisitacao;
	
	private String leiEndereco;
	
	private String leiCidade;
	
	private String leiestado;
	
	private String leiEnderecoWeb;

	public Date getLeiDataOcorrencia() {
		return leiDataOcorrencia;
	}

	public void setLeiDataOcorrencia(Date leiDataOcorrencia) {
		this.leiDataOcorrencia = leiDataOcorrencia;
	}

	public Date getLeiDataVisitacao() {
		return leiDataVisitacao;
	}

	public void setLeiDataVisitacao(Date leiDataVisitacao) {
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
	
	
}
