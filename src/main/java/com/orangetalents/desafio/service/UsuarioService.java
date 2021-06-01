package com.orangetalents.desafio.service;

import com.orangetalents.desafio.dto.InUsuarioDTO;
import com.orangetalents.desafio.dto.OutUsuarioDTO;
import com.orangetalents.desafio.model.Usuario;

public interface UsuarioService {

    OutUsuarioDTO findById(String cpf);

    Usuario create(InUsuarioDTO usuarioDTO);
}
