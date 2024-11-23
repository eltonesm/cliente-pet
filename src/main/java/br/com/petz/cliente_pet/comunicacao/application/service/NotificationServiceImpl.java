package br.com.petz.cliente_pet.comunicacao.application.service;

import br.com.petz.cliente_pet.comunicacao.application.api.ZApiRequest;
import br.com.petz.cliente_pet.comunicacao.infra.comunicacao.ZApiClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class NotificationServiceImpl implements NotificationService {

    private final ZApiClient zApiClient;

    @Override
    public void sendCongratulations(String phone, String studentName) {
        String message = String.format("Parabéns, %s! Você está indo muito bem. Continue assim!", studentName);
        log.info("Enviando mensagem para o número: {} com a mensagem: {}", phone, message);
        ZApiRequest request = new ZApiRequest(phone, message);
        log.debug("Payload enviado: {}", request);
        sendMessage(request);
    }

    private void sendMessage(ZApiRequest request) {
        try {
            zApiClient.sendText(request);
            log.info("Mensagem enviada com sucesso para o número: {}", request.getPhone());
        } catch (FeignException e) {
            log.error("Erro ao enviar mensagem: {}", e.contentUTF8());
            throw e;
        }

    }

    @Override
    public void sendMotivation(String phone, String studentName) {
        String message = String.format("Olá, Wakander! Não desista, você está mais perto de alcançar seus objetivos!", studentName);
        ZApiRequest request = new ZApiRequest(phone, message);
        zApiClient.sendText(request);
    }
}
