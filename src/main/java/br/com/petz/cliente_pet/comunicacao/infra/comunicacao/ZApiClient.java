package br.com.petz.cliente_pet.comunicacao.infra.comunicacao;

import br.com.petz.cliente_pet.comunicacao.application.api.ZApiRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(
        name = "zApiClient",
        url = "https://api.z-api.io/instances/3D8B37B6E9D570D09CC482FC59B53879/token/5A894E1545EB74A7FC0DAB27/send-text"
)
public interface ZApiClient {
    @PostMapping("/send-text")
    void sendText(@RequestBody ZApiRequest request);
}
