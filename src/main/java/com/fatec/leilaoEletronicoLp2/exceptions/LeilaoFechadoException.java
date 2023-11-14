package com.fatec.leilaoEletronicoLp2.exceptions;

public class LeilaoFechadoException extends RuntimeException{
	
	private static final long serialVersionUID = 5696746720435250792L;
	
	public LeilaoFechadoException(String msg){
        super(msg);
    }
}
