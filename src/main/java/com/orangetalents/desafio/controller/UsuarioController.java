package com.orangetalents.desafio.controller;

import com.orangetalents.desafio.dto.InUsuarioDTO;
import com.orangetalents.desafio.dto.OutUsuarioDTO;
import com.orangetalents.desafio.service.UsuarioService;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("{cpf}")
    public ResponseEntity<OutUsuarioDTO> findById(
            @NotBlank
            @PathVariable() String cpf) {

        return ResponseEntity.ok(usuarioService.findById(cpf));
    }

    @PostMapping
    public ResponseEntity<Void> create(
            @NonNull
            @RequestBody @Valid InUsuarioDTO usuarioDTO) {

        var usuario = usuarioService.create(usuarioDTO);

        var location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/usuarios/{cpf}")
                .buildAndExpand(usuario.getCpf())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
