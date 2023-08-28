package com.fatec.leilaoEletronicoLp2.dtos;


public class DispositivoInformaticaDto {
	
	
	
	public DispositivoInformaticaDto(Integer diId, String diEnderecoFisico, String diMarca, String diProcessador,
			String diTela, double diArmazenamento, double diMemoria, int diTensao, int diNumeroPortas, String tipoDiNome) {
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
	}

	private Integer diId;
	
	private String diEnderecoFisico;
	
	private String diMarca;
	
	private String diProcessador; 
	
	private String diTela;
	
	private double diArmazenamento;
	
	private double diMemoria;
	
	private int diTensao;
	
	private int diNumeroPortas;
	
	private String tipoDiNome;

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

	public String getTipoDiNome() {
		return tipoDiNome;
	}

	public void setTipoDiNome(String tipoDiNome) {
		this.tipoDiNome = tipoDiNome;
	}

	
	
	
	
	
}
