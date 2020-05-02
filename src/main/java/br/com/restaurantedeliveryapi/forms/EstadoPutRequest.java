package br.com.restaurantedeliveryapi.forms;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class EstadoPutRequest {

    @NotNull @NotEmpty
    private String nome;
}
