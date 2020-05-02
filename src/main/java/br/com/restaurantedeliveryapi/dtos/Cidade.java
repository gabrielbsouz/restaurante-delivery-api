package br.com.restaurantedeliveryapi.dtos;

import br.com.restaurantedeliveryapi.models.Estado;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cidade {

    @EqualsAndHashCode.Include
    private Long id;
    private String nome;
    private Estado estado;
}
