package com.example.message.infrastructure.mqtt;

import io.smallrye.reactive.messaging.MutinyEmitter;

import org.eclipse.microprofile.reactive.messaging.Channel;

import com.example.message.domain.model.Message;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MqttClient {
    
    @Inject
    @Channel("mqtt-out")
    MutinyEmitter<String> mqttEmitter;

    public void sendMessage(Message message) {
        try {
            mqttEmitter.send(serializeMessageToJson(message))
                .subscribe().with(
                    success -> System.out.println("The message was sended."),
                    failure -> System.out.println("Error: " + failure.getMessage())
                );
        } catch (Exception exception) {
            System.out.println("Serialization error: " + exception.getMessage());
        }
    }

    public String serializeMessageToJson(Message message) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(message);
    }
}
