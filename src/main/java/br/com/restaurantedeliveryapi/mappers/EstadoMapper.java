package br.com.restaurantedeliveryapi.mappers;

import br.com.restaurantedeliveryapi.dtos.Estado;
import br.com.restaurantedeliveryapi.forms.EstadoPostRequest;
import br.com.restaurantedeliveryapi.forms.EstadoPutRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstadoMapper {

    Estado modelToSchema(br.com.restaurantedeliveryapi.models.Estado model);

    List<Estado> modelListToListSchema(List<br.com.restaurantedeliveryapi.models.Estado> modelList);

    br.com.restaurantedeliveryapi.models.Estado schemaPostToModel(EstadoPostRequest schemaPost);

    br.com.restaurantedeliveryapi.models.Estado schemaPutToModel(EstadoPutRequest schemaPost);
}
