package br.com.restaurantedeliveryapi.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Erro {

    private int httpCode;
    private String httpMessage;
    private String descricao;
    private List<ParametroInvalido> parametrosInvalidos;

    public Erro(){}

    public Erro(int httpCode, String httpMessage, String descricao) {
        this.httpCode = httpCode;
        this.httpMessage = httpMessage;
        this.descricao = descricao;
    }
}
