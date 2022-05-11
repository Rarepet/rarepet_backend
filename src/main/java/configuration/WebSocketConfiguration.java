package skku.Rarepet.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import skku.Rarepet.global.interceptor.HttpHandshakeInterceptor;
import skku.Rarepet.handler.SocketHandler;

import java.io.IOException;


/**
 * Building the Signaling Server
 */
@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfiguration implements WebSocketConfigurer {

    private final SocketHandler socketHandler;
    /**
     *  create an endpoint that a client application can use to register as a WebSocket connection
     */
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(socketHandler, "/socket")
                    .setAllowedOrigins("*");
    }
}
