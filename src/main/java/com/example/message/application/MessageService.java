package com.example.message.application;

import com.example.message.domain.model.Message;
import com.example.message.infrastructure.mqtt.MqttClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MessageService {
    @Inject
    private MqttClient mqttClient;

    public void send(Message message){
        mqttClient.sendMessage(message);;
    }

}
