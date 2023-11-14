package com.fatec.leilaoEletronicoLp2.dtos;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class LeilaoForm {
	
	private LocalDateTime leiDataOcorrencia;
	
	private LocalDateTime leiDataVisitacao;
	
	private String leiEndereco;
	
	private String leiCidade;
	
	private String leiestado;
	
	private String leiEnderecoWeb;
	
	private List<Integer> idEntidadesFinanceiras;
	
	private LocalDateTime leiHoraFim;
	
	

	
	
	
    


	public LocalDateTime getLeiHoraFim() {
		return leiHoraFim;
	}

	public void setLeiHoraFim(LocalDateTime leiHoraFim) {
		this.leiHoraFim = leiHoraFim;
	}

	public List<Integer> getIdEntidadesFinanceiras() {
		return idEntidadesFinanceiras;
	}

	public void setIdEntidadesFinanceiras(List<Integer> idEntidadesFinanceiras) {
		this.idEntidadesFinanceiras = idEntidadesFinanceiras;
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
	
	
}
