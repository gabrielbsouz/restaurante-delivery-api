package br.com.restaurantedeliveryapi.controllers;

import br.com.restaurantedeliveryapi.dtos.Cidade;
import br.com.restaurantedeliveryapi.dtos.Culinaria;
import br.com.restaurantedeliveryapi.forms.CidadePostRequest;
import br.com.restaurantedeliveryapi.mappers.CidadeMapper;
import br.com.restaurantedeliveryapi.services.CidadeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/{id}")
    public Cidade buscarCidade(@PathVariable Long id){

        br.com.restaurantedeliveryapi.models.Cidade model = service.buscar(id);

        Cidade cidade = mapper.modelToSchema(model);

        return cidade;
    }

    @PostMapping
    public ResponseEntity<Cidade> cadastrarCidade(@Valid @RequestBody CidadePostRequest request){

        br.com.restaurantedeliveryapi.models.Cidade model = mapper.schemaPostToModel(request);

        service.salvar(model);

        Cidade cidade = mapper.modelToSchema(model);

        return new ResponseEntity<>(cidade, HttpStatus.CREATED);
    }
}
