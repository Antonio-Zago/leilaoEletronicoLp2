package com.fatec.leilaoEletronicoLp2.exceptions;

public class ClienteJaCadastradoException extends RuntimeException {
	
	private static final long serialVersionUID = 5696746720435250792L;
	
	public ClienteJaCadastradoException(String msg){
        super(msg);
    }
}
