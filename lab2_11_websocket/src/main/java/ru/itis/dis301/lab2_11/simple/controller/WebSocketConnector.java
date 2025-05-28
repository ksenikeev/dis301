package ru.itis.dis301.lab2_11.simple.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 	http://localhost:8080/ws.html
 * 	Соединение осуществляется на endpoint, определяемый через uri
 * 	При соединении передается идентификатор пользователя, чтобы зафиксировать ассоциированный с ним экземпляр WebSocketConnector
 * 	сообщения имеют вид json {"user":"user_name","text":"message"}
 */
@Component
@ServerEndpoint(value = "/msg/{username}")
public class WebSocketConnector {
    private Session session;
    private String username;
    public static Map<String, WebSocketConnector> endPoints = new HashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) {
        this.session = session;
        this.username = username;
        endPoints.put(username, this);
    }

    @OnMessage
    public void onMessage(Session session, String message, @PathParam("username") String username) {
        // Handle new messages

        ObjectMapper mapper = new ObjectMapper();
        try {
            Message msg = mapper.readValue(message, Message.class);

            // Запрашиваем WebSocketConnector получателя, чтобы через его атрибут сессии отправить сообщение
            WebSocketConnector userConnector = endPoints.get(msg.getUser());
            // заменяем имя получателя на имя отправителя, чтобы получатель знал от кого сообщение
            msg.setUser(username);
            userConnector.sendMessage(mapper.writeValueAsString(msg));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(session.getId() + " message " + message);
    }

    @OnClose
    public void onClose(Session session) {
        // WebSocket connection closes
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        // Do error handling here
    }

    public void sendMessage(String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}
