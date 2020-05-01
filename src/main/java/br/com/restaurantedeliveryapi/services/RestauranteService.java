package br.com.restaurantedeliveryapi.services;

import br.com.restaurantedeliveryapi.models.Restaurante;

import java.util.List;

public interface RestauranteService {

    List<Restaurante> listar();

    Restaurante buscar(Long id);

    Restaurante salvar(Restaurante restaurante);

    Restaurante atualizar(Long id, Restaurante restaurante);

    void excluir(Long id);
}
