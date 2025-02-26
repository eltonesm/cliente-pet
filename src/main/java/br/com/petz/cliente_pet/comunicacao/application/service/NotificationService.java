package br.com.petz.cliente_pet.comunicacao.application.service;

public interface NotificationService {
    void sendCongratulations(String phone);

    void sendMotivation(String phone);
}