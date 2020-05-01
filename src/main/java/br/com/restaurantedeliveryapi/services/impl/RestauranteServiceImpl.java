package br.com.restaurantedeliveryapi.services.impl;

import br.com.restaurantedeliveryapi.exceptions.EntidadeEmUsoException;
import br.com.restaurantedeliveryapi.exceptions.EntidadeNaoEncontradaException;
import br.com.restaurantedeliveryapi.exceptions.RecursoNaoEncontradoException;
import br.com.restaurantedeliveryapi.models.Culinaria;
import br.com.restaurantedeliveryapi.models.Restaurante;
import br.com.restaurantedeliveryapi.repositories.CulinariaRepository;
import br.com.restaurantedeliveryapi.repositories.RestauranteRepository;
import br.com.restaurantedeliveryapi.services.RestauranteService;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteServiceImpl implements RestauranteService {

    private final RestauranteRepository repository;
    private final CulinariaRepository culinariaRepository;

    public RestauranteServiceImpl(RestauranteRepository repository, CulinariaRepository culinariaRepository) {
        this.repository = repository;
        this.culinariaRepository = culinariaRepository;
    }

    @Override
    public List<Restaurante> listar() {

        return repository.findAll();
    }

    @Override
    public Restaurante buscar(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Restaurante com o id: " + id + " não foi encontrada!"));
    }

    @Override
    public Restaurante salvar(Restaurante restaurante) {

        Long idCulinaria = restaurante.getCulinaria().getId();
        Culinaria culinaria = culinariaRepository.findById(idCulinaria)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Culinária com o id: " + idCulinaria + " não existe!"));

        restaurante.setCulinaria(culinaria);

        return repository.save(restaurante);
    }

    @Override
    public Restaurante atualizar(Long id, Restaurante restaurante) {

        Restaurante restauranteAtual = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Culinária com o id: " + id + " não foi encontrada!"));

        Long idCulinaria = restaurante.getCulinaria().getId();
        Culinaria culinaria = culinariaRepository.findById(idCulinaria)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Culinária com o id: " + idCulinaria + " não existe!"));

        restaurante.setCulinaria(culinaria);

        BeanUtils.copyProperties(restaurante, restauranteAtual, "id");

        restaurante.setId(restauranteAtual.getId());
        return restauranteAtual;
    }

    @Override
    public void excluir(Long id) {

        repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Restaurante com o id: " + id + " não foi encontrado!"));

        repository.deleteById(id);
    }
}
