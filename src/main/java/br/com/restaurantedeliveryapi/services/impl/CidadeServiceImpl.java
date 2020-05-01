package br.com.restaurantedeliveryapi.services.impl;

import br.com.restaurantedeliveryapi.models.Cidade;
import br.com.restaurantedeliveryapi.repositories.CidadeRepository;
import br.com.restaurantedeliveryapi.services.CidadeService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CidadeServiceImpl implements CidadeService {

    private final CidadeRepository repository;

    public CidadeServiceImpl(CidadeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Cidade> listar() {

        return repository.findAll();
    }

    @Override
    public Cidade buscar(Long id) {
        return null;
    }

    @Override
    public Cidade salvar(Cidade cidade) {
        return null;
    }

    @Override
    public Cidade atualizar(Long id, Cidade cidade) {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }
}
