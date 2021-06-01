package com.orangetalents.desafio.service.client;

import com.orangetalents.desafio.configuration.FeignConfiguration;
import com.orangetalents.desafio.dto.AnoModeloDTO;
import com.orangetalents.desafio.dto.FipeDTO;
import com.orangetalents.desafio.dto.MarcasDTO;
import com.orangetalents.desafio.dto.ModelosDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "FipeClient", url = "https://parallelum.com.br/fipe/api/v1", configuration = FeignConfiguration.class)
public interface FipeClient {

    @GetMapping(value = "/carros/marcas")
    List<MarcasDTO> findMarcas();

    @GetMapping(value = "/carros/marcas/{idMarca}/modelos")
    ModelosDTO findModelos(@PathVariable("idMarca") String idMarca);

    @GetMapping(value = "/carros/marcas/{idMarca}/modelos/{idModelo}/anos")
    List<AnoModeloDTO> findAnosModelo(@PathVariable("idMarca") String idMarca,
                                      @PathVariable("idModelo") int idModelo);

    @GetMapping(value = "/carros/marcas/{idMarca}/modelos/{idModelo}/anos/{anoModelo}")
    FipeDTO findFipe(@PathVariable("idMarca") String idMarca,
                     @PathVariable("idModelo") int idModelo,
                     @PathVariable("anoModelo") String anoModelo);
}
