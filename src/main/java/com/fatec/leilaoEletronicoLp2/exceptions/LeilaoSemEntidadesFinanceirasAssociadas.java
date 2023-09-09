package com.fatec.leilaoEletronicoLp2.exceptions;

public class LeilaoSemEntidadesFinanceirasAssociadas extends RuntimeException {
	
	private static final long serialVersionUID = 5696746720435250792L;
	
	public LeilaoSemEntidadesFinanceirasAssociadas(String msg){
        super(msg);
    }
}
