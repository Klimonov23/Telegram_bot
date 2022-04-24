package com.telegram.telegram_bot.service;

import com.telegram.telegram_bot.bot.Bot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class SendMessageServiceImpl implements SendMessageService {
    private final Bot bot;

    @Autowired
     public SendMessageServiceImpl(Bot bt){
        this.bot=bt;
    }

    @Override
    public void sendMessage(String chat_id, String message) {
        SendMessage sendMessage=new SendMessage();
        sendMessage.setChatId(chat_id);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);
        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
