package br.com.petz.cliente_pet.comunicacao.application.service;

import br.com.petz.cliente_pet.comunicacao.application.api.ZApiRequest;
import br.com.petz.cliente_pet.comunicacao.infra.comunicacao.ZApiClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    private final ZApiClient zApiClient;

    @Override
    public void sendCongratulations(String phone) {
        String message = " Parabéns! Você está conquistando grandes coisas! Continue assim! ";
        sendMessage(phone, message);
    }

    @Override
    public void sendMotivation(String phone) {
        String message = "Não desista! Cada passo te leva mais perto do sucesso. Você consegue!";
        sendMessage(phone, message);
    }

    private void sendMessage(String phone, String message) {
        // Sanitiza o número de telefone
        String sanitizedPhone = sanitizePhoneNumber(phone);

        // Cria o objeto de requisição
        ZApiRequest request = new ZApiRequest(sanitizedPhone, message);

        try {
            log.info("Enviando requisição para Z-API: {}", request);
            zApiClient.sendText(request); // Chama o método Feign
            log.info("Mensagem enviada com sucesso para o telefone: {}", sanitizedPhone);
        } catch (Exception e) {
            log.error("Erro ao enviar mensagem para o telefone {}: {}", sanitizedPhone, e.getMessage());
            throw new RuntimeException("Falha ao enviar mensagem", e);
        }
    }

    private String sanitizePhoneNumber(String phone) {
        // Remove espaços, caracteres especiais e valida o formato
        return phone.replaceAll("[^\\d]", "");
    }
}

