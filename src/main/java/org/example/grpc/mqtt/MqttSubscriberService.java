package org.example.grpc.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Service;

@Service
public class MqttSubscriberService {
    //    private static final Logger logger = LoggerFactory.getLogger(MqttSubscriberService.class);
    private final MqttClient mqttClient;

    /**
     * Constructor for MqttSubscriberService.
     *
     * @param mqttClient The MqttClient instance to use for subscribing.
     */
    public MqttSubscriberService(MqttClient mqttClient) {
        this.mqttClient = mqttClient;
    }

    /**
     * Subscribes to a given MQTT topic.
     *
     * @param topic The MQTT topic to subscribe to.
     * @throws MqttException If there is an error subscribing.
     */
    public void subscribeToTopic(String topic) throws MqttException {
        if (!mqttClient.isConnected()) {
            System.out.println("MQTT client is not connected for subscription. Attempting to reconnect.");
            try {
                mqttClient.connect();
                System.out.println("Successfully reconnected to MQTT broker for subscription.");
            } catch (MqttException e) {
                System.out.println("Failed to reconnect to MQTT broker for subscription: {}" + e.getMessage());
                throw new MqttException(e); // Re-throw to indicate failure
            }
        }

        // Subscribe with a Quality of Service (QoS) of 1 (at least once)
        mqttClient.subscribe(topic, 1, new IMqttMessageListener() {
            @Override
            public void messageArrived(String receivedTopic, MqttMessage message) throws Exception {
                // Log the incoming message
                System.out.println("MQTT Message Received - Topic: '{}', Message: '{}'" + receivedTopic + new String(message.getPayload()));
                // You can add further processing logic here, e.g.,
                // storing the message in a database, triggering other services, etc.
            }
        });
        System.out.println("Subscribed to MQTT topic: {}" + topic);
    }
}
