package br.com.restaurantedeliveryapi.services;

import br.com.restaurantedeliveryapi.models.Estado;

import java.util.List;

public interface EstadoService {

    List<Estado> listar();

    Estado buscar(Long id);

    Estado salvar(Estado estado);

    Estado atualizar(Long id, Estado estado);

    void excluir(Long id);
}
