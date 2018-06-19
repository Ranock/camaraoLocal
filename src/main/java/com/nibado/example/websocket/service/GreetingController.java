package com.nibado.example.websocket.service;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.nibado.example.websocket.service.model.Greeting;
import com.nibado.example.websocket.service.model.HelloMessage;

@Controller

public class GreetingController {
	  @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
    	System.out.println("Received hello: {}" +  message.getName());
        return new Greeting("Hello, " + message.getName() + "!");
    }
}
