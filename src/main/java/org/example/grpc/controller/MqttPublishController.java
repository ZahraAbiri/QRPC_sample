package org.example.grpc.controller;
//import com.example.hybridapp.mqtt.MqttPublisherService;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.example.grpc.mqtt.MqttPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MqttPublishController {
    @Autowired
     MqttPublisherService mqttPublisherService;

    /**
     * Handles POST requests to /api/mqtt/publish.
     * Publishes a message to a specified MQTT topic.
     * <p>
     * Request body example:
     * {
     * "topic": "/topic/test",
     * "message": "Hello from MQTT via HTTP!",
     * "qos": 1,
     * "retained": false
     * }
     *
     * @param payload A map containing topic, message, qos, and retained status.
     * @return ResponseEntity indicating success or failure.
     */
    @PostMapping("/api/mqtt/publish")
    public ResponseEntity<String> publishMqttMessage(@RequestBody Map<String, Object> payload) {
        try {
            String topic = (String) payload.getOrDefault("topic", "/topic/default");
            String message = (String) payload.getOrDefault("message", "Default MQTT Message");
            // Default QoS to 1 if not provided or invalid
            int qos = (payload.get("qos") instanceof Integer) ? (Integer) payload.get("qos") : 1;
            // Default retained to false if not provided
            boolean retained = (payload.get("retained") instanceof Boolean) ? (Boolean) payload.get("retained") : false;

            mqttPublisherService.publish(topic, message, qos, retained);
            return ResponseEntity.ok("MQTT message published successfully to topic: " + topic);
        } catch (MqttException e) {
            return ResponseEntity.status(500).body("Failed to publish MQTT message: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Invalid request payload: " + e.getMessage());
        }
    }
    /*
    *  درخواست‌های HTTP POST را برای انتشار پیام‌ها به یک کارگزار MQTT مدیریت می‌کند.
    * اگرچه خود این متد MQTT نیست، اما با یک سرویس MQTT برای ارسال پیام‌ها تعامل دارد
    * اگر می‌خواهید مستقیماً با یک کارگزار MQTT تعامل داشته باشید،
    *  معمولاً از یک کتابخانه کلاینت MQTT (مانند Paho، Eclipse Mosquitto و غیره)
    * برای اتصال به کارگزار و انتشار/اشتراک در موضوعات استفاده می‌کنی
    *
    * */
}
