package com.fatec.leilaoEletronicoLp2.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "LEILAO")
public class Leilao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer leiId;
	
	private Date leiDataOcorrencia;
	
	private Date leiDataVisitacao;
	
	private String leiEndereco;
	
	private String leiCidade;
	
	private String leiEstado;
	
	private String leiEnderecoWeb;
	
	public Leilao() {}
	
	
	public Leilao(Date leiDataOcorrencia, Date leiDataVisitacao, String leiEndereco, String leiCidade, String leiEstado,
			String leiEnderecoWeb) {
		super();
		this.leiDataOcorrencia = leiDataOcorrencia;
		this.leiDataVisitacao = leiDataVisitacao;
		this.leiEndereco = leiEndereco;
		this.leiCidade = leiCidade;
		this.leiEstado = leiEstado;
		this.leiEnderecoWeb = leiEnderecoWeb;
	}

	public Integer getLeiId() {
		return leiId;
	}

	public void setLeiId(Integer leiId) {
		this.leiId = leiId;
	}

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

	public String getLeiEstado() {
		return leiEstado;
	}

	public void setLeiEstado(String leiEstado) {
		this.leiEstado = leiEstado;
	}

	public String getLeiEnderecoWeb() {
		return leiEnderecoWeb;
	}

	public void setLeiEnderecoWeb(String leiEnderecoWeb) {
		this.leiEnderecoWeb = leiEnderecoWeb;
	}
	
	

}
