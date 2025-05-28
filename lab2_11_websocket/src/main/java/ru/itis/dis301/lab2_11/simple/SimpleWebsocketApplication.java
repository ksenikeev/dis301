package ru.itis.dis301.lab2_11.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
	Программа запускает обмен сообщениями на веб сокетах
	http://localhost:8080/ws.html
 */
@SpringBootApplication(scanBasePackages = "ru.itis.dis301.lab2_11.simple")
public class SimpleWebsocketApplication {
	public static void main(String[] args) {
		SpringApplication.run(SimpleWebsocketApplication.class, args);
	}
}
