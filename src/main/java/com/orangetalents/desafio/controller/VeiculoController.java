package com.orangetalents.desafio.controller;

import com.orangetalents.desafio.dto.InVeiculoDTO;
import com.orangetalents.desafio.service.VeiculoService;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @PostMapping
    public ResponseEntity<Void> create(
            @NonNull
            @RequestBody @Valid InVeiculoDTO veiculoDTO) {

        var veiculo = veiculoService.create(veiculoDTO);

        var location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/veiculos/{id}")
                .buildAndExpand(veiculo.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
