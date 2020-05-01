package br.com.restaurantedeliveryapi.services;

import br.com.restaurantedeliveryapi.models.Culinaria;

import java.util.List;

public interface CulinariaService {

    List<Culinaria> listar();

    Culinaria buscar(Long id);

    Culinaria salvar(Culinaria culinaria);

    Culinaria atualizar(Long id, Culinaria culinaria);

    void excluir(Long id);
}
