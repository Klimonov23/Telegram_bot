package com.telegram.telegram_bot.service;

import com.telegram.telegram_bot.bot.Bot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-level test for SMS")
public class SendMessageServiceTest {
    private SendMessageService sendMessageService;
    private Bot bot;
    @BeforeEach //используется для обозначения того, что аннотированный метод должен выполняться перед каждым методом в классе
    public void init(){
        this.bot= Mockito.mock(Bot.class);
        sendMessageService=new SendMessageServiceImpl(bot);
    }
    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        String chatId="test chatId";
        String message="test message";

        SendMessage sendMessage=new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);

        sendMessageService.sendMessage(chatId,message);
        Mockito.verify(bot).execute(sendMessage);
    }


}
