package org.example.grpc.mqttorder;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventoryService {

    @Autowired
    private MqttClient mqttClient;

    public void subscribeToOrders() throws MqttException {
        mqttClient.subscribe("orders", (topic, msg) -> {
            String orderMessage = new String(msg.getPayload());
            System.out.println("Inventory updated based on: " + orderMessage);
            // Logic to update inventory based on the order
        });
    }
}

