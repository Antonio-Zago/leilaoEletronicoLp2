package com.fatec.leilaoEletronicoLp2.dtos;



import com.fatec.leilaoEletronicoLp2.models.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;



public class LeilaoDetalhesDto {

    private Integer leiId;
    private LocalDateTime leiDataOcorrencia;
    private LocalDateTime leiDataVisitacao;
    private String leiEndereco;
    private String leiCidade;
    private String leiestado;
    private String leiEnderecoWeb;
    private List<String> entidadesFinanceirasNomes;
    private List<String> nomeProdutos;
    private LocalDateTime leiDataHoraFim;
    private Integer leiTotalProdutos;
    
    
    
    



	public Integer getLeiTotalProdutos() {
		return leiTotalProdutos;
	}


	public void setLeiTotalProdutos(Integer leiTotalProdutos) {
		this.leiTotalProdutos = leiTotalProdutos;
	}


	public LocalDateTime getLeiDataHoraFim() {
		return leiDataHoraFim;
	}


	public void setLeiDataHoraFim(LocalDateTime leiDataHoraFim) {
		this.leiDataHoraFim = leiDataHoraFim;
	}


	public List<String> getNomeProdutos() {
		return nomeProdutos;
	}


	public void setNomeProdutos(List<String> nomeProdutos) {
		this.nomeProdutos = nomeProdutos;
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
