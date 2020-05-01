package br.com.restaurantedeliveryapi.forms;

import br.com.restaurantedeliveryapi.dtos.Culinaria;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class RestaurantePutRequest {

    @NotNull @NotEmpty
    private String nome;
    @NotNull
    private BigDecimal taxaFrete;
    @Valid
    private Culinaria culinaria;
}
