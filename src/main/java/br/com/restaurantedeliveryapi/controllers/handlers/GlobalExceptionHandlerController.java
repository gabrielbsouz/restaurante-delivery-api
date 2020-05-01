package br.com.restaurantedeliveryapi.controllers.handlers;

import br.com.restaurantedeliveryapi.dtos.Erro;
import br.com.restaurantedeliveryapi.dtos.ParametroInvalido;
import br.com.restaurantedeliveryapi.exceptions.EntidadeEmUsoException;
import br.com.restaurantedeliveryapi.exceptions.RecursoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandlerController extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        List<ParametroInvalido> invalidParameters = new ArrayList<>();

        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String parametro = ((FieldError) error).getField();
            String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            invalidParameters.add(new ParametroInvalido(parametro, mensagem));
        }

        Erro erro = new Erro();
        erro.setHttpCode(status.value());
        erro.setHttpMessage("Bad Request");
        erro.setDescricao("Os parâmetros informados são inválidos!");
        erro.setParametrosInvalidos(invalidParameters);

        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public final ResponseEntity<Erro> handleRecursoNaoEncontradoException(RecursoNaoEncontradoException ex) {

        Erro erro = new Erro(404, "Not Found", ex.getMessage());

        return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntidadeEmUsoException.class)
    public final ResponseEntity<Erro> handleEntidadeEmUsoException(EntidadeEmUsoException ex) {

        Erro erro = new Erro(409, "Conflict", ex.getMessage());

        return new ResponseEntity<>(erro, HttpStatus.CONFLICT);
    }
}
