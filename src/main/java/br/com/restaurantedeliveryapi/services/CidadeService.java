package br.com.restaurantedeliveryapi.services;

import br.com.restaurantedeliveryapi.models.Cidade;

import java.util.List;

public interface CidadeService {

    List<Cidade> listar();

    Cidade buscar(Long id);

    Cidade salvar(Cidade cidade);

    Cidade atualizar(Long id, Cidade cidade);

    void excluir(Long id);
}
