package br.com.restaurantedeliveryapi.exceptions;

public class EntidadeEmUsoException extends RuntimeException {

    public EntidadeEmUsoException(String exception) {
        super(exception);
    }
}
