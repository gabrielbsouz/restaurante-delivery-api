package br.com.restaurantedeliveryapi.services.impl;

import br.com.restaurantedeliveryapi.exceptions.EntidadeNaoEncontradaException;
import br.com.restaurantedeliveryapi.exceptions.RecursoNaoEncontradoException;
import br.com.restaurantedeliveryapi.models.Cidade;
import br.com.restaurantedeliveryapi.models.Culinaria;
import br.com.restaurantedeliveryapi.models.Estado;
import br.com.restaurantedeliveryapi.models.Restaurante;
import br.com.restaurantedeliveryapi.repositories.CidadeRepository;
import br.com.restaurantedeliveryapi.repositories.EstadoRepository;
import br.com.restaurantedeliveryapi.services.CidadeService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CidadeServiceImpl implements CidadeService {

    private final CidadeRepository repository;
    private final EstadoRepository estadoRepository;

    public CidadeServiceImpl(CidadeRepository repository, EstadoRepository estadoRepository) {
        this.repository = repository;
        this.estadoRepository = estadoRepository;
    }

    @Override
    public List<Cidade> listar() {

        return repository.findAll();
    }

    @Override
    public Cidade buscar(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cidade com id: " + id + " não foi encontrado!"));
    }

    @Override
    public Cidade salvar(Cidade cidade) {

        Long idEstado = cidade.getEstado().getId();
        Estado estado = estadoRepository.findById(idEstado)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Estado com o id: " + idEstado + " não existe!"));

        cidade.setEstado(estado);

        return repository.save(cidade);
    }

    @Override
    public Cidade atualizar(Long id, Cidade cidade) {

        Cidade cidadeAtual = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Restaurante com o id: " + id + " não foi encontrado!"));

        Long idEstado = cidade.getEstado().getId();
        Estado estado = estadoRepository.findById(idEstado)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Estado com o id: " + idEstado + " não existe!"));

        cidade.setEstado(estado);

        BeanUtils.copyProperties(cidade, cidadeAtual, "id");

        cidade.setId(cidadeAtual.getId());

        return cidadeAtual;
    }

    @Override
    public void excluir(Long id) {

        repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cidade com o id: " + id + " não foi encontrado!"));

        repository.deleteById(id);
    }
}
