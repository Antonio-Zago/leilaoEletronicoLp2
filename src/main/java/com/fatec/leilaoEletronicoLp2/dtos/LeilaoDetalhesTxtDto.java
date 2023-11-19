package com.fatec.leilaoEletronicoLp2.dtos;

import java.util.List;

public class LeilaoDetalhesTxtDto {
	private List<String> nomesProdutos;
	
	private List<String> nomesClientes;
	
	private List<String> nomeEntidadeFinanceira;
	
	private List<ProdutosLancesDto> historicoLances;

	public List<String> getNomesProdutos() {
		return nomesProdutos;
	}

	public void setNomesProdutos(List<String> nomesProdutos) {
		this.nomesProdutos = nomesProdutos;
	}

	public List<String> getNomesClientes() {
		return nomesClientes;
	}

	public void setNomesClientes(List<String> nomesClientes) {
		this.nomesClientes = nomesClientes;
	}

	public List<String> getNomeEntidadeFinanceira() {
		return nomeEntidadeFinanceira;
	}

	public void setNomeEntidadeFinanceira(List<String> nomeEntidadeFinanceira) {
		this.nomeEntidadeFinanceira = nomeEntidadeFinanceira;
	}

	public List<ProdutosLancesDto> getHistoricoLances() {
		return historicoLances;
	}

	public void setHistoricoLances(List<ProdutosLancesDto> historicoLances) {
		this.historicoLances = historicoLances;
	}
	
	
}
