package br.com.restaurantedeliveryapi.mappers;

import br.com.restaurantedeliveryapi.dtos.Cidade;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CidadeMapper {

    Cidade modelToSchema(br.com.restaurantedeliveryapi.models.Cidade model);

    List<Cidade> modelListToListSchema(List<br.com.restaurantedeliveryapi.models.Cidade> modelList);
}
