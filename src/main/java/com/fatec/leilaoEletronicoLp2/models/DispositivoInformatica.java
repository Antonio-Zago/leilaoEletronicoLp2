package com.fatec.leilaoEletronicoLp2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "DIPOSITIVOS_INFORMATICA")
public class DispositivoInformatica {
	private int diId;
	private String diEnderecoFisico;
	private String diMarca;
	private String diProcessador;
}
