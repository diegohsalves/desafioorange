package com.orangetalents.desafio.decoder;

import com.orangetalents.desafio.exception.RequestException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

@Slf4j
public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        log.error("Erro ao realizar a requisição!");
        log.error("Status {}, razão {}!", response.status(), response.reason());
        try {
            log.error("Body: {}!", IOUtils.toString(response.body().asInputStream()));
        } catch (Exception e) {
            log.error("Erro ao converter o body!", e);
        }
        return new RequestException("Erro ao realizar a requisição!");
    }
}
