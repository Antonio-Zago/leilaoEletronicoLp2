package com.fatec.leilaoEletronicoLp2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CLIENTE")
public class Cliente {
	
	@Id
	private String cliCpf;
	private String cliNome;
	private String cliEmail;
	
public Cliente() {}
	
	
	public Cliente(String cliCpf, String cliNome, String cliEmail) {
		super();
		this.cliCpf = cliCpf;
		this.cliNome = cliNome;
		this.cliEmail = cliEmail;
	}
	public String getCliCpf() {
		return cliCpf;
	}
	public void setCliCpf(String cliCpf) {
		this.cliCpf = cliCpf;
	}
	public String getCliNome() {
		return cliNome;
	}
	public void setCliNome(String cliNome) {
		this.cliNome = cliNome;
	}
	public String getCliEmail() {
		return cliEmail;
	}
	public void setCliEmail(String cliEmail) {
		this.cliEmail = cliEmail;
	}

}
