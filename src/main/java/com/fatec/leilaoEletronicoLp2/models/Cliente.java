package com.fatec.leilaoEletronicoLp2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Table(name = "CLIENTE")
public class Cliente {
	
	@Id
	private String cliCpf;
	private String cliNome;
	private String cliEmail;

}
