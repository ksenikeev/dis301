package ru.itis.dis301.lab2_11.stomp.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import ru.itis.dis301.lab2_11.stomp.model.Greeting;
import ru.itis.dis301.lab2_11.stomp.model.HelloMessage;

@Controller
public class GreetingController {


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        System.out.println(message);
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, "
                + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

}
