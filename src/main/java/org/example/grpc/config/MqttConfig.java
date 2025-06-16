package org.example.grpc.config;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.example.grpc.mqtt.MqttPublisherService;
import org.example.grpc.mqtt.MqttSubscriberService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttConfig {
    @Value("${mqtt.broker.url}")
    private String brokerUrl;

    @Value("${mqtt.client.id}")
    private String clientId;

    @Bean
    public MqttClient mqttClient() throws MqttException {
        // Create an MQTT client instance
        MqttClient client = new MqttClient(brokerUrl, clientId);
        // Connect to the MQTT broker
        client.connect();
        System.out.println("Connected to MQTT broker: " + brokerUrl); // Log connection
        return client;
    }

//    @Bean
//    public MqttPublisherService mqttPublisherService(MqttClient mqttClient) {
//        return new MqttPublisherService(mqttClient);
//    }

//    @Bean
//    public MqttSubscriberService mqttSubscriberService(MqttClient mqttClient) throws MqttException {
//        MqttSubscriberService subscriber = new MqttSubscriberService(mqttClient);
//        // Subscribe to a default topic when the subscriber service is created
//        subscriber.subscribeToTopic("/topic/messages");
//        return subscriber;
//    }
}
