package br.com.restaurantedeliveryapi.services.impl;

import br.com.restaurantedeliveryapi.exceptions.EntidadeEmUsoException;
import br.com.restaurantedeliveryapi.exceptions.RecursoNaoEncontradoException;
import br.com.restaurantedeliveryapi.models.Culinaria;
import br.com.restaurantedeliveryapi.models.Estado;
import br.com.restaurantedeliveryapi.repositories.EstadoRepository;
import br.com.restaurantedeliveryapi.services.EstadoService;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
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

        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Estado com id: " + id + " não foi encontrado!"));
    }

    @Override
    public Estado salvar(Estado estado) {

        return repository.save(estado);
    }

    @Override
    public Estado atualizar(Long id, Estado estado) {

        Estado estadoAtual = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Estado com o id: " + id + " não foi encontrado!"));

        BeanUtils.copyProperties(estado, estadoAtual, "id");
        estado.setId(estadoAtual.getId());

        return estadoAtual;
    }

    @Override
    public void excluir(Long id) {

        try {
            repository.findById(id)
                    .orElseThrow(() -> new RecursoNaoEncontradoException("Estado com o id: " + id + " não foi encontrada!"));

            repository.deleteById(id);

        } catch (DataIntegrityViolationException e){

            throw new EntidadeEmUsoException("Estado com o id: " + id + " não pode ser removida, pois está em uso!");
        }
    }
}
