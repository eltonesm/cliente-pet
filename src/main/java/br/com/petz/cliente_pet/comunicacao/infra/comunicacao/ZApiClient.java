package br.com.petz.cliente_pet.comunicacao.infra.comunicacao;

import br.com.petz.cliente_pet.comunicacao.application.api.ZApiRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "zApiClient",
        url = "${zapi.url}/instances/${zapi.instance-id}/token/${zapi.instance-token}")
public interface ZApiClient {

    @PostMapping("/send-text")
    void sendText(@RequestBody ZApiRequest request); // Nenhum modelo de resposta
}