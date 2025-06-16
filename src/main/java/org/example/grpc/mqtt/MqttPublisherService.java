package org.example.grpc.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MqttPublisherService {
//    private static final Logger logger = LoggerFactory.getLogger(MqttPublisherService.class);
    private final MqttClient mqttClient;

    public MqttPublisherService(MqttClient mqttClient) {
        this.mqttClient = mqttClient;
    }

    public void publish(String topic, String messageContent, int qos, boolean retained) throws MqttException {
        if (!mqttClient.isConnected()) {
            System.out.println("MQTT client is not connected. Attempting to reconnect before publishing.");
            try {
                mqttClient.connect();
                System.out.println("Successfully reconnected to MQTT broker.");
            } catch (MqttException e) {
                System.out.println("Failed to reconnect to MQTT broker: {}"+ e.getMessage());
                throw new MqttException(e); // Re-throw to indicate failure
            }
        }

        MqttMessage message = new MqttMessage(messageContent.getBytes());
        message.setQos(qos);
        message.setRetained(retained);
        mqttClient.publish(topic, message);
        System.out.println("Message published to topic '{}': {}"+ topic+ messageContent);
    }
}
