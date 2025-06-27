package org.example.grpc.mqttorder;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderService {

    @Autowired
    private MqttClient mqttClient;

    @PostMapping
    public String createOrder(@RequestBody OrderProduct order) {
        // Publish order message
        String orderMessage = "New order created: " + order.toString();
        MqttMessage message = new MqttMessage(orderMessage.getBytes());
        try {
            mqttClient.publish("orders", message);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error creating order";
        }
        return "Order created successfully";
    }
}

