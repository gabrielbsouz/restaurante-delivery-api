package br.com.restaurantedeliveryapi.controllers;

import br.com.restaurantedeliveryapi.dtos.Cidade;
import br.com.restaurantedeliveryapi.mappers.CidadeMapper;
import br.com.restaurantedeliveryapi.services.CidadeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/cidades")
public class CidadeController {

    private final CidadeService service;
    private final CidadeMapper mapper;

    public CidadeController(CidadeService service, CidadeMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<Cidade> listarCidades(){

        List<br.com.restaurantedeliveryapi.models.Cidade> modelList = service.listar();

        List<Cidade> cidades = mapper.modelListToListSchema(modelList);

        return cidades;
    }
}
