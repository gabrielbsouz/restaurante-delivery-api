package br.com.restaurantedeliveryapi.forms;

import br.com.restaurantedeliveryapi.dtos.Estado;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CidadePutRequest {

    @NotNull @NotEmpty
    private String nome;
    @Valid
    private Estado estado;
}
