package com.telegram.telegram_bot.command;

import com.telegram.telegram_bot.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command {
    private final SendMessageService sendMessageService;
    public final static String START_MESSAGE = "Привет. Я Telegram Bot. Я помогу тебе быть в курсе последних " +
            "статей тех авторов, котрые тебе интересны. Я еще маленький и только учусь.";

    public StartCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(),START_MESSAGE);

    }
}
