package br.com.restaurantedeliveryapi.mappers;

import br.com.restaurantedeliveryapi.dtos.Estado;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstadoMapper {

    Estado modelToSchema(br.com.restaurantedeliveryapi.models.Estado model);

    List<Estado> modelListToListSchema(List<br.com.restaurantedeliveryapi.models.Estado> modelList);
}
