package br.com.restaurantedeliveryapi.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Culinaria {

    @EqualsAndHashCode.Include
    private Long id;
    private String nome;
}
