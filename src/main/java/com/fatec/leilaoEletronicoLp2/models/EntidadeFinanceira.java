package com.fatec.leilaoEletronicoLp2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ENTIDADE_FINANCEIRA")
public class EntidadeFinanceira {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer entfinId;
	
	private String entfinNome;
	
	public EntidadeFinanceira() {}
	
	

	public EntidadeFinanceira(String entfinNome) {
		super();
		this.entfinNome = entfinNome;
	}



	public Integer getEntfinId() {
		return entfinId;
	}

	public void setEntfinId(Integer entfinId) {
		this.entfinId = entfinId;
	}

	public String getEntfinNome() {
		return entfinNome;
	}

	public void setEntfinNome(String entfinNome) {
		this.entfinNome = entfinNome;
	}
	
	
}
