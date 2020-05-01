package br.com.restaurantedeliveryapi.mappers;

import br.com.restaurantedeliveryapi.dtos.Culinaria;
import br.com.restaurantedeliveryapi.forms.CulinariaPostRequest;
import br.com.restaurantedeliveryapi.forms.CulinariaPutRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CulinariaMapper {

    Culinaria modelToSchema(br.com.restaurantedeliveryapi.models.Culinaria model);

    List<Culinaria> modelListToListSchema(List<br.com.restaurantedeliveryapi.models.Culinaria> modelList);

    br.com.restaurantedeliveryapi.models.Culinaria schemaPostToModel(CulinariaPostRequest schemaPost);

    br.com.restaurantedeliveryapi.models.Culinaria schemaPutToModel(CulinariaPutRequest schemaPut);
}
