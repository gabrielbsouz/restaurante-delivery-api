package br.com.restaurantedeliveryapi.controllers;

import br.com.restaurantedeliveryapi.dtos.Culinaria;
import br.com.restaurantedeliveryapi.dtos.Restaurante;
import br.com.restaurantedeliveryapi.forms.RestaurantePostRequest;
import br.com.restaurantedeliveryapi.forms.RestaurantePutRequest;
import br.com.restaurantedeliveryapi.mappers.RestauranteMapper;
import br.com.restaurantedeliveryapi.services.RestauranteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/restaurantes")
public class RestauranteController {

    private final RestauranteService service;
    private final RestauranteMapper mapper;

    public RestauranteController(RestauranteService service, RestauranteMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<Restaurante> listarRestaurantes(){

        List<br.com.restaurantedeliveryapi.models.Restaurante> modelList = service.listar();

        List<Restaurante> restaurantes = mapper.modelListToListSchema(modelList);

        return restaurantes;
    }

    @GetMapping("/{id}")
    public Restaurante buscarRestaurante(@PathVariable Long id){

        br.com.restaurantedeliveryapi.models.Restaurante model = service.buscar(id);

        Restaurante restaurante = mapper.modelToSchema(model);

        return restaurante;
    }

    @PostMapping
    public ResponseEntity<Restaurante> cadastrarRestaurante(@Valid @RequestBody RestaurantePostRequest request){

        br.com.restaurantedeliveryapi.models.Restaurante model = mapper.schemaPostToModel(request);

        service.salvar(model);

        Restaurante restaurante = mapper.modelToSchema(model);

        return new ResponseEntity<>(restaurante, HttpStatus.CREATED);
    }

    @Transactional
    @PutMapping("/{id}")
    public Restaurante atualizarRestaurante(@PathVariable Long id, @Valid @RequestBody RestaurantePutRequest request){

        br.com.restaurantedeliveryapi.models.Restaurante model = mapper.schemaPutToModel(request);

        service.atualizar(id, model);

        Restaurante restaurante = mapper.modelToSchema(model);

        return restaurante;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirRestaurante(@PathVariable Long id){

        service.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
