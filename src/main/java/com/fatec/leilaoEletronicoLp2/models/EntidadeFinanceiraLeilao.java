package com.fatec.leilaoEletronicoLp2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ENTIDADE_FINANCEIRA_LEILAO")
public class EntidadeFinanceiraLeilao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer entfinleiId;
	
	@ManyToOne
	@JoinColumn(name = "entidade_financeira")
	private EntidadeFinanceira entidadeFinanceira;
	
	@ManyToOne
	@JoinColumn(name = "leilao")
	private Leilao leilao;
	
}
