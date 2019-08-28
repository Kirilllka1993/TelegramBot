package com.example.myproject;

import com.example.myproject.config.BotConfig;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@SpringBootApplication
public class TelegramBotApplication {

    public TelegramBotApplication() {
        ApiContextInitializer.init();
    }

    @Autowired
    private BotConfig botConfig;

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .setFieldAccessLevel(PRIVATE);
        return mapper;
    }

    @Bean
    public TelegramBotsApi telegramBotsApi() {
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            botsApi.registerBot(botConfig);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return botsApi;
    }

    public static void main(String[] args) {
        SpringApplication.run(TelegramBotApplication.class, args);
    }


}


