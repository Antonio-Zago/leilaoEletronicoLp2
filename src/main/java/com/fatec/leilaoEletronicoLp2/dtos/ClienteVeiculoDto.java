package com.fatec.leilaoEletronicoLp2.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ClienteVeiculoDto {
	
	private Integer id;
	
	private Integer veiculo;
	
	private String nomeCliente;
	
	private String cpfCliente;
	
	private Double valorLance;

}
