package br.com.restaurantedeliveryapi.exceptions;

public class RecursoNaoEncontradoException extends RuntimeException {

    public RecursoNaoEncontradoException(String exception) {
        super(exception);
    }
}
