package com.freemahn.telegram;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

@Component
public class JarvisHandlerFactory {
    @Value("${token}")
    private String token;

    @Bean
    public JarvisHandler getJarvisHandler() {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        JarvisHandler jarvisHandler = new JarvisHandler(token);
        try {
            telegramBotsApi.registerBot(jarvisHandler);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return jarvisHandler;
    }
}
