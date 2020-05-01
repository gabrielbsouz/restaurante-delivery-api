package br.com.restaurantedeliveryapi.controllers;

import br.com.restaurantedeliveryapi.dtos.Estado;
import br.com.restaurantedeliveryapi.forms.EstadoPostRequest;
import br.com.restaurantedeliveryapi.forms.EstadoPutRequest;
import br.com.restaurantedeliveryapi.mappers.EstadoMapper;
import br.com.restaurantedeliveryapi.services.EstadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/estados")
public class EstadoController {

    private final EstadoService service;
    private final EstadoMapper mapper;

    public EstadoController(EstadoService service, EstadoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<Estado> listarEstados(){

        List<br.com.restaurantedeliveryapi.models.Estado> modelList = service.listar();

        List<Estado> estados = mapper.modelListToListSchema(modelList);

        return estados;
    }

    @GetMapping("/{id}")
    public Estado buscarEstado(@PathVariable Long id){

        br.com.restaurantedeliveryapi.models.Estado model = service.buscar(id);

        Estado estado = mapper.modelToSchema(model);

        return estado;
    }

    @PostMapping
    public ResponseEntity<Estado> cadastrarEstado(@Valid @RequestBody EstadoPostRequest request){

        br.com.restaurantedeliveryapi.models.Estado model = mapper.schemaPostToModel(request);

        service.salvar(model);

        Estado estado = mapper.modelToSchema(model);

        return new ResponseEntity<>(estado, HttpStatus.CREATED);
    }

    @Transactional
    @PutMapping("/{id}")
    public Estado atualizarEstado(@PathVariable Long id, @Valid @RequestBody EstadoPutRequest request){

        br.com.restaurantedeliveryapi.models.Estado model = mapper.schemaPutToModel(request);

        service.atualizar(id, model);

        Estado estado = mapper.modelToSchema(model);

        return estado;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirEstado(@PathVariable Long id){

        service.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
