package com.fatec.leilaoEletronicoLp2.dtos;

public class DispositivoInformaticaForm {

	private String diEnderecoFisico;
	
	private String diMarca;
	
	private String diProcessador; 
	
	private String diTela;
	
	private double diArmazenamento;
	
	private double diMemoria;
	
	private int diTensao;
	
	private int diNumeroPortas;
	
	private int tipoDi;
	
	private Integer leilao;
	
	

	public Integer getLeilao() {
		return leilao;
	}

	public void setLeilao(Integer leilao) {
		this.leilao = leilao;
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

	public double getDiArmazenamento() {
		return diArmazenamento;
	}

	public void setDiArmazenamento(double diArmazenamento) {
		this.diArmazenamento = diArmazenamento;
	}

	public double getDiMemoria() {
		return diMemoria;
	}

	public void setDiMemoria(double diMemoria) {
		this.diMemoria = diMemoria;
	}

	public int getDiTensao() {
		return diTensao;
	}

	public void setDiTensao(int diTensao) {
		this.diTensao = diTensao;
	}

	public int getDiNumeroPortas() {
		return diNumeroPortas;
	}

	public void setDiNumeroPortas(int diNumeroPortas) {
		this.diNumeroPortas = diNumeroPortas;
	}

	public int getTipoDi() {
		return tipoDi;
	}

	public void setTipoDi(int tipoDi) {
		this.tipoDi = tipoDi;
	}
	
	
	
}
