package br.com.petz.cliente_pet.comunicacao.application.api;

import br.com.petz.cliente_pet.comunicacao.application.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/congratulations")
    public ResponseEntity<String> sendCongratulations(
            @RequestParam String phone,
            @RequestParam String studentName) {
        notificationService.sendCongratulations(phone, studentName);
        return ResponseEntity.ok("Mensagem de parabéns enviada com sucesso!");
    }

    @PostMapping("/motivation")
    public ResponseEntity<String> sendMotivation(
            @RequestParam String phone,
            @RequestParam String studentName) {
        notificationService.sendMotivation(phone, studentName);
        return ResponseEntity.ok("Mensagem de motivação enviada com sucesso!");
    }
}
