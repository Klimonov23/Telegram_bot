package com.telegram.telegram_bot.command;

import com.telegram.telegram_bot.bot.Bot;
import com.telegram.telegram_bot.service.SendMessageService;
import com.telegram.telegram_bot.service.SendMessageServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

abstract public class AbstractCommandTests {
    protected Bot bot=Mockito.mock(Bot.class);
    protected SendMessageService service=new SendMessageServiceImpl(bot);
    abstract String getCommandName();

    abstract String getCommandMessage();

    abstract Command getCommand();
    @Test
    public void test_command() throws TelegramApiException {
        Long chatId = 1234567824356L;
        Update update=new Update();
        Message message=Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(chatId);
        Mockito.when(message.getText()).thenReturn(getCommandName());
        update.setMessage(message);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(getCommandMessage());
        sendMessage.enableHtml(true);

        getCommand().execute(update);

        Mockito.verify(bot).execute(sendMessage);
    }
}
