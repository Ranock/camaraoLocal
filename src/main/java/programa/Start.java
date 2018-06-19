package programa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import programa.websocketp.MySessionHandler;

@SpringBootApplication
public class Start {

	public static void main(String[] args) {
		SpringApplication.run(Start.class, args);

		WebSocketClient webSocketClient = new StandardWebSocketClient();
		WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);
		stompClient.setMessageConverter(new MappingJackson2MessageConverter());
		stompClient.setTaskScheduler(new ConcurrentTaskScheduler());

		String url = "ws://127.0.0.1:8080/hello";
		StompSessionHandler sessionHandler = new MySessionHandler();
		stompClient.connect(url, sessionHandler);
	}

}
