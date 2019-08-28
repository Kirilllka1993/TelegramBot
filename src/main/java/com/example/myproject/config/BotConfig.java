package com.example.myproject.config;

import com.example.myproject.exception.NoSuchTownException;
import com.example.myproject.model.Town;
import com.example.myproject.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BotConfig extends TelegramLongPollingBot {

    @Autowired
    private UserService userService;


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String message_text = update.getMessage().getText();
            String responseMessage = null;
            String chat_id = update.getMessage().getChatId().toString();

            switch (message_text) {
                case "/start":
                    sendMsg(chat_id, "Добро пожаловать. Кнопки управления представлены ниже.");
                    break;
                case "Доступные города":
                    List<Town> cities = userService.findAll();
                    cities.stream().forEach(city -> sendMsg(chat_id, city.getTownName()));
                    break;

                case "Помощь":
                    sendMsg(chat_id, "Звони на телефон 555-555-555");
                    break;

                default:
                    try {
                        responseMessage = userService.getDescription(message_text).getDescription();
                        sendMsg(chat_id, responseMessage);
                    } catch (NoSuchTownException e) {
                        sendMsg(chat_id, "У меня нет информации о городе: " + message_text);
                    }
                    break;
            }
        }
    }

    private void sendMsg(final String chatId, final String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        setButtons(sendMessage);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
        }
    }

    private void setButtons(final SendMessage sendMessage) {
        // Создаем клавиуатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры
        keyboardFirstRow.add(new KeyboardButton("Доступные города"));

        // Вторая строчка клавиатуры
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboardSecondRow.add(new KeyboardButton("Помощь"));

        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        // и устанваливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);
    }


    @Override
    public String getBotUsername() {
        return "town";
    }

    @Override
    public String getBotToken() {
        return "745428405:AAEs9OiGXiWjdv5DXCa0OokuRZWh15nYcaU";
    }
}


//token: 745428405:AAEs9OiGXiWjdv5DXCa0OokuRZWh15nYcaU
//name town
//username: kirill1111_bot
//https://monsterdeveloper.gitbooks.io/writing-telegram-bots-on-java/content/chapter1.html
