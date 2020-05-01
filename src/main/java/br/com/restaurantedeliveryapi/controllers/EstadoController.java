package br.com.restaurantedeliveryapi.controllers;

import br.com.restaurantedeliveryapi.dtos.Estado;
import br.com.restaurantedeliveryapi.mappers.EstadoMapper;
import br.com.restaurantedeliveryapi.services.EstadoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
