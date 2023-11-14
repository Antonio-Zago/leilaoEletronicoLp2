package com.fatec.leilaoEletronicoLp2.exceptions;

public class GenericException extends RuntimeException{
	private static final long serialVersionUID = 5696746720435250792L;
	
	public GenericException(String msg){
        super(msg);
    }
}
