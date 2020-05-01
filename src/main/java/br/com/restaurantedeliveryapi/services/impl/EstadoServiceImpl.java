package br.com.restaurantedeliveryapi.services.impl;

import br.com.restaurantedeliveryapi.models.Estado;
import br.com.restaurantedeliveryapi.repositories.EstadoRepository;
import br.com.restaurantedeliveryapi.services.EstadoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoServiceImpl implements EstadoService {

    private final EstadoRepository repository;

    public EstadoServiceImpl(EstadoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Estado> listar() {

        return repository.findAll();
    }

    @Override
    public Estado buscar(Long id) {
        return null;
    }

    @Override
    public Estado salvar(Estado estado) {
        return null;
    }

    @Override
    public Estado atualizar(Long id, Estado estado) {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }
}
