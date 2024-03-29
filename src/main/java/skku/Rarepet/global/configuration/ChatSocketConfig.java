package skku.Rarepet.global.configuration;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.HandshakeHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
import skku.Rarepet.global.interceptor.HttpHandshakeInterceptor;
import skku.Rarepet.handler.ChatHandler;

@Configuration
@RequiredArgsConstructor
@EnableWebSocket
public class ChatSocketConfig implements WebSocketConfigurer {

    private final ChatHandler chatHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

        registry.addHandler(chatHandler, "ws/chat")
                .addInterceptors(new HttpHandshakeInterceptor())
                .setAllowedOrigins("*");
    }

}

