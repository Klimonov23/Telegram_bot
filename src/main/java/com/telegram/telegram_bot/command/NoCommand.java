package com.telegram.telegram_bot.command;

import com.telegram.telegram_bot.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class NoCommand implements Command {

    private final SendMessageService sendMessageService;

    public static final String NO_MESSAGE = "Я поддерживаю команды, начинающиеся со слеша(/).\n"
            + "Чтобы посмотреть список команд введите /help";

    public NoCommand(SendMessageService sendBotMessageService) {
        this.sendMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), NO_MESSAGE);

    }
}