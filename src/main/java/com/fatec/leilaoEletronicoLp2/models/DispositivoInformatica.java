package com.fatec.leilaoEletronicoLp2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "DIPOSITIVOS_INFORMATICA")
public class DispositivoInformatica {
	
	public DispositivoInformatica() {}
	
	
	
	public DispositivoInformatica(String diEnderecoFisico, String diMarca, String diProcessador, String diTela,
			double diArmazenamento, double diMemoria, int diTensao, int diNumeroPortas, TiposDi tipoDi, Leilao leilao) {
		this.diEnderecoFisico = diEnderecoFisico;
		this.diMarca = diMarca;
		this.diProcessador = diProcessador;
		this.diTela = diTela;
		this.diArmazenamento = diArmazenamento;
		this.diMemoria = diMemoria;
		this.diTensao = diTensao;
		this.diNumeroPortas = diNumeroPortas;
		this.tipoDi = tipoDi;
		this.leilao = leilao;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int diId;
	
	
	private String diEnderecoFisico;
	private String diMarca;
	private String diProcessador; 
	private String diTela;
	private double diArmazenamento;
	private double diMemoria;
	private int diTensao;
	private int diNumeroPortas;
	
	@ManyToOne
	@JoinColumn(name =  "tipoDi")
	private TiposDi tipoDi;
	
	@ManyToOne
	@JoinColumn(name = "leilao")
	private Leilao leilao;
	
	
	
	
	
	
	public Leilao getLeilao() {
		return leilao;
	}



	public void setLeilao(Leilao leilao) {
		this.leilao = leilao;
	}



	public TiposDi getTipoDi() {
		return tipoDi;
	}
	public void setTipoDi(TiposDi tipoDi) {
		this.tipoDi = tipoDi;
	}
	public int getDiId() {
		return diId;
	}
	public void setDiId(int diId) {
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
	
	
	
}
