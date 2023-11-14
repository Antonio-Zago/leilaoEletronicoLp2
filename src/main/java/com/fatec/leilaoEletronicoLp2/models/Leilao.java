package com.fatec.leilaoEletronicoLp2.models;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "LEILAO")
public class Leilao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer leiId;
	
	private LocalDateTime leiDataOcorrencia;
	
	private LocalDateTime leiDataVisitacao;
	
	private String leiEndereco;
	
	private String leiCidade;
	
	private String leiEstado;
	
	private String leiEnderecoWeb;


	
	private LocalDateTime leiDataHorafim;
	
	@ManyToMany
    @JoinTable(
    		name="leilao_entidade_financeira",
    		joinColumns= @JoinColumn(name = "leiId"), 
    		inverseJoinColumns=@JoinColumn(name="entfinId"))
	private List<EntidadeFinanceira> entidadesFinanceiras;
	
	public Leilao() {}
	
	
	public Leilao(LocalDateTime leiDataOcorrencia, LocalDateTime leiDataVisitacao, String leiEndereco, String leiCidade, String leiEstado,
			String leiEnderecoWeb, List<EntidadeFinanceira> entidadeFinanceiras, LocalDateTime horaFim) {
		super();
		this.leiDataOcorrencia = leiDataOcorrencia;
		this.leiDataVisitacao = leiDataVisitacao;
		this.leiEndereco = leiEndereco;
		this.leiCidade = leiCidade;
		this.leiEstado = leiEstado;
		this.leiEnderecoWeb = leiEnderecoWeb;
		this.entidadesFinanceiras = entidadeFinanceiras;
		this.leiDataHorafim = horaFim;
	}
	
	
	



	public LocalDateTime getLeiDataHorafim() {
		return leiDataHorafim;
	}


	public void setLeiDataHorafim(LocalDateTime leiDataHorafim) {
		this.leiDataHorafim = leiDataHorafim;
	}


	public List<EntidadeFinanceira> getEntidadesFinanceiras() {
		return entidadesFinanceiras;
	}


	public void setEntidadesFinanceiras(List<EntidadeFinanceira> entidadesFinanceiras) {
		this.entidadesFinanceiras = entidadesFinanceiras;
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


	private LocalTime horarioInicio;
	private LocalTime horarioFim;

	public Leilao(LocalTime horarioInicio, LocalTime horarioFim) {
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
	}

	public String getStatus() {
		LocalTime horarioAtual = LocalTime.now();

		if (horarioAtual.isBefore(horarioInicio)) {
			return "EM ABERTO";
		} else if (horarioAtual.isAfter(horarioInicio) && horarioAtual.isBefore(horarioFim)) {
			return "EM ANDAMENTO";
		} else {
			return "FINALIZADO";
		}
	}
}
