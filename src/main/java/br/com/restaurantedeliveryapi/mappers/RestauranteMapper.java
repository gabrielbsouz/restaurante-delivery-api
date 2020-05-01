package br.com.restaurantedeliveryapi.mappers;

import br.com.restaurantedeliveryapi.dtos.Restaurante;
import br.com.restaurantedeliveryapi.forms.RestaurantePostRequest;
import br.com.restaurantedeliveryapi.forms.RestaurantePutRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RestauranteMapper {

    Restaurante modelToSchema(br.com.restaurantedeliveryapi.models.Restaurante model);

    List<Restaurante> modelListToListSchema(List<br.com.restaurantedeliveryapi.models.Restaurante> modelList);

    br.com.restaurantedeliveryapi.models.Restaurante schemaPostToModel(RestaurantePostRequest schemaPost);

    br.com.restaurantedeliveryapi.models.Restaurante schemaPutToModel(RestaurantePutRequest schemaPut);

}
