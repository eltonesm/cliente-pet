package br.com.petz.cliente_pet.config;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FeignErrorDecoder implements ErrorDecoder {
    private static final Logger LOGGER = LoggerFactory.getLogger(FeignErrorDecoder.class);

    @Override
    public Exception decode(String methodKey, Response response) {
        String errorDetails = String.format(
                "Erro ao chamar o método '%s'. Código HTTP: %d, Motivo: %s",
                methodKey, response.status(), response.reason()
        );

        if (response.status() == HttpStatus.NOT_FOUND.value()) {
            LOGGER.warn("Recurso não encontrado: {}", errorDetails);
            return new ResponseStatusException(HttpStatus.NOT_FOUND, response.reason());
        } else if (response.status() == HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()) {
            LOGGER.error("Erro de tipo de mídia não suportado: {}", errorDetails);
            return new ResponseStatusException(HttpStatus.UNSUPPORTED_MEDIA_TYPE, response.reason());
        } else {
            LOGGER.error("Erro inesperado: {}", errorDetails);
            return new RuntimeException(errorDetails);
        }
    }
}
