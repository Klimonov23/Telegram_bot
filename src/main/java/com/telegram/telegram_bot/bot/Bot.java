package com.telegram.telegram_bot.bot;

import com.telegram.telegram_bot.command.CommandConteiner;
import com.telegram.telegram_bot.command.NoCommand;
import com.telegram.telegram_bot.service.SendMessageService;
import com.telegram.telegram_bot.service.SendMessageServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import static com.telegram.telegram_bot.command.CommandName.*;
@Component
public class Bot extends TelegramLongPollingBot {

    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    private final CommandConteiner commandContainer;

    public Bot() {
        this.commandContainer =new CommandConteiner(new SendMessageServiceImpl(this));
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
           if (message.startsWith("/")){
               String commandIdentifier = message.split(" ")[0].toLowerCase();
               commandContainer.retrieveCommand(commandIdentifier).execute(update);
           }
           else commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
        }
    }
}
