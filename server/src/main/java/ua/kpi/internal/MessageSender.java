package ua.kpi.internal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import ua.kpi.common.ServerAction;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class MessageSender {
    private final static String QUEUE_NAME = "server-actions";
    private Connection connection = null;
    private Channel channel = null;
    private ObjectMapper objectMapper;

    public void init() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        try {
            connection = connectionFactory.newConnection();
            channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
        objectMapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();
    }

    public void sendMessage(ServerAction message) {
        try {
            String json = objectMapper.writeValueAsString(message);
            channel.basicPublish("", QUEUE_NAME, null, json.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
