package br.com.restaurantedeliveryapi.exceptions;

public class EntidadeNaoEncontradaException extends RuntimeException{

    public EntidadeNaoEncontradaException(String exception) {
        super(exception);
    }
}
