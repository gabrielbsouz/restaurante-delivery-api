package br.com.restaurantedeliveryapi.controllers;

import br.com.restaurantedeliveryapi.dtos.Culinaria;
import br.com.restaurantedeliveryapi.forms.CulinariaPostRequest;
import br.com.restaurantedeliveryapi.forms.CulinariaPutRequest;
import br.com.restaurantedeliveryapi.mappers.CulinariaMapper;
import br.com.restaurantedeliveryapi.services.CulinariaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/culinarias")
public class CulinariaController {

    private final CulinariaService service;
    private final CulinariaMapper mapper;

    public CulinariaController(CulinariaService service, CulinariaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<Culinaria> listarCulinarias(){

        List<br.com.restaurantedeliveryapi.models.Culinaria> modelList = service.listar();

        List<Culinaria> culinarias = mapper.modelListToListSchema(modelList);

        return culinarias;
    }

    @GetMapping("/{id}")
    public Culinaria buscarCulinaria(@PathVariable Long id){

        br.com.restaurantedeliveryapi.models.Culinaria model = service.buscar(id);

        Culinaria culinaria = mapper.modelToSchema(model);

        return culinaria;
    }

    @PostMapping
    public ResponseEntity<Culinaria> cadastrarCulinaria(@Valid @RequestBody CulinariaPostRequest request){

        br.com.restaurantedeliveryapi.models.Culinaria model = mapper.schemaPostToModel(request);

        service.salvar(model);

        Culinaria culinaria = mapper.modelToSchema(model);

        return new ResponseEntity<>(culinaria, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Culinaria atualizarCulinaria(@PathVariable Long id, @Valid @RequestBody CulinariaPutRequest request){

        br.com.restaurantedeliveryapi.models.Culinaria model = mapper.schemaPutToModel(request);

        service.atualizar(id, model);

        Culinaria culinaria = mapper.modelToSchema(model);

        return culinaria;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirCulinaria(@PathVariable Long id){

        service.excluir(id);

        return ResponseEntity.noContent().build();
    }

}
