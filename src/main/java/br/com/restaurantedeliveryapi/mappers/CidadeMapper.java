package br.com.restaurantedeliveryapi.mappers;

import br.com.restaurantedeliveryapi.dtos.Cidade;
import br.com.restaurantedeliveryapi.forms.CidadePostRequest;
import br.com.restaurantedeliveryapi.forms.CidadePutRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CidadeMapper {

    Cidade modelToSchema(br.com.restaurantedeliveryapi.models.Cidade model);

    List<Cidade> modelListToListSchema(List<br.com.restaurantedeliveryapi.models.Cidade> modelList);

    br.com.restaurantedeliveryapi.models.Cidade schemaPostToModel(CidadePostRequest schemaPost);

    br.com.restaurantedeliveryapi.models.Cidade schemaPutToModel(CidadePutRequest schemaPost);
}
