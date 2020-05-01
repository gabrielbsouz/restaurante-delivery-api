package br.com.restaurantedeliveryapi.services.impl;

import br.com.restaurantedeliveryapi.exceptions.EntidadeEmUsoException;
import br.com.restaurantedeliveryapi.exceptions.RecursoNaoEncontradoException;
import br.com.restaurantedeliveryapi.models.Culinaria;
import br.com.restaurantedeliveryapi.repositories.CulinariaRepository;
import br.com.restaurantedeliveryapi.services.CulinariaService;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CulinariaServiceImpl implements CulinariaService {

    private final CulinariaRepository repository;

    public CulinariaServiceImpl(CulinariaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Culinaria> listar() {

        return repository.findAll();
    }

    @Override
    public Culinaria buscar(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cozinha com o id: " + id + " não foi encontrada!"));
    }

    @Override
    public Culinaria salvar(Culinaria culinaria) {

        return repository.save(culinaria);
    }

    @Override
    public Culinaria atualizar(Long id, Culinaria culinaria) {

        Culinaria culinariaAtual = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Culinária com o id: " + id + " não foi encontrada!"));

        BeanUtils.copyProperties(culinaria, culinariaAtual, "id");

        culinariaAtual = repository.save(culinaria);

        return culinariaAtual;
    }

    @Override
    public void excluir(Long id) {

        try {
            repository.findById(id)
                    .orElseThrow(() -> new RecursoNaoEncontradoException("Culinária com o id: " + id + " não foi encontrada!"));

            repository.deleteById(id);

        } catch (DataIntegrityViolationException e){

            throw new EntidadeEmUsoException("Culinária com o id: " + id + " não pode ser removida, pois está em uso!");
        }
    }
}
