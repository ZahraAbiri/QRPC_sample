package org.example.grpc.mqttorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MqttInitializer implements CommandLineRunner {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private NotificationService notificationService;

    @Override
    public void run(String... args) throws Exception {
        inventoryService.subscribeToOrders();
        notificationService.subscribeToOrders();
    }
}

