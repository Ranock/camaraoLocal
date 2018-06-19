package programa.websocketp;

import java.lang.reflect.Type;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import programa.model.AcaoWebsocket;
import programa.service.WebSocketService;

public class MySessionHandler extends StompSessionHandlerAdapter {
	
    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
    	
        session.subscribe("/topic/greetings", this);

        System.out.println("New session: {}" +  session.getSessionId() + "oi");
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        exception.printStackTrace();
        session.disconnect();
        WebSocketClient webSocketClient = new StandardWebSocketClient();
		WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);
		stompClient.setMessageConverter(new MappingJackson2MessageConverter());
		stompClient.setTaskScheduler(new ConcurrentTaskScheduler());

		String url = "ws://127.0.0.1:8080/hello";
		StompSessionHandler sessionHandler = new MySessionHandler();
		stompClient.connect(url, sessionHandler);
        
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return AcaoWebsocket.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
    	WebSocketService webService = new WebSocketService();
    	AcaoWebsocket acao = (AcaoWebsocket) payload;
    	webService.realizaAcao(acao);
    }
}